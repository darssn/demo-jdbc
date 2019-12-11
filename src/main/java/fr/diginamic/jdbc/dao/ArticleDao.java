package fr.diginamic.jdbc.dao;

import java.util.List;

import fr.diginamic.jdbc.entites.Article;


public interface ArticleDao {
	
	List<Article> extraire();
	
	void insert(Article article);
	
	boolean deleteArticleDes(String des);

	int updatePrix(String des , double pourcent);
	
	double affichMoyPrixArticle();
	
	
	

}
