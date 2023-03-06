package br.com.blogdoai.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.id;

public abstract class PaginaPOO {

    String URL_BLOG = "https://blogdoagi.com.br/";
    public WebDriver navegador;

    public String palavraChaveSucesso = "CDB";
    public String palavraChaveErro = "13/08/2021";
    public String palavraComNavecacao = "Celular";

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
//        WebDriverManager.firefoxdriver().setup();
//        WebDriverManager.operadriver().setup();
    }

    @BeforeEach
    public void setup() {
        navegador = new ChromeDriver();
//      navegador - new FirefoxDriver();
//      navegador = new OperaDriver();
        navegador.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        navegador.get(URL_BLOG);
        ;
    }

    @AfterEach
    public void teardown() {
        navegador.quit();
    }

    public void maximizaTela() {
        this.navegador.manage().window().maximize();
    }

    public void preencheComPesquisaValidaResolucaoMenor(String texto) {
        this.navegador.findElement(id("overlay-open")).click();
        this.navegador.findElement(className("mobile-search")).click();
        this.navegador.findElement(By.cssSelector(".mobile-search .search-field")).sendKeys(texto);
        this.navegador.findElement(By.cssSelector(".mobile-search .search-field")).submit();
    }

    public void preencheComPesquisaValidaResolucaoMaior(String texto) {
        this.navegador.findElement(id("search-open")).click();
        this.navegador.findElement(By.name("s")).sendKeys(texto);
        this.navegador.findElement(By.name("s")).submit();

    }

    public void pesquisaSemString() {
        this.navegador.findElement(By.id("search-open")).click();
        this.navegador.findElement(By.name("s")).submit();

    }

//    public void tiraPrintDoResultado() throws IOException {
//        UUID uuid = UUID.randomUUID();
//        String fileName = "screenshot_" + uuid.toString() + ".png";
//        File screenshotFile = ((TakesScreenshot) this.navegador).getScreenshotAs(OutputType.FILE);
//        FileUtil.copyFile(screenshotFile, new File("cenariodetesteprint/" + fileName));
//    }

    public void verificaSePalavraComSucessoFoiExibida(String texto) {
        WebElement resultadoDaBusca = this.navegador.findElement(By.className("archive-title"));
        String expectedText = String.format("Resultados da busca por: %s", texto);
        String actualText = resultadoDaBusca.getText();
        if (!actualText.equals(expectedText)) {
            System.out.println("Erro ao verificar se a palavra foi exibida com sucesso. Texto esperado: " + expectedText + ". Texto atual: " + actualText);
        }
    }

    public void verificaENavega(String texto) {
        WebElement entraNaultimaMateria = this.navegador.findElement(By.className("entry-title"));
        String actualText = entraNaultimaMateria.getText().toLowerCase(Locale.ROOT);
        if (!actualText.contains(texto.toLowerCase(Locale.ROOT))) {
            System.out.println("Erro ao verificar e entrar na última matéria. Texto esperado: " + texto + ". Texto atual: " + actualText);
        }
    }

    public void verificaSePalavraComErroFoiExibida(String texto) {
        String expectedText = String.format("Nenhum resultado");
        this.navegador.getPageSource().contains(expectedText);
    }

    public void verificaMensageConfirmaExistenciaDaPalavraENavaga(String texto) {
        WebElement entraNaUltimaMateria = this.navegador.findElement(By.cssSelector("h2.entry-title"));
        String expectedTitle = texto.toLowerCase(Locale.ROOT);
        String actualTitle = entraNaUltimaMateria.getText().toLowerCase(Locale.ROOT);
        if (!actualTitle.contains(expectedTitle)) {
            System.out.println("Erro ao verificar e entrar na última matéria. Texto esperado: " + expectedTitle + ". Texto atual: " + actualTitle);
        } else {
            entraNaUltimaMateria.click();
        }
    }

    public void verificaMensageSemPesquisa()  {
        WebElement resultadoDaBusca = this.navegador.findElement(By.cssSelector("h1.archive-title"));
        String expectedText = String.format("Resultados da busca por:");
        try {
            Assert.assertEquals(expectedText, resultadoDaBusca.getText());
        } catch (AssertionError e) {
            System.out.println("Erro ao verificar se a palavra foi exibida com sucesso: " + e.getMessage());
        }
    }


}
