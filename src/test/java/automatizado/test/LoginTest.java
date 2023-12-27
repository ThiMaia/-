package automatizado.test;

import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;
import automatizado.page.LoginPO;

public class LoginTest extends BaseTest{

    private static LoginPO loginPage;

    @BeforeClass
    public static void prepararTestes(){
        loginPage = new LoginPO(driver);
    }

    @Test
    public void TC001_loginESenhaEmBranco(){
        loginPage.escrever(loginPage.emailParaLogin , "");
        loginPage.escrever(loginPage.senhaParaLogin, "");
        loginPage.confirmarLogin();
        assertTrue(loginPage.mensagemDeRetorno(), loginPage.mensagemDeRetorno().contains("Informe usuário e senha, os campos não podem ser brancos."));
    }

    @Test
    public void TC002_loginPreenchidoErradaESenhaEmBranco(){ 
        loginPage.escrever(loginPage.emailParaLogin , "teste@teste.com\"");
        loginPage.escrever(loginPage.senhaParaLogin, "");
        loginPage.confirmarLogin();
        assertTrue(loginPage.mensagemDeRetorno(), loginPage.mensagemDeRetorno().contains("Informe usuário e senha, os campos não podem ser brancos."));   
        loginPage.limpaLogin();
    }

    @Test
    public void TC003_loginEmBrancoESenhaPreenchidaErrada(){
        loginPage.escrever(loginPage.emailParaLogin , "");
        loginPage.escrever(loginPage.senhaParaLogin, "teste@teste.com");
        loginPage.confirmarLogin();
        assertTrue(loginPage.mensagemDeRetorno(), loginPage.mensagemDeRetorno().contains("Informe usuário e senha, os campos não podem ser brancos."));
        loginPage.limpaLogin();
    }
    
        @Test
    public void TC004_loginESenhaPreenchidosErrados(){
        loginPage.escrever(loginPage.emailParaLogin , "teste@teste.com");
        loginPage.escrever(loginPage.senhaParaLogin, "teste@teste.com");
        loginPage.confirmarLogin();
        assertTrue(loginPage.mensagemDeRetorno(), loginPage.mensagemDeRetorno().contains("E-mail ou senha inválidos"));
        loginPage.limpaLogin();
    }

    @Test
    public void TC005_loginCorretoSenhaIncorreta(){
        loginPage.escrever(loginPage.emailParaLogin , "souzathiago021992@gmail.com");
        loginPage.escrever(loginPage.senhaParaLogin, "teste@teste.com");
        loginPage.confirmarLogin();
        assertTrue(loginPage.mensagemDeRetorno(), loginPage.mensagemDeRetorno().contains("E-mail ou senha inválidos"));
        loginPage.limpaLogin();
    }

    @Test
    public void TC006_loginIncorretoComSenhaCorreta(){
        loginPage.escrever(loginPage.emailParaLogin , "teste@teste.com");
        loginPage.escrever(loginPage.senhaParaLogin, "teste1234");
        loginPage.confirmarLogin();
        assertTrue(loginPage.mensagemDeRetorno(), loginPage.mensagemDeRetorno().contains("E-mail ou senha inválidos"));
        loginPage.limpaLogin();
    }

    @Test
    public void TC007_loginEsenhaCorretos(){
        loginPage.escrever(loginPage.emailParaLogin , "souzathiago021992@gmail.com");
        loginPage.escrever(loginPage.senhaParaLogin, "teste1234");
        loginPage.confirmarLogin();
        loginPage.botaoDeAdicionarProduto.isEnabled();
        driver.get(URL_BASE);
    }

}
