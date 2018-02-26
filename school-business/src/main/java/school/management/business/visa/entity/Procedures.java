package school.management.business.visa.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import school.management.db.pojo.IncrementDataEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@DynamicUpdate
@Table(name="qz_procedures")
public class Procedures extends IncrementDataEntity { // 办理流程

    @Override
    public boolean isNewRecord() {
        return id == null;
    }

	@Id
	@GeneratedValue
    private Integer id;

    private String title;

    private String content;

    private Date createTime = new Date();

//    private Integer delFlag;

   
}