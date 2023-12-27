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

    public void addEmail(String texto){
        emailParaLogin.sendKeys(texto);
    }

    public void addSenha(String texto){
        senhaParaLogin.sendKeys(texto);
        botaoDeLogin.click();
    }

    public String mensagemDeRetorno(){
        return spanMensagem.getText();
    }

    public void limpaLogin(){
        emailParaLogin.clear();
        senhaParaLogin.clear();
    }

}
