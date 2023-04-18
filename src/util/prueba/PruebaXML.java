package util.prueba;

import java.util.ArrayList;

import generandoXML.Alumno;
import generandoXML.Aula;
import util.UtilConversionJSON;



public class PruebaXML {

	public static void main(String[] args) {
			
		Alumno a1 = new Alumno(415, "Jorge", "Jacinto");
		Alumno a2 = new Alumno(745, "Pedro", "Gutarra");
		Alumno a3 = new Alumno(845, "Leo", "Jacinto");
		
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		alumnos.add(a1);
		alumnos.add(a2);
		alumnos.add(a3);
		
		Aula aula = new Aula();
		aula.setIdAula(141);
		aula.setNombre("A103");
		aula.setAlumnos(alumnos);
		
		UtilConversionJSON.toXML("D:/_RECURSOS/aula2.xml", aula);
		
		Aula datos = UtilConversionJSON.fromXML("D:/datos/aula2.xml", Aula.class);
		System.out.println(datos.getNombre());
		
			
	}
	

}
