package school.management.admin.modules.business.businesshelp.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.management.admin.common.annotation.SysLog;
import school.management.admin.modules.business.businesshelp.service.BusinessHelpAdminServiceImpl;
import school.management.admin.modules.sys.controller.AbstractController;
import school.management.admin.modules.sys.entity.SysUserEntity;
import school.management.business.businesshelp.entity.BusinessHeadlines;
import school.management.common.utils.R;
import school.management.common.validator.ValidatorUtils;
import school.management.common.validator.group.AddGroup;
import school.management.common.validator.group.UpdateGroup;
import school.management.db.utils.PageUtils;

import java.util.Map;

@RestController
@RequestMapping("/businesshelp")
public class BusinessHelpController extends AbstractController {

    @Autowired
    BusinessHelpAdminServiceImpl businessHelpAdminServiceImpl;

    /**
     * 创业头条
     */
    @RequestMapping("/headlines/list")
    @RequiresPermissions("business:businesshelp:headlines:list")
    public R headlinesList(@RequestParam Map<String, Object> params){
        PageUtils page = businessHelpAdminServiceImpl.headlinesQueryPageMap(params);
        return R.ok().put("page", page);
    }
    @RequestMapping("/headlines/info/{id}")
    public R headlinesInfo(@PathVariable("id") int id){
        return R.ok().put("headlines", businessHelpAdminServiceImpl.headlinesInfo(id));
    }
    @SysLog("保存创业头条")
    @RequestMapping("/headlines/save")
    @RequiresPermissions("business:businesshelp:headlines:save")
    public R save(@RequestBody BusinessHeadlines businessHeadlines){
        ValidatorUtils.validateEntity(businessHeadlines, AddGroup.class);
        return R.ok();
    }
    @SysLog("修改创业头条")
    @RequestMapping("/headlines/update")
    @RequiresPermissions("business:businesshelp:headlines:update")
    public R update(@RequestBody BusinessHeadlines businessHeadlines){
        ValidatorUtils.validateEntity(businessHeadlines, UpdateGroup.class);
        return R.ok();
    }

}
