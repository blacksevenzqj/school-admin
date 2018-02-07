package school.management.admin.modules.business.businesshelp.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.management.business.businesshelp.entity.BusinessHeadlines;
import school.management.business.businesshelp.service.BusinessHeadlinesServiceImpl;
import school.management.db.utils.PageUtils;

import java.util.Map;

@Slf4j
@Service(value = "businessHelpAdminServiceImpl")
public class BusinessHelpAdminServiceImpl {

    @Autowired
    BusinessHeadlinesServiceImpl businessHeadlinesServiceImpl;

    public PageUtils<BusinessHeadlines> queryPageMap(Map<String, Object> params){
        return businessHeadlinesServiceImpl.queryPageMap(params);
    }

    public BusinessHeadlines saveBusinessHeadlines(BusinessHeadlines businessHeadlines){
        return businessHeadlinesServiceImpl.save(businessHeadlines);
    }


}
