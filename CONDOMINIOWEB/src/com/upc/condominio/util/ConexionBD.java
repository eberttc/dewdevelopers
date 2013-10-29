package com.upc.condominio.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConexionBD {
	
	
	public static Connection obtenerConexion() throws SQLException {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost/bdcondominio",
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
		Properties env = new Properties();
		try{
			 Context context=new InitialContext();
		        
		     Context envContext = (Context) context.lookup("java:/comp/env");
			 DataSource datasource = (DataSource) envContext.lookup("jdbc/CondominioDS");
			 
			 cn = datasource.getConnection();
		
		
		}catch(Exception e){
			e.printStackTrace();
			throw new SQLException("No se pudo encontrar el DataSource.");							
		}
		
		
		return cn;
		
		
	}

}
