package school.management.business.advisory.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import school.management.business.advisory.dao.AdvisoryFreeQuestionDao;
import school.management.business.advisory.entity.AdvisoryFreeQuestion;
import school.management.db.service.CrudService;

@Slf4j
@Service(value = "advisoryFreeQuestionServiceImpl")
public class AdvisoryFreeQuestionServiceImpl extends CrudService<AdvisoryFreeQuestionDao, AdvisoryFreeQuestion, Integer> {
}
