import com.entity.ComparisonOperatorEntity;
import com.entity.Order;
import com.entity.Student;
import org.drools.core.base.RuleNameEqualsAgendaFilter;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangzl 2020.09.15
 * @version 1.00.00
 * @Description:
 * @history:
 */
public class DroolsTest {

    /**
     * 函数
     */
    @Test
    public void case08_function() {

        KieServices kieServices = KieServices.Factory.get();
        //获取Kie容器对象
        KieContainer kieContainer = kieServices.newKieClasspathContainer();
        //从Kie容器对象中获取会话对象
        KieSession session = kieContainer.newKieSession();
        Student s1 = new Student();
        s1.setAge(50);
        s1.setName("王五");
        session.insert(s1);

        //激活规则,指定规则名称
        session.fireAllRules();
        session.dispose();
    }

    /**
     * 查询
     */
    @Test
    public void case07_query() {

        KieServices kieServices = KieServices.Factory.get();
        //获取Kie容器对象
        KieContainer kieContainer = kieServices.newKieClasspathContainer();
        //从Kie容器对象中获取会话对象
        KieSession session = kieContainer.newKieSession();
        Student s1 = new Student();
        s1.setAge(50);
        s1.setName("test");
        session.insert(s1);
        QueryResults resultsRows = session.getQueryResults("query_1");

        for(QueryResultsRow row: resultsRows) {
            Student s = (Student) row.get("$s"); //规则文件中的绑定变量名
            System.out.println(s.toString());
        }

        //激活规则,指定规则名称
        session.fireAllRules();
        session.dispose();
    }


    /**
     * 全局变量测试
     */
    @Test
    public void case06_global() {

        KieServices kieServices = KieServices.Factory.get();
        //获取Kie容器对象
        KieContainer kieContainer = kieServices.newKieClasspathContainer();
        //从Kie容器对象中获取会话对象
        KieSession session = kieContainer.newKieSession();
        //Fact对象
        session.setGlobal("count", 10);
        List<String> list = new ArrayList<String>();
        list.add("sdsds");
        session.setGlobal("gList", list);
        //激活规则,指定规则名称
        session.fireAllRules();
        session.dispose();
    }

    /**
     * 内嵌方法insert
     */
    @Test
    public void case05_insert() {

        KieServices kieServices = KieServices.Factory.get();
        //获取Kie容器对象
        KieContainer kieContainer = kieServices.newKieClasspathContainer();
        //从Kie容器对象中获取会话对象
        KieSession session = kieContainer.newKieSession();
        //Fact对象
        Student fact = new Student();
        fact.setAge(10);
        session.insert(fact);
        //激活规则,指定规则名称
        session.fireAllRules();
        session.dispose();
    }

    /**
     * 内嵌方法update
     */
    @Test
    public void case04_update() {

        KieServices kieServices = KieServices.Factory.get();
        //获取Kie容器对象
        KieContainer kieContainer = kieServices.newKieClasspathContainer();
        //从Kie容器对象中获取会话对象
        KieSession session = kieContainer.newKieSession();
        //Fact对象
        Student fact = new Student();
        fact.setAge(2);
        session.insert(fact);
        //激活规则,指定规则名称
        session.fireAllRules();
        session.dispose();
    }

    /**
     * 指定规则名称
     */
    @Test
    public void case03() {

        KieServices kieServices = KieServices.Factory.get();
        //获取Kie容器对象
        KieContainer kieContainer = kieServices.newKieClasspathContainer();
        //从Kie容器对象中获取会话对象
        KieSession session = kieContainer.newKieSession();
        //Fact对象
        ComparisonOperatorEntity fact = new ComparisonOperatorEntity();
        fact.setNames("张三");
        session.insert(fact);
        //激活规则,指定规则名称
        session.fireAllRules(new RuleNameEqualsAgendaFilter("book_discount_1"));
        session.dispose();
    }

    @Test
    public void case02() {

        KieServices kieServices = KieServices.Factory.get();
        //获取Kie容器对象
        KieContainer kieContainer = kieServices.newKieClasspathContainer();
        //从Kie容器对象中获取会话对象
        KieSession session = kieContainer.newKieSession();
        //Fact对象
        ComparisonOperatorEntity fact = new ComparisonOperatorEntity();
        fact.setNames("张三");
        session.insert(fact);
        //激活规则,由Drools框架自动进行规则匹配,如果匹配成功,则执行当前规则
        session.fireAllRules();
        session.dispose();
    }

    @Test
    public void case01() {

        KieServices kieServices = KieServices.Factory.get();
        //获取Kie容器对象
        KieContainer kieContainer = kieServices.newKieClasspathContainer();
        //从Kie容器对象中获取会话对象
        KieSession session = kieContainer.newKieSession();
        //Fact对象
        Order order = new Order();
        order.setOriginalPrice(150d);
        session.insert(order);
        //激活规则,由Drools框架自动进行规则匹配,如果匹配成功,则执行当前规则
        session.fireAllRules();
        session.dispose();
        //优惠后的价格
        System.out.println(order.getRealPrice());
    }
}
