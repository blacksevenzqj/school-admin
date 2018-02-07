package school.management.admin.modules.business.businesshelp.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import school.management.admin.modules.sys.controller.AbstractController;
import school.management.common.utils.R;
import school.management.db.utils.PageUtils;

import java.util.Map;

@RestController
@RequestMapping("/businesshelp")
public class BusinessHelpController extends AbstractController {

    /**
     * 所有用户列表
     */
    @RequestMapping("/headlines/list")
    @RequiresPermissions("business:businesshelp:headlines:list")
    public R headlinesList(@RequestParam Map<String, Object> params){
//        PageUtils page = sysUserService.queryPageMap(params);
//        return R.ok().put("page", page);
        return null;
    }

}
