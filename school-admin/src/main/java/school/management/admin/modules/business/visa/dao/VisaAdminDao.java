package school.management.admin.modules.business.visa.dao;


import school.management.admin.modules.business.visa.entity.VisaComboVo;

import java.util.List;
import java.util.Map;

public interface VisaAdminDao {

    List<VisaComboVo> visaComboVoQueryList(Map<String, Object> queryMap);


}
