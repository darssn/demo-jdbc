package fr.diginamic.props;

import java.util.ResourceBundle;
import java.util.Set;

public class TestConfiguration {

	public static void main(String[] args) {

		ResourceBundle data = ResourceBundle.getBundle("database");
		
		String test1 = data.getString("cle1");
	
		System.out.println(test1);
		
		
		Set<String> listCle = data.keySet(); 
		
		for(String cle : listCle){
			
			System.out.println("La cle est : "+cle +" , la valeur est : " + data.getString(cle) );
			
		}
	}

}
