package fr.diginamic.jdbc;


import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;
import fr.diginamic.jdbc.entites.Fournisseur;



public class TestInsertion {

	public static void main(String[] args)  {
	
		FournisseurDaoJdbc fournisseur = new FournisseurDaoJdbc();
		
		fournisseur.insert(new Fournisseur(4,"La maison de la peinture"));
		fournisseur.insert(new Fournisseur(5,"L'Espace Création"));
			

	}

}
