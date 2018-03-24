package school.management.elasticsearch.client;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.replication.ReplicationResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.rest.RestStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import school.management.elasticsearch.annotation.EsFieldData;
import school.management.elasticsearch.annotation.EsIndex;
import school.management.elasticsearch.annotation.EsType;
import school.management.elasticsearch.common.EsConfig;
import school.management.elasticsearch.config.ESClientDecorator;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class EsClient {

    @Autowired
    private RestHighLevelClient client;

    /**
     * 传入：子类POJO的Class
     */
    public <T> void createIndexMapping(Class<T> tClass){
        CreateIndexRequest request = new CreateIndexRequest(tClass.getSuperclass().getAnnotation(EsIndex.class).indexName());
        request.settings(Settings.builder()
                .put(EsConfig.NUMBER_OF_SHARDS, tClass.getSuperclass().getAnnotation(EsIndex.class).numberOfShards())
                .put(EsConfig.NUMBER_OF_REPLICAS, tClass.getSuperclass().getAnnotation(EsIndex.class).numberOfReplicas()));

        Map mapField = new HashMap();
        Field[] fields = tClass.getFields();
        for(Field field : fields) {
            if (field.getAnnotation(EsFieldData.class) == null || StringUtils.isBlank(field.getAnnotation(EsFieldData.class).dataName())) {
                mapField.put(field.getName(), ESClientDecorator.getMapType().get(EsConfig.El_STRING));
            } else {
                mapField.put(field.getName(), ESClientDecorator.getMapType().get(field.getAnnotation(EsFieldData.class).dataName()));
            }
        }

        Map mapProperties = new HashMap();
        mapProperties.put(EsConfig.PROPERTIES, mapField);

        Map mapType = new HashMap();
        mapType.put(tClass.getAnnotation(EsType.class).typeName(), mapProperties);
        request.mapping(tClass.getAnnotation(EsType.class).typeName(), mapType);

        ActionListener<CreateIndexResponse> listener = new ActionListener<CreateIndexResponse>() {
            @Override
            public void onResponse(CreateIndexResponse createIndexResponse) {
                boolean acknowledged = createIndexResponse.isAcknowledged();
                boolean shardsAcknowledged = createIndexResponse.isShardsAcknowledged();
                log.info(String.valueOf(acknowledged) + ":" + String.valueOf(shardsAcknowledged));
            }
            @Override
            public void onFailure(Exception e) {
                log.error(e.getMessage());
            }
        };
        client.indices().createAsync(request, listener);
    }

// ***************************************************************************************************

    // 新增文档：如果 _id 相同，则为 更新文档 操作
    public void createIndexDoc(IndexRequest indexRequest){
        ActionListener<IndexResponse> listener = new ActionListener<IndexResponse>(){
            @Override
            public void onResponse(IndexResponse indexResponse) {
                ClientUtils.responseProcess(indexResponse);
            }
            @Override
            public void onFailure(Exception e) {
                log.error(e.getMessage());
            }
        };
        client.indexAsync(indexRequest, listener);
    }
    // 更新文档：如果 _id 不存在，则为 新增文档 操作
    public void upDateIndexDoc(UpdateRequest updateRequest){
        ActionListener<UpdateResponse> listener = new ActionListener<UpdateResponse>() {
            @Override
            public void onResponse(UpdateResponse updateResponse) {
                ClientUtils.responseProcess(updateResponse);
            }
            @Override
            public void onFailure(Exception e) {
                log.error(e.getMessage());
            }
        };
        client.updateAsync(updateRequest, listener);
    }
    // 删除文档：
    public void deleteIndexDoc(DeleteRequest deleteRequest){
        ActionListener<DeleteResponse> listener = new ActionListener<DeleteResponse>() {
            @Override
            public void onResponse(DeleteResponse deleteResponse) {
                ClientUtils.responseProcess(deleteResponse);
            }
            @Override
            public void onFailure(Exception e) {
                log.error(e.getMessage());
            }
        };
        client.deleteAsync(deleteRequest, listener);
    }

    // 批量操作：
    public void processDocBulk(BulkRequest request){
        ActionListener<BulkResponse> listener = new ActionListener<BulkResponse>() {
            @Override
            public void onResponse(BulkResponse bulkResponse) {
                for (BulkItemResponse bulkItemResponse : bulkResponse) {
                    if(bulkItemResponse.isFailed()){
                        BulkItemResponse.Failure failure = bulkItemResponse.getFailure();
                        log.error(failure.toString());
                    }else{
                        DocWriteResponse itemResponse = bulkItemResponse.getResponse();
                        if (bulkItemResponse.getOpType() == DocWriteRequest.OpType.INDEX
                                || bulkItemResponse.getOpType() == DocWriteRequest.OpType.CREATE) {
                            IndexResponse indexResponse = (IndexResponse) itemResponse;
                            ClientUtils.responseProcess(indexResponse);
                        } else if (bulkItemResponse.getOpType() == DocWriteRequest.OpType.UPDATE) {
                            UpdateResponse updateResponse = (UpdateResponse) itemResponse;
                            ClientUtils.responseProcess(updateResponse);
                        } else if (bulkItemResponse.getOpType() == DocWriteRequest.OpType.DELETE) {
                            DeleteResponse deleteResponse = (DeleteResponse) itemResponse;
                            ClientUtils.responseProcess(deleteResponse);
                        }
                    }
                }
            }
            @Override
            public void onFailure(Exception e) {
                log.error(e.getMessage());
            }
        };
        client.bulkAsync(request, listener);
    }

// ***************************************************************************************************

    /**
     * 传入：子类POJO的Class
     */
    public <T> T getById(GetRequest getRequest, Class<T> tClass) {
        System.out.println(getRequest.index() + getRequest.type() + getRequest.id());
        try {
            GetResponse getResponse = client.get(getRequest);
//            String index = getResponse.getIndex();
//            String type = getResponse.getType();
//            String id = getResponse.getId();
            if (getResponse.isExists()) {
//                long version = getResponse.getVersion();
//                Map<String, Object> sourceAsMap = getResponse.getSourceAsMap();
//                byte[] sourceAsBytes = getResponse.getSourceAsBytes();
                String sourceAsString = getResponse.getSourceAsString();
                return JSON.parseObject(sourceAsString, tClass);
            }
        }catch (ElasticsearchException e) {
            if (e.status() == RestStatus.NOT_FOUND) {
                log.error("GET Index Not_Exists" + ":" + getRequest.index() + ":" + getRequest.type() + ":" + getRequest.id() + ":" + getRequest.version());
            }else if(e.status() == RestStatus.CONFLICT){
                log.error("GET Version Different " + ":" + getRequest.index() + ":" + getRequest.type() + ":" + getRequest.id() + ":" + getRequest.version());
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return null;
    }
    public <T> List<T> search(SearchRequest request, Class<T> tClass) {
        List<T> list = new ArrayList<>();
        try {
            SearchResponse response = client.search(request);
            if (response.getHits() == null) {
                return null;
            }
            response.getHits().forEach(item -> list.add(JSON.parseObject(item.getSourceAsString(), tClass)));
            return list;
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return null;
    }


}
