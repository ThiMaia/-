package automatizado.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProdutoPO extends BasePO{

    public ProdutoPO(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "ul>li>a.nav-link")
    public WebElement linkVoltar;

    @FindBy(css = "nav>a.navbar-brand")
    public WebElement tituloWeb;

    @FindBy(id = "btn-adicionar")
    public WebElement botaoCriarProdutoElement;

    @FindBy(css= "div>div>div>div>h4.modal-title")
    public WebElement tituloPrdoutoDoWidget;

    @FindBy(css = "div>div>div>div>label")
    public WebElement nomeDoCampoCodigo;

    @FindBy(id = "codigo")
    public WebElement inputCodigo;

    @FindBy(id = "nome")
    public WebElement inputNomeDoProduto;

    @FindBy(id = "quantidade")
    public WebElement inputQuantidadeDoProduto;

    @FindBy(id = "valor")
    public WebElement inputValorDoProduto;

    @FindBy(id = "data")
    public WebElement inputDataDoProduto;

    @FindBy(id = "btn-salvar")
    public WebElement botaoDeSalvarProdutoCriando;

    @FindBy(id = "btn-sair")
    public WebElement botaoDeSair;

    @FindBy(css = "div.modal-header>h4")
    public WebElement tituloDoWidgetProduto;

    public String retornarTituloDaPaginaDeProduto(){
        return driver.getTitle();
    }

    public void clicarCriarProduto(){
        botaoCriarProdutoElement.click();
        botaoCriarProdutoElement.click();
    }

}
