package school.management.business.visa.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import school.management.business.visa.dao.mybatis.VisaOrderDao;
import school.management.business.visa.entity.order.VisaOrderMaster;
import school.management.business.visa.entity.order.VisaOrderMasterVo;
import school.management.db.service.CrudService;


@Slf4j
@Service(value = "visaOrderServiceImpl")
public class VisaOrderServiceImpl extends CrudService<VisaOrderDao, VisaOrderMasterVo, Integer> {

}
