package fr.univavignon.pokedex.api;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
public class IPokedexFactoryTest  {
    Pokemon pok;
    IPokedexFactory pokedexFactory;
    IPokemonMetadataProvider pokemonMDProvider;
    IPokemonFactory pokemonFact;
    IPokedex pdx;


    @Before
    public void start() {
        pokedexFactory = mock(IPokedexFactory.class);
        pokemonMDProvider = mock(IPokemonMetadataProvider.class);
        pokemonFact = mock(IPokemonFactory.class);
        pdx = mock(IPokedex.class);

    }

    @Test
    public void creationPokedex() {
        when(pokedexFactory.createPokedex(pokemonMDProvider, pokemonFact)).thenReturn(pdx);
        assertEquals(pokedexFactory.createPokedex(pokemonMDProvider, pokemonFact), pdx);

    }





}
