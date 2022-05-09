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
        //  on crée bulbizarre et aquali avec les donées suivantes
        when(pkFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(p1);
        when(pkFactory.createPokemon(133,2729, 202, 5000, 4)).thenReturn(p2);


        // Et puis selon ce que j'ai compris ici on vas verifier la methode creatPokemon retourne bien les bon pokemons qu'on veut
         //Ici je fais une méthode plustot static on specifiant exactement les valeur
        Pokemon pkFact1 = pkFactory.createPokemon(0, 613, 64, 4000, 4);
        Pokemon pkFact2 = pkFactory.createPokemon(133,2729, 202, 5000, 4);
        Assert.assertEquals(p1, pkFact1);
        Assert.assertEquals(p2, pkFact2);



      //Comment je peux Amélioré mon test :
        //Je peux Tester que c'est les bons pokémons attendu en comparant un par un leur index ,  nom , attack , stamina , Cp.....

        Assert.assertEquals(p1.getIndex(),pkFact1.getIndex());
        Assert.assertEquals(p1.getName(),pkFact1.getName());
        Assert.assertEquals(p1.getAttack(),pkFact1.getAttack());
        Assert.assertEquals(p1.getDefense(),pkFact1.getDefense());
        Assert.assertEquals(p1.getStamina(),pkFact1.getStamina());
        Assert.assertEquals(p1.getCp(),pkFact1.getCp());
        Assert.assertEquals(p1.getHp(),pkFact1.getHp());
        Assert.assertEquals(p1.getDust(),pkFact1.getDust());
        Assert.assertEquals(p1.getCandy(),pkFact1.getCandy());


        Assert.assertEquals(p2.getIndex(),pkFact2.getIndex());
        Assert.assertEquals(p2.getName(),pkFact2.getName());
        Assert.assertEquals(p2.getAttack(),pkFact2.getAttack());
        Assert.assertEquals(p2.getDefense(),pkFact2.getDefense());
        Assert.assertEquals(p2.getStamina(),pkFact2.getStamina());
        Assert.assertEquals(p2.getCp(),pkFact2.getCp());
        Assert.assertEquals(p2.getHp(),pkFact2.getHp());
        Assert.assertEquals(p2.getDust(),pkFact2.getDust());
        Assert.assertEquals(p2.getCandy(),pkFact2.getCandy());
     

    }







}
