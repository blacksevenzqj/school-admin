package school.management.elasticsearch.client;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
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
