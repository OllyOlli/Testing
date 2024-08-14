package Desktop.WORK_SHOP_1;

 org.openqa.selenium.By;

public class NewAddressFormPage {

    WebDriver driver;
    WebDriverWait wait;

    public NewAddressFormPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void enterAlias(String alias) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alias"))).sendKeys(alias);
    }

    public void enterAddress(String address) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address1"))).sendKeys(address);
    }

    public void enterCity(String city) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("city"))).sendKeys(city);
    }

    public void enterZipPostalCode(String postalCode) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("postcode"))).sendKeys(postalCode);
    }

    public void selectCountry(String country) {
        Select countryDropdown = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_country"))));
        countryDropdown.selectByVisibleText(country);
    }

    public void enterPhone(String phone) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone"))).sendKeys(phone);
    }

    public void saveAddress() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='submitAddress']"))).click();
    }

    public void fillAndSaveNewAddress(String alias, String address, String city, String postalCode, String country, String phone) {
        enterAlias(alias);
        enterAddress(address);
        enterCity(city);
        enterZipPostalCode(postalCode);
        selectCountry(country);
        enterPhone(phone);
        saveAddress();
    }
}
