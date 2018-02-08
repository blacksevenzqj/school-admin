package school.management.business.visa.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import school.management.business.visa.dao.mybatis.NeedKnowDao;
import school.management.business.visa.entity.NeedKnow;
import school.management.db.service.CrudService;


@Slf4j
@Service(value = "needKnowServiceImpl")
public class NeedKnowServiceImpl extends CrudService<NeedKnowDao, NeedKnow, Integer> {

}
