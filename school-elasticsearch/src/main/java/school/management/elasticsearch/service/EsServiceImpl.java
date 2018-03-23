package school.management.elasticsearch.service;


import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
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

import java.util.List;

@Component
public class EsServiceImpl {

    @Autowired
    EsClient esClient;

    /**
     * 传入：子类POJO的Class
     */
    public <T> RestResult<List<T>> searchMatchByTitle(Class<T> tClass, String title) {
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices(tClass.getSuperclass().getAnnotation(EsIndex.class).indexName());
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchQuery(EsConfig.EsSearchConfig.SEARCH_TITLE, title));
        searchRequest.source(searchSourceBuilder);
        return RestResult.getSuccessResult(esClient.search(searchRequest, tClass));
    }

    public <T> RestResult createIndexDocuments(Class<T> tClass, EsBaseEntity obj){
        IndexRequest indexRequest = new IndexRequest(tClass.getSuperclass().getAnnotation(EsIndex.class).indexName(),
                tClass.getAnnotation(EsType.class).typeName(), obj.getDbId())
                .source(obj);


        return RestResult.getSuccessResult();
    }

    public <T> RestResult createEsHotNewIndexMapping(Class<T> tClass) {
        esClient.createIndexMapping(tClass);
        return RestResult.getSuccessResult();
    }

}
