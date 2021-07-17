package messagequeue.entity;

import lombok.Data;
import org.springframework.http.HttpHeaders;

/**
 * @author Yunfei Shen
 */
@Data
public class Notification {

    public Notification(NotifyInfo notifyInfo, HttpHeaders httpHeaders) {
        this.notifyInfo = notifyInfo;
        this.httpHeaders = httpHeaders;
    }

    private NotifyInfo notifyInfo;
    private HttpHeaders httpHeaders;
}
