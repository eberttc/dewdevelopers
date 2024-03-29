package com.upc.condominio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Visitante;
import com.upc.condominio.util.ConexionBD;

public class VisitanteDAO extends BaseDAO {
	
	// Considerar Insertar, Listar Visitantes por Residentes
	
	@SuppressWarnings("resource")
	public Visitante insertar(Visitante visitante) throws DAOExcepcion {
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
				
		try {
				String query =	"INSERT INTO VISITANTES (N_CORREL, C_DNIVIS, C_NOMVIS, N_IDRES, D_HORAFECHAVISIT) " +
								"VALUES (?,?,?,?,?)";
				
				con = ConexionBD.obtenerConexion();
				stmt = con.prepareStatement(query);
				stmt.setInt(1, visitante.getIntCorrelativo());
				stmt.setString(2, visitante.getStrDNIVisitante());
				stmt.setString(3, visitante.getStrNombreVisitante());
				stmt.setInt(4, visitante.getIntCodigoResidente());
				
				stmt.setDate(5, new java.sql.Date(visitante.getdHoraFechaVisitante().getTime()) );
				
			
				
				int i = stmt.executeUpdate();
				if (i != 1) {
					throw new SQLException("ERROR: NO SE PUDO INSERTAR");
				} else {
					System.out.println("LA VISITA FUE REGISTRADA CORRECTAMENTE");
				}
	
				int id = 0;
				query = "SELECT LAST_INSERT_ID()";
				stmt = con.prepareStatement(query);
				rs = stmt.executeQuery();
				if (rs.next()) {
					id = rs.getInt(1);
				}
				visitante.setIntCorrelativo(id);

		} catch (SQLException e) {
				visitante = null;
				//System.err.println(e.getMessage());
				throw new DAOExcepcion(e.getMessage());
		} finally {
				this.cerrarResultSet(rs);
				this.cerrarStatement(stmt);
				this.cerrarConexion(con);
		}
		return visitante;
	}
/*	
	public List<Visitante> buscarVisitante(int codResidente) throws DAOExcepcion {
		
		List<Visitante> lista = new ArrayList<Visitante>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
				String query =	"select C_NomRes, C_DniVis, C_NomVis, D_HoraFechaVisit from residentes r inner join visitantes v on r.N_IdRes = v.N_IdRes " +
								"where v.N_IdRes = ? ";
				con = ConexionBD.obtenerConexion();
				stmt = con.prepareStatement(query);
				stmt.setInt(1, codResidente);
				rs = stmt.executeQuery();
				String nomResidente = "";
				
				while (rs.next()) {

					Visitante visitante = new Visitante();
					nomResidente = rs.getString("C_NomRes");
					visitante.setintCorrelativo(rs.getInt("N_Correl"));
					visitante.setstrDNIVisitante(rs.getString("C_DniVis"));
					visitante.setstrNombreVisitante(rs.getString("C_NomVis"));
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
*/
	public Collection<Visitante> listarVisitante() throws DAOExcepcion {
		Collection<Visitante> v = new ArrayList<Visitante>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			String query =	"SELECT V.N_Correl, V.C_DniVis, V.C_NomVis, r.C_NomRes, V.D_HoraFechaVisit FROM Visitantes V  inner join residentes r on r.N_IdRes = v.N_IdRes "; // +
//					"WHERE r.N_IdRes = ? ";
					con = ConexionBD.obtenerConexion();
					stmt = con.prepareStatement(query);
//					stmt.setInt(1, idVisitante);
					rs = stmt.executeQuery();
				
					while (rs.next()) {
						Visitante visitante = new Visitante();
						visitante.setIntCorrelativo(rs.getInt("N_Correl"));
						visitante.setStrDNIVisitante(rs.getString("C_DniVis"));
						visitante.setStrNombreVisitante(rs.getString("C_NomVis"));
						visitante.setStrNombreResidente(rs.getString("C_NomRes"));
						visitante.setdHoraFechaVisitante(rs.getDate("D_HoraFechaVisit"));
						v.add(visitante);
					}
														
		} catch (SQLException e) {
				System.err.println(e.getMessage());
				throw new DAOExcepcion(e.getMessage());
		} finally {
				this.cerrarResultSet(rs);
				this.cerrarStatement(stmt);
				this.cerrarConexion(con);
		}
		return v;
	}

	
}


