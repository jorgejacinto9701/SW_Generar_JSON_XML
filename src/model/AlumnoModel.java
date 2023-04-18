package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import entidad.Alumno;
import util.ConversionesDateSql;
import util.MySqlDBConexion;

public class AlumnoModel {

	private static Logger log = Logger.getLogger(AlumnoModel.class.getName());
		

	public List<Alumno> listaAlumno() {
		ArrayList<Alumno> data = new ArrayList<Alumno>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; 
		try {
			con = MySqlDBConexion.getConexion();
			String sql = "select * from alumno";
			pstm = con.prepareStatement(sql);
			log.info(">>> " + pstm);
			
			rs = pstm.executeQuery();
			Alumno obj = null;
			while(rs.next()){
				obj = new Alumno();
				obj.setIdAlumno(rs.getInt(1));
				obj.setNombre(rs.getString(2));
				obj.setDni(rs.getString(3));
				obj.setCorreo(rs.getString(4));
				obj.setFechaNacimiento(ConversionesDateSql.toString(rs.getDate(5)));
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
