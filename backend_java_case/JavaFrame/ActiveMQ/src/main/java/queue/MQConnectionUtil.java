package queue;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;

public class MQConnectionUtil {
	
	private final static Log _logger = LogFactory.getLog(MQConnectionUtil.class);

	private PooledConnectionFactory pooledConnectionFactory = null;
	
	private static MQConnectionUtil mqConnectionUtil = null;
	
	public Connection getConnection(){
		
		Connection connection = null;
		
		try {
			connection = pooledConnectionFactory.createConnection();
		} catch (Exception e) {
			_logger.error("", e);
		}
		
		return connection;
	}
	
	public static final MQConnectionUtil getInstance(){
		
		if(mqConnectionUtil == null){
			return new MQConnectionUtil();
		}else{
			return mqConnectionUtil;
		}
	}
	
	private MQConnectionUtil(){
		
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory( ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD, "tcp://localhost:61616");
		pooledConnectionFactory = new PooledConnectionFactory();
		pooledConnectionFactory.setConnectionFactory(connectionFactory);
		pooledConnectionFactory.setMaxConnections(100);//最大连接数100
	}
}
