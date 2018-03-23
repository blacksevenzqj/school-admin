package test;

import school.management.elasticsearch.annotation.EsFieldType;
import school.management.elasticsearch.annotation.EsType;
import school.management.elasticsearch.entity.EsHotNew;

import java.lang.reflect.Field;

public class MyTest {

    public static void main(String args[]){

        System.out.println(EsHotNew.class.getAnnotation(EsType.class).indexName());
        System.out.println(EsHotNew.class.getAnnotation(EsType.class).typeName());
        System.out.println(EsHotNew.class.getAnnotation(EsType.class).routingName());
        System.out.println(EsHotNew.class.getAnnotation(EsType.class).numberOfShards());
        System.out.println(EsHotNew.class.getAnnotation(EsType.class).numberOfReplicas());

//        fangshe(HotNew.class);


    }


    public static void fangshe(Class tClass){
        Field[] fields2 = tClass.getFields();
        for(Field field : fields2) {
            if(field.getAnnotation(EsFieldType.class) != null){
                System.out.println(field.getAnnotation(EsFieldType.class).typeName());
            }
            System.out.println(field);
        }
    }


}
