package school.admin.modules.sys.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import school.admin.modules.sys.dao.SysUserRoleDao;
import school.admin.modules.sys.entity.SysUserRoleEntity;
import school.db.service.CrudService;

import java.util.ArrayList;
import java.util.List;


/**
 * 用户与角色对应关系
 */
@Service("sysUserRoleServiceImpl")
public class SysUserRoleServiceImpl extends CrudService<SysUserRoleDao, SysUserRoleEntity> {

	public void saveOrUpdate(Long userId, List<Long> roleIdList) {
		//先删除用户与角色关系
		this.deleteByMap(new MapUtils().put("user_id", userId));

		if(roleIdList.size() == 0){
			return ;
		}
		
		//保存用户与角色关系
		List<SysUserRoleEntity> list = new ArrayList<>(roleIdList.size());
		for(Long roleId : roleIdList){
			SysUserRoleEntity sysUserRoleEntity = new SysUserRoleEntity();
			sysUserRoleEntity.setUserId(userId);
			sysUserRoleEntity.setRoleId(roleId);

			list.add(sysUserRoleEntity);
		}
		this.insertBatch(list);
	}

	public List<Long> queryRoleIdList(Long userId) {
		return baseMapper.queryRoleIdList(userId);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteBatch(Long[] roleIds){
		this.deleteBatchByIds(roleIds);
	}
}
