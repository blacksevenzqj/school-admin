package school.management.admin.modules.business.visa.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import school.management.admin.common.annotation.SysLog;
import school.management.admin.modules.business.visa.dao.VisaAdminDao;
import school.management.business.visa.entity.Visa;
import school.management.business.visa.service.BaseInformationServiceImpl;
import school.management.business.visa.entity.BaseInformation;
import school.management.business.visa.service.VisaServiceImpl;
import school.management.db.utils.PageUtils;

import java.util.List;
import java.util.Map;

@Slf4j
@Service(value = "visaAdminServiceImpl")
public class VisaAdminServiceImpl {

    @Autowired
    VisaAdminDao visaAdminDao;

    /**
     * 主类：
     */
    @Autowired
    VisaServiceImpl visaServiceImpl;

    public PageUtils<Visa> visaQueryPageMap(Map<String, Object> params){
        return visaServiceImpl.queryPageMap(params);
    }
    public Visa visaInfo(Integer id){
        return visaServiceImpl.get(id);
    }
    public Visa saveOrUpDateVisa(Visa baseInformation){
        return visaServiceImpl.save(baseInformation);
    }
    public void delVisaByIds(Integer[] ids){
        visaServiceImpl.deleteBatchByIds(ids);
    }



    /**
     * 基本信息：
     */
    @Autowired
    BaseInformationServiceImpl baseInformationServiceImpl;

//    @DataSource(name = DataSourceNames.BUSINESS_SYSTEM)
    public PageUtils<BaseInformation> baseInformationQueryPageMap(Map<String, Object> params){
        return baseInformationServiceImpl.queryPageMap(params);
    }
    public BaseInformation baseInformationInfo(Integer id){
        return baseInformationServiceImpl.get(id);
    }
    public BaseInformation saveOrUpDateBaseInformation(BaseInformation baseInformation){
        return baseInformationServiceImpl.save(baseInformation);
    }
    public void delBaseInformationByIds(Integer[] ids){
        baseInformationServiceImpl.deleteBatchByIds(ids);
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
