package com.service;

import com.rule.NewKieBase;
import org.kie.api.KieBase;
import org.springframework.stereotype.Service;

@Service
public class DroolsService {

    public KieBase newKieBase() {
        KieBase kieBase = NewKieBase.rulekieBase();
        return kieBase;
    }

}
