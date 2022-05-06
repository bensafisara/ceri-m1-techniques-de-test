package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex{
    private List<Pokemon> pokemon_List = new ArrayList<Pokemon>();
    private IPokemonMetadataProvider pokemonMetaProv;
    private IPokemonFactory pokemFacto;
    public Pokedex(IPokemonFactory PokemFacto, IPokemonMetadataProvider PokemonMetaProv) {
        this.pokemFacto = PokemFacto;
        this.pokemonMetaProv = PokemonMetaProv;
    }

    @Override
    public int size() {
        return pokemon_List.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemon_List.add(pokemon);
        return pokemon_List.size();
    }

    public Pokemon getPokemon(int id) throws PokedexException {
        Pokemon id_retourne = pokemon_List.get(id);

        if(id < 0 || id > 150 ) throw new PokedexException("Aucun pokemon avec cette id");

        if(id_retourne==null) throw new PokedexException("Aucun pokemon avec cette id");

        return id_retourne;
    }

    @Override
    public List<Pokemon> getPokemons() {
        return pokemon_List;
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {

        List<Pokemon> lst = pokemon_List;
        lst.sort(order);
        return lst;

    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return pokemFacto.createPokemon(index,cp,hp,dust,candy);

    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {

        if(pokemonMetaProv.getPokemonMetadata(index) == null)  throw new PokedexException("metadata du pokemon non existante ");

        return pokemonMetaProv.getPokemonMetadata(index);

    }
}
