import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.FormPage;

import static org.testng.Assert.assertTrue;

public class FormTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        // Inicializa o WebDriver e navega até a página de login
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void testeLogin() {
        // Cria uma instância de FormPage e executa as ações de login
        FormPage formPage = new FormPage(driver);
        formPage.enterUsername("tomsmith")
                .enterPassword("SuperSecretPassword!")
                .clickLoginButton();

        // Verifica se a mensagem de sucesso contém o texto esperado
        String successMessage = formPage.getSuccessMessage();
        assertTrue(successMessage.contains("You logged into a secure area!"));
    }

   // @AfterTest
    public void tearDown() {
        // Fecha o navegador
        driver.quit();
    }
}
