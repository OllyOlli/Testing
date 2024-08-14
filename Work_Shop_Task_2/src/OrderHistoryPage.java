package WORK_SHOP_2;

// Třída pro stránku historie objednávek
public class OrderHistoryPage {

    WebDriver driver;

    // Konstruktor pro inicializaci WebDriveru
    public OrderHistoryPage(WebDriver driver) {
        this.driver = driver;
    }

    // Metoda pro přechod na historii objednávek
    public void goToOrderHistory() {
        driver.findElement(By.xpath("//a[@title='Orders']")).click();
    }

    // Metoda pro ověření stavu objednávky a částky
    public boolean verifyOrder(String expectedStatus, String expectedAmount) {
        String orderStatus = driver.findElement(By.xpath("//span[contains(text(), 'Awaiting check payment')]")).getText();
        String orderAmount = driver.findElement(By.xpath("//td[@class='history_price']")).getText();
        return orderStatus.equals(expectedStatus) && orderAmount.contains(expectedAmount);
    }
}
