package test;

import school.management.elasticsearch.annotation.EsFieldData;
import school.management.elasticsearch.annotation.EsIndex;
import school.management.elasticsearch.annotation.EsType;
import school.management.elasticsearch.entity.EsHotNew;
import school.management.elasticsearch.entity.group.EsIndexGroup;

import java.lang.reflect.Field;

public class MyTest {

    public static void main(String args[]){

        System.out.println(EsIndexGroup.class.getAnnotation(EsIndex.class).indexName());
        System.out.println(EsHotNew.class.getAnnotation(EsType.class).typeName());
        System.out.println(EsHotNew.class.getAnnotation(EsType.class).routingName());
        System.out.println(EsIndexGroup.class.getAnnotation(EsIndex.class).numberOfShards());
        System.out.println(EsIndexGroup.class.getAnnotation(EsIndex.class).numberOfReplicas());

        fangshe(EsHotNew.class);

        System.out.println(EsHotNew.class.getSuperclass());
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
