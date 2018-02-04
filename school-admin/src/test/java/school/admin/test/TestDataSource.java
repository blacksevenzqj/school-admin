package school.admin.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import school.admin.common.annotation.SysLog;
import school.admin.modules.sys.entity.SysLogEntity;
import school.admin.modules.sys.entity.SysUserEntity;
import school.admin.modules.sys.service.SysLogServiceImpl;
import school.admin.modules.sys.service.SysUserServiceImpl;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDataSource {

    @Autowired
    SysUserServiceImpl sysUserServiceImpl;

    @Autowired
    SysLogServiceImpl sysLogServiceImpl;

    @Test
    public void queryAllMenuId() {
        List<Long> list = sysUserServiceImpl.queryAllMenuId(2L);
        for(Long l : list){
            log.info(l.toString());
        }
    }

    @Test
    public void sysUserTestSave() {
        SysUserEntity sysUserEntity = new SysUserEntity();
        sysUserEntity.setUsername("999");
        sysUserEntity = sysUserServiceImpl.save(sysUserEntity);
        log.info(sysUserEntity.toString());
//        sysUserServiceImpl.testSave();

    }


    @Test
    public void sysLogSave() {
        SysLogEntity sysLog = new SysLogEntity();
        sysLog.setUsername("3333");
        sysLog.setOperation("666");
        sysLogServiceImpl.save(sysLog);
    }

    @Test
    public void sysLogTestSave() {
        sysLogServiceImpl.testSave();
    }

}
