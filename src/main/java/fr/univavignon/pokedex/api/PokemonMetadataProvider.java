package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PokemonMetadataProvider implements IPokemonMetadataProvider{
    List<PokemonMetadata> metadataPokemon;



    public PokemonMetadataProvider() {
        metadataPokemon.add(new PokemonMetadata(0,  "Bulbizarre", 126, 126, 90));
        metadataPokemon.add(new PokemonMetadata(133, "Aquali", 186, 168, 260));

    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {


        return metadataPokemon.get(index);

    }

}
