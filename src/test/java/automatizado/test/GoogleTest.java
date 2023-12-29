package automatizado.test;

import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;
import automatizado.page.GooglePO;



/**Classe que testa parcialmente a pesquisa do google */

public class GoogleTest extends BaseTest {

    /**Criar uma instancia da classe GooglePo para ter acesso aos metodos e propriedades publicas*/
    private static GooglePO googlePage;

    /*classe que atualiza a informa;'ao de url base para teste do google' */
    @BeforeClass
    public static void prepararTestes(){
        driver.get("https://www.google.com/");
        googlePage = new GooglePO(driver);
    }

    /**incio dos testes do google */
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

    
    @Test
    public void TC004_deveLimparAPesquisaEPersquisagoku(){
        googlePage.limpaCampo();
        googlePage.pesquisar("Goku");
        assertTrue(googlePage.retornoDaPesquisaDoGooogle(), googlePage.retornoDaPesquisaDoGooogle().contains("resultado"));   
    }
 
}
