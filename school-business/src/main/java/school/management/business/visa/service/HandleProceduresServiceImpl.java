package school.management.business.visa.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import school.management.business.visa.dao.mybatis.HandleProceduresDao;
import school.management.business.visa.entity.HandleProcedures;
import school.management.db.service.CrudService;


@Slf4j
@Service(value = "handleProceduresServiceImpl")
public class HandleProceduresServiceImpl extends CrudService<HandleProceduresDao, HandleProcedures, Integer> {

}
