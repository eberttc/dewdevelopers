package com.upc.condominio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.exceptions.LoginExcepcion;
import com.upc.condominio.modelo.Menu;
import com.upc.condominio.modelo.Usuario;
import com.upc.condominio.util.ConexionBD;


public class UsuarioDAO extends BaseDAO {

	public Usuario validar(String correo, String clave, String tipoUsuraio)
			throws DAOExcepcion, LoginExcepcion {
		
		String query1 = "select N_IdRes, C_Correo, C_Clave, C_NomRes"			
						+ " from residentes where C_Correo=? and C_Clave=?";
		
		String query2 = "select N_IdUsua, C_Correo,C_Clave, C_NomUsua"			
			        	+ " from usuariosistema where C_Correo=? and C_Clave=?";
		
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
					vo.setCorreo(rs.getString("C_Correo"));
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
	
	public List<Menu> obtienePermisos(Usuario usuario)
			throws DAOExcepcion {
		
		String query = "SELECT u.N_CodOpc, "+
						"m.C_Descri, "+
						"m.N_CodPad, "+
						"m.C_Accion  "+
						 "  FROM menu m, usuario_menu u "+
						"where m.N_CodOpc=u.N_CodOpc and "+
						"u.N_CodUsu= ? and "+
						"u.C_TipUsu= ? and "+
						"u.C_EstReg= ?" ;
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<Menu> listadoMenu=new ArrayList<Menu>();
		
			
		try {
			con = ConexionBD.obtenerConexion();
			
			stmt = con.prepareStatement(query);
			
			stmt.setInt(1, usuario.getIdUsuario());
			stmt.setString(2,usuario.getTipoUsuario());
			stmt.setString(3,"S");
			rs = stmt.executeQuery();

			while (rs.next()) {
				Menu m=new Menu();
				m.setCodigoMenu(rs.getInt(1));
				m.setNombre(rs.getString(2));
				m.setCodigoPadre(rs.getInt(3));
				m.setAccion(rs.getString(4));
				listadoMenu.add(m);
				
			} 
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		
		
		return listadoMenu;
	}
	
	

}
