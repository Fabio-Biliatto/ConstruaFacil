package webTests;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class comprarCursoCS {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void iniciar(){
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/91/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();// Maximizar a janela

        wait = new WebDriverWait(driver, 60); // espera at� 60 segundos

        System.out.println("0 - Antes do Teste iniciar");
    }

    @After
    public void finalizar(){
        driver.quit();
        System.out.println("Z - Depois do Teste finalizar");

    }

    @Dado("^que acesso o site da Iterasys$")
    public void queAcessoOSiteDaIterasys() {
        driver.get("https://www.iterasys.com.br");
        System.out.println("1 - Acessou o site");
    }

    @Quando("^pesquiso por \"([^\"]*)\"$")
    public void pesquisoPor(String curso) {
        driver.findElement(By.id("searchtext")).click();        //Opcional
        driver.findElement(By.id("searchtext")).clear();       //Opcional
        driver.findElement(By.id("searchtext")).sendKeys(Keys.chord(curso)); // escreve nome do curso letra p/ letra
        System.out.println("2 - Digitou o nome do curso " +curso);
    }

    @E("^clico na Lupa$")
    public void clicoNaLupa() {
        driver.findElement(By.id("btn_form_search")).click();
        System.out.println("3 - Clicou na lupa");
    }

    @Entao("^vejo a lista de resultados para o curso \"([^\"]*)\"$")
    public void vejoAListaDeResultadosParaCurso(String curso) {
        String textoesperado = "Cursos � \"" + curso + "\"";
        wait.until(ExpectedConditions.textToBe(By.cssSelector("h3:nth-child(1)"),textoesperado));
        assertEquals(driver.findElement(By.cssSelector("h3:nth-child(1)")).getText(),textoesperado);
        System.out.println("4 - Exibiu a lista de resultados para o curso " + curso);
    }


    @Quando("^clico em Matricule-se$")
    public void clicoEmMatriculeSe() {
        driver.findElement(By.cssSelector("span.comprar")).click();
        System.out.println("5 - Clicou em Matricule-se");
    }

    @Entao("^confirmo o nome do curso como \"([^\"]*)\" e o preco de \"([^\"]*)\"$")
    public void confirmoONomeDoCursoComoEOPrecoDe(String curso, String preco)  {
        assertEquals(driver.findElement(By.cssSelector("span.item-title")).getText(), curso);
        assertEquals(driver.findElement(By.cssSelector("span.new-price")).getText(), preco);
        System.out.println("6 - Confirmou o nome como " + curso + " e o preco do curso como " + preco);

    }

    @E("^pressiono Enter$")
    public void pressionoEnter() {
        driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER);
    }

    @Quando("^clico na imagem de um curso$")
    public void clicoNaImagemDeUmCurso() {
        driver.findElement(By.cssSelector("span.mais")).click();
    }

    @Entao("^vejo a pagina com detalhes do curso$")
    public void vejoAPaginaComDetalhesDoCurso() {
        wait.until(ExpectedConditions.titleIs("Mantis - Iterasys"));
        assertEquals(driver.getTitle(), "Mantis - Iterasys");
    }

    @E("^clico no botao Ok do popup da LGPD$")
    public void clicoNoBotaoOkDoPopupDaLGPD() {
        driver.findElement(By.cssSelector("a.cc-btn.cc-dismiss")).click();
    }
}
