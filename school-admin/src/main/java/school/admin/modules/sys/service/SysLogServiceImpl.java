package school.admin.modules.sys.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import school.admin.modules.sys.dao.SysLogDao;
import school.admin.modules.sys.entity.SysLogEntity;
import school.db.service.CrudService;


@Slf4j
@Service(value = "sysLogServiceImpl")
public class SysLogServiceImpl extends CrudService<SysLogDao, SysLogEntity> {

}
