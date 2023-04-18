package util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ConversionesDateSql {

	public static Date toFecha(String fecha) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date fec = null;
		try {
			fec = new Date(sdf.parse(fecha).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return fec;
	}
	
	public static String toString(Date fecha) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String salida = null;
		try {
			sdf.format(fecha);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return salida;
	}
}