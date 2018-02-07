package school.management.business.businesshelp.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import school.management.db.pojo.IncrementDataEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@DynamicUpdate
@Table(name="cy_business_headlines")
public class BusinessHeadlines extends IncrementDataEntity {

	@Override
	public boolean isNewRecord() {
		return id == null;
	}

	@Id
	@GeneratedValue
	@Column(name="id",nullable=true)
    private Integer id;
	
	@Column(name="sys_user_id",nullable=true)
    private Integer sysUserId = 1;
	
	@Column(name="title",nullable=true)
	@NotNull(message="头条标题必填") 
    private String title;
	
	@Column(name="headline_level",nullable=true)
    private Integer headLineLevel = 1;
	
	@Column(name="headline_text_url",nullable=true)
	@NotNull(message="头条链接必填") 
	private String headLineTextUrl;
	
	@Column(name="total_number_like",nullable=true)
    private Integer totalNumberLike = 0;
	
	@Column(name="total_number_comments",nullable=true)
    private Integer totalNumberComments = 0;
	
	@Column(name="create_time",nullable=true)
    private Date createTime;
	
//	@Column(name="del_flag",nullable=true)
//    private Integer delFlag = 0;
	
}
