package school.management.business.airticket.entity.vo;

import lombok.Data;
import school.management.business.airticket.entity.base.AirTicketOrder;
import school.management.business.airticket.entity.fobook.DailyLowestPriceVO;
import java.util.List;

@Data
public class AirTicketOrderVo extends AirTicketOrder {

    private String userName;

    private List<DailyLowestPriceVO> routingList;

    private String goCityName;

}
