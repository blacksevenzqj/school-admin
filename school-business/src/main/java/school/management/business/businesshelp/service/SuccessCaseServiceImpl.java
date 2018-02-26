package school.management.business.businesshelp.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import school.management.business.businesshelp.dao.SuccessCaseDao;
import school.management.business.businesshelp.entity.SuccessCase;
import school.management.db.service.CrudService;

@Slf4j
@Service(value = "successCaseServiceImpl")
public class SuccessCaseServiceImpl extends CrudService<SuccessCaseDao, SuccessCase, Integer> {
}
