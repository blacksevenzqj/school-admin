package school.management.elasticsearch.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EsType {

    String indexName() default "";

    String typeName() default "";

    String routingName() default "";

    int numberOfShards() default 5;

    int numberOfReplicas() default 1;

}
