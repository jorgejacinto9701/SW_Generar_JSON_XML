package generandoXML;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

//-------------------------------------------
// Java Architecture for XML Binding (JAXB)
//-------------------------------------------

public class Ejecucion {

	public static void main(String[] args) {
		Ejecucion e = new Ejecucion();
		e.deObjetosToXML();
		//e.deXMLToObjetos();
	}
	public void deXMLToObjetos() {

		try {
			
			File file = new File("D:/_RECURSOS/aula.xml");
			
			JAXBContext jc = JAXBContext.newInstance(Aula.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			
			//Se recupera el objeto
			Aula aula = (Aula) unmarshaller.unmarshal(file);
			
			System.out.println(aula.getIdAula());
			System.out.println(aula.getNombre());
			
			for (Alumno a : aula.getAlumnos()) {
				System.out.println(a.getIdAlumno() + " - " + a.getNombre());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public void deObjetosToXML() {

		FileWriter writer = null;
		try {
			
			writer = new FileWriter("D:/_RECURSOS/aula.xml");
			
			//Se crea la data (Podria ser de una BD)
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
			
			//La libreria es JAXB
			JAXBContext jc = JAXBContext.newInstance(Aula.class);

			//Esta clase genera el XML
			Marshaller marshaller = jc.createMarshaller();
			//Salida en XML
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			//El archivo donde se genera el XML
			marshaller.marshal(aula, writer);
			//Imprimir en consola
			marshaller.marshal(aula, System.out);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {}
		}
		
	}
}
