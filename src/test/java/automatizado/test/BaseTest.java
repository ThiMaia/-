package automatizado.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/**Base teste que serve de heranca para todas as classes de teste446 */

public abstract class BaseTest {
    
    /**Iniciar as variaveis que seram ultilizadas por todas as clasess */
    protected static WebDriver driver;
    public static final String URL_BASE = "C:/Selenium Java/controle-de-produtos/sistema/login.html";
    private static final String CAMINHO_DRIVER = "src/test/java/automatizado/resource/chromedriver-v12006099.exe";
   

    /**Classe que sera executada antes de qualquer classe de teste, para prepara;'ao dos testes e setado o webdriver que sera usado o tamanho da tela a ser executado. etc' */
    @BeforeClass
    public static void iniciar(){
        System.setProperty("webdriver.chrome.driver",CAMINHO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_BASE);
    } 

    /**Classe que sera executado ao final de todos os testes e fecha o chrome */ 
    @AfterClass
    public static void finalizar(){
    driver.quit();
    }

}
