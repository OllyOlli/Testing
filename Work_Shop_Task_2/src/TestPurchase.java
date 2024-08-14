package WORK_SHOP_2;

import java.io.IOException;


// Hlavní třída pro testování nákupu
public class TestPurchase {

    WebDriver driver;

    @Before
    public void setup() {
        // Inicializace WebDriveru (nahraď svým nastavením pro WebDriver)
        System.setProperty("webdriver.chrome.driver", "\"C:\\Users\\olgah\\Desktop\\chromedriver.exe\"");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testHummingbirdSweaterPurchase() throws IOException {
        driver.get("https://mystore-testlab.coderslab.pl/index.php");

        // Přihlášení uživatele
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAsUser("test@test.com", "123456"); // nahraď emailem a heslem

        // Výběr produktu a kontrola slevy
        ProductPage productPage = new ProductPage(driver);
        productPage.selectHummingbirdPrintedSweater();
        assertTrue(productPage.checkDiscount(20.0)); // Ověření slevy 20%

        // Výběr velikosti, nastavení počtu a přidání do košíku
        productPage.selectSize("M"); // Parametrizovatelná velikost
        productPage.setQuantity(5); // Parametrizovatelný počet kusů
        productPage.addToCart();

        // Přechod k pokladně
        CartPage cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();

        // Potvrzení adresy, výběr doručení a platby
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.confirmAddress();
        checkoutPage.chooseDeliveryMethod();
        checkoutPage.selectPayByCheck();
        checkoutPage.confirmOrder();

        // Pořízení screenshotu potvrzení objednávky
        checkoutPage.takeScreenshot("order_confirmation.png");

        // Ověření objednávky v historii
        OrderHistoryPage orderHistoryPage = new OrderHistoryPage(driver);
        orderHistoryPage.goToOrderHistory();
        assertTrue(orderHistoryPage.verifyOrder("Awaiting check payment", "1000")); // nahraď očekávanou částkou
    }

    @After
    public void tearDown() {
        // Zavření prohlížeče
        driver.quit();
    }
}
