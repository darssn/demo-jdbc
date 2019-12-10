package fr.diginamic.jdbc;


import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;
import fr.diginamic.jdbc.entites.Fournisseur;

public class TestSelect {

	public static void main(String[] args) {	
		
		List<Fournisseur> listeFournisseur = new ArrayList<>();
		FournisseurDaoJdbc fournisseur = new FournisseurDaoJdbc();
		
		
		listeFournisseur= fournisseur.extraire();
		
		
		for(Fournisseur f :listeFournisseur){
			
			System.out.println(f.getId()+"      "+f.getNom() );
			
		}
		
		
	}

}
