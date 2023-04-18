package generacionJSON;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Ejecucion {

		public static void main(String[] args) {
		
			Alumno obj1 = new Alumno(15, "Luis", "Perez");
			Alumno obj2 = new Alumno(12, "Ana", "Quispe");
			Alumno obj3 = new Alumno(13, "Luisa", "Arcos");
			Alumno obj4 = new Alumno(14, "Alberto", "Jacinto");
			
			ArrayList<Alumno> data = new ArrayList<Alumno>();
			data.add(obj1);
			data.add(obj2);
			data.add(obj3);
			data.add(obj4);
			
			Aula aula = new Aula(141, "C102", data);
			//--------------------------------------------
			//De objeto Java----->Archivo JSON
			//---------------------------------------------
			FileWriter file= null;
			try {
				file = new FileWriter("D:/_RECURSOS/aula.json");
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
			    gson.toJson(aula, file);
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
				reader = new FileReader("D:/_RECURSOS/aula.json");
				Gson gson = new Gson();
			    Aula objAula =  gson.fromJson(reader, Aula.class);
			    System.out.println("ID Aula \t:" + objAula.getIdAula());
			    System.out.println("Nombre Aula \t:" + objAula.getNombre());
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				try {
					file.close();
				} catch (Exception e2) {}
			}
			
		}
		
		
}




