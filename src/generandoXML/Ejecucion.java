package generandoXML;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import entidad.Alumno;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import model.AlumnoModel;

//-------------------------------------------
// Java Architecture for XML Binding (JAXB)
//-------------------------------------------

public class Ejecucion {

	public static void main(String[] args) {
		FileWriter writer = null;
		try {

			AlumnoModel model = new AlumnoModel();
			List<Alumno> lstData = model.listaAlumno();
			
			DataAlumno objData = new DataAlumno();
			objData.setLista(lstData);
			
			writer = new FileWriter("D:/_RECURSOS/alumno.xml");
			
			// La libreria es JAXB
			JAXBContext jc = JAXBContext.newInstance(DataAlumno.class);

			// Esta clase genera el XML
			Marshaller marshaller = jc.createMarshaller();
			// Salida en XML
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			// El archivo donde se genera el XML
			marshaller.marshal(objData, writer);
			// Imprimir en consola
			marshaller.marshal(objData, System.out);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
			}
		}

		try {

			File file = new File("D:/_RECURSOS/alumno.xml");

			JAXBContext jc = JAXBContext.newInstance(DataAlumno.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();

			// Se recupera el objeto
			DataAlumno aula = (DataAlumno) unmarshaller.unmarshal(file);

			System.out.println(aula.getLista());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
