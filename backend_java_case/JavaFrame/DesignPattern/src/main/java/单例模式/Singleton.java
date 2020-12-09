package 单例模式;

public class Singleton {
	
	private volatile static Singleton uniquenInstance;
	
	private Singleton(){
		
	}
	
	public static Singleton getInstance(){
		
	    if(uniquenInstance == null){
	    	
	    	synchronized (Singleton.class) {
	    		
	    		uniquenInstance = new Singleton();
			}
	    }
	    
	    return uniquenInstance;
	}

}
