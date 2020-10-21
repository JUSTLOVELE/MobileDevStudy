package com.service;

import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yangzl 2020.10.21
 * @version 1.00.00
 * @Description:
 * @history:
 */
@Service
public class RuleService {

    @Autowired
    private KieBase kieBase;

    public void rule(){

        KieSession kieSession = kieBase.newKieSession();
        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
