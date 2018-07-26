package fr.gtm.projetproxibanquev2ws.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionBDD {
	// attributs nécessaire à la connexion
		private String url;
		private String login;
		private String pass;
		private Connection connect = null;
		private Statement st = null;
		private String laRequete;
		

		//Constructeurs
		/**
		 * @param url
		 * @param login
		 * @param pass
		 * @param connect
		 * @param st
		 * @param laRequete
		 */
		/**
		 * 
		 * Constructeur de niveau 1 permettant de modifier les paramètres de connexion
		 */
		public ConnectionBDD(String url, String login, String pass) {
			super();
			this.url = url;
			this.login = login;
			this.pass = pass;
		
		}
		
		/**
		 * Surcharge de constructeur permettant une initialisation basique des paramètres de connexion
		 */
		public ConnectionBDD() {
			super();
			this.url = "jdbc:mysql://localhost/proxibanquesgbd";
			this.login = "root";
			this.pass = "";
			this.connect = null;
			this.st = null;
			this.laRequete = "";
		}


		/**
		 * Méthode de connection à la base de donnée
		 */
		public void seConnecter() {
			// TODO ici mettre le code pour se connecter à la bdd
			try {
				// Charger le driver
				Class.forName("com.mysql.jdbc.Driver");

				// Récupérer la connection dans mon objet de type Connection
				connect = DriverManager.getConnection(this.url, this.login, this.pass);
				
				// Préparer le statement et la requête
				this.st = connect.createStatement();

			} catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		

		/**
		 * @param query
		 */
		/**
		 * 
		 * Méthode permettant d'executer une requete, attention nécessite une connectio BDD ! (voir seConnecter)
		 */
		public ResultSet executeRequete(String query) {
			this.laRequete = query;
			ResultSet rs = null;
			try {
			  rs = this.st.executeQuery(laRequete);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return rs;
		}
		
		/**
		 * @param query
		 */
		/**
		 * 
		 * Methode permettant de mettre à jour les données en BDD, attention nécessite une connectio BDD ! (voir seConnecter)
		 */
		public void updateData(String query) {
			this.laRequete = query;
			try {
				this.st.executeUpdate(laRequete);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * Méthode permettant de fermer la connection active et donc libérer de la mémoire
		 */
		public void closeConnection() {
			try {
				// libérer la mémoire
				connect.close();
				st.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
}
