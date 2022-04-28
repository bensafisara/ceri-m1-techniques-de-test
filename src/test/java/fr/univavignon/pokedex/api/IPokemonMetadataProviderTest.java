package fr.univavignon.pokedex.api;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonMetadataProviderTest extends TestCase {

    //Cette class est chargé pour un index donné de retourner les métadonnées d’une espèce

private  IPokemonMetadataProvider PMPT;

    @Before
    public  void Start(){


        PMPT = Mockito.mock(IPokemonMetadataProvider.class);



    }





}
