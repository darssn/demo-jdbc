package fr.diginamic.props;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TestConnexionJdbc {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		/**Chargement Driver mariadb
		 * */
			Class.forName("org.mariadb.jdbc.Driver");
			
			/**Recuperation des données du ficher .properties
			 * */
			ResourceBundle data = ResourceBundle.getBundle("database");
			
			String dbPath = data.getString("db.path");
			String dbUsername = data.getString("db.username");
			String dbPwd = data.getString("db.pwd");
		
			/**Ouverture connection a la base de données
			 * */
			Connection connect = DriverManager.getConnection(dbPath,dbUsername,dbPwd);
			
			
			System.out.println(connect);
			
	
		/**Fermeture connection a la base de données
		 * */
			connect.close();
		
	}

}
