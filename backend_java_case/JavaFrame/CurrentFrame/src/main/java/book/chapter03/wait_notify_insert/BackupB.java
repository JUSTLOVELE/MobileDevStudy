package book.chapter03.wait_notify_insert;


public class BackupB extends Thread {

	private DBTools dbtools;

	public BackupB(DBTools dbtools) {
		super();
		this.dbtools = dbtools;
	}

	@Override
	public void run() {
		dbtools.backupB();
	}

}
