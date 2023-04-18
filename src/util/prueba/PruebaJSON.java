package util.prueba;

import java.util.ArrayList;

import generacionJSON.Alumno;
import generacionJSON.Aula;
import util.UtilConversionJSON;

public class PruebaJSON {

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
		
		UtilConversionJSON.toJSON("D:/_RECURSOS/aula2.json", aula);
		
		Aula datos = UtilConversionJSON.fromJSON("D:/_RECURSOS/aula2.json", Aula.class);
		System.out.println(datos.getNombre());
		
			
	}
	

}
