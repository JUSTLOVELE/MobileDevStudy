package com.shiro.helloworld;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;



/**
 * Simple Quickstart application showing how to use Shiro's API.
 *
 * @since 0.9 RC2
 */
public class Quickstart {

	private static final Log _log = LogFactory.getLog(Quickstart.class);
	

    public static void main(String[] args) {

        // The easiest way to create a Shiro SecurityManager with configured
        // realms, users, roles and permissions is to use the simple INI config.
        // We'll do that by using a factory that can ingest a .ini file and
        // return a SecurityManager instance:

        // Use the shiro.ini file at the root of the classpath
        // (file: and url: prefixes load from files and urls respectively):
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();

        // for this simple example quickstart, make the SecurityManager
        // accessible as a JVM singleton.  Most applications wouldn't do this
        // and instead rely on their container configuration or web.xml for
        // webapps.  That is outside the scope of this simple quickstart, so
        // we'll just do the bare minimum so you can continue to get a feel
        // for things.
        SecurityUtils.setSecurityManager(securityManager);

        // Now that a simple Shiro environment is set up, let's see what you can do:

        // get the currently executing user:
        //获取当前的Subject.
        Subject currentUser = SecurityUtils.getSubject();

        // Do some stuff with a Session (no need for a web or EJB container!!!)
        //即便没有web环境也可以使用session
        //测试使用session
        //获取Session: Subject
        Session session = currentUser.getSession();
        session.setAttribute("someKey", "aValue");
        String value = (String) session.getAttribute("someKey");
        if (value.equals("aValue")) {
            _log.info("---> Retrieved the correct value! [" + value + "]");
        }

        // let's login the current user so we can check against roles and permissions:
        // 测试当前的用户是否已经被认证,即是否已经被登录
        if (!currentUser.isAuthenticated()) {
        	//把用户名和密码封装为username和password
            UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");
            // rememberme,后面解释
            token.setRememberMe(true);
            try {
            	//执行登录.
                currentUser.login(token);
            } 
            //若没有指定的账户,则shiro将会抛出UnknownAccountException异常
            catch (UnknownAccountException uae) {
                _log.info("----> 这里没有用户:" + token.getPrincipal());
               // return; 
            } 
            //若用户存在,但密码不匹配,密码错误
            catch (IncorrectCredentialsException ice) {
                _log.info("----> 密码错误:" + token.getPrincipal() + " was incorrect!");
               // return; 
            } 
            //用户被锁定的异常,与spring集成后web环境下可以测试
            catch (LockedAccountException lae) {
                _log.info("The account for username " + token.getPrincipal() + " is locked.  " +
                        "Please contact your administrator to unlock it.");
            }
            // ... catch more exceptions here (maybe custom ones specific to your application?
            // 所有认证时,异常的父类
            catch (AuthenticationException ae) {
                //unexpected condition?  error?
            }
        }

        //say who they are:
        //print their identifying principal (in this case, a username):
        _log.info("----> User [" + currentUser.getPrincipal() + "] logged in successfully.");

        //test a role:
        // 测试是否有某一个角色
        if (currentUser.hasRole("schwartz")) {
            _log.info("----> May the Schwartz be with you!");
        } else {
            _log.info("----> Hello, mere mortal.");
           // return; 
        }

        //test a typed permission (not instance-level)
        //测试用户是否具备某一个行为,调用subject的isPermitted
        if (currentUser.isPermitted("lightsaber:weild")) {
            _log.info("----> You may use a lightsaber ring.  Use it wisely.");
        } else {
            _log.info("Sorry, lightsaber rings are for schwartz masters only.");
        }

        //a (very powerful) Instance Level permission:
        // 
        if (currentUser.isPermitted("user:delete:zhangsan")) {
            _log.info("----> You are permitted to 'drive' the winnebago with license plate (id) 'eagle5'.  " +
                    "Here are the keys - have fun!");
        } else {
            _log.info("Sorry, you aren't allowed to drive the 'eagle5' winnebago!");
        }

        //all done - log out!
        //执行登出,调用subject的Logout()方法
        System.out.println("---->" + currentUser.isAuthenticated());
        currentUser.logout();
        System.out.println("---->" + currentUser.isAuthenticated());
        System.exit(0);
    }
}
