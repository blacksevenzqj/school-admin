package school.management.elasticsearch.entity.base;

import lombok.Data;
import school.management.elasticsearch.annotation.EsFieldData;
import school.management.elasticsearch.common.EsConfig;

import java.util.Date;

@Data
public class EsBaseEntity {

    @EsFieldData(dataName= EsConfig.El_STRING)
    public String title;

    @EsFieldData(dataName= EsConfig.El_KEYWORD)
    public String dbId;

    @EsFieldData(dataName= EsConfig.El_KEYWORD)
    public String esId;

    @EsFieldData(dataName= EsConfig.El_KEYWORD)
    public String serviceUrl;

    @EsFieldData(dataName=EsConfig.EL_DATE)
    public Date postDate;

}
