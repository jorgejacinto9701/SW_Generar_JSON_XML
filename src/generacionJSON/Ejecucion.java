package generacionJSON;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import entidad.Alumno;
import model.AlumnoModel;

public class Ejecucion {

		public static void main(String[] args) {
		
			AlumnoModel model = new AlumnoModel();
			List<Alumno> lstData = model.listaAlumno();

			//--------------------------------------------
			//De objeto Java----->Archivo JSON
			//---------------------------------------------
			FileWriter file= null;
			try {
				file = new FileWriter("D:/_RECURSOS/alumno.json");
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
			    gson.toJson(lstData, file);
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				try {
					file.close();
				} catch (Exception e2) {}
			}
			//--------------------------------------------
			//De archivo JSON -----> al objeto java
			//---------------------------------------------
			FileReader reader= null;
			try {
				reader = new FileReader("D:/_RECURSOS/alumno.json");
				Gson gson = new Gson();
				Type listType = new TypeToken<List<Alumno>>() {}.getType();
				List<Alumno> lstSalida =  gson.fromJson(reader, listType);
			    System.out.println(lstSalida);
		
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				try {
					file.close();
				} catch (Exception e2) {}
			}
			
		}
		
		
}




