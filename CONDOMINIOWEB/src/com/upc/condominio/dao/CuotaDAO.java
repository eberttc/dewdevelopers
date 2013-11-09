package com.upc.condominio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.mysql.jdbc.CallableStatement;
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
				String query =	"INSERT INTO CUOTA (C_Period, N_IdVivi, N_ImpPag, D_FecVen) " +
								"VALUES (?,?,?,?)";
				
				con = ConexionBD.obtenerConexion();
				stmt = con.prepareStatement(query);
				stmt.setString(1, cuota.getC_Period());
				stmt.setInt(2, cuota.getN_IdVivi());
				stmt.setDouble(3, cuota.getN_ImpPag());
				//
				d = cuota.getD_FecVen();
				java.sql.Timestamp dt = new java.sql.Timestamp(d.getTime());
				stmt.setTimestamp(4, dt);
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
	
	public String eliminar(int idCuot) throws DAOExcepcion {
		String query = "delete from CUOTA WHERE N_IdCuot=?";
		Connection con = null;
		PreparedStatement stmt = null;
		String vReturn = "NO_OK";
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idCuot);
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo eliminar el registro de Cuota");
			}else{
				vReturn = "OK";
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vReturn;
	}
	
	public Cuota buscarPeriodoVivienda(Cuota cuota) throws DAOExcepcion {
		Cuota cuotaBuscada =null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "SELECT N_IdCuot,C_Period,N_IdVivi,N_TipPag,N_ImpPag,D_FecVen, D_FecPag FROM Cuota " 
							+ " WHERE C_Period=? AND  N_IdVivi=? " ;
			stmt = con.prepareStatement(query);
			stmt.setString(1, cuota.getC_Period());
			stmt.setInt(2, cuota.getN_IdVivi());
			rs = stmt.executeQuery();
			while (rs.next()) 
			{
				cuotaBuscada = new Cuota();
				cuotaBuscada.setN_IdCuot(rs.getInt("N_IdCuot"));
				cuotaBuscada.setC_Period(rs.getString("C_Period"));
				cuotaBuscada.setN_IdVivi(rs.getInt("N_IdVivi"));
				cuotaBuscada.setN_TipPag(rs.getInt("N_TipPag"));
				cuotaBuscada.setN_ImpPag(rs.getFloat("N_ImpPag"));
				cuotaBuscada.setD_FecVen(rs.getDate("D_FecVen"));
				cuotaBuscada.setD_FecPag(rs.getDate("D_FecPag"));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return cuotaBuscada;
	}
	
	public Cuota obtener(int idCuot) throws DAOExcepcion {
		Cuota cuotaBuscada =null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "SELECT N_IdCuot,C_Period,N_IdVivi,N_TipPag,N_ImpPag,D_FecVen, D_FecPag FROM Cuota " 
							+ " WHERE N_IdCuot=?" ;
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idCuot);
			rs = stmt.executeQuery();
			while (rs.next()) 
			{
				cuotaBuscada = new Cuota();
				cuotaBuscada.setN_IdCuot(rs.getInt("N_IdCuot"));
				cuotaBuscada.setC_Period(rs.getString("C_Period"));
				cuotaBuscada.setN_IdVivi(rs.getInt("N_IdVivi"));
				cuotaBuscada.setN_TipPag(rs.getInt("N_TipPag"));
				cuotaBuscada.setN_ImpPag(rs.getFloat("N_ImpPag"));
				cuotaBuscada.setD_FecVen(rs.getDate("D_FecVen"));
				cuotaBuscada.setD_FecPag(rs.getDate("D_FecPag"));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return cuotaBuscada;
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
		//	cuota.setD_FecPag(rs.getDate("D_FecPag"));
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

	public Cuota realizarPago(Cuota cuota) throws DAOExcepcion {
		
		Connection con = null;
		PreparedStatement stmt = null;
		java.util.Date d; 
		
		try {
				String query =	"UPDATE CUOTA SET N_TipPag=?, D_FecPag=? " +
								"WHERE N_IdCuot=?";
				con = ConexionBD.obtenerConexion();
				stmt = con.prepareStatement(query);
				stmt.setInt(1, cuota.getN_TipPag());
				
				//
				d = cuota.getD_FecPag();
				java.sql.Timestamp dt = new java.sql.Timestamp(d.getTime());
				stmt.setTimestamp(2, dt);
				//
				stmt.setInt(3, cuota.getN_IdCuot());
				
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
	
	/* M�todos del DAO con llamadas a PROCEDIMIENTOS ALMACENADOS*/
	
	public Cuota insertarPA(Cuota cuota) throws DAOExcepcion {
		
		Connection con = null;
		CallableStatement procedAlmacenado = null;
		ResultSet rs = null;
		java.util.Date d; 
		
		try {
				con = ConexionBD.obtenerConexion();
				procedAlmacenado = (CallableStatement) con.prepareCall("{ call usp_cond_mnt_insert_cuota (?,?,?,?) }");
				
				procedAlmacenado.setString(1, cuota.getC_Period());
				procedAlmacenado.setInt(2, cuota.getN_IdVivi());
				procedAlmacenado.setDouble(3, cuota.getN_ImpPag());
				//
				d = cuota.getD_FecVen();
				java.sql.Timestamp dt = new java.sql.Timestamp(d.getTime());
				procedAlmacenado.setTimestamp(4, dt);
				boolean i = procedAlmacenado.execute();
				if (i != false) {
					throw new SQLException("ERROR: NO SE PUDO INSERTAR");
				}
	
				int id = 0;
				String query = "SELECT LAST_INSERT_ID()";
				PreparedStatement stmt2 = con.prepareStatement(query);
				rs = stmt2.executeQuery();
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
				this.cerrarStatement(procedAlmacenado);
				this.cerrarConexion(con);
		}
		return cuota;
	}
	
	public Cuota actualizarPA(Cuota cuota) throws DAOExcepcion {
		
		Connection con = null;
		//PreparedStatement stmt = null;
		CallableStatement procedAlmacenado = null;
		java.util.Date d; 
		
		try {
				con = ConexionBD.obtenerConexion();
				procedAlmacenado = (CallableStatement) con.prepareCall("{ call usp_cond_mnt_update_cuota (?,?,?,?,?) }");

				procedAlmacenado.setInt(1, cuota.getN_IdCuot());
				procedAlmacenado.setString(2, cuota.getC_Period());
				procedAlmacenado.setInt(3, cuota.getN_IdVivi());
				procedAlmacenado.setDouble(4, cuota.getN_ImpPag());
				//
				d = cuota.getD_FecVen();
				java.sql.Timestamp dt = new java.sql.Timestamp(d.getTime());
				procedAlmacenado.setTimestamp(5, dt);
				//
				
				int i = procedAlmacenado.executeUpdate();
				if (i != 1) {
					throw new SQLException("ERROR: NO SE PUDO ACTUALIZAR LA CUOTA");
				}
		} catch (SQLException e) {
				cuota = null;	
				System.err.println(e.getMessage());
				throw new DAOExcepcion(e.getMessage());
		} finally {
				this.cerrarStatement(procedAlmacenado);
				this.cerrarConexion(con);
		}
		return cuota;
	}
	
}
