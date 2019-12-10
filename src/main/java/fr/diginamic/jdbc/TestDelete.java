package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDelete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection connect = Connectionbdd.newConnect();
		
		try {
			
			
			Statement st = connect.createStatement();
			
			st.executeUpdate("delete from fournisseur where NOM='La Maison des Peintures'");
			
			connect.commit();
			st.close();
			connect.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
		
		
		

	}

}
