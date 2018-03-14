package school.management.admin.modules.business.airticket.dao;

import school.management.business.airticket.entity.vo.AirTicketOrderVo;

import java.util.List;
import java.util.Map;

public interface AirTicketOrderDao {

    List<AirTicketOrderVo> airTicketOrderQueryPageMap(Map<String, Object> queryMap);

}
