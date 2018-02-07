package school.management.admin.modules.business.businesshelp.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import school.management.admin.modules.business.businesshelp.service.BusinessHelpAdminServiceImpl;
import school.management.admin.modules.sys.controller.AbstractController;
import school.management.common.utils.R;
import school.management.db.utils.PageUtils;

import java.util.Map;

@RestController
@RequestMapping("/businesshelp")
public class BusinessHelpController extends AbstractController {

    @Autowired
    BusinessHelpAdminServiceImpl businessHelpAdminServiceImpl;


    /**
     * 创业头条列表
     */
    @RequestMapping("/headlines/list")
    @RequiresPermissions("business:businesshelp:headlines:list")
    public R headlinesList(@RequestParam Map<String, Object> params){
        PageUtils page = businessHelpAdminServiceImpl.queryPageMap(params);
        return R.ok().put("page", page);
    }



}
