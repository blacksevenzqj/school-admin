package school.admin.modules.sys.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import school.admin.modules.sys.dao.SysUserDao;
import school.admin.modules.sys.entity.SysUserEntity;
import school.db.service.CrudService;

import java.util.List;

@Slf4j
@Service(value = "sysUserServiceImpl")
public class SysUserServiceImpl extends CrudService<SysUserDao, SysUserEntity> {

    /**
     * 查询用户的所有菜单ID
     */
    List<Long> queryAllMenuId(Long userId){
        return getDao().queryAllMenuId(userId);
    }

    /**
     * 修改密码
     * @param userId       用户ID
     * @param password     原密码
     * @param newPassword  新密码
     */
    boolean updatePassword(Long userId, String password, String newPassword){
        return getDao().updatePassword(userId, password, newPassword);
    }

}
