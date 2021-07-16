package messagequeue.entity;

import lombok.Data;

/**
 * @author Yunfei Shen
 */
@Data
public class NotifyInfo {

    public NotifyInfo() {
        // Default Constructor
    }

    private String email;
    private String orderNumber;
    private String username;
    private String startingPlace;
    private String endPlace;
    private String startingTime;
    private String date;
    private String seatClass;
    private String seatNumber;
    private String price;

}