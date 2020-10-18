package org.yzl.java.frame.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsProduce_Topic {

    public static final String ACTIVEMQ_URL = "tcp://127.0.0.1:61616";

    public static final String TOPIC_NAME = "topic01";

    public static void main(String[] args) {

        try {
            //1.创建连接工厂,按照给定的url地址,采用默认用户名和密码
            ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
            //2.通过连接工场,获得连接connection
            Connection connection = activeMQConnectionFactory.createConnection();
            connection.start();
            //3.创建会话session
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            //4.创建目的地,具体是队列还是主题
            Topic topic = session.createTopic(TOPIC_NAME);
            //5.创建消息的生产者
            MessageProducer messageProducer = session.createProducer(topic);
            //6.通过使用messageProducer生产3条消息发送到MQ的队列里面
            for(int i=1; i<=3; i++) {
                //7.创建消息
                TextMessage textMessage = session.createTextMessage("msg---" + i);//理解为一个字符串
                //8.通过messageProducer发送给MQ
                messageProducer.send(textMessage);
            }
            //9.关闭资源
            messageProducer.close();
            session.close();
            connection.close();
            System.out.println("****消息发布到MQ完成");

        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}