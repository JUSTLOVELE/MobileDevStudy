package com.study.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class MyTypeFilter implements TypeFilter{

	/**
	 * metadataReader : ��ȡ��ǰ����ɨ��������Ϣ
	 * metadataReaderFactory : ���Ի�ȡ�����κ������Ϣ
	 */
	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
		//��ȡ��ǰ��ע�����Ϣ
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		//��ȡ��ǰ����ɨ�������Ϣ
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		//��ȡ��ǰ����Դ��Ϣ
		Resource resource = metadataReader.getResource();
		
		String className = classMetadata.getClassName();
		System.out.println("---->" + className);
		
		if(className.contains("er")) {
			return true;
		}
		
		
		return false;
	}

}
