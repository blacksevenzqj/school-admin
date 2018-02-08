package school.management.business.visa.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import school.management.business.visa.dao.mybatis.ProceduresDao;
import school.management.business.visa.dao.mybatis.VisaDao;
import school.management.business.visa.entity.Procedures;
import school.management.business.visa.entity.Visa;
import school.management.db.service.CrudService;


@Slf4j
@Service(value = "proceduresServiceImpl")
public class ProceduresServiceImpl extends CrudService<ProceduresDao, Procedures, Integer> {

}
