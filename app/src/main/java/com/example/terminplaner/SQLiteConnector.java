package com.example.terminplaner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

public class SQLiteConnector {
    private Connection conn;



    	public SQLiteConnector() throws ClassNotFoundException, SQLException {
			Class.forName("org.sqlite.JDBC");
			String db = "jdbc:sqlite:Config.sqlite";
			conn = DriverManager.getConnection(db);
	}

	/**
	 * Schliesst die Verbindung zur SQLiteDB
	 * @throws SQLException
	 */
	public void close () throws SQLException{
		conn.close();
	}

	/**
	 * Erstellt die SQLiteDB fuer den ersten Start
	 * Ohne "BEGIN TRANSACTION" wurde sql querry ausgeführt, warum geht es nicht damit?
	 * @throws SQLException
	 */
	public void createDB() throws SQLException{

		try {
			String[] query = {
								"CREATE TABLE IF NOT EXISTS Kunde(Kundeid INT PRIMARY KEY,  Vorname TEXT,Nachname TEXT,Design TEXT) ;",
								"CREATE TABLE IF NOT EXISTS Termin(Terminid INT PRIMARY KEY,Kundeid INT,Kalendertag TEXT);",
								"CREATE TABLE IF NOT EXISTS Kalendertag(Kalendertagid INT PRIMARY KEY,Datum TEXT);",


							};
			for(String sql : query) {
				Statement stmt = this.conn.createStatement();
				stmt.execute(sql);
				stmt.close();
			}

		} catch(SQLIntegrityConstraintViolationException e) {
			e.getStackTrace();
		}
	}



    public void addTermin() throws SQLException{
        String sql = "INSERT INTO Kunde(Vorname,Nachname,Design) VALUES(?,?,?)";
        PreparedStatement stmt = this.conn.prepareStatement(sql);

        stmt.executeUpdate();
        stmt.close();
    }
/*

    public void deleteTermin(String key) throws SQLException{
        String sql = "DELETE FROM KUNDE  Where  Setup(Option) VALUES(?)";
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        stmt.setString(1, key.toUpperCase());
        stmt.executeUpdate();
        stmt.close();
    }

    public void updateTermin(String key) throws SQLException{
        String sql = "INSERT INTO Setup(Option) VALUES(?)";
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        stmt.setString(1, key.toUpperCase());
        stmt.executeUpdate();
        stmt.close();
    }

*/
}
