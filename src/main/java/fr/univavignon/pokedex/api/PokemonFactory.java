package fr.univavignon.pokedex.api;

import java.util.Random;

public class PokemonFactory implements IPokemonFactory{
    IPokemonMetadataProvider iPokemMetaPro;

    public PokemonFactory(IPokemonMetadataProvider iPokemMetaPro ){
        this.iPokemMetaPro = iPokemMetaPro;


    }


    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {

        try {
            PokemonMetadata pokemonMetadata = iPokemMetaPro.getPokemonMetadata(index);
            Random rand = new Random();
            int attack = rand.nextInt(16);
            int def = rand.nextInt(16);
            int stami = rand.nextInt(16);
            double iv =  ((attack + def + stami) * 100 / 45);

            Pokemon pokemon = new Pokemon(index, pokemonMetadata.getName(), pokemonMetadata.getAttack()+attack, pokemonMetadata.getDefense()+def, pokemonMetadata.getStamina()+stami, cp, hp, dust, candy, iv);
            return pokemon;
        }
        catch (PokedexException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
