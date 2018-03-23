package school.management.elasticsearch.entity;

import lombok.Data;
import school.management.elasticsearch.annotation.EsType;


@Data
@EsType(indexName="school", typeName="hotnew", routingName="hotnew", numberOfShards=5, numberOfReplicas=1)
public class EsHotNew extends EsBaseEntity{

}
