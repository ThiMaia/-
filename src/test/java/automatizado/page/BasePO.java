package automatizado.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Clase base para criacao das novas PagesObjects.
 * Todas as pages devem ser herdadas desta classe'
 */

public abstract class BasePO {

    /**
     * Driver base que sera usado pelas pages
     */
    protected WebDriver driver;
    
    /**
     * Construtor base para cria;'ao de fabrica de elementos(PageFactory)'
     * @param driver (Driver da pagina atual.)
     */
    public BasePO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
