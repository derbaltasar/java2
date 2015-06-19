package app;

import java.awt.Button;
import java.awt.Component;
import java.awt.Label;

public class Klasse {
	
	public int add(int a , int b){
		return a + b;
	}

	public int max(int[] arr){
		int max=arr[0];//!
		for (int n : arr) {
			if(n>max){
				max = n;
			}
		}
		return max;
	}
	
	
	public void methodeMitException(int z){
		if(z<0){
			throw new IllegalArgumentException();
		}
		//hier gehts weiter.....
	}
	
	public void dauert(){
		try {
			Thread.sleep(80);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public Component createComponent(String c){
		if(c.equals("b")){
			return new Button();
		}
		return new Label();
	}
	
}
