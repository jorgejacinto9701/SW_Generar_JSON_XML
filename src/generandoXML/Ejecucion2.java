package generandoXML;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import entidad.Tipo;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import model.TipoModel;

//-------------------------------------------
// Java Architecture for XML Binding (JAXB)
//-------------------------------------------

public class Ejecucion2 {

	public static void main(String[] args) {
		FileWriter writer = null;
		try {

			TipoModel model = new TipoModel();
			List<Tipo> lstData = model.listaTipo();
			
			DataTipo objData = new DataTipo();
			objData.setLista(lstData);
			
			writer = new FileWriter("D:/_RECURSOS/Tipo.xml");
			
			// La libreria es JAXB
			JAXBContext jc = JAXBContext.newInstance(DataTipo.class);

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

			File file = new File("D:/_RECURSOS/Tipo.xml");

			JAXBContext jc = JAXBContext.newInstance(DataTipo.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();

			// Se recupera el objeto
			DataTipo data = (DataTipo) unmarshaller.unmarshal(file);

			System.out.println(data.getLista());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
