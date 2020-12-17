package com.spring.ch_02.study_03;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * ���û���������õĻ�,@ComponentScanĬ�ϻ�ɨ������������ͬ�İ�
 * ���Ҫɨ������:
 * @ComponentScan(basePackages={"study_01", "study_01"})
 * Ҳ����ֱ��ָ��class:
 * @ComponentScan(basePackageClasses={CDPlayer.class, DVDPlayer.class})
 * @author Administrator
 *
 */
@Configuration
@ComponentScan
public class CDPlayerConfigure {

}
