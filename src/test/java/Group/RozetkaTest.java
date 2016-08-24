package Group;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class RozetkaTest {
    WebDriver driver;
    MainPage mainPage;
    SearchResultTest searchResultTest;
    Cart cart;

    @Before
    public void precondition(){
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage = new MainPage(driver);
        searchResultTest = new SearchResultTest(driver);
        cart = new Cart(driver);
    }

    @Test
    public void serchRozetka(){
        mainPage.open();
        mainPage.searchProduct("розетка");
        Assert.assertEquals("розетка", searchResultTest.getSearchMessage());
    }

    @Test
    public void checkPriceCart() throws InterruptedException {
        mainPage.open();
        mainPage.searchProduct("iphone");
        searchResultTest.addFirstItemCart();
        cart.waitForCart();
        Integer priceForOne = new Integer(cart.getPrice());
        cart.increaseQuantity();
        Integer priceForTwo =  new Integer(cart.getPrice());
        Assert.assertEquals(new Integer(priceForOne * 2), priceForTwo);
    }

    @After
    public void postcondition(){
        driver.quit();
    }
}
