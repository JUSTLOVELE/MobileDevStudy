package 代理模式;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyRemote extends Remote{
	
	public String sayHello() throws RemoteException;

}
