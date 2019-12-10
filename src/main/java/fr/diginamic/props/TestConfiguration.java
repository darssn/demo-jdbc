package fr.diginamic.props;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

public class TestConfiguration {

	public static void main(String[] args) {

		ResourceBundle data = ResourceBundle.getBundle("database");
		
		String test1 = data.getString("cle1");
	
		System.out.println(test1);
		
		List<String> l = new ArrayList<>();
		
		
		Set<String> listCle = data.keySet(); 
		
		for(String cle : listCle){
			
			l.add(cle);
			System.out.println("La cle est : "+cle +" , la valeur est : " + data.getString(cle) );
			
		}
		
		
		Collections.sort(l);
		
		System.out.println(l);
		
		
	}

}
