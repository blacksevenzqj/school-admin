package school.management.admin.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import school.management.elasticsearch.client.EsClient;
import school.management.elasticsearch.common.EsConfig;
import school.management.elasticsearch.common.RestResult;
import school.management.elasticsearch.entity.EsHotNew;
import school.management.elasticsearch.entity.base.EsBaseEntity;
import school.management.elasticsearch.service.EsServiceImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestEs {

    @Autowired
    EsClient esClient;

    @Autowired
    EsServiceImpl esServiceImpl;

    @Test
    public void esClient() throws Exception{
//        esClient.createIndexMapping(EsHotNew.class);
        esServiceImpl.createEsHotNewIndexMapping(EsHotNew.class);

        Thread.currentThread().sleep(3000L);
    }

    @Test
    public void save() throws Exception{
        EsHotNew obj = new EsHotNew();
        obj.setTitle("feiji");
        obj.setDbId("111");
        obj.setCreateDate(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        obj.setServiceUrl("http://www.baidu.com");
        esServiceImpl.createIndexDocuments(EsHotNew.class, obj);

        Thread.currentThread().sleep(3000L);
    }

    @Test
    public void get() throws Exception {
        RestResult restResult = esServiceImpl.searchMatchByTitle(EsHotNew.class, "feiji");
        System.out.println(restResult);
    }


}
