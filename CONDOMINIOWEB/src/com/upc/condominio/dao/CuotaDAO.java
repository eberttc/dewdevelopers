package com.upc.condominio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Cuota;
import com.upc.condominio.util.ConexionBD;

public class CuotaDAO  extends BaseDAO {
	
public Cuota insertar(Cuota cuota) throws DAOExcepcion {
				
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		java.util.Date d; 
		
		try {
				String query =	"INSERT INTO CUOTA (C_Period, N_IdVivi, N_TipPag, N_ImpPag, D_FecVen) " +
								"VALUES (?,?,?,?,?)";
				
				con = ConexionBD.obtenerConexion();
				stmt = con.prepareStatement(query);
				stmt.setString(1, cuota.getC_Period());
				stmt.setInt(2, cuota.getN_IdVivi());
				stmt.setInt(3, cuota.getN_TipPag());
				stmt.setDouble(4, cuota.getN_ImpPag());
				//
				d = cuota.getD_FecVen();
				java.sql.Timestamp dt = new java.sql.Timestamp(d.getTime());
				stmt.setTimestamp(5, dt);
				//
				
				int i = stmt.executeUpdate();
				if (i != 1) {
					throw new SQLException("ERROR: NO SE PUDO INSERTAR");
				}
	
				int id = 0;
				query = "SELECT LAST_INSERT_ID()";
				stmt = con.prepareStatement(query);
				rs = stmt.executeQuery();
				if (rs.next()) {
					id = rs.getInt(1);
				}
				cuota.setN_IdCuot(id);

		} catch (SQLException e) {
				cuota = null;
				System.err.println(e.getMessage());
				throw new DAOExcepcion(e.getMessage());
		} finally {
				this.cerrarResultSet(rs);
				this.cerrarStatement(stmt);
				this.cerrarConexion(con);
		}
		return cuota;
	}

public Cuota actualizar(Cuota cuota) throws DAOExcepcion {
	
	Connection con = null;
	PreparedStatement stmt = null;
	java.util.Date d; 
	
	try {
			String query =	"UPDATE CUOTA SET C_Period=?, N_IdVivi=?, N_TipPag=?, N_ImpPag=?, D_FecVen=? " +
							"WHERE N_IdCuot=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, cuota.getC_Period());
			stmt.setInt(2, cuota.getN_IdVivi());
			stmt.setInt(3, cuota.getN_TipPag());
			stmt.setDouble(4, cuota.getN_ImpPag());
			//
			d = cuota.getD_FecVen();
			java.sql.Timestamp dt = new java.sql.Timestamp(d.getTime());
			stmt.setTimestamp(5, dt);
			//
			stmt.setInt(6, cuota.getN_IdCuot());
			
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("ERROR: NO SE PUDO ACTUALIZAR LA CUOTA");
			}
	} catch (SQLException e) {
			cuota = null;	
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
	} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
	}
	return cuota;
}

public void eliminar(int idCuot) throws DAOExcepcion {
	String query = "delete from CUOTA WHERE N_IdCuot=?";
	Connection con = null;
	PreparedStatement stmt = null;
	try {
		con = ConexionBD.obtenerConexion();
		stmt = con.prepareStatement(query);
		stmt.setInt(1, idCuot);
		int i = stmt.executeUpdate();
		if (i != 1) {
			throw new SQLException("No se pudo eliminar el registro de Cuota");
		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
		throw new DAOExcepcion(e.getMessage());
	} finally {
		this.cerrarStatement(stmt);
		this.cerrarConexion(con);
	}
}

public Collection<Cuota> listar() throws DAOExcepcion {
	Collection<Cuota> listaCuota = new ArrayList<Cuota>();
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	try {
		con = ConexionBD.obtenerConexion();
		String query = "SELECT N_IdCuot,C_Period,N_IdVivi,N_TipPag,N_ImpPag,D_FecVen, D_FecPag FROM Cuota order by C_Period";
		stmt = con.prepareStatement(query);
		rs = stmt.executeQuery();
		while (rs.next()) 
		{
			Cuota cuota = new Cuota();
			cuota.setN_IdCuot(rs.getInt("N_IdCuot"));
			cuota.setC_Period(rs.getString("C_Period"));
			cuota.setN_IdVivi(rs.getInt("N_IdVivi"));
			cuota.setN_TipPag(rs.getInt("N_TipPag"));
			cuota.setN_ImpPag(rs.getFloat("N_ImpPag"));
			cuota.setD_FecVen(rs.getDate("D_FecVen"));
			cuota.setD_FecPag(rs.getDate("D_FecPag"));
			listaCuota.add(cuota);
		}

	} catch (SQLException e) {
		System.err.println(e.getMessage());
		throw new DAOExcepcion(e.getMessage());
	} finally {
		this.cerrarResultSet(rs);
		this.cerrarStatement(stmt);
		this.cerrarConexion(con);
	}
	return listaCuota;
}

}
