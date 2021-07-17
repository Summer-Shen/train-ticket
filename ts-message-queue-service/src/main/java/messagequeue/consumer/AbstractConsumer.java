package messagequeue.consumer;

import org.apache.rocketmq.spring.core.RocketMQListener;

/**
 *
 * @param <T>
 */
public abstract class AbstractConsumer<T> implements RocketMQListener<T> {
}
