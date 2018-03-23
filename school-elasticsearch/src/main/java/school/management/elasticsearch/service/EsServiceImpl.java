package school.management.elasticsearch.service;


import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import school.management.elasticsearch.annotation.EsIndex;
import school.management.elasticsearch.annotation.EsType;
import school.management.elasticsearch.client.EsClient;
import school.management.elasticsearch.common.EsConfig;
import school.management.elasticsearch.common.RestResult;
import school.management.elasticsearch.entity.base.EsBaseEntity;
import school.management.elasticsearch.entity.group.EsIndexGroup;
import school.management.elasticsearch.util.EsUtils;

import java.util.List;

@Component
@Slf4j
public class EsServiceImpl {

    @Autowired
    EsClient esClient;

    /**
     * 新增索引
     */
    // 传入：子类POJO的Class
    public <T> RestResult createIndexMapping(Class<T> tClass) {
        esClient.createIndexMapping(tClass);
        return RestResult.getSuccessResult();
    }

// ***************************************************************************************************

    /**
     * 新增、修改、删除 文档：
     */
    // 新增文档：
    // 传入：子类POJO的Class
    public <T> RestResult createIndexDoc(Class<T> tClass, EsBaseEntity obj){
        try {
            IndexRequest indexRequest = new IndexRequest(
                    tClass.getSuperclass().getAnnotation(EsIndex.class).indexName(),
                    tClass.getAnnotation(EsType.class).typeName(),
                    obj.getDbId()
            ).source(EsUtils.Class2Array(obj));
            esClient.createIndexDoc(indexRequest);
            return RestResult.getSuccessResult();
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return RestResult.getFailResult(500,"新增文档失败");
    }
    // 删除文档：
    // 传入：子类POJO的Class
    public <T> RestResult deleteIndexDoc(Class<T> tClass, EsBaseEntity obj) {
        try {
            DeleteRequest request = new DeleteRequest(
                    tClass.getSuperclass().getAnnotation(EsIndex.class).indexName(),
                    tClass.getAnnotation(EsType.class).typeName(),
                    obj.getDbId());
            esClient.deleteIndexDoc(request);
            return RestResult.getSuccessResult();
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return RestResult.getFailResult(500,"删除文档失败");
    }



    // 批量操作：
    // 传入：子类POJO的Class
    public <T> RestResult processDocBulk(Class<T> tClass, List<EsBaseEntity> createList, List<EsBaseEntity> upDateList, List<EsBaseEntity> deleteList){
        BulkRequest request = new BulkRequest();
        try {
            if(createList != null) {
                for (EsBaseEntity obj : createList) {
                    IndexRequest indexRequest = new IndexRequest(
                            tClass.getSuperclass().getAnnotation(EsIndex.class).indexName(),
                            tClass.getAnnotation(EsType.class).typeName(),
                            obj.getDbId()
                    ).source(EsUtils.Class2Array(obj));
                    request.add(indexRequest);
                }
            }
            if(upDateList != null) {
                for (EsBaseEntity obj : upDateList) {
                    UpdateRequest updateRequest = new UpdateRequest(tClass.getSuperclass().getAnnotation(EsIndex.class).indexName(),
                            tClass.getAnnotation(EsType.class).typeName(),
                            obj.getDbId()
                    ).doc(EsUtils.Class2Array(obj));
                    request.add(updateRequest);
                }
            }
            if(deleteList != null) {
                for (EsBaseEntity obj : deleteList) {
                    DeleteRequest deleteRequest = new DeleteRequest(
                            tClass.getSuperclass().getAnnotation(EsIndex.class).indexName(),
                            tClass.getAnnotation(EsType.class).typeName(),
                            obj.getDbId());
                    request.add(deleteRequest);
                }
            }
            esClient.processDocBulk(request);
            return RestResult.getSuccessResult();
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return RestResult.getFailResult(500,"新增文档失败");
    }

// ***************************************************************************************************

    /**
     * 查询
     */
    // 传入：子类POJO的Class
    public <T> RestResult<List<T>> searchMatchByTitle(Class<T> tClass, String title) {
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices(tClass.getSuperclass().getAnnotation(EsIndex.class).indexName());
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchQuery(EsConfig.EsSearchConfig.SEARCH_TITLE, title));
        searchRequest.source(searchSourceBuilder);
        return RestResult.getSuccessResult(esClient.search(searchRequest, tClass));
    }



}