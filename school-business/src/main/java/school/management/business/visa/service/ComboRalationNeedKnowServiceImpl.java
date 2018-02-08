package school.management.business.visa.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import school.management.business.visa.dao.mybatis.ComboRalationNeedKnowDao;
import school.management.business.visa.entity.ComboRalationNeedKnow;
import school.management.db.service.CrudService;


@Slf4j
@Service(value = "comboRalationNeedKnowServiceImpl")
public class ComboRalationNeedKnowServiceImpl extends CrudService<ComboRalationNeedKnowDao, ComboRalationNeedKnow, Integer> {

}
