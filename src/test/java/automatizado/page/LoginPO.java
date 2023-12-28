package automatizado.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO{

    public LoginPO(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    public WebElement emailParaLogin;

    @FindBy(id = "senha")
    public WebElement senhaParaLogin;

    @FindBy(id = "btn-entrar")
    public WebElement botaoDeLogin;

    @FindBy(css = "form.form-login>div.alert>span")
    public WebElement spanMensagem;

    @FindBy(id = "btn-adicionar")
    public WebElement botaoDeAdicionarProduto;

    public void escrever(WebElement input, String texto){
        input.sendKeys(texto + Keys.TAB);
    }

    public void confirmarLogin(){
        botaoDeLogin.click();
    }

    public String mensagemDeRetorno(){
        return spanMensagem.getText();
    }

    public void limpaLogin(){
        emailParaLogin.clear();
        senhaParaLogin.clear();
    }

    public void executarAcaoDeLogin(String email, String senha){
        limpaLogin();
        escrever(emailParaLogin , email);
        escrever(senhaParaLogin, senha);
        confirmarLogin();
    }

    public String retornarTituloDaPaginaDeProduto(){
        return driver.getTitle();
    }

}
