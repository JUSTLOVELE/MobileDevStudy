package com.spring.ch_03.study_02;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MagicExistsCondition implements Condition{

	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		
		Environment env = context.getEnvironment();
		boolean b = env.containsProperty("magic");
		System.out.println(b);
		//ºÏ≤Èmagic Ù–‘
		return true;
	}
}
