package org.yzl.java.frame.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQMessageProducer;
import org.apache.activemq.AsyncCallback;
import org.apache.activemq.ScheduledMessage;

import javax.jms.*;
import java.util.UUID;

/**
 * @author yangzl 2020.07.24
 * @version 1.00.00
 * @Description:延时投递
 * @history:
 */
public class JmsProduce_DelayAndSchedule {

    public static final String ACTIVEMQ_URL = "tcp://127.0.0.1:61616";

    public static final String QUEUE_NAME = "queue-AsyncSend";

    public static void main(String[] args) {

        try {

            ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
            Connection connection = activeMQConnectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            Queue queue = session.createQueue(QUEUE_NAME);
            long delay = 3 * 1000; //延迟投递的时间 3s
            long perrid = 4 *1000; //重复投递的时间间隔 4秒
            int repeat = 5; //重复投递的次数

            MessageProducer activeMQMessageProducer = (MessageProducer) session.createProducer(queue);
            TextMessage textMessage = null;

            for (int i = 0; i < 15; i++) {

                textMessage = session.createTextMessage("delay msg---" + i);
                textMessage.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, delay);
                textMessage.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_PERIOD, perrid);
                textMessage.setIntProperty(ScheduledMessage.AMQ_SCHEDULED_REPEAT, repeat);
                activeMQMessageProducer.send(textMessage);
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
