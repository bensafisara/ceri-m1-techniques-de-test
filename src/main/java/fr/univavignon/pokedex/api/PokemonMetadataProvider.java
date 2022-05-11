//PokemonMetadataProvider



package fr.univavignon.pokedex.api;

import java.util.*;

public class PokemonMetadataProvider implements IPokemonMetadataProvider{
 public static List<PokemonMetadata> mdataPokemon =new ArrayList<PokemonMetadata>();


    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {

        for (PokemonMetadata data : mdataPokemon) {
            if(data.getIndex() == index)  return data;

        }

        throw new PokedexException("erreur index dans PokemonMetadataProvider  ");
    }

    }

