package Desktop.WORK_SHOP_1;

public class TestNewAddress {

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testAddNewAddress() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php");

        // Přihlášení uživatele
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAsUser("test@test.com", "123456"); // email a heslo

        // Kliknutí na dlaždici Adresy a vytvoření nové adresy
        AddressesPage addressesPage = new AddressesPage(driver);
        addressesPage.clickAddressesTile();
        addressesPage.clickCreateNewAddress();

        // Vyplnění a uložení nové adresy
        NewAddressFormPage newAddressFormPage = new NewAddressFormPage(driver);
        newAddressFormPage.fillAndSaveNewAddress("TestAlias", "TestAddress", "TestCity", "12345", "United States", "123456789");

        // Ověření správnosti přidané adresy
        AddressVerificationPage verificationPage = new AddressVerificationPage(driver);
        assertTrue(verificationPage.verifyAddress("TestAlias", "TestAddress", "TestCity", "12345", "United States", "123456789"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
