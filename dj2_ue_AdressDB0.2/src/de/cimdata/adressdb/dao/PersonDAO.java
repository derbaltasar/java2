package de.cimdata.adressdb.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import de.cimdata.adressdb.db.DBConnect;
import de.cimdata.adressdb.db.DBProp;
import de.cimdate.adressdb.model.Person;

public class PersonDAO {
	private DBConnect db = DBConnect.getInstance();

	public List<Person> findAllPersons() {
		List<Person> list = new ArrayList<>();

		try {

			Statement st = db.getConnection().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM person");

			// für jeden Datensatz ein Pesronobjekt erzeugen und der
			// Person-Liste hinzufügen
			while (rs.next()) {
				Person p = new Person();
				p.setId(rs.getInt("id"));
				p.setVorname(rs.getString("vorname"));
				p.setNachname(rs.getString("nachname"));
				p.setPlz(rs.getString("plz"));
				p.setOrt(rs.getString("ort"));
				p.setStrasse(rs.getString("strasse"));
				p.setTelefon(rs.getString("telefon"));
				p.setMobil(rs.getString("mobil"));
				p.setEmail(rs.getString("email"));
				list.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public boolean savePerson(Person p) {
		// Insert--------------------------
		try {
			
			String query = "INSERT INTO person (vorname, nachname, plz, ort, strasse, telefon, mobil, email) "
					+ "VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement insertStatement = db.getConnection().prepareStatement(query);
			insertStatement.setString(1, p.getVorname());
			insertStatement.setString(2, p.getNachname());
			insertStatement.setString(3, p.getPlz());
			insertStatement.setString(4, p.getOrt());
			insertStatement.setString(5, p.getStrasse());
			insertStatement.setString(6, p.getTelefon());
			insertStatement.setString(7, p.getMobil());
			insertStatement.setString(8, p.getEmail());

			int row = insertStatement.executeUpdate();
			
			return row == 1;// 1 Datensatz wurde gespeichert
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {
		PersonDAO dao = new PersonDAO();
		System.out.println(dao.findAllPersons());
	}

	public boolean updatePerson(int id, String fxIdColumn, String newValue) {
		try {
			String q = "UPDATE person SET "+DBProp.get(fxIdColumn) + "= ? WHERE id = ?";
			PreparedStatement ps = db.getConnection().prepareStatement(q);
			ps.setString(1, newValue);
			ps.setInt(2, id);
			ps.executeUpdate();
			return ps.getUpdateCount()==1;// wenn ein Datensatz geändert wurde: true
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
