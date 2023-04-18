package generacionJSON;

import java.util.List;

public class Aula {

	private int idAula;
	private String nombre;
	private List<Alumno> alumnos;

	public Aula() {
		super();
	}

	public Aula(int idAula, String nombre, List<Alumno> alumnos) {
		this.idAula = idAula;
		this.nombre = nombre;
		this.alumnos = alumnos;
	}

	public int getIdAula() {
		return idAula;
	}

	public void setIdAula(int idAula) {
		this.idAula = idAula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

}
