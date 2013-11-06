package com.upc.condominio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.TipoPago;
import com.upc.condominio.util.ConexionBD;

public class TipoPagoDAO extends BaseDAO {

	public List<TipoPago> ListarTipoPago(String estadoTipoPago) throws DAOExcepcion {
		
		List<TipoPago> lstTipoPago = new ArrayList<TipoPago>();
		Connection conexion = null;
		PreparedStatement sentencia = null;
		ResultSet resulset = null;
		
		try {
				String query =	"SELECT tp.N_TipPag, tp.C_Descri, tp.C_EstReg FROM tipopago tp " 
								+ "WHERE tp.C_EstReg LIKE ? ";
				conexion = ConexionBD.obtenerConexion();
				sentencia = conexion.prepareStatement(query);
				sentencia.setString(1, "%" + estadoTipoPago + "%");
				resulset = sentencia.executeQuery();
				
				while (resulset.next()) {

					TipoPago tipoPago = new TipoPago();
					tipoPago.setnTipoPago(resulset.getInt("N_TipPag"));
					tipoPago.setcDescri(resulset.getString("C_Descri"));
					tipoPago.setcEstReg(resulset.getString("C_EstReg"));
														
					lstTipoPago.add(tipoPago);
				}
		} 
		catch (SQLException e) {
				lstTipoPago = null;
				System.err.println(e.getMessage());
				throw new DAOExcepcion(e.getMessage());
		} 
		finally {
				this.cerrarResultSet(resulset);
				this.cerrarStatement(sentencia);
				this.cerrarConexion(conexion);
		}
		return lstTipoPago;
	} 
}
