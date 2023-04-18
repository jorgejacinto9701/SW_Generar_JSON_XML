package util;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public abstract class UtilConversionJSON {

	public static void toJSON(String filePat, Object data) {
		FileWriter file = null;
		try {
			file = new FileWriter(filePat);
			Gson gson = new Gson();
			gson.toJson(data, file);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				file.close();
			} catch (Exception e2) {
			}
		}
	}

	public static <T> T fromJSON(String filePat, Class<T> clase) {
		FileReader reader = null;
		T tipo = null;
		try {
			reader = new FileReader(filePat);
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			tipo = gson.fromJson(reader, clase);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (Exception e2) {
			}
		}
		return tipo;
	}

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
