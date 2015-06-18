package myobserver;

import java.util.ArrayList;
import java.util.List;

public class MyObservable {
	private boolean changed = false;	
	private List<MyObserver> list = new ArrayList<>();
	
	//TODO contains, null prüfen
	public void addObserver(MyObserver obs){
		if(!list.contains(obs)){// wenn noch nicht enthalten
			list.add(obs);
		}
	}
	
	public void removeObserver(MyObserver obs){
		list.remove(obs);
	}
	
	public void notifyObservers(){
		notifyObservers(null);
	}
	public void notifyObservers(Object  obj){
		if(changed){
			for (MyObserver myObserver : list) {
				myObserver.update( this, obj);
			}
			changed=false;
		}
	}
	public boolean isChanged() {
		return changed;
	}
	public void setChanged() {
		this.changed = true;
	}

}
