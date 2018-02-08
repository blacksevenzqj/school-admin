package school.management.business.visa.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import school.management.business.visa.dao.mybatis.ComboRalationBaseInformationDao;
import school.management.business.visa.entity.ComboRalationBaseInformation;
import school.management.db.service.CrudService;


@Slf4j
@Service(value = "comboRalationBaseInformationServiceImpl")
public class ComboRalationBaseInformationServiceImpl extends CrudService<ComboRalationBaseInformationDao, ComboRalationBaseInformation, Integer> {

}
