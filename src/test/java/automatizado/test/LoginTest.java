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
        loginPage.executarAcaoDeLogin("", "");
        assertTrue(loginPage.mensagemDeRetorno(), loginPage.mensagemDeRetorno().contains("Informe usuário e senha, os campos não podem ser brancos."));
    }

    @Test
    public void TC002_loginPreenchidoErradaESenhaEmBranco(){ 
        loginPage.executarAcaoDeLogin("teste@teste.com", "");
        assertTrue(loginPage.mensagemDeRetorno(), loginPage.mensagemDeRetorno().contains("Informe usuário e senha, os campos não podem ser brancos."));   
    }

    @Test
    public void TC003_loginEmBrancoESenhaPreenchidaErrada(){
       loginPage. executarAcaoDeLogin("", "teste@teste.com");
        assertTrue(loginPage.mensagemDeRetorno(), loginPage.mensagemDeRetorno().contains("Informe usuário e senha, os campos não podem ser brancos."));
    }
    
        @Test
    public void TC004_loginESenhaPreenchidosErrados(){
        loginPage.executarAcaoDeLogin("teste@teste.com", "teste@teste.com");
        assertTrue(loginPage.mensagemDeRetorno(), loginPage.mensagemDeRetorno().contains("E-mail ou senha inválidos"));
    }

    @Test
    public void TC005_loginCorretoSenhaIncorreta(){
        loginPage.executarAcaoDeLogin("souzathiago021992@gmail.com", "teste@teste.com");
        assertTrue(loginPage.mensagemDeRetorno(), loginPage.mensagemDeRetorno().contains("E-mail ou senha inválidos"));
    }

    @Test
    public void TC006_loginIncorretoComSenhaCorreta(){
        loginPage.executarAcaoDeLogin("teste@teste.com", "teste1234");
        assertTrue(loginPage.mensagemDeRetorno(), loginPage.mensagemDeRetorno().contains("E-mail ou senha inválidos"));
    }

    @Test
    public void TC007_loginEsenhaCorretos(){
        loginPage.executarAcaoDeLogin("souzathiago021992@gmail.com", "teste1234");
        loginPage.botaoDeAdicionarProduto.isEnabled();
        driver.get(URL_BASE);
    }

}
