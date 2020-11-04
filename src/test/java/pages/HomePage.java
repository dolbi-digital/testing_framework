package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "#CybotCookiebotDialogBodyButtonAccept")
    private WebElement acceptCookie;

    @FindBy(css = "div.site-nav__icons > button.icon-menu")
    private WebElement menuItem;

    @FindBy(css = ".site-nav__menu__primary > li:nth-child(3) > button")
    private WebElement partnersItem;

    @FindBy(css = ".site-nav__menu__secondary > li:nth-child(3) > a")
    private WebElement officesItem;

    private void exWait(WebDriver driver, int sec, WebElement element) {
        new WebDriverWait(driver, sec).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void openMenu() {
        acceptCookie.click();
        exWait(driver, 10, menuItem);
        menuItem.click();
    }

    public void selectPartnersItem() {
        exWait(driver, 7, partnersItem);
        partnersItem.click();
    }

    public void selectOfficesItem() {
        exWait(driver, 10, officesItem);
        officesItem.click();
    }
}