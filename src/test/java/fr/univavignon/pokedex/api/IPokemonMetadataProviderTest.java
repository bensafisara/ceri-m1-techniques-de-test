package fr.univavignon.pokedex.api;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.*;

import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonMetadataProviderTest  {

    //Cette class est chargé pour un index donné de retourner les métadonnées d’une espèce

private  IPokemonMetadataProvider PMPT;

    PokemonMetadata p1;
    PokemonMetadata p2;
    @Before
    public  void Start(){


            PMPT = Mockito.mock(IPokemonMetadataProvider.class);


            // initialisation des pokemons
            p1 = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
            p2 = new PokemonMetadata(133, "Aquali", 186, 186, 260);



    }



    @Test
    public void getPokemonMetadataTest() throws PokedexException {


        doReturn(p2).when(PMPT).getPokemonMetadata(133);
        doReturn(p1).when(PMPT).getPokemonMetadata(0);

        assertThrows(PokedexException.class, () -> PMPT.getPokemonMetadata(-1));
        assertThrows(PokedexException.class, () -> PMPT.getPokemonMetadata(152));

        assertEquals(p1, PMPT.getPokemonMetadata(0));
        assertEquals(p2, PMPT.getPokemonMetadata(133));

        Mockito.doThrow(new PokedexException(" ")).when(PMPT).getPokemonMetadata(Mockito.intThat(i -> i < 0 || i > 150));


    }




}
