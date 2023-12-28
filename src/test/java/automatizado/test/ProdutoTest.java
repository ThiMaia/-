package automatizado.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;

import automatizado.page.LoginPO;
import automatizado.page.ProdutoPO;

import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProdutoTest extends BaseTest{

    private static LoginPO loginPage;
    private static ProdutoPO controleProdutoPage;

    @BeforeClass
    public static void prepararTestes(){
        loginPage = new LoginPO(driver);
        loginPage.executarAcaoDeLogin("souzathiago021992@gmail.com","teste1234");
        controleProdutoPage = new ProdutoPO(driver);
        assertEquals(controleProdutoPage.retornarTituloDaPaginaDeProduto(),"Controle de Produtos");
    }
    @Test
    public void TC0001_deveAbrirModaldeCadastroAoClicarEmCriar(){
        controleProdutoPage.clicarCriarProduto();
        String titulo = controleProdutoPage.tituloDoWidgetProduto.getText();
        assertEquals("Produto", titulo);

    }
}
