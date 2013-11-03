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
