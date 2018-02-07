package school.management.admin.modules.business.visa.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import school.management.admin.common.annotation.SysLog;
import school.management.admin.modules.business.visa.dao.VisaAdminDao;
import school.management.business.visa.service.BaseInformationServiceImpl;
import school.management.business.visa.entity.BaseInformation;

import java.util.List;

@Slf4j
@Service(value = "visaAdminServiceImpl")
public class VisaAdminServiceImpl {

    @Autowired
    BaseInformationServiceImpl baseInformationServiceImpl;
    @Autowired
    VisaAdminDao visaAdminDao;

    @Transactional(readOnly = true)
//    @DataSource(name = DataSourceNames.BUSINESS_SYSTEM)
    public BaseInformation getBaseInformation(Integer baseInformationId){
        return baseInformationServiceImpl.get(baseInformationId);
    }
    @SysLog
    public BaseInformation saveBaseInformation(BaseInformation baseInformation){
        return baseInformationServiceImpl.save(baseInformation);
    }
    @Transactional(readOnly = true)
    public List<BaseInformation> getBaseInformationList(){
        return visaAdminDao.getBaseInformationList();
    }




/**
 * JPA 测试
 */
//    @Autowired
//    BaseInformationRepository baseInformationRepository;
//
//    @Transactional(readOnly = true)
//    public BaseInformation getBaseInformationForJpa(Integer baseInformationId){
//        return baseInformationRepository.findOne(baseInformationId);
//    }
//    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
//    public BaseInformation saveBaseInformationForJpa(BaseInformation baseInformation){
//        return baseInformationRepository.saveAndFlush(baseInformation);
//    }

}
