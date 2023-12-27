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
         loginPage.addEmail("");
        loginPage.addSenha("");
        assertTrue(loginPage.mensagemDeRetorno(), loginPage.mensagemDeRetorno().contains("Informe usuário e senha, os campos não podem ser brancos."));
    }

    @Test
    public void TC002_loginPreenchidoErradaESenhaEmBranco(){ 
        loginPage.addEmail("teste@teste.com");
        loginPage.addSenha("");
        assertTrue(loginPage.mensagemDeRetorno(), loginPage.mensagemDeRetorno().contains("Informe usuário e senha, os campos não podem ser brancos."));   
        loginPage.limpaLogin();
    }

    @Test
    public void TC003_loginEmBrancoESenhaPreenchidaErrada(){
        loginPage.addEmail("");
        loginPage.addSenha("teste@teste.com");
        assertTrue(loginPage.mensagemDeRetorno(), loginPage.mensagemDeRetorno().contains("Informe usuário e senha, os campos não podem ser brancos."));
        loginPage.limpaLogin();
    }
    
        @Test
    public void TC004_loginESenhaPreenchidosErrados(){
        loginPage.addEmail("teste@teste.com");
        loginPage.addSenha("teste@teste.com");
        assertTrue(loginPage.mensagemDeRetorno(), loginPage.mensagemDeRetorno().contains("E-mail ou senha inválidos"));
        loginPage.limpaLogin();
    }

    @Test
    public void TC005_loginCorretoSenhaIncorreta(){
        loginPage.addEmail("souzathiago021992@gmail.com");
        loginPage.addSenha("teste@teste.com");
        assertTrue(loginPage.mensagemDeRetorno(), loginPage.mensagemDeRetorno().contains("E-mail ou senha inválidos"));
        loginPage.limpaLogin();
    }

    @Test
    public void TC006_loginIncorretoComSenhaCorreta(){
        loginPage.addEmail("teste@teste.com");
        loginPage.addSenha("teste1234");
        assertTrue(loginPage.mensagemDeRetorno(), loginPage.mensagemDeRetorno().contains("E-mail ou senha inválidos"));
        loginPage.limpaLogin();
    }

    @Test
    public void TC007_loginEsenhaCorretos(){
        loginPage.addEmail("souzathiago021992@gmail.com");
        loginPage.addSenha("teste1234");
        loginPage.botaoDeAdicionarProduto.isEnabled();
        driver.get(URL_BASE);
    }

}
