package WORK_SHOP_2;

// Třída pro stránku s produktem
public class ProductPage {

    WebDriver driver;

    // Konstruktor pro inicializaci WebDriveru
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    // Metoda pro výběr produktu Hummingbird Printed Sweater
    public void selectHummingbirdPrintedSweater() {
        driver.findElement(By.xpath("//a[contains(text(),'Hummingbird Printed Sweater')]")).click();
    }

    // Metoda pro ověření slevy
    public boolean checkDiscount(double expectedDiscount) {
        String discountText = driver.findElement(By.xpath("//span[@class='discount-percentage']")).getText();
        double discount = Double.parseDouble(discountText.replace("%", "").trim());
        return discount == expectedDiscount;
    }

    // Metoda pro výběr velikosti
    public void selectSize(String size) {
        Select sizeDropdown = new Select(driver.findElement(By.id("group_1")));
        sizeDropdown.selectByVisibleText(size);
    }

    // Metoda pro nastavení počtu kusů
    public void setQuantity(int quantity) {
        WebElement quantityInput = driver.findElement(By.id("quantity_wanted"));
        quantityInput.clear();
        quantityInput.sendKeys(String.valueOf(quantity));
    }

    // Metoda pro přidání produktu do košíku
    public void addToCart() {
        driver.findElement(By.name("Submit")).click();
    }
}
