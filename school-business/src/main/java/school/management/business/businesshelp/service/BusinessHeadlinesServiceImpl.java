package school.management.business.businesshelp.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import school.management.business.businesshelp.dao.BusinessHeadlinesDao;
import school.management.business.businesshelp.entity.BusinessHeadlines;
import school.management.db.service.CrudService;

@Slf4j
@Service(value = "businessHeadlinesServiceImpl")
public class BusinessHeadlinesServiceImpl extends CrudService<BusinessHeadlinesDao, BusinessHeadlines, Integer> {
}
