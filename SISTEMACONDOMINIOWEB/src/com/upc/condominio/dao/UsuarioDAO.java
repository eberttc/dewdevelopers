package com.upc.condominio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.exceptions.LoginExcepcion;
import com.upc.condominio.modelo.Usuario;
import com.upc.condominio.util.ConexionBD;


public class UsuarioDAO extends BaseDAO {

	public Usuario validar(String correo, String clave, String tipoUsuraio)
			throws DAOExcepcion, LoginExcepcion {
		
		String query1 = "select N_IdRes, C_Correo, C_Clave, C_NomRes"			
						+ " from residentes where C_Correo=? and C_Clave=?";
		
		String query2 = "select N_IdUsua, C_Clave, C_NomUsua"			
			        	+ " from usuariosistema where N_IdUsua=? and C_Clave=?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Usuario vo = new Usuario();
		
		
			
		try {
			con = ConexionBD.obtenerConexion();
			if(tipoUsuraio.equals("R"))
				stmt = con.prepareStatement(query1);
			else
				stmt = con.prepareStatement(query2);
			
			stmt.setString(1, correo);
			stmt.setString(2, clave);
			rs = stmt.executeQuery();

			if (rs.next()) {
				if(tipoUsuraio.equals("R")){
					vo.setIdUsuario(rs.getInt("N_IdRes"));
					vo.setCorreo(rs.getString("C_Correo"));
					vo.setClave(rs.getString("C_Clave"));
					vo.setNombres(rs.getString("C_NomRes"));									
					vo.setTipoUsuario(tipoUsuraio);
				}else{
					
					vo.setIdUsuario(rs.getInt("N_IdUsua"));
					vo.setClave(rs.getString("C_Clave"));
					vo.setNombres(rs.getString("C_NomUsua"));									
					vo.setTipoUsuario(tipoUsuraio);
				}
				
			} else {
				throw new LoginExcepcion("No existe");
			}
		} catch (LoginExcepcion e) {
			System.err.println(e.getMessage());
			throw new LoginExcepcion(e.getMessage());
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}

}
