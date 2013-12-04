package com.upc.condominio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Residente;
import com.upc.condominio.modelo.Vivienda;
import com.upc.condominio.util.ConexionBD;

public class ViviendaDAO extends BaseDAO {

	public Vivienda insertar(Vivienda vivienda) throws DAOExcepcion {
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
				String query =	"INSERT INTO VIVIENDAS (C_NroEdi, C_NroDpto, N_NumMet, C_TipViv, N_IdRes, C_EstReg) " +
								"VALUES (?,?,?,?,?,?)";
				
				con = ConexionBD.obtenerConexion();
				stmt = con.prepareStatement(query);
				stmt.setString(1, vivienda.getC_Ubicacion());
				stmt.setString(2, vivienda.getC_Numero());
				stmt.setDouble(3, vivienda.getN_Metraje());
				stmt.setString(4, vivienda.getC_TipViv());
				stmt.setInt(5, vivienda.getResidente().getIdResidente());
				stmt.setInt(6, 1);
				
				int i = stmt.executeUpdate();
				if (i != 1) {
					vivienda = null;
					throw new SQLException("ERROR: NO SE PUDO INSERTAR");
				}
	
				int id = 0;
				query = "SELECT LAST_INSERT_ID()";
				stmt = con.prepareStatement(query);
				rs = stmt.executeQuery();
				if (rs.next()) {
					id = rs.getInt(1);
				}
				vivienda.setN_IdVivi(id);

		} catch (SQLException e) {
				vivienda = null;
				System.err.println(e.getMessage());
				throw new DAOExcepcion(e.getMessage());
		} finally {
				this.cerrarResultSet(rs);
				this.cerrarStatement(stmt);
				this.cerrarConexion(con);
		}
		return vivienda;
	}

	public List<Vivienda> listar() throws DAOExcepcion {
		
		List<Vivienda> lista = new ArrayList<Vivienda>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			String query =	"SELECT V.N_IdVivi, V.C_NroEdi, V.C_NroDpto, V.N_NumMet, V.C_TipViv, R.N_IdRes, R.C_NomRes " +
					"FROM VIVIENDAS V INNER JOIN RESIDENTES R ON V.N_IdRes = R.N_IdRes " +
					"WHERE V.C_EstReg ='S'";
				con = ConexionBD.obtenerConexion();
				stmt = con.prepareStatement(query);
				rs = stmt.executeQuery();
				
				while (rs.next()) {

					Residente residente = new Residente();
					Vivienda vivienda= new Vivienda();
					
					residente.setIdResidente(rs.getInt("N_IdRes"));
					residente.setNombreResidente(rs.getString("C_NomRes"));
					
					vivienda.setResidente(residente);
					vivienda.setN_IdVivi(rs.getInt("N_IdVivi"));
					vivienda.setC_Ubicacion(rs.getString("C_NroDpto"));
					vivienda.setC_Numero(rs.getString("C_NroEdi"));
					vivienda.setN_Metraje(rs.getDouble("N_NumMet"));
					vivienda.setC_TipViv(rs.getString("C_TipViv"));
														
					lista.add(vivienda);
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
	
	public int getExisteVivienda(Vivienda vivienda) throws DAOExcepcion {
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int v_nCantidad = 0; 
		
		try {
			String query =	"SELECT COUNT(*) AS CANTIDAD FROM VIVIENDAS V " +
							"WHERE V.C_NroEdi = ? AND V.C_NroDpto = ? AND V.C_TipViv = ? AND V.N_IdRes = ?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vivienda.getC_Ubicacion());
			stmt.setString(2, vivienda.getC_Numero());
			stmt.setString(3, vivienda.getC_TipViv());
			stmt.setInt(4, vivienda.getResidente().getIdResidente());
			
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				v_nCantidad = rs.getInt("CANTIDAD");
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
	
	public Vivienda obtener(int idVivienda) throws DAOExcepcion {
	
		Vivienda vivienda = new Vivienda();
		Residente residente = new Residente();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
				String query =	"SELECT V.N_IdVivi, V.C_Ubicacion, V.C_Numero, V.N_Metraje, V.C_TipViv, R.N_CodRes, R.C_NomRes " +
								"FROM VIVIENDAS V INNER JOIN RESIDENTES R ON V.N_CodRes = R.N_CodRes " +
								"WHERE V.N_IdVivi = ? AND V.C_EstReg = 1";
				con = ConexionBD.obtenerConexion();
				stmt = con.prepareStatement(query);
				stmt.setInt(1, idVivienda);
				rs = stmt.executeQuery();
				
				if (rs.next()) {
					
					residente.setIdResidente(rs.getInt("N_CodRes"));
					residente.setNombreResidente(rs.getString("C_NomRes"));
					
					vivienda.setResidente(residente);
					vivienda.setN_IdVivi(rs.getInt("N_IdVivi"));
					vivienda.setC_Ubicacion(rs.getString("C_Ubicacion"));
					vivienda.setC_Numero(rs.getString("C_Numero"));
					vivienda.setN_Metraje(rs.getDouble("N_Metraje"));
					vivienda.setC_TipViv(rs.getString("C_TipViv"));
					
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
		return vivienda;
	}
	
	public Vivienda actualizar(Vivienda vivienda) throws DAOExcepcion {
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			
				String query =	"UPDATE VIVIENDAS SET C_Ubicacion=?, C_Numero=?, N_Metraje=?, C_TipViv=?, N_CodRes=? " +
								"WHERE N_IdVivi=?";
				con = ConexionBD.obtenerConexion();
				stmt = con.prepareStatement(query);
				stmt.setString(1, vivienda.getC_Ubicacion());
				stmt.setString(2, vivienda.getC_Numero());
				stmt.setDouble(3, vivienda.getN_Metraje());
				stmt.setString(4, vivienda.getC_TipViv());
				stmt.setInt(5, vivienda.getResidente().getIdResidente());
				stmt.setInt(6, vivienda.getN_IdVivi());
				
				int i = stmt.executeUpdate();
				if (i != 1) {
					throw new SQLException("ERROR: NO SE PUDO ACTUALIZAR");
				}
		} catch (SQLException e) {
				vivienda = null;	
				System.err.println(e.getMessage());
				throw new DAOExcepcion(e.getMessage());
		} finally {
				this.cerrarStatement(stmt);
				this.cerrarConexion(con);
		}
		return vivienda;
	}

	
	public String eliminar(int idVivienda) throws DAOExcepcion {
		
		Vivienda vivienda = new Vivienda();
		Connection con = null;
		PreparedStatement stmt = null;
		
		String vReturn = "NO_OK";
		try {
				String query = "UPDATE VIVIENDAS SET C_EstReg = 0 WHERE N_IdVivi=?";
				con = ConexionBD.obtenerConexion();
				stmt = con.prepareStatement(query);
				stmt.setInt(1, idVivienda);
				
				int i = stmt.executeUpdate();
				if (i != 1) {
					throw new SQLException("ERROR: NO SE PUDO ELIMINAR");
				}else{
					vReturn = "OK";
				}
		} catch (SQLException e) {
				vivienda = null;	
				System.err.println(e.getMessage());
				throw new DAOExcepcion(e.getMessage());
		} finally {
				this.cerrarStatement(stmt);
				this.cerrarConexion(con);
		}
		return vReturn;
	}

	
}
