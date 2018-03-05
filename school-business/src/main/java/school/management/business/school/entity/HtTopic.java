package school.management.business.school.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import school.management.db.pojo.IncrementDataEntity;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@DynamicUpdate
@Table(name="ht_topic")
public class HtTopic extends IncrementDataEntity {

	@Override
	public boolean isNewRecord() {
		return id == null;
	}

	@Id
	@GeneratedValue
	private Integer id;
	private String title;
	private String content;
	private String instraction;
	private Integer hotTopic;
	private Integer topicType;
	private Integer jionPeopleNum;
	private Date createTime;
	private String topicImgUrl;
	
}
