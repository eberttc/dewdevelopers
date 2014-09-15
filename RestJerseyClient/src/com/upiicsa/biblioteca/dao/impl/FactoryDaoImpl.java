package com.upiicsa.biblioteca.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.upiicsa.biblioteca.dao.FactoryDao;

public class FactoryDaoImpl implements FactoryDao {

	Log logger = LogFactory.getLog(FactoryDaoImpl.class);
			
	private Connection connection = null;
	final String driverDB = "com.mysql.jdbc.Driver";
	final String urlDB = "jdbc:mysql://localhost:8080/biblioteca;";
	final String userDB = "root";
	final String passDB = "root";
	
	@Override
	public Connection getConex() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName(driverDB);
		connection = DriverManager.getConnection(urlDB, userDB, passDB);
		return connection;
	}

	@Override
	public void closeConnection() throws SQLException {
		// TODO Auto-generated method stub
		connection.close();
	}
	
}
