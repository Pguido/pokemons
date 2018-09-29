package pokemon.repositories;

import java.util.LinkedList;
import java.util.List;

import javax.management.RuntimeErrorException;

import pokemon.model.Usuario;

public class UsuarioRepositorio {

	private List<Usuario> usuarios = new LinkedList<>();
	private static UsuarioRepositorio instance;
	
	public static UsuarioRepositorio get() {
		if (instance == null) {
			instance = new UsuarioRepositorio();
		}
		return instance;
	}
	
	public Usuario findAny() {
		return usuarios.stream().findAny().orElse(null);
	}
	
	public Usuario findByUsername(String username) {
		try{Usuario usuario = usuarios.stream().filter(x->x.getNombre().equals(username)).findFirst().get();
		return usuario;}
		catch(Exception e){
		throw new RuntimeException("No existe usuario");
		}
		
	}

	public void registrar(Usuario usuario) {
		usuarios.add(usuario);
	}

	public List<Usuario> findAll() {
		return usuarios;
	}
	
	
}
