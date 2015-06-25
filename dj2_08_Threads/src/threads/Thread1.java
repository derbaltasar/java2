package threads;

public class Thread1 extends Thread{
	
	

	
	private boolean stop = false;

	
	@Override
	public void run() {  // Thread l�uf so lange wie run l�uft
		while(!stop){
			System.out.println(getName());
			
			try {
				Thread.sleep(10);// Hauptthread verz�gern
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
