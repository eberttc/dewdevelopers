package com.upc.condominio.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Mensaje;
import com.upc.condominio.modelo.Reserva;
import com.upc.condominio.util.ConexionBD;

public class ReservaDAO extends BaseDAO{

	public Reserva insertar(Reserva r)throws DAOExcepcion{
		
		String query = "INSERT into reservaespacio (D_fecReg,N_IdEspa,N_IdRanHor,N_IdRes) values (?,?,?,?)";
		Connection cn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			cn = ConexionBD.obtenerConexion();
			stmt = cn.prepareStatement(query);
			stmt.setDate(1, r.getD_fecReg());
			stmt.setInt(2, r.getN_idEspa());
			stmt.setInt(3, r.getN_idRes());
			stmt.setInt(4, r.getN_idRanHor());
			int i = stmt.executeUpdate();
			
			if(i != 1){
				throw new SQLException("No se pudo insertar");
			}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(cn);
			
		}
		return r;
		
	}
	
	public int verificarhorario(Date fecReg, int idEsp, int idRanHor) throws DAOExcepcion{
		Collection<Mensaje> cm = new ArrayList<Mensaje>();
		Connection con=null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int aux = 0;
		try {
			con = ConexionBD.obtenerConexion();//SELECT N_IDMens, C_Titulo, C_Conten, D_FecPub FROM mensaje
			String query = "select count(*) from reservaespacio where D_FecReg=? and N_IdEspa=? and N_idRanHor=?;";
			stmt = con.prepareStatement(query);
			stmt.setDate(1, fecReg);
			stmt.setInt(2, idEsp);
			stmt.setInt(3, idRanHor);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				aux = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		}finally{
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
			
		}
		return aux;
	}
}
