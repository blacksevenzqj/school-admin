package school.management.admin.modules.business.school.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.listener.Topic;
import org.springframework.stereotype.Service;
import school.management.business.businesshelp.entity.BusinessHeadlines;
import school.management.business.businesshelp.entity.SuccessCase;
import school.management.business.businesshelp.service.BusinessHeadlinesServiceImpl;
import school.management.business.businesshelp.service.SuccessCaseServiceImpl;
import school.management.business.hot.entity.TodayNews;
import school.management.business.hot.service.TodayNewsServiceImpl;
import school.management.business.school.entity.HtTopic;
import school.management.business.school.service.HtTopicServiceImpl;
import school.management.db.utils.PageUtils;

import java.util.Date;
import java.util.Map;

@Slf4j
@Service(value = "topicAdminServiceImpl")
public class TopicAdminServiceImpl {

    @Autowired
    HtTopicServiceImpl htTopicServiceImpl;

    public PageUtils<HtTopic> topicQueryPageMap(Map<String, Object> params){
        return htTopicServiceImpl.queryPageMap(params);
    }
    public HtTopic topicInfo(int id){
        return htTopicServiceImpl.get(id);
    }

    public HtTopic saveOrUpDateTopic(HtTopic topic){
    	topic.setCreateTime(new Date());
        return htTopicServiceImpl.save(topic);
    }

    public void delTopicByIds(Integer[] ids){
    	htTopicServiceImpl.deleteBatchByIds(ids);
    }
   
}
