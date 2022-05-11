package fr.univavignon.pokedex.api;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static fr.univavignon.pokedex.api.PokemonMetadataProvider.mdataPokemon;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonFactoryTest  {





    //tester la IPokemonFactory qui  permet de créer un individu.
    IPokemonFactory pkFactory1= new PokemonFactory();
    IPokemonFactory pkFactory2= new PokemonFactory();
    Pokemon p1;
    Pokemon p2 ;


    @Before
    public void start() {

        mdataPokemon.add(new PokemonMetadata(0,"Bulbizarre",126,126,90));
        mdataPokemon.add(new PokemonMetadata(133,"Aquali",186,186,260));
        p1 =  new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        p2 = new Pokemon(133, "Aquali", 186, 186, 260, 2729, 202, 5000, 4, 1);




    }
    @Test
    public void CreationTest() {
        //  on crée bulbizarre et aquali avec les donées suivantes
       // when(pkFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(p1);
        //when(pkFactory.createPokemon(133,2729, 202, 5000, 4)).thenReturn(p2);

        // Et puis selon ce que j'ai compris ici on vas verifier la methode creatPokemon retourne bien les bon pokemons qu'on veut
            //Ici je fais une méthode plustot static on specifiant exactement les valeur
            /*Pokemon pkFact1_ = pkFactory1.createPokemon(0, 613, 64, 4000, 4);
            Pokemon pkFact2_= pkFactory2.createPokemon(133,2729, 202, 5000, 4);
            Assert.assertEquals(p1, pkFact1_);
            Assert.assertEquals(p2, pkFact2_);*/

                //Comment je peux Amélioré mon test :
                //Je peux Tester que c'est les bons pokémons attendu en comparant un par un leur index ,  nom , attack , stamina , Cp.....
                /**
                 * on verifie que les pokemons cree par la methods createPokemon sont bons
                 */
                Pokemon pkFact1 = pkFactory1.createPokemon(0, 613, 64, 4000, 4);
                Pokemon pkFact2 = pkFactory2.createPokemon(133,2729, 202, 5000, 4);


                //deuxieme pokemon
                Assert.assertEquals(p1.getIndex(),pkFact1.getIndex());
                Assert.assertEquals(p1.getCp(),pkFact1.getCp());
                Assert.assertEquals(p1.getHp(),pkFact1.getHp());
                Assert.assertEquals(p1.getDust(),pkFact1.getDust());
                Assert.assertEquals(p1.getCandy(),pkFact1.getCandy());

               //premier pokemon
                Assert.assertEquals(p2.getIndex(),pkFact2.getIndex());
                Assert.assertEquals(p2.getCp(),pkFact2.getCp());
                Assert.assertEquals(p2.getHp(),pkFact2.getHp());
                Assert.assertEquals(p2.getDust(),pkFact2.getDust());
                Assert.assertEquals(p2.getCandy(),pkFact2.getCandy());


    }



}