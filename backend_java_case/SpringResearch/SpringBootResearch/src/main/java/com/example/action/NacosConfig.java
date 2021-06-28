package com.example.action;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class NacosConfig {

    @Value("${cnf.message:}")
    private String myname;

    /**
     * 读取nacos配置文件信息
     * @return
     */
    @GetMapping("/nacosConfigTest")
    public String nacosConfigTest() {
        System.out.println("myname=" + myname);
        return this.myname;
    }
}
