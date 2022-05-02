package fr.univavignon.pokedex.api;

import junit.framework.TestCase;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class IPokemonTrainerFactoryTest {

    IPokedexFactory PokedexF = mock(IPokedexFactory.class);
    IPokemonTrainerFactory PokemonTrainerF = mock(IPokemonTrainerFactory.class);
    IPokedex pdx = mock(IPokedex.class);
    PokemonTrainer PokemonT;

    @Before
    public void start(){
        // on creee l'instance que devra être crée
        PokemonT = new PokemonTrainer("UnString", Team.INSTINCT, pdx);
        // Qd j'appel createTrainer je dois obtenir mon PokemonTrainer
        when(PokemonTrainerF.createTrainer("UnString",Team.MYSTIC,PokedexF)).thenReturn(PokemonT);

    }


    @Test
    public void creationTrainerTest() {

        //un objet de la classe Pokemon Trainer et vérifier les classes
        PokemonTrainer Pokemon_Trainer1 = PokemonTrainerF.createTrainer("UnString",Team.MYSTIC,PokedexF);
        assertEquals(PokemonT.getClass(),Pokemon_Trainer1.getClass());

        //verifier que name pareil
        assertEquals("UnString",Pokemon_Trainer1.getName());
        //verifier que team pareil

        assertEquals(PokemonT.getTeam(),Pokemon_Trainer1.getTeam());
        // on verifie qu'on obtient le bon pokedex
        assertEquals(PokemonT.getPokedex(),Pokemon_Trainer1.getPokedex());

    }








}
