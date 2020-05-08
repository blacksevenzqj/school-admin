package school.management.elasticsearch.entity.group;

import lombok.Data;
import school.management.elasticsearch.annotation.EsFieldData;
import school.management.elasticsearch.annotation.EsIndex;
import school.management.elasticsearch.common.EsConfig;
import school.management.elasticsearch.entity.base.EsBaseEntity;

@Data
@EsIndex(indexName="school", numberOfShards=5, numberOfReplicas=1)
public class EsIndexGroup extends EsBaseEntity {

    @EsFieldData(dataName= EsConfig.El_STRING, analyzerType= EsConfig.AnalyzerConfig.IK, analyzerSearchType= EsConfig.AnalyzerConfig.IK_SEARCH)
//    @EsFieldData(dataName= EsConfig.El_STRING)
    public String title;

    @EsFieldData(dataName= EsConfig.El_KEYWORD)
    public String serviceUrl;

}
