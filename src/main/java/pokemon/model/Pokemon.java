package pokemon.model;

import java.util.ArrayList;
import java.util.List;
import spark.Spark;

public class Pokemon {

	private TipoPokemon tipo;
	private String nombre;
	private Pokemon evolucion;
	private List<String> fotos;

	public Pokemon(TipoPokemon tipo, String nombre, Pokemon evolucion) {
		super();
		this.tipo = tipo;
		this.nombre = nombre;
		this.evolucion = evolucion;
		this.fotos = new ArrayList<>();
	}

	public List<String> getFotos() {
		return fotos;
	}

	public TipoPokemon getTipo() {
		return tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public Pokemon getEvolucion() {
		return evolucion;
	}
	
	public Pokemon agregarFoto(String url) {
		this.fotos.add(url);
		return this;
	}

	@Override
	public String toString() {
		return "Pokemon [tipo=" + tipo + ", nombre=" + nombre + ", fotos=" + fotos + "]";
	}

}
