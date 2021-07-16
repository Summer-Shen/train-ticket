package messagequeue.producer;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import java.util.Map;

/**
 * @author Yunfei Shen
 * @param <T>
 */
public abstract class AbstractProducer<T> {
    /**
     *
     * @param t type for message
     * @param headersMap map of headers
     * @return new message object
     */
    public Message<T> newMessage(T t, Map<String, Object> headersMap) {
        return new Message<T>() {
            @Override
            public T getPayload() {
                return t;
            }

            @Override
            public MessageHeaders getHeaders() {
                return new MessageHeaders(headersMap);
            }
        };
    }

    /**
     *
     * @param topic topic of message
     * @param tag tag of message
     * @return a str representation of message destination
     */
    public String newDestination(String topic, String tag) {
        return topic + ":" + tag;
    }
}
