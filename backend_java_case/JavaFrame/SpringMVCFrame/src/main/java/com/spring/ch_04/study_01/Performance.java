package com.spring.ch_04.study_01;

/**
 * 编写Performance的perform()方法:
 * execution(*com.spring.ch_04.study_01.Performance.perform(..))
 * 表达式以*号开始表明我们不关心返回值的类型,然后指定全限定类名和方法名,对于参数列表,我们使用两个点号(..)表明切点要选择任意的perform()方法,无论入参是什么
 *   现在假设我们需要配置的切点仅匹配concert包,在此场景下,可以使用within()指示器来限制匹配:
 *   and 代替 &&,or代替||
 *   execution(*com.spring.ch_04.study_01.Performance.perform(..)) and within(concert.*)
 * Spring还引入了一个新的bean()指示器,它允许我们在切点表达式中使用bean的ID来标识bean
 *   execution(* com.spring.ch_04.study_01.Performance.perform(..)) and bean('woodstock')
 * 还可以做非操作:为除了特定ID以外的其他bean应用通知,以下场景不会被编织到所有ID不为woodstock的bean中:
 *   execution(* com.spring.ch_04.study_01.Performance.perform(..)) and !bean('woodstock')
 * @author Administrator
 *
 */
public interface Performance {

	public void perform();
	
	public void perform_v2();
}
