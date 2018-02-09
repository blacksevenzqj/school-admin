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
@Table(name="qz_handle_procedures")
public class HandleProcedures extends IncrementDataEntity {

    @Override
    public boolean isNewRecord() {
        return id == null;
    }

	@Id
	@GeneratedValue
    private Integer id;
	private Integer visaId;
    private Integer comboId;
    private Integer proceduresId;
    private Integer order;
    private Date createTime;
//    private Integer delFlag;

   
}