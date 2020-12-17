package redisClient;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JedisUtilTest {

	JedisPool pool;
	Jedis jedis;

	@Before
	public void setUp() {

		pool = new JedisPool(new JedisPoolConfig(), "192.168.1.96");
		jedis = pool.getResource();
	}

	@Test
	public void testGet() {
		System.out.println(jedis.get("lu"));
	}

	@Test
	public void basicString() {

		jedis.set("name", "lmmjj");
		System.out.println(jedis.get("name"));
		jedis.append("name", "bcmjj");
		System.out.println(jedis.get("name"));
		jedis.set("name", "yhmjj");
		System.out.println(jedis.get("name"));
		jedis.del("name");
		System.out.println("del = " + jedis.get("name"));
	}

	@Test
	public void testMap() {
		Map<String, String> user = new HashMap<String, String>();
		user.put("name", "xxx");
		user.put("pwd", "pwd22");
		jedis.hmset("user", user);
		// ȡ��������һ�����͵�list
		List<String> rsmap = jedis.hmget("user", "name");
		System.out.println(rsmap);
		jedis.hdel("user", "pwd");
		System.out.println(jedis.hmget("user", "pwd"));
		// ����keyΪuser�ļ��д�ŵ�ֵ�ĸ���
		System.out.println(jedis.hlen("user"));
		System.out.println(jedis.exists("user"));
		System.out.println(jedis.hkeys("user"));// ����map�����е�����key [pwd, name]
		System.out.println(jedis.hvals("user"));
		Iterator<String> iter = jedis.hkeys("user").iterator();

		while (iter.hasNext()) {
			String key = iter.next();
			System.out.println(key + ":" + jedis.hmget("user", key));
		}
	}

	@Test
	public void testList() {
		// ��ʼǰ�Ƴ���������
		jedis.del("java framework");
		System.out.println(jedis.lrange("java framework", 0, -1));
		// ��key java framework�д����������
		jedis.lpush("java framework", "spring");
		jedis.lpush("java framework", "struts");
		jedis.lpush("java framework", "hibernate");
		// ��һ����key���ڶ�������ʼλ�ã��������ǽ���λ�ã�jedis.llen��ȡ���� -1��ʾȡ������
		System.out.println(jedis.lrange("java framework", 0, -1));
	}

	@Test
	public void testSet() {

		jedis.sadd("sname", "minxr");
		jedis.sadd("sname", "jarorwar");
		jedis.sadd("sname", "����");
		jedis.sadd("sname", "noname");
		// �Ƴ�noname
		jedis.srem("sname", "noname");
		System.out.println(jedis.smembers("sname"));// ��ȡ���м����value
		System.out.println(jedis.sismember("sname", "minxr"));// �ж� minxr
																// �Ƿ���sname���ϵ�Ԫ��
		System.out.println(jedis.srandmember("sname"));
		System.out.println(jedis.scard("sname"));// ���ؼ��ϵ�Ԫ�ظ���
	}

	@Test
	public void test() throws InterruptedException {
		// keys�д���Ŀ�����ͨ���
		System.out.println(jedis.keys("*")); // ���ص�ǰ�������е�key [sose, sanme, name, jarorwar, foo, sname, java framework, user, braand]
		System.out.println(jedis.keys("*name"));// ���ص�sname [sname, name]
		System.out.println(jedis.del("sanmdde"));// ɾ��keyΪsanmdde�Ķ��� ɾ���ɹ�����1  ɾ��ʧ�ܣ����߲����ڣ����� 0
		System.out.println(jedis.ttl("sname"));// ���ظ���key����Чʱ�䣬�����-1���ʾ��Զ��Ч
		jedis.setex("timekey", 10, "min");// ͨ���˷���������ָ��key�Ĵ���Чʱ�䣩 ʱ��Ϊ��
		Thread.sleep(5000);// ˯��5���ʣ��ʱ�佫Ϊ<=5
		System.out.println(jedis.ttl("timekey")); // ������Ϊ5
		jedis.setex("timekey", 1, "min"); // ��Ϊ1�������ٿ�ʣ��ʱ�����1��
		System.out.println(jedis.ttl("timekey")); // ������Ϊ1
		System.out.println(jedis.exists("key"));// ���key�Ƿ����
												// System.out.println(jedis.rename("timekey","time"));
		System.out.println(jedis.get("timekey"));// ��Ϊ�Ƴ�������Ϊnull
		System.out.println(jedis.get("time")); // ��Ϊ��timekey ������Ϊtime ���Կ���ȡ��ֵ
												// min
		// jedis ����
		// ע�⣬�˴���rpush��lpush��List�Ĳ�������һ��˫���������ӱ��������ģ�
		jedis.del("a");// ��������ݣ��ټ������ݽ��в���
		jedis.rpush("a", "1");
		jedis.lpush("a", "6");
		jedis.lpush("a", "3");
		jedis.lpush("a", "9");
		System.out.println(jedis.lrange("a", 0, -1));// [9, 3, 6, 1]
		System.out.println(jedis.sort("a")); // [1, 3, 6, 9] //�����������
		System.out.println(jedis.lrange("a", 0, -1));
	}
}
