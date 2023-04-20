package generacionJSON;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import entidad.Tipo;
import model.TipoModel;

public class Ejecucion2 {

	public static void main(String[] args) {

		// La data de tipos del BD
		TipoModel model = new TipoModel();
		List<Tipo> lista = model.listaTipo();
		System.out.println(lista);
		
		// Generacion del archivo JSON
		FileWriter file = null;
		try {
			file = new FileWriter("D:/_RECURSOS/tipo.json");
			//Gson gson = new Gson(); //Data en una sola línea
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			gson.toJson(lista, file);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				file.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//--------------------------------------------
		//De archivo JSON -----> al objeto java
		//---------------------------------------------
		FileReader reader= null;
		try {
			reader = new FileReader("D:/_RECURSOS/tipo.json");
			Gson gson = new Gson();
			
			Type listType = new TypeToken<List<Tipo>>() {}.getType();
			List<Tipo> lstSalida =  gson.fromJson(reader, listType);
			for (Tipo x : lstSalida) {
				System.out.println(x.getDescripcion());	
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				reader.close();
			} catch (Exception e2) {}
		}
		
	}

}
