package fr.diginamic.jvm;

import java.util.ArrayList;
import java.util.List;

public class TestMemoire {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> liste = new ArrayList<>();
		
		long a = 0;
		
		while(true){
			
		liste.add("01234567890123456789012345678901234567890123456789");
		a++;
		 if(a%10000 == 0){
			 System.out.println(liste.size());
		 }
		
		}
		
		// pour 10 Mo max : taille 810 000 
		// pour 20 Mo max : taille 1 820 000
		// pour 100 ko max : Error occurred during initialization of VM Too small initial heap

	}

}
