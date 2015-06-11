package singleton;
// final -> keine Vererbung
public final class Singleton {
	
	private static Singleton instance = null;
	
	private Singleton(){}

	// synchronized-> Thread-sicher
	public synchronized static Singleton getInstance(){
		if(instance==null){
			instance = new Singleton();
		}
		
		return instance;
	}
	
	
	//---------------- andere  Methoden------------------------------
	
	public void methode(){
		
	}
	
}
