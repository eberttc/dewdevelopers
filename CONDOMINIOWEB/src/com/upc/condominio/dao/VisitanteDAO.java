package com.upc.condominio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Visitante;
import com.upc.condominio.util.ConexionBD;

public class VisitanteDAO extends BaseDAO {
	
	// Considerar Insertar, Listar y Buscar Visitantes
	
	@SuppressWarnings("resource")
	public Visitante insertar(Visitante visitante) throws DAOExcepcion {
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
				
		try {
				String query =	"INSERT INTO VISITANTES (N_CORREL, C_DNIVIS, C_NOMVIS, N_CODRES, D_HORAFECHAVISIT) " +
								"VALUES (?,?,?,?,?,?)";
				
				con = ConexionBD.obtenerConexion();
				stmt = con.prepareStatement(query);
				stmt.setInt(1, visitante.getintCorrelativo());
				stmt.setString(2, visitante.getstrDNIVisitante());
				stmt.setString(3, visitante.getstrNombreVisitante());
				stmt.setInt(4, visitante.getintCodigoResidente());
				
				
				
				stmt.setDate(5, new java.sql.Date(visitante.getdHoraFechaVisitante().getTime()) );
				
			
				
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
				visitante.setintCorrelativo(id);

		} catch (SQLException e) {
				visitante = null;
				System.err.println(e.getMessage());
				throw new DAOExcepcion(e.getMessage());
		} finally {
				this.cerrarResultSet(rs);
				this.cerrarStatement(stmt);
				this.cerrarConexion(con);
		}
		return visitante;
	}
	
	public List<Visitante> buscarVisitante(String estadoVisitante) throws DAOExcepcion {
		
		List<Visitante> lista = new ArrayList<Visitante>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
				String query =	"SELECT V.N_Correl, V.C_DniVis, V.C_NomVis, V.N_CodRes, V.D_HoraFechaVisit FROM Visitantes V " +
								"WHERE V.N_Correl LIKE ? ";
				con = ConexionBD.obtenerConexion();
				stmt = con.prepareStatement(query);
				stmt.setString(1, "%" + estadoVisitante + "%");
				rs = stmt.executeQuery();
				
				while (rs.next()) {

					Visitante visitante = new Visitante();
					visitante.setintCorrelativo(rs.getInt("N_Correl"));
					visitante.setstrDNIVisitante(rs.getString("C_DniVis"));
					visitante.setstrNombreVisitante(rs.getString("C_NomVis"));
					visitante.setintCodigoResidente(rs.getInt("N_CodRes"));
					visitante.setdHoraFechaVisitante(rs.getDate("D_HoraFechaVisit"));
					
					lista.add(visitante);
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

	public Visitante obtener(int idVisitante) throws DAOExcepcion {
		
		Visitante visitante = new Visitante();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			String query =	"SELECT V.N_Correl, V.C_DniVis, V.C_NomVis, V.N_CodRes, V.D_HoraFechaVisit FROM Visitantes V " +
					"WHERE V.N_Correl = ? ";
					con = ConexionBD.obtenerConexion();
					stmt = con.prepareStatement(query);
					stmt.setInt(1, idVisitante);
					rs = stmt.executeQuery();
				
				if (rs.next()) {		
					
					visitante.setintCorrelativo(rs.getInt("N_Correl"));
					visitante.setstrDNIVisitante(rs.getString("C_DniVis"));
					visitante.setstrNombreVisitante(rs.getString("C_NomVis"));
					visitante.setintCodigoResidente(rs.getInt("N_CodRes"));
					visitante.setdHoraFechaVisitante(rs.getDate("D_HoraFechaVisit"));
														
			}
		} catch (SQLException e) {
			visitante = null;
				System.err.println(e.getMessage());
				throw new DAOExcepcion(e.getMessage());
		} finally {
				this.cerrarResultSet(rs);
				this.cerrarStatement(stmt);
				this.cerrarConexion(con);
		}
		return visitante;
	}

	
}


