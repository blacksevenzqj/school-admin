package school.admin.modules.sys.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import school.admin.modules.sys.dao.SysLogDao;
import school.admin.modules.sys.entity.SysLogEntity;
import school.admin.modules.sys.entity.SysUserEntity;
import school.db.service.CrudService;


@Slf4j
@Service(value = "sysLogServiceImpl")
public class SysLogServiceImpl extends CrudService<SysLogDao, SysLogEntity> {

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void testSave(){
        SysLogEntity sysLogEntity = new SysLogEntity();
        sysLogEntity.setUsername("123");
        sysLogEntity = save(sysLogEntity);
        log.info(sysLogEntity.toString());
        sysLogEntity.setUsername("456");
        sysLogEntity = save(sysLogEntity);
        log.info(sysLogEntity.toString());
        testSave2();
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void testSave2(){
        SysLogEntity sysLogEntity = new SysLogEntity();
        sysLogEntity.setUsername("789");
        sysLogEntity = save(sysLogEntity);
        log.info(sysLogEntity.toString());
        int a = 1/0;
    }

}
