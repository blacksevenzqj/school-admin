package school.management.elasticsearch.service;


import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import school.management.elasticsearch.annotation.EsType;
import school.management.elasticsearch.client.EsClient;
import school.management.elasticsearch.common.EsConfig;
import school.management.elasticsearch.common.RestResult;
import school.management.elasticsearch.entity.EsHotNew;

import java.util.List;

@Component
public class EsServiceImpl {

    @Autowired
    EsClient esClient;

    public RestResult<List<EsHotNew>> searchMatchByTitle(String title) {
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices(EsHotNew.class.getAnnotation(EsType.class).indexName());
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchQuery(EsConfig.EsSearchConfig.SEARCH_TITLE, title));
        searchRequest.source(searchSourceBuilder);
        return RestResult.getSuccessResult(esClient.search(searchRequest, EsHotNew.class));
    }

    public <T> RestResult createEsHotNewIndexMapping(Class<T> tClass) {
        esClient.createIndexMapping(tClass);
        return RestResult.getSuccessResult();
    }

}
