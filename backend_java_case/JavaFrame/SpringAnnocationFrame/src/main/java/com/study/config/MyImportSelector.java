package com.study.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

//�Զ����߼�������Ҫ��������
public class MyImportSelector implements ImportSelector{

	//����ֵ,���ǵ��뵽�����е����
	//AnnotationMetadata:��ǰ��ע@Importע����������ע����Ϣ
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		//������Ҫ����nullֵ
		//���ַ�ʽ�Ͱ�blue������bean��������
		return new String[] {"com.study.bean.Blue"};
	}
}
