package school.management.admin.common.utils;

import school.management.business.hot.entity.TodayNews;
import school.management.elasticsearch.entity.EsHotNew;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BsEntity2EsEntity {


    public static EsHotNew TodayNews2EsHotNew(TodayNews todayNews, String serviceUrl){
        EsHotNew esHotNew = new EsHotNew();
        esHotNew.setDbId(String.valueOf(todayNews.getId()));
        esHotNew.setTitle(todayNews.getTitle());
        esHotNew.setServiceUrl(serviceUrl);
        esHotNew.setCreateDate(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        return esHotNew;
    }



}
