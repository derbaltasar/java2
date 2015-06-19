package de.cimdata.adressdb.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;
import de.cimdata.adressdb.db.DBConnect;
import de.cimdata.adressdb.db.DBProp;
import de.cimdata.adressdb.exception.DBConnectException;
import de.cimdate.adressdb.model.Person;

public class PersonDAO {
	private DBConnect db = DBConnect.getInstance();

	public PersonDAO() {
		try {
			db.connectDB();
		} catch (DBConnectException e) {
			throw e;
		}

	}

	public List<Person> findAllPersons() {
		List<Person> list = null;

		try {

			Statement st = db.getConnection().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM person");

			list = createPersonList(rs);

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
			PreparedStatement insertStatement = db.getConnection()
					.prepareStatement(query);
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

	/**
	 * 
	 * @param id
	 * @param fxIdColumn
	 *            - fx:id der Tabellenspalte (TableView)
	 * @param newValue
	 *            - neuer Wert der Tabellenzelle
	 * @return true, wenn update erfolgreich
	 */
	public boolean updatePerson(int id, String fxIdColumn, String newValue) {
		try {
			String q = "UPDATE person SET " + DBProp.get(fxIdColumn)
					+ "= ? WHERE id = ?";
			PreparedStatement ps = db.getConnection().prepareStatement(q);
			ps.setString(1, newValue);
			ps.setInt(2, id);
			ps.executeUpdate();
			return ps.getUpdateCount() == 1;// wenn ein Datensatz geändert
											// wurde: true
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean deletePerson(ObservableList<Person> oList) {
		String idset = "?";
		for (int i = 1; i < oList.size(); i++) {
			idset += ",?"; // -> WHERE id IN (?,?,?) PreparedStatement
		}
		try {
			PreparedStatement deleteStatement = db.getConnection()
					.prepareStatement(
							"DELETE FROM person WHERE id IN (" + idset + ")");//(?,?,?)

			for (int i = 0; i < oList.size(); i++) {
				deleteStatement.setInt(i+1, oList.get(i).getId());// Person.id
			}
			deleteStatement.executeUpdate();
			return deleteStatement.getUpdateCount() > 0;  // wenn löschen erfolgreich
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public List<Person> findByField(String columnFxId, String text) {
		List<Person> list = null;
		try {

			// DBProp.get(columnFxId) -> columnFXId zu DB-Feld
			String q = "SELECT *  FROM person WHERE " + DBProp.get(columnFxId)
					+ " LIKE ?";
			PreparedStatement ps = db.getConnection().prepareStatement(q);
			ps.setString(1, text + "%");
			ResultSet rs = ps.executeQuery();
			list = createPersonList(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	// TODO
	private List<Person> createPersonList(ResultSet rs) throws SQLException {
		List<Person> list = new ArrayList<>();
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

		return list;
	}

	public static void main(String[] args) {
		PersonDAO dao = new PersonDAO();
		System.out.println(dao.findAllPersons());
	}

}
