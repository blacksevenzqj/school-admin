package school.management.business.visa.dao.mybatis;

import school.management.business.visa.entity.order.VisaOrderDetail;
import school.management.business.visa.entity.order.VisaOrderMaster;
import school.management.business.visa.entity.order.VisaOrderMasterVo;
import school.management.db.dao.CrudDao;


public interface VisaOrderDao extends CrudDao<VisaOrderMasterVo, Integer> {

    void updateVisaOrderMaster(VisaOrderMaster visaOrderMaster);

    void updateVisaOrderDetail(VisaOrderDetail visaOrderDetail);

}
