package sub;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 消息消费者
 * 
 * @author yangzuliang
 * 
 */
public class TopicSubscriber {

	public static void main(String[] args) throws Exception{
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		Connection connection = factory.createConnection();
		connection.start();

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Topic topic = session.createTopic("myTopic.message");
		
		MessageConsumer consumer = session.createConsumer(topic);
		consumer.setMessageListener(new MessageListener() {
			
			public void onMessage(Message message) {
				
				TextMessage tm = (TextMessage) message;
				try {
					System.out.println("Received message: " + tm.getText());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
}
