package generandoXML;

import java.util.List;

import entidad.Alumno;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DataAlumno {

	private List<Alumno> lista;

	public List<Alumno> getLista() {
		return lista;
	}

	public void setLista(List<Alumno> lista) {
		this.lista = lista;
	}

}
