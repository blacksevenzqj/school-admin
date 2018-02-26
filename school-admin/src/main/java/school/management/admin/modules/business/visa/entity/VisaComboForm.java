package school.management.admin.modules.business.visa.entity;

import lombok.Data;
import school.management.business.visa.entity.VisaCombo;

@Data
public class VisaComboForm extends VisaCombo {

    private Integer[] baseInformationIds;

    private Integer[] needKnowIds;

    private Integer[] proceduresIds;

}
