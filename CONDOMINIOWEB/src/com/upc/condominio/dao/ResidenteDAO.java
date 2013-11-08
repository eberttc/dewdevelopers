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
				stmt.setString(1, residente.getNombreResidente());
				stmt.setInt(2, residente.getTipoDocumento());
				stmt.setString(3, residente.getNumeroDocumento());
				//
				d = residente.getFechaNacimiento();
				java.sql.Timestamp dt = new java.sql.Timestamp(d.getTime());
				stmt.setTimestamp(4, dt);
				//
				stmt.setString(5, residente.getCorreo());
				stmt.setString(6, residente.getClave());
				stmt.setInt(7, 1);
				
				
				
				int i = stmt.executeUpdate();
				if (i != 1) {
					residente = null;
					throw new SQLException("ERROR: NO SE PUDO INSERTAR");
				}
	
				int id = 0;
				query = "SELECT LAST_INSERT_ID()";
				stmt = con.prepareStatement(query);
				rs = stmt.executeQuery();
				if (rs.next()) {
					id = rs.getInt(1);
				}
				residente.setIdResidente(id);

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
	
	public int getExisteDocumento(int p_nTi_Doc, String p_vNu_Doc) throws DAOExcepcion {
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int v_nCantidad = 0; 
		
		try {
			String query =	"SELECT COUNT(*) as cantidad FROM RESIDENTES R " +
							"WHERE R.N_TipDoc = ? AND R.C_NumDoc = ? AND C_ESTREG=1";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, p_nTi_Doc);
			stmt.setString(2, p_vNu_Doc);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				v_nCantidad = rs.getInt("cantidad");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return v_nCantidad;
	}
	
	public int getExisteCorreo(String p_vCorreo) throws DAOExcepcion {
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int v_nCantidad = 0; 
		
		try {
			String query =	"SELECT COUNT(*) as cantidad FROM RESIDENTES R " +
							"WHERE R.C_Correo = ? AND C_ESTREG=1";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, p_vCorreo);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				v_nCantidad = rs.getInt("cantidad");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return v_nCantidad;
	}

	public List<Residente> buscarPorNombre(String nombre) throws DAOExcepcion {
		
		List<Residente> lista = new ArrayList<Residente>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
				String query =	"SELECT R.N_IdRes, R.C_NomRes, R.N_TipDoc, R.C_NumDoc, R.D_FecNac, R.C_Correo FROM RESIDENTES R " +
								"WHERE R.C_NomRes LIKE ? AND C_ESTREG=1";
				con = ConexionBD.obtenerConexion();
				stmt = con.prepareStatement(query);
				stmt.setString(1, "%" + nombre + "%");
				rs = stmt.executeQuery();
				
				while (rs.next()) {

					Residente residente = new Residente();
					residente.setIdResidente(rs.getInt("N_IdRes"));
					residente.setNombreResidente(rs.getString("C_NomRes"));
					residente.setTipoDocumento(rs.getInt("N_TipDoc"));
					residente.setNumeroDocumento(rs.getString("C_NumDoc"));
					residente.setFechaNacimiento(rs.getDate("D_FecNac"));
					residente.setCorreo(rs.getString("C_Correo"));
														
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
				String query =	"SELECT R.N_IdRes, R.C_NomRes, R.N_TipDoc, R.C_NumDoc, R.D_FecNac, R.C_Correo FROM RESIDENTES R " +
								"WHERE R.N_IdRes = ? AND C_ESTREG=1";
				con = ConexionBD.obtenerConexion();
				stmt = con.prepareStatement(query);
				stmt.setInt(1, idResidente);
				rs = stmt.executeQuery();
				
				if (rs.next()) {
					residente.setIdResidente(rs.getInt("N_IdRes"));
					residente.setNombreResidente(rs.getString("C_NomRes"));
					residente.setTipoDocumento(rs.getInt("N_TipDoc"));
					residente.setNumeroDocumento(rs.getString("C_NumDoc"));
					residente.setFechaNacimiento(rs.getDate("D_FecNac"));
					residente.setCorreo(rs.getString("C_Correo"));
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
								"WHERE N_IdRes=?";
				con = ConexionBD.obtenerConexion();
				stmt = con.prepareStatement(query);
				stmt.setString(1, residente.getNombreResidente());
				stmt.setInt(2, residente.getTipoDocumento());
				stmt.setString(3, residente.getNumeroDocumento());
				//
				d = residente.getFechaNacimiento();
				java.sql.Timestamp dt = new java.sql.Timestamp(d.getTime());
				stmt.setTimestamp(4, dt);
				//
				stmt.setString(5, residente.getCorreo());
				stmt.setInt(6, residente.getIdResidente());
				
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
				String query = "UPDATE RESIDENTES SET C_EstReg = 0 WHERE N_IdRes=?";
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
