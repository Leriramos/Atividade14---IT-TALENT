package PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormPage {
    private WebDriver driver;

    // Localizadores dos elementos da página
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("/html/body/div[2]/div/div/form/button");
    private By successMessage = By.id("flash");

    // Construtor que inicializa o driver
    public FormPage(WebDriver driver) {
        this.driver = driver;

    }
    // Método para inserir o nome de usuário
    public FormPage enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
        return this;
    }

    // Método para inserir a senha
    public FormPage enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    // Método para clicar no botão de login
    public FormPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return this;
    }

    // Método para obter a mensagem de sucesso
    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }
}
