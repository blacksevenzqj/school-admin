package school.management.elasticsearch.entity;

import lombok.Data;
import school.management.elasticsearch.annotation.EsType;
import school.management.elasticsearch.entity.group.EsIndexGroup;


@Data
@EsType(typeName="hotnew", routingName="hotnew")
public class EsHotNew extends EsIndexGroup {

    @Override
    public String toString() {
        return "EsHotNew{" +
                "title='" + title + '\'' +
                ", serviceUrl='" + serviceUrl + '\'' +
                ", dbId='" + dbId + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}
