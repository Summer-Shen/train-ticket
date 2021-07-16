package messagequeue.producer;

import messagequeue.entity.NotifyInfo;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class NotificationProducer extends AbstractProducer<NotifyInfo>{

    private final RocketMQTemplate rocketMQTemplate;

    @Autowired
    public NotificationProducer(RocketMQTemplate rocketMQTemplate) {
        this.rocketMQTemplate = rocketMQTemplate;
    }

    public void produceMessage(NotifyInfo notifyInfo, HttpHeaders httpHeaders, String tag) {
        String destination = newDestination("notification", tag);
        Map<String, Object> headersMap = new HashMap<>();
        headersMap.put("httpHeaders", httpHeaders);
        Message<NotifyInfo> message = newMessage(notifyInfo, headersMap);
        // TODO: possibly another delayLevel?
        rocketMQTemplate.asyncSend(destination, message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println(sendResult);
            }

            @Override
            public void onException(Throwable e) {
                System.out.println(e.getMessage());
            }
        }, 0, 1);
    }
}
