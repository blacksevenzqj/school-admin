package school.management.admin.modules.business.visa.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import school.management.admin.common.annotation.SysLog;
import school.management.admin.modules.business.visa.dao.VisaAdminDao;
import school.management.business.visa.entity.*;
import school.management.business.visa.service.*;
import school.management.db.utils.PageUtils;

import java.util.List;
import java.util.Map;

@Slf4j
@Service(value = "visaAdminServiceImpl")
public class VisaAdminServiceImpl {

    @Autowired
    VisaAdminDao visaAdminDao;

    /**
     * 签证_主类：
     */
    @Autowired
    VisaServiceImpl visaServiceImpl;

    public PageUtils<Visa> visaQueryPageMap(Map<String, Object> params){
        return visaServiceImpl.queryPageMap(params);
    }
    public Visa visaInfo(Integer id){
        return visaServiceImpl.get(id);
    }
    public Visa saveOrUpDateVisa(Visa visa){
        return visaServiceImpl.save(visa);
    }
    public void delVisaByIds(Integer[] ids){
        visaServiceImpl.deleteBatchByIds(ids);
    }

    /**
     * 套餐_主类：
     */
    VisaComboServiceImpl visaComboServiceImpl;

    public PageUtils<VisaCombo> visaComboQueryPageMap(Map<String, Object> params){
        return visaComboServiceImpl.queryPageMap(params);
    }
    public VisaCombo visaComboInfo(Integer id){
        return visaComboServiceImpl.get(id);
    }
    public VisaCombo saveOrUpDateVisaCombo(VisaCombo visaCombo){
        return visaComboServiceImpl.save(visaCombo);
    }
    public void delVisaComboByIds(Integer[] ids){
        visaComboServiceImpl.deleteBatchByIds(ids);
    }


    /**
     * 套餐_基本信息：
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
     * 套餐_须知：
     */
    @Autowired
    NeedKnowServiceImpl needKnowServiceImpl;

    public PageUtils<NeedKnow> needKnowQueryPageMap(Map<String, Object> params){
        return needKnowServiceImpl.queryPageMap(params);
    }
    public NeedKnow needKnowInfo(Integer id){
        return needKnowServiceImpl.get(id);
    }
    public NeedKnow saveOrUpDateNeedKnow(NeedKnow needKnow){
        return needKnowServiceImpl.save(needKnow);
    }
    public void delNeedKnowByIds(Integer[] ids){
        needKnowServiceImpl.deleteBatchByIds(ids);
    }


// =====================================================================================================================

    /**
     * 签证_主类：套餐_主类：套餐_基本信息：关系表
     */
    @Autowired
    ComboRalationBaseInformationServiceImpl comboRalationBaseInformationServiceImpl;

    public ComboRalationBaseInformation saveOrUpDateComboRalationBaseInformation(ComboRalationBaseInformation comboRalationBaseInformation){
        return comboRalationBaseInformationServiceImpl.save(comboRalationBaseInformation);
    }
    public void delComboRalationBaseInformationByIds(Integer[] ids){
        comboRalationBaseInformationServiceImpl.deleteBatchByIds(ids);
    }

    /**
     * 签证_主类：套餐_主类：套餐_须知：关系表
     */
    @Autowired
    ComboRalationNeedKnowServiceImpl comboRalationNeedKnowServiceImpl;

    public ComboRalationNeedKnow saveOrUpDateComboRalationNeedKnow(ComboRalationNeedKnow comboRalationNeedKnow){
        return comboRalationNeedKnowServiceImpl.save(comboRalationNeedKnow);
    }
    public void delComboRalationNeedKnowByIds(Integer[] ids){
        comboRalationNeedKnowServiceImpl.deleteBatchByIds(ids);
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
