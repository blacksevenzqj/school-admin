package school.management.business.hot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import school.management.business.businesshelp.dao.BusinessHeadlinesDao;
import school.management.business.businesshelp.entity.BusinessHeadlines;
import school.management.business.hot.dao.TodayNewsDao;
import school.management.business.hot.entity.TodayNews;
import school.management.db.service.CrudService;

@Slf4j
@Service(value = "TodayNewsServiceImpl")
public class TodayNewsServiceImpl extends CrudService<TodayNewsDao, TodayNews, Integer> {
}
