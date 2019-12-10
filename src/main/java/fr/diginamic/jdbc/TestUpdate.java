package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class TestUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		try {
	
		Connection connect = Connectionbdd.newConnect();		
			
		Statement st = connect.createStatement();
		
		st.executeUpdate("update fournisseur set NOM='La Maison des Peintures' where ID=4 ");
		
		connect.commit();			
		st.close();
		connect.close();
			
		} catch (SQLException e) {
			System.out.println(e);
			
		}

	}

}
