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
		//��login�����hashCodeһ��
		_log.info("secondRealm");
		_log.info(token.hashCode());
		_log.info("doGetAuthenticationInfo:" + token);
		//1.��AuthenticationTokenת��ΪUsernamePasswordToken
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		//2.��UsernamePasswordToken������ȡusername
		String username = upToken.getUsername();
		//3.�������ݿ�ķ���,�����ݿ��в�ѯusername��Ӧ���û���¼,����ģ��
		System.out.println("�����ݿ��л�ȡusername: " + username + "����Ӧ���û���Ϣ");
		//4.���û�������,������׳�UnknownAccountException�쳣
		if("unknown".equals(username)) {
			
			throw new UnknownAccountException("�û�������");
		}
		//5.�����û���Ϣ�����,�����Ƿ���Ҫ�׳�������AuthenticationException�쳣
		if("monster".equals(username)) {
			
			throw new LockedAccountException("�û�������");
		}
		//6.�����û������,������AuthenticationInfo���󲢷���,ͨ��ʹ�õ�ʵ����Ϊ:SimpleAuthenticationInfo
		//������Ϣ�Ǵ����ݿ��л�ȡ
		//1).principal: ��֤��ʵ����Ϣ,������username,Ҳ���������ݱ��Ӧ���û���ʵ�������
		Object principal = username;
		//2).credentials: ���� ������1-6�ļ���ֵ
		//Object credentials = "fc1709d0a95a6be30bc5926fdb7f22f4";
		//��Ϊ������ֵ,ÿ�μ��ܵĽ������ͬ,���Բ���ֱ���������Ǹ���
		Object credentials = null;
		
		if("admin".equals(username)) {
			credentials = "038bdaf98f2037b31f1e75b5b4c9b26e";
		}else if("user".equals(username)) {
			credentials = "098d2c478e9c11555ce2823231e02ec1";
		}
		
		//3).realmName: ��ǰrealm �����name, ���ø����getName() ��������
		String realmName = getName();
		//4).��ֵ
		ByteSource credentialsSalt = ByteSource.Util.bytes(username);
		
		//������ķ�װ�ɶ���
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
