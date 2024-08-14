package Desktop.WORK_SHOP_1;

public class AddressesPage {

    WebDriver driver;
    WebDriverWait wait;

    public AddressesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void clickAddressesTile() {
        WebElement addressesTile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Addresses']")));
        addressesTile.click();
    }

    public void clickCreateNewAddress() {
        WebElement createNewAddressButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-link-action='add-address']")));
        createNewAddressButton.click();
    }
}
