package com.upc.condominio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.upc.condominio.exceptions.DAOExcepcion;
import com.upc.condominio.modelo.Residente;
import com.upc.condominio.util.ConexionBD;

public class ResidenteDAO extends BaseDAO {

	public Residente insertar(Residente residente) throws DAOExcepcion {
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
				String query =	"INSERT INTO RESIDENTES (N_CODRES, C_NOMRES, C_TIPDOC, C_NUMDOC, D_FECHANAC, C_CORREO, C_CLAVE) " +
								"VALUES (?,?,?,?,?,?,?)";
				
				con = ConexionBD.obtenerConexion();
				stmt = con.prepareStatement(query);
				stmt.setInt(1, residente.getN_CodRes());
				stmt.setString(2, residente.getC_NomRes());
				stmt.setString(3, residente.getC_TipDoc());
				stmt.setString(4, residente.getC_NumDoc());
				stmt.setString(5, residente.getD_FecNac());
				stmt.setString(6, residente.getC_Correo());
				stmt.setString(7, residente.getC_Clave());
				
				int i = stmt.executeUpdate();
				if (i != 1) {
					throw new SQLException("ERROR: NO SE PUDO INSERTAR");
				}
	
				int id = 0;
				query = "SELECT LAST_INSERT_ID()";
				stmt = con.prepareStatement(query);
				rs = stmt.executeQuery();
				if (rs.next()) {
					id = rs.getInt(1);
				}
				residente.setN_CodRes(id);

		} catch (SQLException e) {
				residente = null;
				System.err.println(e.getMessage());
				throw new DAOExcepcion(e.getMessage());
		} finally {
				this.cerrarResultSet(rs);
				this.cerrarStatement(stmt);
				this.cerrarConexion(con);
		}
		return residente;
	}

	
}
