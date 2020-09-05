package com.rule;

public class RuleExecute {

    public static String activityRule() {
        StringBuffer ruleDrl = new StringBuffer();
        ruleDrl.append("package rules \n ");
        ruleDrl.append("import   com.model.Person; \n");
        ruleDrl.append(" rule    \'person_1\' \n");
        ruleDrl.append(" no-loop true \n");
        ruleDrl.append(" salience  10 \n");
        ruleDrl.append(" when \n");
        ruleDrl.append("  $p:Person(name==\'张三\',age==\'22\' )\n ");
        ruleDrl.append(" then \n");
        ruleDrl.append("  modify($p){ setName(\'张小三\' )} \n");
        ruleDrl.append("end \n");
        return ruleDrl.toString();
    }

}
