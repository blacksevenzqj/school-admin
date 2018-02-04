package school.admin.modules.sys.dao;

import school.admin.modules.sys.entity.SysMenuEntity;
import school.db.dao.CrudDao;
import java.util.List;

/**
 * 菜单管理
 */
public interface SysMenuDao extends CrudDao<SysMenuEntity, Long> {
	
	/**
	 * 根据父菜单，查询子菜单
	 * @param parentId 父菜单ID
	 */
	List<SysMenuEntity> queryListParentId(Long parentId);
	
	/**
	 * 获取不包含按钮的菜单列表
	 */
	List<SysMenuEntity> queryNotButtonList();

}
