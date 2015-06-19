package de.cimdata.adressdb.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import de.cimdata.adressdb.exception.DBConnectException;

/**
 * DBConnect als Singleton Java 2
 * 
 * @author M. Schirmer (Dozent) dj2_ue_DB_FXTable: DBConnect.java 15.06.2015
 */
public final class DBConnect {

	private static DBConnect instance = null;
	private Connection con;

	private DBConnect(){ // TODO Verbessern

	}

	public void connectDB() {
		if (con == null) {
			try {
				con = DriverManager.getConnection(
						DBProp.get("url") + DBProp.get("db"),
						DBProp.get("usr"), DBProp.get("pwd"));
			} catch (SQLException e) {

				System.out.println("Fehler bei der DB-Verbindung");
				throw new DBConnectException();
				// e.printStackTrace();
			}

		}

	}

	public synchronized static DBConnect getInstance() {
		if (instance == null) {
			instance = new DBConnect();
		}

		return instance;
	}

	public Connection getConnection() {
		return con;
	}

}
