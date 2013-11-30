package com.upc.condominio.dao;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.EspacioComun;
import com.upc.condominio.util.ConexionBD;

public class EspacioComunDAO extends BaseDAO{
	
	public Collection<EspacioComun> listarEspacios() throws DAOExcepcion{
		Collection<EspacioComun> cm = new ArrayList<EspacioComun>();
		Connection con=null;
		CallableStatement cs = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String sql = "call ListarEspacioComun";
			cs = con.prepareCall(sql);
			rs = cs.executeQuery();
			while (rs.next()) {
				EspacioComun m = new EspacioComun();
				m.setIdespacio(rs.getInt(1));
				m.setNombreEspacio(rs.getString(2));
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
