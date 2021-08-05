package pages;

import com.sun.org.apache.bcel.internal.generic.ARETURN;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Resultado {
    WebDriver driver;


    // O texto onde fica escrito Curso > "Nome do Curso"
    @FindBy(css = "h3")
    WebElement indicadorDeCurso;

    @FindBy(css = "span.comprar")
    WebElement btnMatriculese;

    public Resultado(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String lerIndicardorDeCurso(){
        return indicadorDeCurso.getText();

    }

    public void clicarMatriculese(){
        btnMatriculese.click();
    }
    public by WebElement verificarElemento()
        return driver.findE
}
