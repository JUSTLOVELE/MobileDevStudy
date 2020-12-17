package com.spring.ch_04.study_01;

/**
 * ��дPerformance��perform()����:
 * execution(*com.spring.ch_04.study_01.Performance.perform(..))
 * ���ʽ��*�ſ�ʼ�������ǲ����ķ���ֵ������,Ȼ��ָ��ȫ�޶������ͷ�����,���ڲ����б�,����ʹ���������(..)�����е�Ҫѡ�������perform()����,���������ʲô
 *   ���ڼ���������Ҫ���õ��е��ƥ��concert��,�ڴ˳�����,����ʹ��within()ָʾ��������ƥ��:
 *   and ���� &&,or����||
 *   execution(*com.spring.ch_04.study_01.Performance.perform(..)) and within(concert.*)
 * Spring��������һ���µ�bean()ָʾ��,�������������е���ʽ��ʹ��bean��ID����ʶbean
 *   execution(* com.spring.ch_04.study_01.Performance.perform(..)) and bean('woodstock')
 * ���������ǲ���:Ϊ�����ض�ID���������beanӦ��֪ͨ,���³������ᱻ��֯������ID��Ϊwoodstock��bean��:
 *   execution(* com.spring.ch_04.study_01.Performance.perform(..)) and !bean('woodstock')
 * @author Administrator
 *
 */
public interface Performance {

	public void perform();
	
	public void perform_v2();
}
