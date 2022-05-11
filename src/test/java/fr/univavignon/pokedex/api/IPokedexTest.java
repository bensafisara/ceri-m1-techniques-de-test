//Pokedextest

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


    private static ArrayList<Pokemon> pdexLIST= new ArrayList<Pokemon>();
    IPokemonFactory PokmFact = new PokemonFactory();
    IPokedexFactory PokdxFact = new PokedexFactory();
    IPokemonMetadataProvider PokmMdataPro = new PokemonMetadataProvider();
    /**
     * Les pokemons  utile pour effectuer les tests
     */
    Pokemon p1;
    Pokemon p2;
    //je veux mocké pokédex du coup je la mock
    //pdx = mock(IPokedex.class);
    //je vais plus mocké mais appeler les implémentation
    IPokedex pdx = new Pokedex(PokmFact,PokmMdataPro);

    @Before
    public  void Start() {



        //instancié des pockémon  avec des new  pockémon

        p1 = new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,0.56);
        p2=new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,1);
        // j' ajoute les pokemons à la liste
        pdexLIST.add(p1);
        pdexLIST.add(p2);
    }



    @Test
    public void addPokemonTest() throws PokedexException {

        // when(pdx.addPokemon(p1)).thenReturn(p1.getIndex());
        //  when(pdx.addPokemon(p2)).thenReturn(p2.getIndex());
       //the expeted number of pokemon in the pokedex
        assertEquals(pdx.addPokemon(p1),1);
        //je retourne la taille de la list si j' appelle pokedex size
        assertEquals(pdx.addPokemon(p2),2);
    }

    // ici je doit tester  the Number of pokemon
    @Test
    public void sizeTest(){
        // i dont have to call addPokemon a chaque fois je doit les mettre dans le beforeEach
        // when(pdx.size()).thenReturn(pdexLIST.size());
        pdx.addPokemon(p1);
        pdx.addPokemon(p2);
        assertEquals(pdx.size(), 2);


    }

    @Test
    public void getPokemonTest() throws PokedexException {

        //le pokemon avec l'index est 0 => bulbizarre
        //Mockito.doReturn(p1).when(pdx).getPokemon(0);
        // le pokemon avec l'index  133 => aquali
      //  Mockito.doReturn(p2).when(pdx).getPokemon(133);

       // Mockito.doThrow(new PokedexException("index n'existe pas ")).when(pdx).getPokemon(Mockito.intThat(i -> i < 0 || i > 150));
        // Doit renvoyer bulbizarre
        assertEquals(pdexLIST.get(0), getpokemonFromIndex(0));
        // Doit renvoyer aquali
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
        /**
         * je cree +eurs liste selon le comparator
         */
        PokemonComparators pokemonComparator= PokemonComparators.INDEX;
        PokemonComparators pokemonComparatorNAME= PokemonComparators.NAME;
        PokemonComparators pokemonComparatorcp= PokemonComparators.CP;
        pdx.addPokemon(p1);
        pdx.addPokemon(p2);
        List<Pokemon> pokemons= new ArrayList<>();
        pokemons.add(p1);
        pokemons.add(p2);
        assertEquals(pdx.getPokemons(pokemonComparator),pokemons);

        List<Pokemon> listpokemonComparatorNAME = new ArrayList<>(pokemons);
        listpokemonComparatorNAME.sort(pokemonComparatorNAME);

        List<Pokemon> listpokemonComparatorcp= new ArrayList<>(pokemons);
        listpokemonComparatorcp.sort(pokemonComparatorcp);

 }
    }




