package fr.univavignon.pokedex.api;
import java.util.Random;

//PokemonFactory


public class PokemonFactory implements IPokemonFactory{



    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {

        try {


            PokemonMetadata pokemonMetadata = new PokemonMetadataProvider().getPokemonMetadata(index);
            Random rand = new Random();
            int attack = rand.nextInt(16);
            int def = rand.nextInt(16);
            int stami = rand.nextInt(16);
            int iv =  (int)((attack + def + stami) * 100 / 45);

            Pokemon pokemon = new Pokemon(index,pokemonMetadata.getName(), pokemonMetadata.getAttack(), pokemonMetadata.getDefense(), pokemonMetadata.getStamina(),cp,hp,dust,candy, iv);
            return pokemon;
        }
        catch (PokedexException e)
        {
            e.printStackTrace();
        }
        return null;
    }


}