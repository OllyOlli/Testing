package Desktop.WORK_SHOP_1;

public class AddressVerificationPage {

    WebDriver driver;
    WebDriverWait wait;

    public AddressVerificationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public boolean verifyAddress(String alias, String address, String city, String postalCode, String country, String phone) {
        String displayedAlias = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='page-subheading']"))).getText();
        String displayedAddress = driver.findElement(By.xpath("//span[@class='address_address1']")).getText();
        String displayedCityAndPostalCode = driver.findElement(By.xpath("//span[@class='address_city']")).getText();
        String displayedCountry = driver.findElement(By.xpath("//span[@class='address_country_name']")).getText();
        String displayedPhone = driver.findElement(By.xpath("//span[@class='address_phone']")).getText();

        return displayedAlias.contains(alias) &&
                displayedAddress.equals(address) &&
                displayedCityAndPostalCode.contains(city) &&
                displayedCityAndPostalCode.contains(postalCode) &&
                displayedCountry.equals(country) &&
                displayedPhone.equals(phone);
    }
}
