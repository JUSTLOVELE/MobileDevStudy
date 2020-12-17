/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package chapter3.transforming;

/**
 * Direct Component
 * 	这个组件提供在消费者和生产者之间的调用.它仅仅允许在camel本次的路由,所以
 * 外部的路由不能指向这条路由.这个组件用于连接路由或者测试
 * 
 */
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

/**
 * How to use transform() DSL
 *
 * @version $Revision$
 */
public class TransformTest extends CamelTestSupport {

    @Test
    public void testTransform() throws Exception {
        MockEndpoint mock = getMockEndpoint("mock:result");
        mock.expectedBodiesReceived("Hello<br/>How are you?");

        template.sendBody("direct:start", "Hello\nHow are you?");

        assertMockEndpointsSatisfied();
    }

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                context.setTracing(true);

                from("direct:start")
                    .transform(body().regexReplaceAll("\n", "<br/>"))
                    .to("mock:result");
            }
        };
    }
}
