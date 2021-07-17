package messagequeue.service;

import messagequeue.entity.NotifyInfo;
import messagequeue.producer.NotificationProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements MessageQueueService{

    private final NotificationProducer notificationProducer;

    @Autowired
    public NotificationServiceImpl(NotificationProducer notificationProducer) {
        this.notificationProducer = notificationProducer;
    }

    /**
     * send a notification with mq
     * @param notifyInfo notify info to be sent
     * @param httpHeaders http headers
     * @return whether notify info is successfully sent
     */
    public boolean sendNotification(NotifyInfo notifyInfo, HttpHeaders httpHeaders, String tag) {
        notificationProducer.produceMessage(notifyInfo, httpHeaders, tag);
        return true;
    }

}
