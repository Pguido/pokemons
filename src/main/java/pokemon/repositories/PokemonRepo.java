package pokemon.repositories;

import java.util.LinkedList;
import java.util.List;

import javax.management.RuntimeErrorException;

import pokemon.model.Pokemon;
import pokemon.model.Usuario;

public class PokemonRepo {

	private List<Pokemon> pokemons = new LinkedList<>();
	private static PokemonRepo instance;
	
	public static PokemonRepo get() {
		if (instance == null) {
			instance = new PokemonRepo();
		}
		return instance;
	}
	
	public Pokemon findAny() {
		return pokemons.stream().findAny().orElse(null);
	}
	
	public Pokemon findByUsername(String username) {
		try{Pokemon usuario = pokemons.stream().filter(x->x.getNombre().equals(username)).findFirst().get();
		return usuario;}
		catch(Exception e){
		throw new RuntimeException("No existe usuario");
		}
		
	}

	public void registrar(Pokemon usuario) {
		pokemons.add(usuario);
	}

	public List<Pokemon> findAll() {
		return pokemons;
	}
	
	
}
