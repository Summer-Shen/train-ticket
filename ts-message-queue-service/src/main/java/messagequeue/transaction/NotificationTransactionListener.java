package messagequeue.transaction;

import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

/**
 * Listens for notification transaction
 * @author Yunfei Shen
 */
public class NotificationTransactionListener implements TransactionListener {
    @Override
    public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        // TODO: what to return / when to commit
        // local transaction process
        if (true) {
            return LocalTransactionState.COMMIT_MESSAGE;
        }
        return LocalTransactionState.ROLLBACK_MESSAGE;
    }

    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt msg) {
        // TODO: what to return / when to commit
        // check transaction status
        return LocalTransactionState.COMMIT_MESSAGE;
    }
}
