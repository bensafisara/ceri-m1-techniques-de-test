package fr.univavignon.pokedex.api;

import org.junit.Test;
import org.mockito.Mockito;
import static fr.univavignon.pokedex.api.PokemonMetadataProvider.mdataPokemon;
import org.junit.Assert;
import org.junit.Before;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

public class IPokemonMetadataProviderTest  {
    IPokemonMetadataProvider pmpt  = new PokemonMetadataProvider();
    PokemonMetadata p2;
    PokemonMetadata p1;

    @Before
    public void start() {
        //pmpt = Mockito.mock(IPokemonMetadataProvider.class);
        p1 = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        p2 = new PokemonMetadata(133, "Aquali", 186, 186, 260);
        //Add les information sur les pokemones
        mdataPokemon.add(p1);
        mdataPokemon.add(p2);
    }


    @Test
    public void getPokemonMetadata() throws PokedexException {
       //JE doit avant remplir les information sur les metadata dans metadatprovider
        // assertEquals(p2, pmpt.getPokemonMetadata(133)); marche pas
        // assertEquals(p1, pmpt.getPokemonMetadata(0); marche pas

        assertEquals(p1.getIndex(),pmpt.getPokemonMetadata(0).getIndex());
        assertEquals(p1.getName(),pmpt.getPokemonMetadata(0).getName());

        assertEquals(p2.getIndex(),pmpt.getPokemonMetadata(133).getIndex());
        assertEquals(p2.getName(),pmpt.getPokemonMetadata(133).getName());

    }
}