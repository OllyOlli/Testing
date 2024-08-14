package WORK_SHOP_2;

// Třída pro stránku přihlášení
public class LoginPage {

    WebDriver driver;

    // Konstruktor pro inicializaci WebDriveru
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Metoda pro zadání emailu
    public void enterEmail(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
    }

    // Metoda pro zadání hesla
    public void enterPassword(String password) {
        driver.findElement(By.id("passwd")).sendKeys(password);
    }

    // Metoda pro kliknutí na tlačítko Přihlásit
    public void clickSignIn() {
        driver.findElement(By.id("SubmitLogin")).click();
    }

    // Metoda pro přihlášení uživatele
    public void loginAsUser(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickSignIn();
    }
}
