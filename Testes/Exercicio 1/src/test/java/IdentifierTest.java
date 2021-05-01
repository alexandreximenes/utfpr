import junit.framework.Assert;
import org.junit.Test;

public class IdentifierTest {

    private Identifier identifier;

    @Test
    public void deveTerTerNoMinimoUmCaracteres(){
        identifier = new Identifier("abc");
        Assert.assertEquals(true, identifier.minCaracter());
    }

    @Test(expected = RuntimeException.class)
    public void deveFalharNoTesteComMinimoUmCaracteres(){
        identifier = new Identifier(null);
        identifier.minCaracter();
    }

    @Test
    public void deveTerTerNoMaximoSeisCaracteres(){
        identifier = new Identifier("abc");
        Assert.assertTrue(identifier.maxCaracter());
    }

    @Test(expected = RuntimeException.class)
    public void deveFalharNoTesteMaximoSeisCaracteres(){
        identifier = new Identifier("abcdefgh");
        identifier.maxCaracter();
    }

    @Test
    public void deveComecarComLetras(){
        identifier = new Identifier("abc");
        Assert.assertTrue(identifier.comecaComLetra());
    }

    @Test(expected = RuntimeException.class)
    public void deveFalharTesteComecarComLetras(){
        identifier = new Identifier("1bc*");
        identifier.comecaComLetra();
    }

    @Test
    public void deveConterLetraOuNumero(){
        identifier = new Identifier("abc123");
        Assert.assertTrue(identifier.contemLetraOuNumero());
    }

    @Test(expected = RuntimeException.class)
    public void deveFalharTesteConterLetraOuNumero(){
        identifier = new Identifier("abc-");
        identifier.contemLetraOuNumero();
    }
}
