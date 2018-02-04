package school.admin.modules.sys.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import school.admin.common.annotation.SysLog;
import school.admin.modules.sys.dao.SysUserDao;
import school.admin.modules.sys.entity.SysLogEntity;
import school.admin.modules.sys.entity.SysUserEntity;
import school.db.service.CrudService;

import java.util.List;

@Slf4j
@Service(value = "sysUserServiceImpl")
public class SysUserServiceImpl extends CrudService<SysUserDao, SysUserEntity, Long> {

    /**
     * 查询用户的所有权限
     * @param userId  用户ID
     */
    public List<String> queryAllPerms(Long userId){
        return getDao().queryAllPerms(userId);
    }

    /**
     * 查询用户的所有菜单ID
     */
    @SysLog("测试Shiro的Service层AOP：queryAllMenuId")
    @Transactional(readOnly = false)
    public List<Long> queryAllMenuId(Long userId){
        return getDao().queryAllMenuId(userId);
    }

    /**
     * 修改密码
     * @param userId       用户ID
     * @param password     原密码
     * @param newPassword  新密码
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean updatePassword(Long userId, String password, String newPassword){
        return getDao().updatePassword(userId, password, newPassword);
    }



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void testSave(){
        SysUserEntity sysUserEntity = new SysUserEntity();
        sysUserEntity.setUsername("123");
        sysUserEntity = save(sysUserEntity);
        log.info(sysUserEntity.toString());
        sysUserEntity.setUsername("456");
        sysUserEntity = save(sysUserEntity);
        log.info(sysUserEntity.toString());
        testSave2();
    }
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void testSave2(){
        SysUserEntity sysUserEntity = new SysUserEntity();
        sysUserEntity.setUsername("789");
        sysUserEntity = save(sysUserEntity);
        log.info(sysUserEntity.toString());
        int a = 1/0;
    }


}
