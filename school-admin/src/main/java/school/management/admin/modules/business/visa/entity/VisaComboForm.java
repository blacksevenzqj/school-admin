package school.management.admin.modules.business.visa.entity;

import lombok.Data;
import school.management.business.visa.entity.VisaCombo;

@Data
public class VisaComboForm extends VisaCombo {

    private Integer baseInformationId;

    private Integer[] needKnowIds;

    private Integer[] proceduresIds;

    private Integer[] studentMaterialIds; // 学生
    private String studentMaterialDesc;

    private Integer[] officersMaterialIds; // 在职
    private String officersMaterialDesc;

    private Integer[] retireesMaterialIds; // 退休
    private String retireesMaterialDesc;

    private Integer[] freelancerMaterialIds; // 自由职业
    private String freelancerMaterialDesc;

    private String acceptEmail;
    private String acceptAddress;

}
