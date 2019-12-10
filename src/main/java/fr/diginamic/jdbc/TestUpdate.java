package fr.diginamic.jdbc;



import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;


public class TestUpdate {

	public static void main(String[] args) {
		
		
		FournisseurDaoJdbc fournisseur = new FournisseurDaoJdbc();
		
		fournisseur.update("La maison de la peinture","La Maison des Peintures");
		
	
	}

}
