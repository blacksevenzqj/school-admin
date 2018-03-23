package school.management.elasticsearch.entity.group;

import lombok.Data;
import school.management.elasticsearch.annotation.EsIndex;
import school.management.elasticsearch.entity.base.EsBaseEntity;

@Data
@EsIndex(indexName="school", numberOfShards=5, numberOfReplicas=1)
public class EsIndexGroup extends EsBaseEntity {

}
