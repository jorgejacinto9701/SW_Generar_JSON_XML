package generandoXML;

import java.util.List;

import entidad.Tipo;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DataTipo {

	private List<Tipo> lista;

	public List<Tipo> getLista() {
		return lista;
	}

	public void setLista(List<Tipo> lista) {
		this.lista = lista;
	}
	
	
}
