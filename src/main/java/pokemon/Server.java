package pokemon;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import pokemon.model.Pokemon;
import pokemon.model.TipoPokemon;
import pokemon.model.Usuario;
import pokemon.repositories.PokemonRepo;
import pokemon.repositories.UsuarioRepositorio;
import spark.ModelAndView;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class Server {
	public static void main(String[] args) {
		Bootstrap.init();
		spark.debug.DebugScreen.enableDebugScreen();
		HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
		Spark.port(8080);
		Spark.get("/", Controller::get);
		Spark.get("/usuario", Controller::getUsuarios);
		Spark.post("/usuario", (req, res) -> {
			Usuario user = new Usuario(req.queryParams("nombre"), req.queryParams("password"));
			Pokemon charizard = new Pokemon(TipoPokemon.FUEGO, "Charizard", null)
					.agregarFoto("https://vignette.wikia.nocookie.net/es.pokemon/images/3/39/Mega-Charizard_Y.png/revision/latest?cb=20160309232803")
					.agregarFoto("http://pre13.deviantart.net/4d21/th/pre/i/2015/084/3/4/006_charizard_by_sarahrichford-d8jh1hy.png")
					.agregarFoto("https://vignette.wikia.nocookie.net/es.pokemon/images/6/69/Mega-Charizard_X_%28anime_XY%29.png/revision/latest?cb=20161101154241");
			PokemonRepo.get().registrar(charizard);
			user.capturar(charizard);
			UsuarioRepositorio.get().registrar(user);
			res.redirect("/usuario/" + user.getNombre());
			return null;
		});
		Spark.get("/usuario_new", (req, res) -> {
			;
			return new ModelAndView(null, "nuevo_usuario.html");
		}, engine);;
		Spark.get("/usuario/:name", (req, res) -> {
			Usuario user = UsuarioRepositorio.get().findByUsername(req.params("name"));
			return new ModelAndView(user, "usuario.html");
		}, engine);

		Spark.get("/pokemons/:name", (req, res) -> {
				return new ModelAndView(PokemonRepo.get().findByUsername(req.params("name")), "pokemon.html");
		}, engine);
	}
}
