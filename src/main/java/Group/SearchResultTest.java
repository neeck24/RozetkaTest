package Group;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultTest {
    private WebDriver driver;
    private final By buyButton = By.name("topurchasesfromcatalog");
    public SearchResultTest(WebDriver driver){
        this.driver = driver;
    }
    public String getSearchMessage(){
        return driver.findElement(By.cssSelector(".search-result-title-text")).getText();
    }
    public void addFirstItemCart(){
        driver.findElement(buyButton).click();
    }
}
