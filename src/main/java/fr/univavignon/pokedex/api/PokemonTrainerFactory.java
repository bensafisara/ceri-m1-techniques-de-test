package fr.univavignon.pokedex.api;

public class PokemonTrainerFactory implements IPokemonTrainerFactory{


    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        IPokemonMetadataProvider pokemonMetadataProvider = new PokemonMetadataProvider();
        IPokemonFactory pokemonFacto = new PokemonFactory(pokemonMetadataProvider);
        return new PokemonTrainer(name,team,pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFacto));
    }
}
