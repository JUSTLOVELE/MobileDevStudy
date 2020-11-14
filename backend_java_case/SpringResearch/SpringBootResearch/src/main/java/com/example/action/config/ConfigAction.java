package com.example.action.config;

import com.example.env.Ymlconfig;
import com.example.factory.HttpsClientRequestFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

/**
 * 配置类action说明
 */
@RestController
public class ConfigAction {

    @Value("${config.test}")
    private String testValue;

    @Autowired
    private Ymlconfig _ymlconfig;

    @GetMapping("/getConfig")
    public String getConfig() {

      return testValue;
    }

    @GetMapping("/getConfig02")
    public String getConfig02() {
        return _ymlconfig.getTest02();
    }

    @Bean("httpsRestTemplate")
    public RestTemplate httpsRestTemplate() {
        return new RestTemplate(new HttpsClientRequestFactory());
    }
}