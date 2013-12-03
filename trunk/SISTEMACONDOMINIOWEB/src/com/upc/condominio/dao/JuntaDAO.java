package com.upc.condominio.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Directivos;
import com.upc.condominio.modelo.Junta;
import com.upc.condominio.util.ConexionBD;

public class JuntaDAO extends BaseDAO {


	public int insertar(Junta junta) throws DAOExcepcion {
		
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
			stmt.setString(2,junta.gettHoraJunta()+":00");
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
			
			
			for(Directivos d:junta.getLstDirectivos()){
				
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
			
			

		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			try {
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
	return idJunta;
	}

	public Junta obtener(int idJunta) throws DAOExcepcion {
		Junta junta=new Junta();
		List<Directivos> lstDirectivos=new ArrayList<Directivos>();
		
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
					Directivos dir=new Directivos();
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
	
	public void eliminar(int idJunta) throws DAOExcepcion{
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
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			try {
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
	}

	public Junta actualizar(Junta j) throws DAOExcepcion {
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
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			try {
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return j;
	}

	public Collection<Junta> listar() throws DAOExcepcion {
		Collection<Junta> c = new ArrayList<Junta>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			
			String query = "select * from junta order by 2 desc";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Junta junta = new Junta();
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

	public Collection<Junta> buscarPorFechaHora(Date fecha,String hora) throws DAOExcepcion {
		Collection<Junta> c = new ArrayList<Junta>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			
			String query = "select * from junta where D_FecJun=? and C_HorJun=?";
			stmt = con.prepareStatement(query);
			stmt.setDate(1, fecha);
			stmt.setString(2, hora);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Junta junta = new Junta();
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
	public Collection<Directivos> listarDirectivos()  throws DAOExcepcion{
		Collection<Directivos> c = new ArrayList<Directivos>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			
			String query = "select * from directivos";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Directivos bean = new Directivos();
				bean.setIntCodigoDirectivo(rs.getInt(1));
				bean.setStrNombreDirectivo(rs.getString(2));
				bean.setStrCargo(rs.getString(3));				
				c.add(bean);
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
	
	public Collection<Directivos> BuscarDirectivos(int codigo)  throws DAOExcepcion{
		Collection<Directivos> c = new ArrayList<Directivos>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			
				
			String query = "select * from directivos where N_CodDir like ?";
			stmt = con.prepareStatement(query);
			
			if(codigo==-1){
				stmt.setString(1,"%%");
			}else{
				stmt.setString(1,"%"+codigo+"%");
			}
			
			rs = stmt.executeQuery();
			while (rs.next()) {
				Directivos bean = new Directivos();
				bean.setIntCodigoDirectivo(rs.getInt(1));
				bean.setStrNombreDirectivo(rs.getString(2));
				bean.setStrCargo(rs.getString(3));				
				c.add(bean);
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
