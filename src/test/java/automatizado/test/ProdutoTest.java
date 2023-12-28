package automatizado.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;

import automatizado.builder.ProdutoBuilder;
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
        controleProdutoPage.clicarCriarProdutoPrimeiraVez();
    }


    @Test
    public void TC0001_deveAbrirModaldeCadastroAoClicarEmCriar(){
        controleProdutoPage.clicarCriarProduto();
        String titulo = controleProdutoPage.tituloDoWidgetProduto.getText();
        assertEquals(titulo, "Produto");
        controleProdutoPage.botaoDeSair.click();
    }

    @Test
    public void TC0002_deveCriarProduto(){
        controleProdutoPage.clicarCriarProduto();
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleProdutoPage);

        produtoBuilder
        .adicionarQuantidade(1)
        .adicionarValor(50.40)
        .adicionarNome("M<artelo")
        .builder();


        produtoBuilder
        .adicionarQuantidade(2)
        .adicionarValor(51.40)
        .adicionarNome("Jungle")
        .builder();

         produtoBuilder
        .adicionarQuantidade(2)
        .adicionarValor(51.40)
        .adicionarNome("Jungle")
        .builder();

        controleProdutoPage.botaoXDeCriacaoDeProduto.click();
    }
}
