package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {
	
	
	public static void main(String[] args) {
		
		//Datenbank Connection
	//	Class.forName("com.mysql.jdbc.Driver");  // Seit Java 7 Optional-> explizit laden des Treibers
						
	
					
		try {//TODO Closable
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2","root","");
			
			
			
			show(con);
			
			// Insert--------------------------
			
			Statement insertStatement = con.createStatement();
			int c1=  insertStatement.executeUpdate("INSERT INTO mitarbeiter (vorname, nachname) VALUES ('Emil','Schuster')");
			System.out.println("insert: "+c1);
			
			show(con);
			
			
			// Delete-------------------------
			// prepareStatement-> für viele Datenbankoperationen geeignet
			PreparedStatement deleteStatement  = con.prepareStatement("DELETE FROM mitarbeiter WHERE nachname = ?");
			deleteStatement.setString(1, "Schuster");// 1. Platzhalter (?) wird ersetzt 
			deleteStatement.executeUpdate();
			
			show(con);
			
			// Update-------------------------
			PreparedStatement updateStatement  = con.prepareStatement("UPDATE mitarbeiter SET nachname = ? WHERE id = ?");
			
			updateStatement.setString(1, "Müller");
			updateStatement.setInt(2, 1);// 2. Platzhalter, id=1
			updateStatement.executeUpdate();
			
			show(con);
			con.close();// TODO 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	private static void show(Connection con) throws SQLException {
		Statement selectStatement = con.createStatement();
		
		ResultSet rs =  selectStatement.executeQuery("SELECT * FROM mitarbeiter");
		
		while(rs.next()){
			
			int id = rs.getInt("id");
			
			String vorname = rs.getString("vorname");
			String nachname = rs.getString("nachname");
			
			
			System.out.println(id+" "+vorname+" "+nachname);
		}
	}

}
