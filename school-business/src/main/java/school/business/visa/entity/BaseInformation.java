//package school.business.visa.entity;
//
//import lombok.Data;
//import org.hibernate.annotations.DynamicUpdate;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import java.math.BigDecimal;
//import java.util.Date;
//
//@Data
//@Entity
//@DynamicUpdate
//@Table(name="qz_base_information")
//public class BaseInformation {
//	@Id
//	@GeneratedValue
//    private Integer baseInformationId;
//    private String name; // 名字
//    private String description; // 描述
//    private Integer enterCountryNum; // 入境次数
//    private Integer stayDay; // 停留天数
//    private String validityTime; // 有效期:年数
//    private String comboContent; // 套餐内容
//    private String handleTime;  // 办理时间
//    private String visaInterview; // 是否需要面签
//    private BigDecimal cashDeposit;  // 保证金
//    private String handleRange; // 处理范围
//    private String comboDescription; // 套餐描述
//    private Date createTime; // 创建时间
//    private Integer delFlag; // 删除标志
//
//}