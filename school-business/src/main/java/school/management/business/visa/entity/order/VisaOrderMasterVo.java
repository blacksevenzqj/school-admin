package school.management.business.visa.entity.order;

import lombok.Data;

import java.util.List;

@Data
public class VisaOrderMasterVo extends VisaOrderMaster{

    List<VisaOrderDetail> orderDetailList;

}
