package steuerung;

public class ThreadJoin extends Thread{
	
	public int result = 0;
	
	
	@Override
	public void run() {
		System.out.println("run...");
		result = 1;
	}

	public static void main(String[] args) {
		
		ThreadJoin t1 = new ThreadJoin();
		
		t1.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
	
			e.printStackTrace();
		}
		
		System.out.println(t1.result);//0 oder 1? 
		
		
		
	}

}
