package com.upc.condominio.dao;

import java.sql.CallableStatement;
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
			}else{System.out.println("El registro se insertó con éxito");}
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
			}else{System.out.println("El registro se actualizó con éxito");}

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
	
		String sql = "call Eliminar(?)";
		Connection cn = null;
		CallableStatement cs = null;
		try {
			cn = ConexionBD.obtenerConexion();
			cs = cn.prepareCall(sql);
			cs.setInt(1, id_mensaje);
			int i = cs.executeUpdate();
			if(i != 1){
				throw new SQLException("El Mensaje no se pudo Eliminar por que ya fue comicado a los residentes");
			}else{System.out.println("El registro se elimninó con éxito");}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally{
			this.cerrarStatement(cs);
			this.cerrarConexion(cn);
			
		}
		
	}
	
	public Collection<Mensaje> listar(int x) throws DAOExcepcion{
		Collection<Mensaje> cm = new ArrayList<Mensaje>();
		Connection con=null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "SELECT C_Titulo,C_Conten,D_FecPub FROM mensajeria m INNER JOIN  mensaje a on m.N_IdMens = a.N_IdMens where m.N_IdRes = ? ORDER By D_FecPub";
			stmt = con.prepareStatement(query);
			stmt.setInt(1, x);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Mensaje m = new Mensaje();
				m.setC_titulo(rs.getString(1));
				m.setC_conten(rs.getString(2));
				m.setD_fecPub(rs.getDate(3));
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
