package com.upc.condominio.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConexionBD {
	
	public static Connection obtenerConexion() throws SQLException {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost/condominio",
					"root", "root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	
	
	public static Connection obtenerConexionPool()throws SQLException{
		
		Connection cn=null;
		try{
			 Context context=new InitialContext();
		     Context envContext = (Context) context.lookup("java:/comp/env");
			 DataSource datasource = (DataSource) envContext
					 .lookup("jdbc/com.upc.condominio"); //CondominioDS
			 cn = datasource.getConnection();
		
		} catch (NamingException ex) {
			System.out.println(ex.getMessage());
			throw new SQLException("No se pudo encontrar el DataSource.");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			throw new SQLException("No se pudo obtener una conexión.");
		}
		
		return cn;
		
		
	}

}
