package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.entites.Fournisseur;

public class TestSelect {

	public static void main(String[] args) {	
		
		List<Fournisseur> listeFournisseur = new ArrayList<>();
		
		try{
			
		Connection connect = Connectionbdd.newConnect();
		
		Statement st = connect.createStatement();
		
		ResultSet rs =  st.executeQuery("select * from fournisseur");
		
		
		while(rs.next()){
			
			int id = rs.getInt("ID");
			String nom = rs.getString("NOM");
			
			listeFournisseur.add(new Fournisseur(id,nom));			
		}
	

		rs.close();
		st.close();
		connect.close();
		
		}catch(SQLException e){
			
			
		}
		
		for(Fournisseur f :listeFournisseur){
			
			System.out.println(f.getId()+"      "+f.getNom() );
			
		}
		
		
	}

}
