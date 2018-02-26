package school.management.admin.modules.business.businesshelp.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.management.admin.common.annotation.SysLog;
import school.management.admin.common.aspect.SysLogConfig;
import school.management.admin.modules.business.businesshelp.service.BusinessHelpAdminServiceImpl;
import school.management.admin.modules.sys.controller.AbstractController;
import school.management.admin.modules.sys.entity.SysUserEntity;
import school.management.business.businesshelp.entity.BusinessHeadlines;
import school.management.business.businesshelp.entity.SuccessCase;
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
    @RequestMapping(value = "/headlines/list", method = RequestMethod.GET)
    @RequiresPermissions("business:businesshelp:headlines:list")
    public R headlinesList(@RequestParam Map<String, Object> params){
        PageUtils page = businessHelpAdminServiceImpl.headlinesQueryPageMap(params);
        return R.ok().put("page", page);
    }
    @RequestMapping(value = "/headlines/info/{id}", method = RequestMethod.GET)
    @RequiresPermissions("business:businesshelp:headlines:info")
    public R headlinesInfo(@PathVariable("id") int id){
        return R.ok().put("headlines", businessHelpAdminServiceImpl.headlinesInfo(id));
    }
    @RequestMapping(value = "/headlines/save", method = RequestMethod.POST)
    @RequiresPermissions("business:businesshelp:headlines:save")
    @SysLog(SysLogConfig.ADD + SysLogConfig.COLON  + SysLogConfig.BUSINESSHELP + SysLogConfig.COLON + SysLogConfig.HEADLINES)
    public R saveHeadlines(@RequestBody BusinessHeadlines businessHeadlines){
        ValidatorUtils.validateEntity(businessHeadlines);
        businessHelpAdminServiceImpl.saveOrUpDateHeadlines(businessHeadlines);
        return R.ok();
    }
    @RequestMapping(value = "/headlines/update", method = RequestMethod.POST)
    @RequiresPermissions("business:businesshelp:headlines:update")
    @SysLog(SysLogConfig.UPDATE + SysLogConfig.COLON  + SysLogConfig.BUSINESSHELP + SysLogConfig.COLON + SysLogConfig.HEADLINES)
    public R updateHeadlines(@RequestBody BusinessHeadlines businessHeadlines){
        ValidatorUtils.validateEntity(businessHeadlines, UpdateGroup.class);
        businessHelpAdminServiceImpl.saveOrUpDateHeadlines(businessHeadlines);
        return R.ok();
    }
    @RequestMapping(value = "/headlines/del", method = RequestMethod.POST)
    @RequiresPermissions("business:businesshelp:headlines:del")
    @SysLog(SysLogConfig.DEL + SysLogConfig.COLON  + SysLogConfig.BUSINESSHELP + SysLogConfig.COLON + SysLogConfig.HEADLINES)
    public R delHeadlines(@RequestBody Integer[] ids){
        businessHelpAdminServiceImpl.delHeadlinesByIds(ids);
        return R.ok();
    }

    /**
     * 成功案例
     */
    //查询
    @RequestMapping(value = "/successCase/list", method = RequestMethod.GET)
    @RequiresPermissions("business:businesshelp:successCase:list")
    public R successCaseList(@RequestParam Map<String, Object> params){
        PageUtils page = businessHelpAdminServiceImpl.successCaseQueryPageMap(params);
        return R.ok().put("page", page);
    }
    
    @RequestMapping(value = "/successCase/info/{id}", method = RequestMethod.GET)
    @RequiresPermissions("business:businesshelp:successCase:info")
    public R successCaseInfo(@PathVariable("id") int id){
        return R.ok().put("successCase", businessHelpAdminServiceImpl.successCaseInfo(id));
    }
    //新增
    @RequestMapping(value = "/successCase/save", method = RequestMethod.POST)
    @RequiresPermissions("business:businesshelp:successCase:save")
    @SysLog(SysLogConfig.ADD + SysLogConfig.COLON  + SysLogConfig.BUSINESSHELP + SysLogConfig.COLON + SysLogConfig.SUCCESS)
    public R savesuccessCase(@RequestBody SuccessCase successCase){
        ValidatorUtils.validateEntity(successCase);
        businessHelpAdminServiceImpl.saveOrUpDateSuccessCase(successCase);
        return R.ok();
    }
    //修改
    @RequestMapping(value = "/successCase/update", method = RequestMethod.POST)
    @RequiresPermissions("business:businesshelp:successCase:update")
    @SysLog(SysLogConfig.UPDATE + SysLogConfig.COLON  + SysLogConfig.BUSINESSHELP + SysLogConfig.COLON + SysLogConfig.SUCCESS)
    public R updatesuccessCase(@RequestBody SuccessCase successCase){
        ValidatorUtils.validateEntity(successCase, UpdateGroup.class);
        businessHelpAdminServiceImpl.saveOrUpDateSuccessCase(successCase);
        return R.ok();
    }
    //删除
    @RequestMapping(value = "/successCase/del", method = RequestMethod.POST)
    @RequiresPermissions("business:businesshelp:successCase:del")
    @SysLog(SysLogConfig.DEL + SysLogConfig.COLON  + SysLogConfig.BUSINESSHELP + SysLogConfig.COLON + SysLogConfig.SUCCESS)
    public R delSuccessCase(@RequestBody Integer[] ids){
        businessHelpAdminServiceImpl.delSuccessCaseByIds(ids);
        return R.ok();
    }
}
