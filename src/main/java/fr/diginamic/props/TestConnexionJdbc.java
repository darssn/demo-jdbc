package fr.diginamic.props;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnexionJdbc {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
			Class.forName("org.mariadb.jdbc.Driver");
		
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/compta", "root", "");
			
			System.out.println(connect);
			
	
		
			connect.close();
		
	}

}
