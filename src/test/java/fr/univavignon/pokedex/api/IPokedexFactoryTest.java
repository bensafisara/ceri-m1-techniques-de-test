package fr.univavignon.pokedex.api;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;



public class IPokedexFactoryTest  {
    private Pokemon pok;
    private IPokedexFactory pokedexFactory ;
    private IPokemonMetadataProvider pokemonMDProvider;
    private IPokemonFactory pokemonFact ;
    private IPokedex pdx;


    @Before
    public void start() {
        //pokedexFactory = mock(IPokedexFactory.class);
        //pokemonMDProvider = mock(IPokemonMetadataProvider.class);
        //pokemonFact = mock(IPokemonFactory.class);
        //pdx = mock(IPokedex.class);
        pokedexFactory = new PokedexFactory();
        pokemonMDProvider= new PokemonMetadataProvider();
        pokemonFact = new PokemonFactory();
        pdx = new Pokedex(pokemonFact,pokemonMDProvider);

    }

    @Test
    public void creationPokedex() {
// je verifie que ca me la bonne  instance de IPokedex et que c pas null
        Assert.assertNotEquals(pokedexFactory.createPokedex(pokemonMDProvider, pokemonFact),  null);
        Assert.assertNotEquals(pokedexFactory.createPokedex(pokemonMDProvider, pokemonFact),  pdx);


    }





}