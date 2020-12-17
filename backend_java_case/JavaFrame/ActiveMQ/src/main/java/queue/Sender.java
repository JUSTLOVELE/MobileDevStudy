package queue;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
1.创建连接使用的工厂类JMS ConnectionFactory 
2.使用管理对象JMS ConnectionFactory建立连接Connection 
3.使用连接Connection 建立会话Session 
4.使用会话Session和管理对象Destination创建消息生产者MessageSender 
5.使用消息生产者MessageProducer发送消息
 * @author yangzuliang
 *
 */
public class Sender {

	private static final int SEND_NUMBER = 5;
	
	public static void main(String[] args) throws Exception {
		//ConnectionFactory ：连接工厂，JMS 用它创建连接
		ConnectionFactory connectionFactory;
		//JMS 客户端到JMS Provider 的连接
		Connection connection = null;
		//Session： 一个发送或接收消息的线程
		Session session;
		//Destination ：消息的目的地;消息发送给谁.
		Destination destination;
		//MessageProducer：消息发送者
		MessageProducer producer;
		// 构造ConnectionFactory实例对象，此处采用ActiveMq的实现jar
		connectionFactory = new ActiveMQConnectionFactory( ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD, "tcp://localhost:61616");
		// 构造从工厂得到连接对象
		//connection = connectionFactory.createConnection();
		//用连接池去连接
		connection = MQConnectionUtil.getInstance().getConnection();
		// 启动
		connection.start();
		// 获取操作连接
		session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
		 // 获取session注意参数值xingbo.xu-queue是一个服务器的queue，须在在ActiveMq的console配置
		destination = session.createQueue("messageQueue");
		 // 得到消息生成者【发送者】
        producer = session.createProducer(destination);
        // 设置持久化
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        // 构造消息，此处写死，项目就是参数，或者方法获取
        sendMessage(session, producer);
        session.commit();
        producer.close();
        session.close();
        connection.close();
	}
	
	public static void sendMessage(Session session, MessageProducer producer)
            throws Exception {
		 TextMessage message = session.createTextMessage("hello world");
         // 发送消息到目的地方
         producer.send(message);
    }
}
