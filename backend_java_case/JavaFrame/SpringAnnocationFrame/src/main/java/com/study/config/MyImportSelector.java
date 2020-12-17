package com.study.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

//自定义逻辑返回需要导入的组件
public class MyImportSelector implements ImportSelector{

	//返回值,就是导入到容器中的组件
	//AnnotationMetadata:当前标注@Import注解的类的所有注解信息
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		//方法不要返回null值
		//这种方式就把blue加入了bean容器中了
		return new String[] {"com.study.bean.Blue"};
	}
}
