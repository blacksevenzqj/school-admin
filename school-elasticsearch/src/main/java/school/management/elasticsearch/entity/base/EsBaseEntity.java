package school.management.elasticsearch.entity.base;

import lombok.Data;
import school.management.elasticsearch.annotation.EsFieldData;
import school.management.elasticsearch.common.EsConfig;

import java.util.Date;

@Data
public class EsBaseEntity {

    @EsFieldData(dataName= EsConfig.El_KEYWORD)
    public String dbId;

    @EsFieldData(dataName=EsConfig.EL_DATE)
    public String createDate;

}
