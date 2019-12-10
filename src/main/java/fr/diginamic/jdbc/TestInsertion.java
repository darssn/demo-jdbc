package fr.diginamic.jdbc;

import java.sql.Connection;

import java.sql.SQLException;
import java.sql.Statement;



public class TestInsertion {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Connection connect = Connectionbdd.newConnect();	
		try {
		
		Statement st = connect.createStatement();
		
		st.executeUpdate("insert into fournisseur(ID,NOM) values (4,'La maison de la Peinture') ");
		
		connect.commit();			
		st.close();
		connect.close();
			
		} catch (SQLException e) {
			System.out.println(e);
		
			
		}
		
	

	}

}
