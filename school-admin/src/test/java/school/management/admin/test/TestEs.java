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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestEs {

    @Autowired
    EsClient esClient;

    @Autowired
    EsServiceImpl esServiceImpl;

    @Test
    public void createIndexMapping() throws Exception{
//        esClient.createIndexMapping(EsHotNew.class);
        esServiceImpl.createIndexMapping(EsHotNew.class);

        Thread.currentThread().sleep(3000L);
    }

    @Test
    public void save() throws Exception{
        EsHotNew obj = new EsHotNew();
        obj.setTitle("feiji");
        obj.setDbId("111");
        obj.setCreateDate(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        obj.setServiceUrl("http://www.baidu.com");
        esServiceImpl.createIndexDoc(EsHotNew.class, obj);

        Thread.currentThread().sleep(3000L);
    }

    @Test
    public void saveBulk() throws Exception{
        List<EsBaseEntity> list = new ArrayList<>();
        EsHotNew obj = new EsHotNew();
        obj.setTitle("feiji");
        obj.setDbId("111");
        obj.setCreateDate(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        obj.setServiceUrl("http://www.baidu.com");
        EsHotNew obj2 = new EsHotNew();
        obj2.setTitle("dapao");
        obj2.setDbId("222");
        obj2.setCreateDate(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        obj2.setServiceUrl("http://www.google.com");
        list.add(obj);
        list.add(obj2);
        esServiceImpl.createDocBulk(EsHotNew.class, list);

        Thread.currentThread().sleep(3000L);
    }

    @Test
    public void searchMatchByTitle() throws Exception {
        RestResult<List<EsHotNew>> restResult = esServiceImpl.searchMatchByTitle(EsHotNew.class, "feiji");
        for(EsHotNew obj : restResult.getData()){
            System.out.println(obj);
        }
    }


}
