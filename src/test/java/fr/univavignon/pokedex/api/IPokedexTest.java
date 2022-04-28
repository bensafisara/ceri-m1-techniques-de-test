package fr.univavignon.pokedex.api;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class IPokedexTest {

//Pour testé toutes les classes il faut déja créé les instances de pokémone
    IPokedex pdx;
    Pokemon p1;
    Pokemon p2;

    @Before
    public  void Start() {


        //je veux mocké pokédex du coup je la mock
        pdx = Mockito.mock(IPokedex.class);
        when(pdx.size()).thenReturn(2);

        //instancié des pockémon  , des new  pockémon


      p1 = new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,0.56);
      p2=new Pokemon(0,"Aquali",186,168,260,2729,202,5000,4,1);



    }

    // ici je doit tester " the Number of pokemon in this pokedex."
    @Test
    public void size(){
        assertEquals(2,3);

    }






    }
