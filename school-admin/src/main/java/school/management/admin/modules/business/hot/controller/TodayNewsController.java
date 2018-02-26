package school.management.admin.modules.business.hot.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.management.admin.common.annotation.SysLog;
import school.management.admin.common.aspect.SysLogConfig;
import school.management.admin.modules.business.businesshelp.service.BusinessHelpAdminServiceImpl;
import school.management.admin.modules.business.hot.service.TodayNewsAdminServiceImpl;
import school.management.admin.modules.sys.controller.AbstractController;
import school.management.admin.modules.sys.entity.SysUserEntity;
import school.management.business.businesshelp.entity.BusinessHeadlines;
import school.management.business.businesshelp.entity.SuccessCase;
import school.management.business.hot.entity.TodayNews;
import school.management.common.utils.R;
import school.management.common.validator.ValidatorUtils;
import school.management.common.validator.group.AddGroup;
import school.management.common.validator.group.UpdateGroup;
import school.management.db.utils.PageUtils;

import java.util.Map;

@RestController
@RequestMapping("/hot")
public class TodayNewsController extends AbstractController {

    @Autowired
    TodayNewsAdminServiceImpl todayNewsAdminServiceImpl;

    /**
     * 今日热点
     */
    @RequestMapping(value = "/todaynews/list", method = RequestMethod.GET)
    @RequiresPermissions("business:hot:todaynews:list")
    public R todayNewsList(@RequestParam Map<String, Object> params){
        PageUtils page = todayNewsAdminServiceImpl.todayNewsQueryPageMap(params);
        return R.ok().put("page", page);
    }
    @RequestMapping(value = "/todaynews/info/{id}", method = RequestMethod.GET)
    @RequiresPermissions("business:hot:todaynews:info")
    public R todayNewsInfo(@PathVariable("id") int id){
        return R.ok().put("todaynews", todayNewsAdminServiceImpl.todayNewsInfo(id));
    }
    @RequestMapping(value = "/todaynews/save", method = RequestMethod.POST)
    @RequiresPermissions("business:hot:todaynews:save")
    @SysLog(SysLogConfig.ADD + SysLogConfig.COLON  + SysLogConfig.HOT + SysLogConfig.COLON + SysLogConfig.TODAYNEWS)
    public R saveHeadlines(@RequestBody TodayNews todayNews){
        ValidatorUtils.validateEntity(todayNews);
        todayNewsAdminServiceImpl.saveOrUpDateTodayNews(todayNews);
        return R.ok();
    }
    @RequestMapping(value = "/todaynews/update", method = RequestMethod.POST)
    @RequiresPermissions("business:hot:todaynews:update")
    @SysLog(SysLogConfig.UPDATE + SysLogConfig.COLON  + SysLogConfig.HOT + SysLogConfig.COLON + SysLogConfig.TODAYNEWS)
    public R updateTodayNews(@RequestBody TodayNews todayNews){
        ValidatorUtils.validateEntity(todayNews, UpdateGroup.class);
        todayNewsAdminServiceImpl.saveOrUpDateTodayNews(todayNews);
        return R.ok();
    }
    @RequestMapping(value = "/todaynews/del", method = RequestMethod.POST)
    @RequiresPermissions("business:hot:todaynews:del")
    @SysLog(SysLogConfig.DEL + SysLogConfig.COLON  + SysLogConfig.HOT + SysLogConfig.COLON + SysLogConfig.TODAYNEWS)
    public R delTodayNews(@RequestBody Integer[] ids){
    	todayNewsAdminServiceImpl.delTodayNewsByIds(ids);
        return R.ok();
    }

}
