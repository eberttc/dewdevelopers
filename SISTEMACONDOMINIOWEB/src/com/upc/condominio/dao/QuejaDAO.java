package com.upc.condominio.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
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
				String query =	"INSERT INTO QUEJAS (N_IDQUEJA, N_IDRES, C_TIPQUE, C_MOTIVO, D_FECQUE, C_ESTADO) " +
								"VALUES (?,?,?,?,?,?)";
				
				con = ConexionBD.obtenerConexion();
				stmt = con.prepareStatement(query);
				stmt.setInt(1, queja.getIntIdQueja());
				stmt.setInt(2, queja.getIntIdResidente());
				stmt.setString(3, queja.getStrTipoQueja());
				stmt.setString(4, queja.getStrMotivoQueja());
				stmt.setDate(5, queja.getdFechaQueja());
				stmt.setString(6, queja.getStrEstadoQueja());
				
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
				queja.setIntIdQueja(id);

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
/*	
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
					queja.setIntIdQueja(rs.getInt("N_IdQueja"));
					queja.setStrTipoQueja(rs.getString("CTipoQueja"));
					queja.setdFechaQueja(rs.getDate("D_FecQue"));
					queja.setStrEstadoQueja(rs.getString("C_Estado"));
														
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
					
					queja.setIntIdQueja(rs.getInt("N_IdQueja"));
					queja.setStrTipoQueja(rs.getString("C_TipQue"));
					queja.setdFechaQueja(rs.getDate("D_FecQue"));
					queja.setStrEstadoQueja(rs.getString("C_Estado"));
														
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
				stmt.setInt(1, queja.getIntIdResidente());
				stmt.setString(2, queja.getStrTipoQueja());
				stmt.setString(3, queja.getStrMotivoQueja());
				//
				d = queja.getdFechaQueja();
				java.sql.Timestamp dt = new java.sql.Timestamp(d.getTime());
				stmt.setTimestamp(4, dt);
				//
				stmt.setString(5, queja.getStrEstadoQueja());
				
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
*/
	public Collection<Queja> listar(String filtro) throws DAOExcepcion {
		Collection<Queja> c = new ArrayList<Queja>();
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String sql = "call filtrarQuejas(?)";
			cs = con.prepareCall(sql);
			cs.setString(1, filtro);
			rs = cs.executeQuery();
			while (rs.next()) {
				Queja q = new Queja();
				q.setIntIdQueja(rs.getInt("N_IdQueja"));
				q.setIntIdResidente(rs.getInt("N_IdRes"));
				q.setStrMotivoQueja(rs.getString(4));
				q.setStrEstadoQueja(rs.getString(6));
				c.add(q);
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(cs);
			this.cerrarConexion(con);
		}
		return c;
	}

/*	public Collection<Queja> listarQuejaPorTipo() throws DAOExcepcion {
		Collection<Queja> c = new ArrayList<Queja>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
//			String query = "select * from bdcondominio.quejas c where c.C_Estado like '%Inves%'";
			String query = "select * from bdcondominio.quejas c where c.C_TipQue like '%?%'";
//			String query = "select * from bdcondominio.quejas";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Queja q = new Queja();
				q.setIntIdQueja(rs.getInt("N_IdQueja"));
				q.setIntIdResidente(rs.getInt("N_IdRes"));
				q.setStrMotivoQueja(rs.getString(4));
				q.setStrEstadoQueja(rs.getString(6));
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
	} */
	
	
}
