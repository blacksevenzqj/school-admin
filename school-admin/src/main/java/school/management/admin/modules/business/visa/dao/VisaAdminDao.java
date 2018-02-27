package school.management.admin.modules.business.visa.dao;


import org.apache.ibatis.annotations.Param;
import school.management.admin.modules.business.visa.entity.VisaComboVo;

import java.util.List;
import java.util.Map;

public interface VisaAdminDao {

    List<VisaComboVo> visaComboVoQueryList(Map<String, Object> queryMap);

    void cbaseInformationDelBatchBycomboIds(@Param("ids") Integer[] ids);

    void cneedKnowDelBatchBycomboIds(@Param("ids") Integer[] ids);

    void handleProceduresDelBatchBycomboIds(@Param("ids") Integer[] ids);

    void roleMaterialDelBatchBycomboIds(@Param("ids") Integer[] ids);

}
