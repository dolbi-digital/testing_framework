package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OfficesPage {
    private WebDriver driver;

    public OfficesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//li[@class='list-item' and contains(text(), 'United Kingdom')]")
    private WebElement unitedKingdomLink;

    @FindBy(xpath = "//h3[contains(text(), 'United Kingdom')]/../..//address")
    private List<WebElement> offices;

    @FindBy(css = "div.site-chapter__box > h3")
    private WebElement officesPage;

    private void exWait(WebDriver driver, int sec, WebElement element) {
        new WebDriverWait(driver, sec).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickOnUnitedKingdom() {
        exWait(driver, 15, unitedKingdomLink);
        unitedKingdomLink.click();
    }

    public void printUKOffices() {
        for(WebElement element : offices) {
            System.out.println(element.getAttribute("textContent") + "\n");
        }
    }

    public String checkPage() {
        return officesPage.getAttribute("textContent");
    }
}