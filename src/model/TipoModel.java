package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import entidad.Tipo;
import util.MySqlDBConexion;

public class TipoModel {

	private static Logger log = Logger.getLogger(TipoModel.class.getName());
		

	public List<Tipo> listaTipo() {
		ArrayList<Tipo> data = new ArrayList<Tipo>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; 
		try {
			con = MySqlDBConexion.getConexion();
			String sql = "select * from tipo";
			pstm = con.prepareStatement(sql);
			log.info(">>> " + pstm);
			
			rs = pstm.executeQuery();
			Tipo obj = null;
			while(rs.next()){
				obj = new Tipo();
				obj.setIdTipo(rs.getInt(1));
				obj.setDescripcion(rs.getString(2));
				data.add(obj);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)pstm.close();
				if (con != null)con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
	
}
