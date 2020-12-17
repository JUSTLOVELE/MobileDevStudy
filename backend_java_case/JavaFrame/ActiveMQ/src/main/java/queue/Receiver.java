package queue;

import javax.jms.*;

/**
 1.创建连接使用的工厂类JMS ConnectionFactory 
 2.使用管理对象JMS ConnectionFactory建立连接Connection 
 3.使用连接Connection 建立会话Session 
 4.使用会话Session和管理对象Destination创建消息消费者MessageReceiver 
 5.使用消息消费者MessageConsumer接受消息
 * @author yangzuliang
 *
 */
public class Receiver {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// ConnectionFactory ：连接工厂，JMS 用它创建连接
		ConnectionFactory connectionFactory;
		// JMS 客户端到JMS Provider 的连接
		Connection connection = null;
		// Session： 一个发送或接收消息的线程
		Session session;
		// Destination ：消息的目的地;消息发送给谁.
		Destination destination;
		// 消费者，消息接收者
		MessageConsumer consumer;
		/*connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD,
				"tcp://localhost:61616");
		// 构造从工厂得到连接对象
		connection = connectionFactory.createConnection();*/
		//用连接池去连接
		connection = MQConnectionUtil.getInstance().getConnection();
		// 启动
		connection.start();
		// 获取操作连接
		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		destination = session.createQueue("messageQueue");
        consumer = session.createConsumer(destination);
        //同步消费,从目的地中显示提取消息,receive方法可以一直阻塞到消息到达
        TextMessage message = (TextMessage) consumer.receive(1000);
        while (null != message) {
            System.out.println("收到消息:" + message.getText());
            message = (TextMessage) consumer.receive(1000);
        } 
        
        consumer.close();
        session.close();
        connection.close();
        

	}
}
