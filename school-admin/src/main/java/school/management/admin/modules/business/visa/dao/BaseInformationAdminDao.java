package school.management.admin.modules.business.visa.dao;

import school.management.business.visa.dao.mybatis.BaseInformationDao;
import school.management.business.visa.entity.BaseInformation;

import java.util.List;

public interface BaseInformationAdminDao extends BaseInformationDao {

    List<BaseInformation> getBaseInformationList();

}
