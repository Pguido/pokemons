package pokemon;

import java.util.List;

import pokemon.model.Usuario;
import pokemon.repositories.UsuarioRepositorio;
import spark.Request;
import spark.Response;

public class Controller {
	
	public static List<Usuario> getUsuarios(Request req, Response res) {
		
		return UsuarioRepositorio.get().findAll();
	}
	
	public static String get(Request req, Response res) {
		return "hola";
	}
}
