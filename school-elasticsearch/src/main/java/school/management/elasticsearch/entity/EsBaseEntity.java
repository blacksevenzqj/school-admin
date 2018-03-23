package school.management.elasticsearch.entity;

import lombok.Data;
import school.management.elasticsearch.annotation.EsFieldType;
import school.management.elasticsearch.common.EsConfig;

import java.util.Date;

@Data
public class EsBaseEntity {

    @EsFieldType(typeName= EsConfig.El_STRING)
    public String title;

    @EsFieldType(typeName= EsConfig.El_KEYWORD)
    public String dbId;

    @EsFieldType(typeName= EsConfig.El_KEYWORD)
    public String esId;

    @EsFieldType(typeName= EsConfig.El_KEYWORD)
    public String serviceUrl;

    @EsFieldType(typeName=EsConfig.EL_DATE)
    public Date postDate;

}
