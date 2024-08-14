package WORK_SHOP_2;

// Třída pro stránku košíku
public class CartPage {

    WebDriver driver;

    // Konstruktor pro inicializaci WebDriveru
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Metoda pro přechod k pokladně
    public void proceedToCheckout() {
        driver.findElement(By.xpath("//a[contains(text(),'Proceed to checkout')]")).click();
    }
}
