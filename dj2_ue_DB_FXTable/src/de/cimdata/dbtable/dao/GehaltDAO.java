package de.cimdata.dbtable.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import de.cimdata.dbtable.db.DBConnect;
import de.cimdata.dbtable.model.Gehalt;

public class GehaltDAO {
	private DBConnect dbc = DBConnect.getInstance();
	
	
	public GehaltDAO() {
		
	}
	
	
	public List<Gehalt> findAll(){
		List<Gehalt> list = new ArrayList<>();
		Connection con = dbc.getConnection();
		try {
			Statement statement = con.createStatement();
			
			ResultSet rs =statement.executeQuery("SELECT name, netto  FROM gehalt");
			while(rs.next()){
				list.add(new Gehalt(rs.getString("name"), rs.getBigDecimal("netto")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}

	
	public static void main(String[] args) {
		GehaltDAO dao = new GehaltDAO();
		
		System.out.println(dao.findAll());
	}
}
