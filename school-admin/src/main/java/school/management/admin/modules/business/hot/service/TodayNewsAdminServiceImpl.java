package school.management.admin.modules.business.hot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.management.business.businesshelp.entity.BusinessHeadlines;
import school.management.business.businesshelp.entity.SuccessCase;
import school.management.business.businesshelp.service.BusinessHeadlinesServiceImpl;
import school.management.business.businesshelp.service.SuccessCaseServiceImpl;
import school.management.business.hot.entity.TodayNews;
import school.management.business.hot.service.TodayNewsServiceImpl;
import school.management.db.utils.PageUtils;

import java.util.Date;
import java.util.Map;

@Slf4j
@Service(value = "todayNewsAdminServiceImpl")
public class TodayNewsAdminServiceImpl {

    @Autowired
    TodayNewsServiceImpl todayNewsServiceImpl;

    public PageUtils<TodayNews> todayNewsQueryPageMap(Map<String, Object> params){
        return todayNewsServiceImpl.queryPageMap(params);
    }
    public TodayNews todayNewsInfo(int id){
        return todayNewsServiceImpl.get(id);
    }

    public TodayNews saveOrUpDateTodayNews(TodayNews todayNews){
    	todayNews.setCreateTime(new Date());
        return todayNewsServiceImpl.save(todayNews);
    }

    public void delTodayNewsByIds(Integer[] ids){
    	todayNewsServiceImpl.deleteBatchByIds(ids);
    }
   
}
