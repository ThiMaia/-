package automatizado.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePO extends BasePO{


    /**Reservando o campo de nome q do google em inputPesquisa */
    @FindBy(name = "q")
    public WebElement inputPesquisa;

    /**Reservando o campo de id result-stats do google em divResultadoPesquisa */
    @FindBy(id = "result-stats")
    public WebElement divResultadoPesquisa;


    /**Contrutor para criacao da pagina do google' */
    public GooglePO(WebDriver driver) {
        super(driver);
    }

    /**metodo que pequisa um texto de entrada no google e executa enter */
    public void pesquisar(String texto){
        inputPesquisa.sendKeys(texto + Keys.ENTER);
    }

    /**metododo que limpa o cmapo de pesquisa */
    public void limpaCampo(){
        inputPesquisa.clear();
    }

    public String retornoDaPesquisaDoGooogle(){
        return divResultadoPesquisa.getText();
    }

}
