package com.upc.condominio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Residente;
import com.upc.condominio.util.ConexionBD;

public class ResidenteDAO extends BaseDAO {

	public Residente insertar(Residente residente) throws DAOExcepcion {
				
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		java.util.Date d; 
		
		try {
				String query =	"INSERT INTO RESIDENTES (C_NOMRES, N_TIPDOC, C_NUMDOC, D_FECNAC, C_CORREO, C_CLAVE, C_ESTREG) " +
								"VALUES (?,?,?,?,?,?,?)";
				
				con = ConexionBD.obtenerConexion();
				stmt = con.prepareStatement(query);
				stmt.setString(1, residente.getC_NomRes());
				stmt.setInt(2, residente.getC_TipDoc());
				stmt.setString(3, residente.getC_NumDoc());
				//
				d = residente.getD_FecNac();
				java.sql.Timestamp dt = new java.sql.Timestamp(d.getTime());
				stmt.setTimestamp(4, dt);
				//
				stmt.setString(5, residente.getC_Correo());
				stmt.setString(6, residente.getC_Clave());
				stmt.setInt(7, 1);
				
				
				
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
				residente.setN_CodRes(id);

		} catch (SQLException e) {
				residente = null;
				System.err.println(e.getMessage());
				throw new DAOExcepcion(e.getMessage());
		} finally {
				this.cerrarResultSet(rs);
				this.cerrarStatement(stmt);
				this.cerrarConexion(con);
		}
		return residente;
	}

	public List<Residente> buscarPorNombre(String nombre) throws DAOExcepcion {
		
		List<Residente> lista = new ArrayList<Residente>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
				String query =	"SELECT R.N_CodRes, R.C_NomRes, R.N_TipDoc, R.C_NumDoc, R.D_FecNac, R.C_Correo FROM RESIDENTES R " +
								"WHERE R.C_NomRes LIKE ? ";
				con = ConexionBD.obtenerConexion();
				stmt = con.prepareStatement(query);
				stmt.setString(1, "%" + nombre + "%");
				rs = stmt.executeQuery();
				
				while (rs.next()) {

					Residente residente = new Residente();
					residente.setN_CodRes(rs.getInt("N_CodRes"));
					residente.setC_NomRes(rs.getString("C_NomRes"));
					residente.setC_TipDoc(rs.getInt("N_TipDoc"));
					residente.setC_NumDoc(rs.getString("C_NumDoc"));
					residente.setD_FecNac(rs.getDate("D_FecNac"));
					residente.setC_Correo(rs.getString("C_Correo"));
														
					lista.add(residente);
				}
		} 
		catch (SQLException e) {
				lista = null;
				System.err.println(e.getMessage());
				throw new DAOExcepcion(e.getMessage());
		} 
		finally {
				this.cerrarResultSet(rs);
				this.cerrarStatement(stmt);
				this.cerrarConexion(con);
		}
		return lista;
	}
	
	public Residente obtener(int idResidente) throws DAOExcepcion {
	
		Residente residente = new Residente();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
				String query =	"SELECT R.N_CodRes, R.C_NomRes, R.N_TipDoc, R.C_NumDoc, R.D_FecNac, R.C_Correo FROM RESIDENTES R " +
								"WHERE R.N_CodRes = ? ";
				con = ConexionBD.obtenerConexion();
				stmt = con.prepareStatement(query);
				stmt.setInt(1, idResidente);
				rs = stmt.executeQuery();
				
				if (rs.next()) {
					residente.setN_CodRes(rs.getInt("N_CodRes"));
					residente.setC_NomRes(rs.getString("C_NomRes"));
					residente.setC_TipDoc(rs.getInt("N_TipDoc"));
					residente.setC_NumDoc(rs.getString("C_NumDoc"));
					residente.setD_FecNac(rs.getDate("D_FecNac"));
					residente.setC_Correo(rs.getString("C_Correo"));
			}
		} catch (SQLException e) {
			residente = null;
				System.err.println(e.getMessage());
				throw new DAOExcepcion(e.getMessage());
		} finally {
				this.cerrarResultSet(rs);
				this.cerrarStatement(stmt);
				this.cerrarConexion(con);
		}
		return residente;
	}
	
	public Residente actualizar(Residente residente) throws DAOExcepcion {
		
		Connection con = null;
		PreparedStatement stmt = null;
		java.util.Date d; 
		
		try {
				String query =	"UPDATE RESIDENTES SET C_NOMRES=?, N_TIPDOC=?, C_NUMDOC=?, D_FECNAC=?, C_CORREO=? " +
								"WHERE N_CODRES=?";
				con = ConexionBD.obtenerConexion();
				stmt = con.prepareStatement(query);
				stmt.setString(1, residente.getC_NomRes());
				stmt.setInt(2, residente.getC_TipDoc());
				stmt.setString(3, residente.getC_NumDoc());
				//
				d = residente.getD_FecNac();
				java.sql.Timestamp dt = new java.sql.Timestamp(d.getTime());
				stmt.setTimestamp(4, dt);
				//
				stmt.setString(5, residente.getC_Correo());
				stmt.setInt(6, residente.getN_CodRes());
				
				int i = stmt.executeUpdate();
				if (i != 1) {
					throw new SQLException("ERROR: NO SE PUDO ACTUALIZAR");
				}
		} catch (SQLException e) {
				residente = null;	
				System.err.println(e.getMessage());
				throw new DAOExcepcion(e.getMessage());
		} finally {
				this.cerrarStatement(stmt);
				this.cerrarConexion(con);
		}
		return residente;
	}

	
	public String eliminar(int idResidente) throws DAOExcepcion {
		
		Residente residente = new Residente();
		Connection con = null;
		PreparedStatement stmt = null;
		
		String vReturn = "NO_OK";
		try {
				String query = "UPDATE RESIDENTES SET C_EstReg = 0 WHERE N_CODRES=?";
				con = ConexionBD.obtenerConexion();
				stmt = con.prepareStatement(query);
				stmt.setInt(1, idResidente);
				
				int i = stmt.executeUpdate();
				if (i != 1) {
					throw new SQLException("ERROR: NO SE PUDO ELIMINAR");
				}else{
					vReturn = "OK";
				}
		} catch (SQLException e) {
				residente = null;	
				System.err.println(e.getMessage());
				throw new DAOExcepcion(e.getMessage());
		} finally {
				this.cerrarStatement(stmt);
				this.cerrarConexion(con);
		}
		return vReturn;
	}

}
