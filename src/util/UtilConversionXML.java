package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public abstract class UtilConversionXML {

	@SuppressWarnings("unchecked")
	public static <T> T fromXML(String filePat, Class<T> clase) {
		T tipo = null;
		try {
			File file = new File(filePat);
			JAXBContext jc = JAXBContext.newInstance(clase);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			tipo = (T) unmarshaller.unmarshal(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tipo;
	}

	public static void toXML(String filePat, Object data) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(filePat);
			// La libreria es JAXB
			JAXBContext jc = JAXBContext.newInstance(data.getClass());
			// Esta clase genera el XML
			Marshaller marshaller = jc.createMarshaller();
			// Salida en XML
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			// El archivo donde se genera el XML
			marshaller.marshal(data, writer);
			// Imprimir en consola
			marshaller.marshal(data, System.out);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
			}
		}
	}
}
