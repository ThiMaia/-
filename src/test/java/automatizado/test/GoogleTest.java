package automatizado.test;

import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;
import automatizado.page.GooglePO;



public class GoogleTest extends BaseTest {

    private static GooglePO googlePage;

    @BeforeClass
    public static void prepararTestes(){
        googlePage = new GooglePO(driver);
    }
    @Test
    public void TC001_devePesquisarNoGoogleOTextoBatataDoce(){
        googlePage.pesquisar("Batata Doce");
        assertTrue(googlePage.retornoDaPesquisaDoGooogle(), googlePage.retornoDaPesquisaDoGooogle().contains("Aproximadamente"));  
    }

    @Test
    public void TC002_deveLimparAPesquisaEPersquisaBatataFrita(){
        googlePage.limpaCampo();
        googlePage.pesquisar("Batata Frita");
        assertTrue(googlePage.retornoDaPesquisaDoGooogle(), googlePage.retornoDaPesquisaDoGooogle().contains("resultado"));   
    }

        @Test
    public void TC003_deveLimparAPesquisaEPersquisaBatata(){
        googlePage.limpaCampo();
        googlePage.pesquisar("Batata");
        assertTrue(googlePage.retornoDaPesquisaDoGooogle(), googlePage.retornoDaPesquisaDoGooogle().contains("resultado"));   
    }

}
