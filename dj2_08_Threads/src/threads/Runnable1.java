package threads;

/*
 * Variante 2: Runnable implementieren
 */
public class Runnable1 implements Runnable {

	@Override
	public void run() {
		while(true){
			System.out.println("run...");
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable1());
		t1.start();
		
		
		
		// "Variante 3" anonym
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				
			}
		});
		
		
		t2.start();
		
		Thread t3 = new Thread( ()-> {}); //Lambda

	}
}
