package school.management.admin.modules.business.school.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.management.admin.common.annotation.SysLog;
import school.management.admin.common.aspect.SysLogConfig;
import school.management.admin.modules.business.school.service.TopicAdminServiceImpl;
import school.management.admin.modules.sys.controller.AbstractController;
import school.management.business.school.entity.HtTopic;
import school.management.common.utils.R;
import school.management.common.validator.ValidatorUtils;
import school.management.common.validator.group.UpdateGroup;
import school.management.db.utils.PageUtils;
import java.util.Map;

@RestController
@RequestMapping("/school")
public class TopicController extends AbstractController {

    @Autowired
    TopicAdminServiceImpl topicAdminServiceImpl;

    /**
     * 热门话题
     */
    @RequestMapping(value = "/topic/list", method = RequestMethod.GET)
    @RequiresPermissions("business:school:topic:list")
    public R topicList(@RequestParam Map<String, Object> params){
        PageUtils page = topicAdminServiceImpl.topicQueryPageMap(params);
        return R.ok().put("page", page);
    }
    @RequestMapping(value = "/topic/info/{id}", method = RequestMethod.GET)
    @RequiresPermissions("business:school:topic:info")
    public R topicInfo(@PathVariable("id") int id){
        return R.ok().put("topic", topicAdminServiceImpl.topicInfo(id));
    }
    @RequestMapping(value = "/topic/save", method = RequestMethod.POST)
    @RequiresPermissions("business:school:topic:save")
    @SysLog(SysLogConfig.ADD + SysLogConfig.COLON  + SysLogConfig.SCHOOL + SysLogConfig.COLON + SysLogConfig.HTTOPIC)
    public R saveTopic(@RequestBody HtTopic htTopic){
        ValidatorUtils.validateEntity(htTopic);
        topicAdminServiceImpl.saveOrUpDateTopic(htTopic);
        return R.ok();
    }
    @RequestMapping(value = "/topic/update", method = RequestMethod.POST)
    @RequiresPermissions("business:school:topic:update")
    @SysLog(SysLogConfig.UPDATE + SysLogConfig.COLON  + SysLogConfig.SCHOOL + SysLogConfig.COLON + SysLogConfig.HTTOPIC)
    public R updateTopic(@RequestBody HtTopic htTopic){
        ValidatorUtils.validateEntity(htTopic, UpdateGroup.class);
        topicAdminServiceImpl.saveOrUpDateTopic(htTopic);
        return R.ok();
    }
    @RequestMapping(value = "/topic/del", method = RequestMethod.POST)
    @RequiresPermissions("business:school:topic:del")
    @SysLog(SysLogConfig.DEL + SysLogConfig.COLON  + SysLogConfig.SCHOOL + SysLogConfig.COLON + SysLogConfig.HTTOPIC)
    public R delTopic(@RequestBody Integer[] ids){
        topicAdminServiceImpl.delTopicByIds(ids);
        return R.ok();
    }

}
