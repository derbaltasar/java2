package threads;

public class Thread1 extends Thread{
	
	

	
	private boolean stop = false;

	
	@Override
	public void run() {  // Thread läuf so lange wie run läuft
		while(!stop){
			System.out.println(getName());
			
			try {
				Thread.sleep(10);// Hauptthread verzögern
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void stopThread(){
		stop = true;
	}
	

	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		Thread1 t2 = new Thread1();
		Thread1 t3 = new Thread1();
		t1.start();// start ruft die run-Methode
		t2.start();
		t3.start();
	///	t1.stop();  nicht!!!!!
		t2.stopThread(); // stop selber schreiben!
		
		
	

	}

}
