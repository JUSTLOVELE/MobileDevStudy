package org.yzl.java.frame.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQMessageProducer;
import org.apache.activemq.AsyncCallback;

import javax.jms.*;
import java.util.UUID;

/**
 * @author yangzl 2020.07.24
  异步
 */
public class JmsProduce_AsyncSend{

    public static final String ACTIVEMQ_URL = "tcp://127.0.0.1:61616";

    public static final String QUEUE_NAME = "queue-AsyncSend";

    public static void main(String[] args) {

        try {
            ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
            activeMQConnectionFactory.setUseAsyncSend(true);
            Connection connection = activeMQConnectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            Queue queue = session.createQueue(QUEUE_NAME);
            ActiveMQMessageProducer activeMQMessageProducer = (ActiveMQMessageProducer) session.createProducer(queue);

            TextMessage textMessage = null;

            for (int i = 0; i < 15; i++) {
                textMessage = session.createTextMessage("msg---" + i);
                textMessage.setJMSMessageID(UUID.randomUUID().toString()+"queue");
                String magid = textMessage.getJMSMessageID();
                activeMQMessageProducer.send(textMessage, new AsyncCallback() {

                    public void onException(JMSException e) {

                    }

                    public void onSuccess() {

                    }
                });
            }

            activeMQMessageProducer.close();
            session.close();
            connection.close();

            System.out.println("发送结束！");

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}