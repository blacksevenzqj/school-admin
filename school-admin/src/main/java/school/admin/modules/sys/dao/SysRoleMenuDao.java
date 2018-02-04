package school.admin.modules.sys.dao;

import school.admin.modules.sys.entity.SysRoleMenuEntity;
import school.db.dao.CrudDao;

import java.util.List;

/**
 * 角色与菜单对应关系
 */
public interface SysRoleMenuDao extends CrudDao<SysRoleMenuEntity, Long> {
	
	/**
	 * 根据角色ID，获取菜单ID列表
	 */
	List<Long> queryMenuIdList(Long roleId);

}
