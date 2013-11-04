package com.upc.condominio.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collection;



import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Mensaje;
import com.upc.condominio.util.ConexionBD;

public class MensajeDAO  extends BaseDAO{

	public Mensaje insertar(Mensaje m) throws DAOExcepcion {
		String query = "insert into mensaje(C_Titulo,C_Conten,D_FecPub) values (?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, m.getC_titulo());
			stmt.setString(2, m.getC_conten());
			stmt.setDate(3, m.getD_fecPub());
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo insertar");
			}
			/*// Obtener el ultimo id
			int id = 0;
			query = "select last_insert_id()";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			m.setN_idMens(id);*/

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return m;
	}
	
	public Mensaje actualizar(Mensaje m) throws DAOExcepcion {
		String query = "UPDATE Mensaje set C_Titulo = ?,C_Conten = ?,D_FecPub = ? where  N_IdMens = ? ";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, m.getC_titulo());
			stmt.setString(2, m.getC_conten());
			stmt.setDate(3, m.getD_fecPub());
			stmt.setInt(4, m.getN_idMens());
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo insertar");
			}
			/*// Obtener el ultimo id
			int id = 0;
			query = "select last_insert_id()";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			m.setN_idMens(id);*/

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return m;
	}

	public void eliminar(int id_mensaje) throws DAOExcepcion{
	
		String query = "DELETE from mensaje where N_IdMens = ?";
		Connection cn = null;
		PreparedStatement stmt = null;
		try {
			cn = ConexionBD.obtenerConexion();
			stmt = cn.prepareStatement(query);
			stmt.setInt(1, id_mensaje);
			int i = stmt.executeUpdate();
			if(i != 1){
				throw new SQLException("No se pudo Eliminar");
			}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally{
			this.cerrarStatement(stmt);
			this.cerrarConexion(cn);
			
		}
		
	}
	
	public Collection<Mensaje> listar() throws DAOExcepcion{
		Collection<Mensaje> cm = new ArrayList<Mensaje>();
		Connection con=null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "SELECT N_IDMens, C_Titulo, C_Conten, D_FecPub FROM mensaje";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Mensaje m = new Mensaje();
				m.setN_idMens(rs.getInt(1));
				m.setC_titulo(rs.getString(2));
				m.setC_conten(rs.getString(3));
				m.setD_fecPub(rs.getDate(4));
				cm.add(m);
			}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		}finally{
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
			
		}
		return cm;
	}
}
