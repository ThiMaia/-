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
    public String mensagem2 = "Todos os campos são obrigatórios para o cadastro!";

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
        .builder();

        controleProdutoPage.botaoDeSair.click();
    }

    @Test
    public void TC0003_naoDeveCriarProdutoSemCodigo(){
        controleProdutoPage.clicarCriarProduto();
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleProdutoPage);

        produtoBuilder
        .adicionarCodigo("")
        .builder();

        
        assertEquals(mensagem2, controleProdutoPage.spanMensagem.getText());
        controleProdutoPage.botaoDeSair.click();
    }

    
    @Test
    public void TC0004_naoDeveCriarProdutoSemNome(){
        controleProdutoPage.clicarCriarProduto();
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleProdutoPage);

        produtoBuilder
        .adicionarNome("")
        .builder();

        
        assertEquals(mensagem2, controleProdutoPage.spanMensagem.getText());
        controleProdutoPage.botaoDeSair.click();
    }

    @Test
    public void TC0005_naoDeveCriarProdutoSemData(){
        controleProdutoPage.clicarCriarProduto();
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleProdutoPage);

        produtoBuilder
        .adicionarData("")
        .builder();

        
        assertEquals(mensagem2, controleProdutoPage.spanMensagem.getText());
        controleProdutoPage.botaoDeSair.click();
    }

    @Test
    public void TC0006_naoDeveCriarProdutoSemQuantidade(){
        controleProdutoPage.clicarCriarProduto();
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleProdutoPage);

        produtoBuilder
        .adicionarQuantidade(null)
        .builder();

        
        assertEquals(mensagem2, controleProdutoPage.spanMensagem.getText());
        controleProdutoPage.botaoDeSair.click();
    }

    @Test
    public void TC0007_naoDeveCriarProdutoSemValor(){
        controleProdutoPage.clicarCriarProduto();
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleProdutoPage);

        produtoBuilder
        .adicionarValor(null)
        .builder();

        
        assertEquals(mensagem2, controleProdutoPage.spanMensagem.getText());
        controleProdutoPage.botaoDeSair.click();
    }

    @Test
    public void TC0008_naoDeveCriarProdutoSemCodigoESemNome(){
        controleProdutoPage.clicarCriarProduto();
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleProdutoPage);

        produtoBuilder
        .adicionarCodigo("")
        .adicionarNome("")
        .builder();

        
        assertEquals(mensagem2, controleProdutoPage.spanMensagem.getText());
        controleProdutoPage.botaoDeSair.click();
    }

    @Test
    public void TC0009_naoDeveCriarProdutoSemCodigoESemNomeESemData(){
        controleProdutoPage.clicarCriarProduto();
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleProdutoPage);

        produtoBuilder
        .adicionarCodigo("")
        .adicionarNome("")
        .adicionarData("")
        .builder();

        
        assertEquals(mensagem2, controleProdutoPage.spanMensagem.getText());
        controleProdutoPage.botaoDeSair.click();
    }

    @Test
    public void TC0010_naoDeveCriarProdutoSemCodigoESemNomeESemDataEsemValor(){
        controleProdutoPage.clicarCriarProduto();
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleProdutoPage);

        produtoBuilder
        .adicionarCodigo("")
        .adicionarNome("")
        .adicionarData("")
        .adicionarValor(null)
        .builder();

        
        assertEquals(mensagem2, controleProdutoPage.spanMensagem.getText());
        controleProdutoPage.botaoDeSair.click();
    }

    @Test
    public void TC0011_naoDeveCriarProdutoSemCodigoESemNomeESemDataEsemValorESemQuantidade(){
        controleProdutoPage.clicarCriarProduto();
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleProdutoPage);

        produtoBuilder
        .adicionarCodigo("")
        .adicionarNome("")
        .adicionarData("")
        .adicionarValor(null)
        .adicionarQuantidade(null)
        .builder();

        
        assertEquals(mensagem2, controleProdutoPage.spanMensagem.getText());
        controleProdutoPage.botaoDeSair.click();
    }


}
