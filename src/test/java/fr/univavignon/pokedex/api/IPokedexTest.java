package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class IPokedexTest {

//Pour testé toutes les classes il faut déja créé les instances de pokémone
    IPokedex pdx;
    Pokemon p1;
    Pokemon p2;
    public static ArrayList<Pokemon> pdexLIST;




    @Before
    public  void Start() {


        //je veux mocké pokédex du coup je la mock
        pdx = mock(IPokedex.class);
        //instancié des pockémon  , des new  pockémon

          p1 = new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,0.56);
          p2=new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,1);
        pdexLIST = new ArrayList<Pokemon>();
        pdexLIST.add(p1);
        pdexLIST.add(p2);

    }
    // ici je doit tester " the Number of pokemon in this pokedex."
    @Test
    public void addPokemonTest() {


        when(pdx.addPokemon(p1)).thenReturn(p1.getIndex());
        //when(pdx.addPokemon(p1)).thenReturn(0);
        when(pdx.addPokemon(p2)).thenReturn(p2.getIndex());
        assertEquals(pdx.addPokemon(p1), 0);
        assertEquals(pdx.addPokemon(p2), 133);
    }



    @Test
    public void sizeTest(){
        // i dont have to call addPokemon a chaque fois je doit les mettre dans le beforeEach
        when(pdx.size()).thenReturn(pdexLIST.size());
            assertEquals(pdx.size(), 2);
            assertEquals(pdx.size(), pdexLIST.size());
    }




    @Test
    public void getPokemonTest() throws PokedexException {

        //le pokemon dont l'index est 0 => bulbizarre
        when(pdx.getPokemon(Mockito.anyInt())).thenReturn(getpokemonFromIndex(0));
        assertEquals(pdexLIST.get(0), getpokemonFromIndex(0));
        assertEquals(pdexLIST.get(1), getpokemonFromIndex(133));

    }





    public Pokemon getpokemonFromIndex(int index) throws PokedexException {
        for(int i=0;i<pdexLIST.size();i++) {
            if(pdexLIST.get(i).getIndex() == index) {
                return pdexLIST.get(i);
            }
        }
        throw new PokedexException("Index n'existe pas");
    }




    @Test
    public void PokemonsSortedTest(){
        PokemonComparators index = PokemonComparators.INDEX;
        when(pdx.getPokemons(index)).thenReturn(pdexLIST);
        List<Pokemon> sortedindex = pdx.getPokemons(index);
        assertEquals(sortedindex,pdexLIST);
        //vérifier que le size est toujours respecté
        Assert.assertEquals(pdexLIST.size(), pdx.getPokemons(index).size());




        PokemonComparators name = PokemonComparators.NAME;
        when(pdx.getPokemons(name)).thenReturn(pdexLIST);
        List<Pokemon> sortedname = pdx.getPokemons(name);
        assertEquals(sortedname,pdexLIST);

        //vérifier que le size est toujours respecté
        Assert.assertEquals(pdexLIST.size(), pdx.getPokemons(name).size());
        // elle  commence  par Bulbizarre
        Assert.assertEquals("Bulbizarre", pdx.getPokemons(name).get(0).getName());

        //  le premier index est  0
        Assert.assertEquals(0, pdx.getPokemons(index).get(0).getIndex());


    }


    @Test
    public void PokemonsList(){
        when(pdx.getPokemons()).thenReturn(pdexLIST);
        List<Pokemon> sorted = pdx.getPokemons();
        assertEquals(sorted,pdexLIST);

    }



    }
