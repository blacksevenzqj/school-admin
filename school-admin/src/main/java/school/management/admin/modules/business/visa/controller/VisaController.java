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
import school.management.business.visa.entity.Visa;
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
        PageUtils page = visaAdminServiceImpl.visaCountryQueryPageMap(params);
        return R.ok().put("page", page);
    }
    @RequestMapping(value = "/country/info/{id}", method = RequestMethod.GET)
    @RequiresPermissions("business:visa:country:info")
    public R headlinesInfo(@PathVariable("id") int id){
        return R.ok().put("country", visaAdminServiceImpl.visaCountryInfo(id));
    }
    @RequestMapping(value = "/country/save", method = RequestMethod.POST)
    @RequiresPermissions("business:visa:country:save")
    @SysLog(SysLogConfig.ADD + SysLogConfig.COLON  + SysLogConfig.VISA + SysLogConfig.COLON + SysLogConfig.COUNTRY)
    public R saveHeadlines(@RequestBody Visa visa){
        ValidatorUtils.validateEntity(visa);
        visaAdminServiceImpl.saveOrUpDateVisaCountry(visa);
        return R.ok();
    }
    @RequestMapping(value = "/country/update", method = RequestMethod.POST)
    @RequiresPermissions("business:visa:country:update")
    @SysLog(SysLogConfig.UPDATE + SysLogConfig.COLON  + SysLogConfig.VISA + SysLogConfig.COLON + SysLogConfig.COUNTRY)
    public R updateHeadlines(@RequestBody Visa visa){
        ValidatorUtils.validateEntity(visa, UpdateGroup.class);
        visaAdminServiceImpl.saveOrUpDateVisaCountry(visa);
        return R.ok();
    }
    @RequestMapping(value = "/country/del", method = RequestMethod.POST)
    @RequiresPermissions("business:visa:country:del")
    @SysLog(SysLogConfig.DEL + SysLogConfig.COLON  + SysLogConfig.VISA + SysLogConfig.COLON + SysLogConfig.COUNTRY)
    public R delHeadlines(@RequestBody Integer[] ids){
        visaAdminServiceImpl.delVisaCountryByIds(ids);
        return R.ok();
    }

}
