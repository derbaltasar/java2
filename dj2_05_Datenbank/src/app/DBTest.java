package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {
	
	
	public static void main(String[] args) {
		
		//Datenbank Connection
		//Class.forName("com.mysql.jdbc.Driver");  // Seit Java 7 Optional-> explizit laden des Treibers
						
	
					
		try {//TODO Closable
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2","root","");
			Statement selectStatement = con.createStatement();
			
			ResultSet rs =  selectStatement.executeQuery("SELECT * FROM mitarbeiter");
			
			while(rs.next()){
				
				int id = rs.getInt("id");
				
				String vorname = rs.getString("vorname");
				String nachname = rs.getString("nachname");
				
				
				System.out.println(id+" "+vorname+" "+nachname);
			}
			
			con.close();// TODO 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
