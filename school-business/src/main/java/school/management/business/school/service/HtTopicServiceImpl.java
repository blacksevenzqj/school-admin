package school.management.business.school.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import school.management.business.school.dao.HtTopicDao;
import school.management.business.school.entity.HtTopic;
import school.management.db.service.CrudService;

@Slf4j
@Service(value = "topicServiceImpl")
public class HtTopicServiceImpl extends CrudService<HtTopicDao, HtTopic, Integer> {
}
