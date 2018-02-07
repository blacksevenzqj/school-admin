package school.management.business.visa.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import school.management.business.visa.dao.mybatis.BaseInformationDao;
import school.management.business.visa.entity.BaseInformation;
import school.management.db.service.CrudService;


@Slf4j
@Service(value = "baseInformationServiceImpl")
public class BaseInformationServiceImpl extends CrudService<BaseInformationDao, BaseInformation, Integer> {

}
