package de.cimdata.adressdb.ui;

import javafx.scene.control.TextField;

public class PLZTextField extends TextField{
	
	@Override 
	public void replaceText(int start, int end, String text) {
        if (text.matches("\\d")&&  getText().length()<6 || text.isEmpty() ) {
            super.replaceText(start, end, text);
        }
        
    }
//  
    @Override 
    public void replaceSelection(String text) {
    	  if (text.matches("\\d")&&  getText().length()<6 || text.isEmpty() ) {
            super.replaceSelection(text);
        }
    }

}
