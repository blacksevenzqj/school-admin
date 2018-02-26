package school.management.admin.modules.business.businesshelp.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.management.business.businesshelp.entity.BusinessHeadlines;
import school.management.business.businesshelp.entity.SuccessCase;
import school.management.business.businesshelp.service.BusinessHeadlinesServiceImpl;
import school.management.business.businesshelp.service.SuccessCaseServiceImpl;
import school.management.db.utils.PageUtils;

import java.util.Date;
import java.util.Map;

@Slf4j
@Service(value = "businessHelpAdminServiceImpl")
public class BusinessHelpAdminServiceImpl {

    @Autowired
    BusinessHeadlinesServiceImpl businessHeadlinesServiceImpl;
    
    @Autowired
    SuccessCaseServiceImpl successCaseServiceImpl;

    public PageUtils<BusinessHeadlines> headlinesQueryPageMap(Map<String, Object> params){
        return businessHeadlinesServiceImpl.queryPageMap(params);
    }
    public BusinessHeadlines headlinesInfo(int id){
        return businessHeadlinesServiceImpl.get(id);
    }

    public BusinessHeadlines saveOrUpDateHeadlines(BusinessHeadlines businessHeadlines){
        businessHeadlines.setCreateTime(new Date());
        return businessHeadlinesServiceImpl.save(businessHeadlines);
    }

    public void delHeadlinesByIds(Integer[] ids){
        businessHeadlinesServiceImpl.deleteBatchByIds(ids);
    }

    public PageUtils<SuccessCase> successCaseQueryPageMap(Map<String, Object> params){
        return successCaseServiceImpl.queryPageMap(params);
    }

    public SuccessCase saveOrUpDateSuccessCase(SuccessCase successCase){
    	successCase.setCreateTime(new Date());
        return successCaseServiceImpl.save(successCase);
    }
    
    public SuccessCase successCaseInfo(int id){
        return successCaseServiceImpl.get(id);
    }
    
    public void delSuccessCaseByIds(Integer[] ids){
    	successCaseServiceImpl.deleteBatchByIds(ids);
    }
}
