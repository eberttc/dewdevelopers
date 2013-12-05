package com.upc.condominio.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;

import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Mensaje;
import com.upc.condominio.util.ConexionBD;

public class MensajeDAO  extends BaseDAO{

	public Mensaje insertarMensaje(Mensaje m) throws DAOExcepcion {
		String sql = "CALL InsertarMensaje(?,?,?)";
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			cs = con.prepareCall(sql);
			cs.setString(1, m.getC_titulo());
			cs.setString(2, m.getC_conten());
			cs.setDate(3, m.getD_fecPub());
			int i = cs.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo insertar");
			}else{System.out.println("El registro se insertó con éxito");}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(cs);
			this.cerrarConexion(con);
		}
		return m;
	}
	
	public Mensaje actualizarMensaje(Mensaje m) throws DAOExcepcion {
		String sql = "CALL ActualizarMensaje(?,?,?,?)";
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			cs = con.prepareCall(sql);
			cs.setInt(1, m.getN_idMens());
			cs.setString(2, m.getC_titulo());
			cs.setString(3, m.getC_conten());
			cs.setDate(4, m.getD_fecPub());
			
			int i = cs.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo insertar");
			}else{System.out.println("El registro se actualizó con éxito");}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(cs);
			this.cerrarConexion(con);
		}
		return m;
	}

	public void eliminarMensaje(int id_mensaje) throws DAOExcepcion{
	
		String sql = "CALL EliminarMensaje(?)";
		Connection cn = null;
		CallableStatement cs = null;
		try {
			cn = ConexionBD.obtenerConexion();
			cs = cn.prepareCall(sql);
			cs.setInt(1, id_mensaje);
			int i = cs.executeUpdate();
			if(i != 1){
				throw new SQLException("El Mensaje no se pudo Eliminar por que ya fue comunicado a los residentes "+i);
			}else{System.out.println("El registro se elimninó con éxito");}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally{
			this.cerrarStatement(cs);
			this.cerrarConexion(cn);
		}
		
	}
	
	public Collection<Mensaje> listarMensajeResidente(int x) throws DAOExcepcion{
		Collection<Mensaje> cm = new ArrayList<Mensaje>();
		Connection con=null;
		CallableStatement cs = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String sql = "CALL ListarMensajeResidente(?);";
			cs = con.prepareCall(sql);
			cs.setInt(1, x);
			rs = cs.executeQuery();
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
			this.cerrarStatement(cs);
			this.cerrarConexion(con);
			
		}
		return cm;
	}
}
