package school.management.elasticsearch.util;

import java.lang.reflect.Field;

public class EsUtils {

    public static String[] Class2Array(Object obj) throws Exception{
        Field[] filds = obj.getClass().getFields();
        String[] strs = new String[filds.length * 2];
        for(int i=0,j=0; i<filds.length; i++,j++){
            strs[j] = filds[i].getName();
            strs[++j] = String.valueOf(filds[i].get(obj));
        }
        return strs;
    }

}
