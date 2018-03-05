package school.management.business.advisory.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import school.management.business.advisory.dao.AdvisoryConsultantDao;
import school.management.business.advisory.entity.AdvisoryConsultant;
import school.management.db.service.CrudService;

@Slf4j
@Service(value = "advisoryConsultantServiceImpl")
public class AdvisoryConsultantServiceImpl extends CrudService<AdvisoryConsultantDao, AdvisoryConsultant, Integer> {
}
