package book.chapter03.wait_notify_insert;


public class BackupA extends Thread {

	private DBTools dbtools;

	public BackupA(DBTools dbtools) {
		super();
		this.dbtools = dbtools;
	}

	@Override
	public void run() {
		dbtools.backupA();
	}

}
