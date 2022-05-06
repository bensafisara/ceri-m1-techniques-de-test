package fr.univavignon.pokedex.api;

import org.junit.Test;
import org.mockito.Mockito;


import org.junit.Assert;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

public class IPokemonMetadataProviderTest  {
    IPokemonMetadataProvider pmpt;

    PokemonMetadata p2;
    PokemonMetadata p1;

    @Before
    public void start() {
        pmpt = Mockito.mock(IPokemonMetadataProvider.class);
        p1 = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        p2 = new PokemonMetadata(133, "Aquali", 186, 186, 260);
    }


    @Test
    public void getPokemonMetadata() throws PokedexException {

        doReturn(p2).when(pmpt).getPokemonMetadata(133);

       doReturn(p1).when(pmpt).getPokemonMetadata(0);


        assertEquals(p1, pmpt.getPokemonMetadata(0));
        assertEquals(p2, pmpt.getPokemonMetadata(133));

        doThrow(new PokedexException("L'index doit etre supérieur à 1 ")).when(pmpt)
                .getPokemonMetadata(Mockito.intThat(i -> i > 150));
        doThrow(new PokedexException("L'index doit etre inférieur à 150 ")).when(pmpt)
                .getPokemonMetadata(Mockito.intThat(i -> i < 0 ));


        assertThrows(PokedexException.class, () -> pmpt.getPokemonMetadata(-10));
        assertThrows(PokedexException.class, () -> pmpt.getPokemonMetadata(200));
    }
}
