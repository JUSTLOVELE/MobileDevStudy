package com.shiro.realms;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;

public class SecondRealm extends AuthenticatingRealm {

	private final static Log _log = LogFactory.getLog(SecondRealm.class); 
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//和login里面的hashCode一样
		_log.info("secondRealm");
		_log.info(token.hashCode());
		_log.info("doGetAuthenticationInfo:" + token);
		//1.把AuthenticationToken转换为UsernamePasswordToken
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		//2.从UsernamePasswordToken中来获取username
		String username = upToken.getUsername();
		//3.调用数据库的方法,从数据库中查询username对应的用户记录,这里模拟
		System.out.println("从数据库中获取username: " + username + "所对应的用户信息");
		//4.若用户不存在,则可以抛出UnknownAccountException异常
		if("unknown".equals(username)) {
			
			throw new UnknownAccountException("用户不存在");
		}
		//5.根据用户信息的情况,决定是否需要抛出其他的AuthenticationException异常
		if("monster".equals(username)) {
			
			throw new LockedAccountException("用户被锁定");
		}
		//6.根据用户的情况,来构建AuthenticationInfo对象并返回,通常使用的实现类为:SimpleAuthenticationInfo
		//以下信息是从数据库中获取
		//1).principal: 认证的实体信息,可以是username,也可以是数据表对应的用户的实体类对象
		Object principal = username;
		//2).credentials: 密码 以下是1-6的加密值
		//Object credentials = "fc1709d0a95a6be30bc5926fdb7f22f4";
		//因为有了盐值,每次加密的结果都不同,所以不能直接用上面那个了
		Object credentials = null;
		
		if("admin".equals(username)) {
			credentials = "038bdaf98f2037b31f1e75b5b4c9b26e";
		}else if("user".equals(username)) {
			credentials = "098d2c478e9c11555ce2823231e02ec1";
		}
		
		//3).realmName: 当前realm 对象的name, 调用父类的getName() 方法即可
		String realmName = getName();
		//4).盐值
		ByteSource credentialsSalt = ByteSource.Util.bytes(username);
		
		//把上面的封装成对象
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, credentialsSalt, realmName);
		return info;
	}
	
	public static void main(String[] args) {
		
		String hashAlgorithmName = "SHA1";
		Object credentials = "123456";
		Object salt = ByteSource.Util.bytes("admin");
		int hashIterations = 1024;
		Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
		System.out.println(result);
		
	}

}
