package sub;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * createSession(arg0, arg1)
 * arg0是设置事务的,arg1是设置acknowledgment mode
 * 当arg0设置为false时：paramB的值可为Session.AUTO_ACKNOWLEDGE，Session.CLIENT_ACKNOWLEDGE，DUPS_OK_ACKNOWLEDGE其中一个
 * 当arg0设置为true时：paramB的值忽略， acknowledgment mode被jms服务器设置为SESSION_TRANSACTED
 * Session.AUTO_ACKNOWLEDGE为自动确认，客户端发送和接收消息不需要做额外的工作。
Session.CLIENT_ACKNOWLEDGE为客户端确认。客户端接收到消息后，必须调用javax.jms.Message的acknowledge方法。jms服务器才会删除消息。
DUPS_OK_ACKNOWLEDGE允许副本的确认模式。一旦接收方应用程序的方法调用从处理消息处返回，会话对象就会确认消息的接收；而且允许重复确认。在需要考虑资源使用时，这种模式非常有效
 *
 * 消息发布者
 * 
 * @author yangzuliang
 *
 */
public class TopicPublisher {

	public static void main(String[] args) throws Exception{
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD, "tcp://localhost:61616");
		Connection connection = factory.createConnection();
		connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	    Topic topic = session.createTopic("myTopic.message");
	    MessageProducer producer = session.createProducer(topic);
	    producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	    
	    while(true){
	    	
	    	TextMessage message = session.createTextMessage();
	 	    message.setText("message_" + System.currentTimeMillis());
	 	    producer.send(message);
	 	    System.out.println("sent message : " + message.getText());
	 	    
	 	    try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
	   
	   // session.commit();
	}
}
