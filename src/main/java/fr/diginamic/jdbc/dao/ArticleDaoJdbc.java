package fr.diginamic.jdbc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.Connectionbdd;
import fr.diginamic.jdbc.entites.Article;
import fr.diginamic.jdbc.entites.Fournisseur;

public class ArticleDaoJdbc implements ArticleDao {

	/**
	 * Recupere la liste des articles de la base de données
	 * 
	 */
	@Override
	public List<Article> extraire() {

		List<Article> liste = new ArrayList<>();
		Connection connect = Connectionbdd.newConnect();
		Statement st = null;
		ResultSet rs = null;

		try {
			st = connect.createStatement();

			rs = st.executeQuery("select article.ID,article.REF,article.DESIGNATION,article.PRIX,article.ID_FOU,"
					+ "fournisseur.NOM from article,fournisseur where article.ID_FOU = fournisseur.ID");

			while (rs.next()) {
				liste.add(new Article(rs.getInt("ID"), rs.getString("REF"), rs.getString("DESIGNATION"),
						rs.getDouble("PRIX"), new Fournisseur(rs.getInt("ID_FOU"), rs.getString("NOM"))));

			}

		} catch (SQLException e) {
			try {
				connect.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(e);
		} finally {
			try {
				rs.close();
				st.close();
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return liste;
	}

	/**
	 * Ajoute un nouveau article a la base de données
	 */
	@Override
	public void insert(Article article) {
		Connection connect = Connectionbdd.newConnect();
		Statement st = null;
		try {
			st = connect.createStatement();

			int id = article.getId();
			String ref = article.getRef().replace("'", "''");
			String des = article.getDes().replace("'", "''");
			double prix = article.getPrix();
			int idFou = article.getFournisseur().getId();

			st.executeUpdate("INSERT INTO article(ID, REF, DESIGNATION, PRIX, ID_FOU) VALUES (" + id + ",'" + ref
					+ "','" + des + "'," + prix + "," + idFou + ")");

			connect.commit();

		} catch (SQLException e) {
			try {
				connect.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(e);
		} finally {
			try {
				st.close();
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	/**
	 * Modification du prix avec une designation et un pourcentage du prix
	 */
	@Override
	public int updatePrix(String des, double pourcent) {
		Connection connect = Connectionbdd.newConnect();
		int up = 0;
		Statement st = null;

		try {
			st = connect.createStatement();

			up = st.executeUpdate("update article set PRIX=PRIX*" + (100 - pourcent) / 100
					+ " where DESIGNATION like '%" + des + "%'");

			connect.commit();

		} catch (SQLException e) {
			try {
				connect.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(e);
		} finally {

			try {
				st.close();
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return up;
	}

	@Override
	public double affichMoyPrixArticle() {

		Connection connect = Connectionbdd.newConnect();
		Statement st = null;
		ResultSet rs = null;
		double moyenne = 0;

		try {
			st = connect.createStatement();

			rs = st.executeQuery("SELECT AVG(PRIX) FROM article");

			while (rs.next()) {
				moyenne = rs.getDouble("AVG(PRIX)");
			}

		} catch (SQLException e) {
			try {
				connect.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(e);
		} finally {
			try {
				rs.close();
				st.close();
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return moyenne;
	}

	/**
	 * Supprime des article dont la designation contient la variable
	 */
	@Override
	public boolean deleteArticleDes(String des) {
		Connection connect = Connectionbdd.newConnect();
		Statement st = null;

		try {
			st = connect.createStatement();
			st.executeUpdate("delete from article where DESIGNATION like '%" + des + "%'");

			connect.commit();

		} catch (SQLException e) {
			try {
				connect.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(e);
			return false;

		} finally {
			try {
				st.close();
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;

	}
}
