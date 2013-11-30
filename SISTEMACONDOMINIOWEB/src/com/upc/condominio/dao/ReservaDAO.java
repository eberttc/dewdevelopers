package com.upc.condominio.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Horario;
import com.upc.condominio.modelo.Mensaje;
import com.upc.condominio.modelo.Reserva;
import com.upc.condominio.util.ConexionBD;

public class ReservaDAO extends BaseDAO{

	public Reserva insertar(Reserva r)throws DAOExcepcion{
		
		String sql = "CALL InsertarReserva(?,?,?,?)";
		Connection cn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			cn = ConexionBD.obtenerConexion();
			stmt = cn.prepareCall(sql);
			stmt.setDate(1, r.getFecReg());
			stmt.setInt(2, r.getIdEspacio());
			stmt.setInt(3, r.getIdResidente());
			stmt.setInt(4, r.getIdHorario());
			int i = stmt.executeUpdate();
			//System.out.println(i);
			if(i ==-1){
				throw new SQLException("El Epacio no esta disponible en el horario solicitado");
			}else{System.out.println("El registo se insertó con éxito ");}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(cn);
			
		}
		return r;
		
	}
	
	public Collection<Horario> listarHorariosDisponibles(Date fecha, int idEspacio) throws DAOExcepcion{
		Collection<Horario> cr = new ArrayList<Horario>();
		Connection con=null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int aux = 0;
		try {
			con = ConexionBD.obtenerConexion();
			String sql = "CALL ListarHorariosDisponibles(?,?);";
			stmt = con.prepareCall(sql);
			stmt.setDate(1, fecha);
			stmt.setInt(2, idEspacio);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Horario h = new Horario();
				h.setIdHorario(rs.getInt(1));
				h.setRango(rs.getString(2));
				cr.add(h);
			}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		}finally{
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
			
		}
		return cr;
	}
}
