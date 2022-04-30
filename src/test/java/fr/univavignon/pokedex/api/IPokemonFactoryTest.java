package fr.univavignon.pokedex.api;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonFactoryTest  {





    //tester la IPokemonFactory qui  permet de créer un individu.
    IPokemonFactory pkFactory;
    Pokemon p1;
    Pokemon p2 ;

    @Before
    public void start() {
        pkFactory = Mockito.mock(IPokemonFactory.class);
        p1 =  new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        p2 = new Pokemon(133, "Aquali", 186, 186, 260, 2729, 202, 5000, 4, 1);



    }
    @Test
    public void CreationTest() {
        //  on crée bulbizarre avec c'est donné
        when(pkFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(p1);
        //  on crée aquali avec c'est donné
        when(pkFactory.createPokemon(133,2729, 202, 5000, 4)).thenReturn(p2);
        Assert.assertEquals(p1, pkFactory.createPokemon(0, 613, 64, 4000, 4));
        Assert.assertEquals(p2, pkFactory.createPokemon(133,2729, 202, 5000, 4));

    }







}
