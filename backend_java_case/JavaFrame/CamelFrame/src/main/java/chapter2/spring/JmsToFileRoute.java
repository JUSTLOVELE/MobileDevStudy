package chapter2.spring;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class JmsToFileRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		from("jmsConfig:incomingOrders")
		.process(new Processor() {
			
			@Override
			public void process(Exchange exchange) throws Exception {
				// TODO Auto-generated method stub
				System.out.println(" JMSToFileRoute " + exchange.getIn().getHeader("CamelFileName"));
			}
		})
		.choice()
			.when(header("CamelFileName").endsWith(".xml"))
				.to("jmsConfig:xmlOrders")
			.when(header("CamelFileName").regex("^.*(csv|csl)$"))
				.to("jmsConfig:csvOrders")
			.otherwise()
				.to("jmsConfig:badOrders").stop()
		.end()
		.to("jmsConfig:continuedProcessing");
	}
}
