package com.spring.ch_02.study_03;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 如果没有其他配置的话,@ComponentScan默认会扫描与配置类相同的包
 * 如果要扫描多个包:
 * @ComponentScan(basePackages={"study_01", "study_01"})
 * 也可以直接指定class:
 * @ComponentScan(basePackageClasses={CDPlayer.class, DVDPlayer.class})
 * @author Administrator
 *
 */
@Configuration
@ComponentScan
public class CDPlayerConfigure {

}
