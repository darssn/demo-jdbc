package fr.diginamic.jdbc;


import java.util.List;

import fr.diginamic.jdbc.dao.ArticleDaoJdbc;
import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;
import fr.diginamic.jdbc.entites.Article;
import fr.diginamic.jdbc.entites.Fournisseur;

public class TestJdbcArticles {

	public static void main(String[] args) {
		
		ArticleDaoJdbc aDao = new ArticleDaoJdbc();
		FournisseurDaoJdbc fDao = new FournisseurDaoJdbc();
		
		Fournisseur f =  new Fournisseur(6,"La maison de la Peinture");
		
		fDao.insert(f);
		
		Article art1 = new Article(11,"A06","Peinture blanche 1L",12.5,f);
		Article art2 = new Article(12,"A07","Peinture rouge mate 1L",15.5,f);
		Article art3 = new Article(13,"A08","Peinture noire laquée 1L",17.5,f);
		Article art4 = new Article(14,"A09","Peinture bleue mate 1L",15.5,f);

		aDao.insert(art1);
		aDao.insert(art2);
		aDao.insert(art3);
		aDao.insert(art4);
		
		
		List<Article> a = aDao.extraire();
		
		for(Article art : a){
			
			System.out.println(art.toString());	
		}
		
		
		aDao.updatePrix("Peinture",20);
		
		double moyenne = aDao.affichMoyPrixArticle();
		
		System.out.println(moyenne);
		
		aDao.deleteArticleDes("Peinture");
		
		fDao.delete(f);
		


	}

}
