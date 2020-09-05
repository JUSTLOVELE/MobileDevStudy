package com.rule;

import org.kie.api.KieBase;
import org.kie.api.io.ResourceType;
import org.kie.internal.utils.KieHelper;

public class NewKieBase {
    //将业务规则写到规则库中
    public static KieBase rulekieBase(String rule) {//rule值就是我们动态传入的规则内容
        KieHelper helper = new KieHelper();
        KieBase kieBase = null;
        try {
            helper.addContent(rule, ResourceType.DRL);
//为了省事，小编直接将rule写成activityRule()
            kieBase = helper.build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kieBase;

    }
}
