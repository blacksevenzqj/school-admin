package school.management.business.visa.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import school.management.business.visa.dao.mybatis.BaseInformationDao;
import school.management.business.visa.entity.BaseInformation;
import school.management.db.service.CrudService;


@Slf4j
@Service(value = "visaServiceImpl")
public class VisaServiceImpl extends CrudService<BaseInformationDao, BaseInformation, Integer> {

}
