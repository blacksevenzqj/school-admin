package school.admin.modules.sys.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import school.admin.modules.sys.dao.SysMenuDao;
import school.admin.modules.sys.entity.SysMenuEntity;
import school.db.service.CrudService;


@Slf4j
@Service(value = "sysMenuServiceImpl")
@Transactional(readOnly = true)
public class SysMenuServiceImpl extends CrudService<SysMenuDao, SysMenuEntity> {


}
