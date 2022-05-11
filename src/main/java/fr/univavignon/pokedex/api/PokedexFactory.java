package fr.univavignon.pokedex.api;


//PokedexFactory

public class PokedexFactory implements  IPokedexFactory {
    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metaDataProv, IPokemonFactory pokmFactory) {
        return new Pokedex(pokmFactory, metaDataProv);
    }
}