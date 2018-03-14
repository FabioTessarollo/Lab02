package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	TreeMap<String, String> dizionario = new TreeMap<String, String>();

	 
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
        
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	
    }
  
    
    @FXML
    void doTranslate(ActionEvent event) {
    	String inserimento = txtWord.getText().toLowerCase();
    	boolean primoNumero = false;
    	for(int i = 0; i < 10; i++) {
    		if(inserimento.contains("" + i)) {
    			txtResult.appendText("Niente numeri! \n");
    			primoNumero = true;
    		}
    	}
    	if (!primoNumero) {
	    	String[] parole = inserimento.split(" ");
	    	if(parole.length == 1) {
	    		txtResult.appendText(dizionario.get(inserimento) + "\n");
	    	} else if (parole.length == 2) {
	    		if(dizionario.containsKey(parole[0])) {
	    			String giaPresenti = dizionario.get(parole[0]);
	    			String nuove = giaPresenti + "; " + parole[1];
	    			dizionario.replace(parole[0], nuove);
	    			txtWord.clear();
	    		} else {
		    		dizionario.put(parole[0], parole[1]);
		    		txtWord.clear();
	    		}
	    	} else {
	    		txtResult.appendText("Errore inserimento");
	    		txtWord.clear();
	    	}
    	}
    	    	
    }
    
    
    @FXML
    void doReset(ActionEvent event) {
    	txtWord.clear();
    	txtResult.clear();
    }
    
}
