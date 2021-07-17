package messagequeue.consumer;

import messagequeue.entity.Notification;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Component
@RocketMQMessageListener(topic = "notification", consumerGroup = "notification")
public class NotificationConsumer extends AbstractConsumer<Notification> {

    private final RestTemplate restTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationConsumer.class);

    @Autowired
    public NotificationConsumer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void onMessage(Notification message) {
        NotificationConsumer.LOGGER.info("[Notification Consumer][Send Email]");
        HttpEntity requestEntitySendEmail = new HttpEntity(message.getNotifyInfo(), message.getHttpHeaders());
        ResponseEntity<Boolean> reSendEmail = restTemplate.exchange(
                "http://ts-notification-service:17853/api/v1/notifyservice/notification/preserve_success",
                HttpMethod.POST,
                requestEntitySendEmail,
                Boolean.class);
        // TODO: what to do w/ reSendEmail?
    }
}
