package chapter2.spring;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

	@Test
	public void work_1() {
		
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("\\chapter2\\spring\\applicationContext.xml");
		ac.start();
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
