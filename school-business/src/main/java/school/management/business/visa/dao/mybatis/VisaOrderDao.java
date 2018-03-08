package school.management.business.visa.dao.mybatis;

import org.apache.ibatis.annotations.Param;
import school.management.business.visa.entity.order.VisaOrderMaster;
import school.management.business.visa.entity.order.VisaOrderMasterVo;
import school.management.db.dao.CrudDao;

public interface VisaOrderDao extends CrudDao<VisaOrderMaster, Integer> {


    VisaOrderMasterVo getVisaOrderMasterVo(@Param("orderMasterId") int orderMasterId);


}
