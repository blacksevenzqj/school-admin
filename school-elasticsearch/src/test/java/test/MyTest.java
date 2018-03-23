package test;

import school.management.elasticsearch.annotation.EsFieldData;
import school.management.elasticsearch.annotation.EsIndex;
import school.management.elasticsearch.annotation.EsType;
import school.management.elasticsearch.entity.EsHotNew;
import school.management.elasticsearch.entity.base.EsBaseEntity;
import school.management.elasticsearch.entity.group.EsIndexGroup;
import school.management.elasticsearch.util.EsUtils;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class MyTest {

    public static void main(String args[])throws Exception{

//        fangshe(EsHotNew.class);

        class2Array(EsHotNew.class);

    }

    public static void class2Array(Class tClass) throws Exception{
        EsHotNew obj = new EsHotNew();
        obj.setTitle("feiji");
        obj.setDbId("111");
        obj.setCreateDate(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        obj.setServiceUrl("http://www.baidu.com");
        String[] strs = EsUtils.Class2Array(obj);
        for(String str : strs) {
            System.out.println(str);
        }
    }


    public static void fangshe(Class tClass){
        Field[] fields2 = tClass.getFields();
        for(Field field : fields2) {
            if(field.getAnnotation(EsFieldData.class) != null){
                System.out.println(field.getAnnotation(EsFieldData.class).dataName());
            }
            System.out.println(field);
        }
    }


}
