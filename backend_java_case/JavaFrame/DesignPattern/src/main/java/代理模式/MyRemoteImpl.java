package 代理模式;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote{

	public MyRemoteImpl() throws RemoteException {
		
	}
	
	public String sayHello(){
		return "Servers says hey";
	}
	
	public static void main(String[] args) {
		try {
			MyRemote service = new MyRemoteImpl();
			Naming.rebind("RemoteHello", service);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
