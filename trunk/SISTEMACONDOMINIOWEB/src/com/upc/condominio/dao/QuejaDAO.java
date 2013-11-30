package com.upc.condominio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Queja;
import com.upc.condominio.util.ConexionBD;

public class QuejaDAO extends BaseDAO {
	
	@SuppressWarnings("resource")
	public Queja insertar(Queja queja) throws DAOExcepcion {
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
				String query =	"INSERT INTO QUEJAS (N_IDQUEJA, N_CODRES, C_TIPQUE, C_MOTIVO, D_FECQUE, C_ESTADO) " +
								"VALUES (?,?,?,?,?,?)";
				
				con = ConexionBD.obtenerConexion();
				stmt = con.prepareStatement(query);
				stmt.setInt(1, queja.getintIdQueja());
				stmt.setInt(2, queja.getintIdResidente());
				stmt.setString(3, queja.getstrTipoQueja());
				stmt.setString(4, queja.getstrMotivoQueja());
				stmt.setDate(5, queja.getdFechaQueja());
				stmt.setString(6, queja.getstrEstadoQueja());
				
				int i = stmt.executeUpdate();
				if (i != 1) {
					throw new SQLException("ERROR: NO SE PUDO INSERTAR");
				} else {
					System.out.println("LA QUEJA FUE REGISTRADA CORRECTAMENTE");
				}
	
				int id = 0;
				query = "SELECT LAST_INSERT_ID()";
				stmt = con.prepareStatement(query);
				rs = stmt.executeQuery();
				if (rs.next()) {
					id = rs.getInt(1);
				}
				queja.setintIdQueja(id);

		} catch (SQLException e) {
				queja = null;
				//System.err.println(e.getMessage());
				throw new DAOExcepcion(e.getMessage());
//				System.out.println("NO SE PUDO INSERTAR");
		} finally {
				this.cerrarResultSet(rs);
				this.cerrarStatement(stmt);
				this.cerrarConexion(con);
		}
		return queja;
	}
	
	public List<Queja> ListarQueja(String estadoQueja) throws DAOExcepcion {
		
		List<Queja> lista = new ArrayList<Queja>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
				String query =	"SELECT Q.N_IdQueja, Q.CTipoQueja, Q.D_FecQue, Q.C_Estado FROM Quejas Q " +
								"WHERE Q.C_Estado LIKE ? ";
				con = ConexionBD.obtenerConexion();
				stmt = con.prepareStatement(query);
				stmt.setString(1, "%" + estadoQueja + "%");
				rs = stmt.executeQuery();
				
				while (rs.next()) {

					Queja queja = new Queja();
					queja.setintIdQueja(rs.getInt("N_IdQueja"));
					queja.setstrTipoQueja(rs.getString("CTipoQueja"));
					queja.setdFechaQueja(rs.getDate("D_FecQue"));
					queja.setstrEstadoQueja(rs.getString("C_Estado"));
														
					lista.add(queja);
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

	public Queja obtener(int idQueja) throws DAOExcepcion {
		
		Queja queja = new Queja();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
				String query =	"SELECT Q.N_IdQueja, Q.C_TipQue, Q.D_FecQue, Q.C_Estado FROM Quejas Q " +
					"WHERE Q.N_IdQueja = ? ";
				con = ConexionBD.obtenerConexion();
				stmt = con.prepareStatement(query);
				stmt.setInt(1, idQueja);
				rs = stmt.executeQuery();
				
				if (rs.next()) {		
					
					queja.setintIdQueja(rs.getInt("N_IdQueja"));
					queja.setstrTipoQueja(rs.getString("C_TipQue"));
					queja.setdFechaQueja(rs.getDate("D_FecQue"));
					queja.setstrEstadoQueja(rs.getString("C_Estado"));
														
			}
		} catch (SQLException e) {
			queja = null;
				System.err.println(e.getMessage());
				throw new DAOExcepcion(e.getMessage());
		} finally {
				this.cerrarResultSet(rs);
				this.cerrarStatement(stmt);
				this.cerrarConexion(con);
		}
		return queja;
	}
	
	public Queja actualizar(Queja queja) throws DAOExcepcion {
		
		Connection con = null;
		PreparedStatement stmt = null;
		java.util.Date d; 
		
		try {
				String query =	"UPDATE QUEJAS SET N_CODRES=?, C_TIPQUE=?, C_MOTIVO=?, D_FECQUE=?, C_ESTADO=? " +
								"WHERE N_CODRES=?";
				con = ConexionBD.obtenerConexion();
				stmt = con.prepareStatement(query);
				stmt.setInt(1, queja.getintIdResidente());
				stmt.setString(2, queja.getstrTipoQueja());
				stmt.setString(3, queja.getstrMotivoQueja());
				//
				d = queja.getdFechaQueja();
				java.sql.Timestamp dt = new java.sql.Timestamp(d.getTime());
				stmt.setTimestamp(4, dt);
				//
				stmt.setString(5, queja.getstrEstadoQueja());
				
				int i = stmt.executeUpdate();
				if (i != 1) {
					throw new SQLException("ERROR: NO SE PUDO ACTUALIZAR");
				}
		} catch (SQLException e) {
				queja = null;	
				System.err.println(e.getMessage());
				throw new DAOExcepcion(e.getMessage());
		} finally {
				this.cerrarStatement(stmt);
				this.cerrarConexion(con);
		}
		return queja;
	}

	public Collection<Queja> listar() throws DAOExcepcion {
		Collection<Queja> c = new ArrayList<Queja>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
//			String query = "select * from bdcondominio.quejas c where c.C_Estado like '%Inves%'";
//			String query = "select * from bdcondominio.quejas c where c.C_Motivo like '%Robo%'";
			String query = "select * from bdcondominio.quejas";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Queja q = new Queja();
				q.setintIdQueja(rs.getInt("N_IdQueja"));
				q.setintIdResidente(rs.getInt("N_CodRes"));
				q.setstrMotivoQueja(rs.getString(4));
				q.setstrEstadoQueja(rs.getString(6));
				c.add(q);
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return c;
	}

}
