package school.management.admin.modules.business.visa.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.management.admin.common.annotation.SysLog;
import school.management.admin.common.aspect.SysLogConfig;
import school.management.admin.modules.business.businesshelp.service.BusinessHelpAdminServiceImpl;
import school.management.admin.modules.business.visa.service.VisaAdminServiceImpl;
import school.management.admin.modules.sys.controller.AbstractController;
import school.management.business.businesshelp.entity.BusinessHeadlines;
import school.management.common.utils.R;
import school.management.common.validator.ValidatorUtils;
import school.management.common.validator.group.UpdateGroup;
import school.management.db.utils.PageUtils;

import java.util.Map;

@RestController
@RequestMapping("/visa")
public class VisaController extends AbstractController {

    @Autowired
    BusinessHelpAdminServiceImpl businessHelpAdminServiceImpl;

    @Autowired
    VisaAdminServiceImpl visaAdminServiceImpl;

    /**
     * 国家
     */
    @RequestMapping(value = "/country/list", method = RequestMethod.GET)
    @RequiresPermissions("business:visa:country:list")
    public R countryList(@RequestParam Map<String, Object> params){
        PageUtils page = visaAdminServiceImpl.visaQueryPageMap(params);
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

}
