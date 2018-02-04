package school.admin.modules.sys.dao;

import school.admin.modules.sys.entity.SysUserRoleEntity;
import school.db.dao.CrudDao;

import java.util.List;

/**
 * 用户与角色对应关系
 */
public interface SysUserRoleDao extends CrudDao<SysUserRoleEntity> {
	
	/**
	 * 根据用户ID，获取角色ID列表
	 */
	List<Long> queryRoleIdList(Long userId);

}
