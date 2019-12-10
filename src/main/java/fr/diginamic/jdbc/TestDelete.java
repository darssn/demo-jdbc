package fr.diginamic.jdbc;


import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;
import fr.diginamic.jdbc.entites.Fournisseur;

public class TestDelete {

	public static void main(String[] args) {
	
		
		
		FournisseurDaoJdbc fournisseur = new FournisseurDaoJdbc();
		
		Fournisseur f = new Fournisseur(4,"La Maison des Peintures");
		
		fournisseur.delete(f);
	
			

	}

}
