package WORK_SHOP_2;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;


// Třída pro stránku pokladny
public class CheckoutPage {

    WebDriver driver;

    // Konstruktor pro inicializaci WebDriveru
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    // Metoda pro potvrzení adresy
    public void confirmAddress() {
        driver.findElement(By.name("confirm-addresses")).click();
    }

    // Metoda pro výběr způsobu doručení
    public void chooseDeliveryMethod() {
        driver.findElement(By.id("delivery_option_2")).click(); // PrestaShop "pick up in store"
    }

    // Metoda pro výběr platby šekem
    public void selectPayByCheck() {
        driver.findElement(By.id("payment-option-1")).click(); // Platba šekem
    }

    // Metoda pro potvrzení objednávky
    public void confirmOrder() {
        driver.findElement(By.xpath("//button[contains(text(),'order with an obligation to pay')]")).click();
    }

    // Metoda pro pořízení screenshotu potvrzení objednávky
    public void takeScreenshot(String filePath) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File(filePath));
    }
}
