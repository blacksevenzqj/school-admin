package school.management.admin.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import school.management.elasticsearch.client.EsClient;
import school.management.elasticsearch.common.RestResult;
import school.management.elasticsearch.entity.EsHotNew;
import school.management.elasticsearch.service.EsServiceImpl;

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
    public void get() throws Exception {
        RestResult restResult = esServiceImpl.searchMatchByTitle("feiji");
        System.out.println(restResult);
    }


}
