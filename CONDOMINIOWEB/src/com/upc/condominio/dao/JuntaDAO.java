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
import com.upc.condominio.modelo.DirectivosDTO;
import com.upc.condominio.modelo.JuntaDTO;
import com.upc.condominio.util.ConexionBD;

public class JuntaDAO extends BaseDAO {


	public JuntaDTO insertar(JuntaDTO junta) throws DAOExcepcion, SQLException {
		
		String query1 = "insert into junta(D_FecJun,C_HorJun,C_TemJun,C_AcuJun) values (?,?,?,?)";

		String query2 = "insert into juntaDirectivos(N_CodJun,N_CodDir,C_PreJun) values (?,?,?)";

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int idJunta=0;
		
		int i=-1;
		try {
			con = ConexionBD.obtenerConexion();
			con.setAutoCommit(false);
			stmt = con.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
		
			stmt.setDate(1,junta.getdFechaJunta());
			stmt.setString(2,junta.gettHoraJunta());
			stmt.setString(3,junta.getStrTemaJunta());
			stmt.setString(4,junta.getStrAcuerdoJunta());
		
			
			i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo insertar");
			}
			
			rs=stmt.getGeneratedKeys();
			
		
			if (rs.next()) {
				idJunta = rs.getInt(1);
			}
			
			if (idJunta == 0) {
				throw new SQLException("No se pudo insertar");
			}
			
			
			for(DirectivosDTO d:junta.getLstDirectivos()){
				
				stmt = con.prepareStatement(query2,Statement.RETURN_GENERATED_KEYS);
				
				stmt.setInt(1,idJunta);
				stmt.setInt(2,d.getIntCodigoDirectivo());
				stmt.setString(3,d.getStrPresideJunta());
				
				i = stmt.executeUpdate();
				if (i != 1) {
					con.rollback();
					throw new SQLException("No se pudo insertar");
				}
				
			}
			
			if (i != 1) {
				con.rollback();
			}
			
			junta.setIntCodigoJunta(idJunta);

		} catch (SQLException e) {
			con.rollback();
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			con.commit();
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
	return junta;
	}

	public JuntaDTO obtener(int idJunta) throws DAOExcepcion {
		JuntaDTO junta=new JuntaDTO();
		List<DirectivosDTO> lstDirectivos=new ArrayList<DirectivosDTO>();
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query1 = "select * from junta where N_CodJun=?";
			String query2 = "select * from juntaDirectivos where N_CodJun=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query1);
			stmt.setInt(1, idJunta);
			rs = stmt.executeQuery();
			if (rs.next()) {
				junta.setIntCodigoJunta(rs.getInt(1));
				junta.setdFechaJunta(rs.getDate(2));
				junta.settHoraJunta(rs.getString(3));
				junta.setStrTemaJunta(rs.getString(4));
				junta.setStrAcuerdoJunta(rs.getString(5));
				
				
				stmt = con.prepareStatement(query2);
				stmt.setInt(1,idJunta);
				rs = stmt.executeQuery();
				while(rs.next()){
					DirectivosDTO dir=new DirectivosDTO();
					dir.setIntCodigoDirectivo(rs.getInt(2));
					dir.setStrPresideJunta(rs.getString(3));
					lstDirectivos.add(dir);
				}
				
				junta.setLstDirectivos(lstDirectivos);
				
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		
		
		return junta;
	}
	
	public void eliminar(int idJunta) throws DAOExcepcion, SQLException {
		String query = "delete from junta  where N_CodJun=?";
		String query2 = "delete from juntadirectivos  where N_CodJun=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			con.setAutoCommit(false);
			stmt = con.prepareStatement(query2);
			stmt.setInt(1, idJunta);
			int i = stmt.executeUpdate();
			if (i == 0) {
				con.rollback();
				throw new SQLException("No se pudo eliminar junta directivos");
				
			}
			
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idJunta);
			i = stmt.executeUpdate();
			if (i != 1) {
				con.rollback();
				throw new SQLException("No se pudo eliminar junta");
			}
			
		} catch (SQLException e) {
			con.rollback();
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			con.commit();
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
	}

	public JuntaDTO actualizar(JuntaDTO j) throws DAOExcepcion, SQLException {
		String query = "update junta set C_TemJun=?,C_AcuJun=? where N_CodJun=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			con.setAutoCommit(false);
			stmt = con.prepareStatement(query);
			stmt.setString(1,j.getStrTemaJunta());
			stmt.setString(2,j.getStrAcuerdoJunta());
			stmt.setInt(3,j.getIntCodigoJunta());
			int i = stmt.executeUpdate();
			if (i != 1) {
				con.rollback();
				throw new SQLException("No se pudo actualizar");
			}
			
		} catch (SQLException e) {
			con.rollback();
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			con.commit();
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return j;
	}

	public Collection<JuntaDTO> listar() throws DAOExcepcion {
		Collection<JuntaDTO> c = new ArrayList<JuntaDTO>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			
			String query = "select * from junta order by 2 desc";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				JuntaDTO junta = new JuntaDTO();
				junta.setIntCodigoJunta(rs.getInt(1));
				junta.setdFechaJunta(rs.getDate(2));
				junta.settHoraJunta(rs.getString(3));
				junta.setStrTemaJunta(rs.getString(4));
				junta.setStrAcuerdoJunta(rs.getString(5));
				c.add(junta);
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
