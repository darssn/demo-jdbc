package fr.diginamic.jdbc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.Connectionbdd;
import fr.diginamic.jdbc.entites.Fournisseur;

public class FournisseurDaoJdbc implements FournisseurDao {

	/**Extrait la liste des fournisseurs de la base de données
	 * 
	 * */
	@Override
	public List<Fournisseur> extraire() {

		List<Fournisseur> liste = new ArrayList<>();

		Connection connect = Connectionbdd.newConnect();

		try {
			Statement st = connect.createStatement();

			ResultSet rs = st.executeQuery("select * from fournisseur");

			while (rs.next()) {

				liste.add(new Fournisseur(rs.getInt("ID"), rs.getString("NOM")));
			}

			rs.close();
			st.close();
			connect.close();

		} catch (SQLException e) {

			System.out.println(e);
		}

		return liste;
	}
	
	/**Ajoute un fournisseur de la liste des fournisseurs de la base de données
	 * 
	 * */

	@Override
	public void insert(Fournisseur fournisseur) {

		Connection connect = Connectionbdd.newConnect();
		
		String nomF = fournisseur.getNom();
		nomF = nomF.replace("'","''");
		
		
		try {
			Statement st = connect.createStatement();
			
			

			st.executeUpdate("insert into fournisseur(ID,NOM) values ("+fournisseur.getId() + ",'"+ nomF + "') ");

			connect.commit();
			st.close();
			connect.close();

		} catch (SQLException e) {

			System.out.println(e);
		}

	}
	
	/**Modifie le nom d'un fournisseur de  la liste des fournisseurs de la base de données
	 * 
	 * */

	@Override
	public int update(String ancienNom, String nouveauNom) {
		
		Connection connect = Connectionbdd.newConnect();
		int up = 0;

		try {
			Statement st = connect.createStatement();

			up = st.executeUpdate("update fournisseur set NOM='"+nouveauNom+"' where NOM='"+ancienNom+"'");

			connect.commit();
			st.close();
			connect.close();

		} catch (SQLException e) {

			System.out.println(e);
		}
		
		
		return up;
	}
	
	/**Supprime un fournisseur de la liste des fournisseurs de la base de données
	 * 
	 * */

	@Override
	public boolean delete(Fournisseur fournisseur) {
		
		Connection connect = Connectionbdd.newConnect();

		try {
			Statement st = connect.createStatement();
			st.executeUpdate("delete from fournisseur where NOM='"+fournisseur.getNom()+"' AND ID="+fournisseur.getId());
			
			connect.commit();
			st.close();
			connect.close();
			
		}catch(SQLException e){
			System.out.println(e);
			return false;
		
		}
		
		
		return true;
	}

}
