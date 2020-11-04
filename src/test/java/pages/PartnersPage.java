package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class PartnersPage {
    private WebDriver driver;

    public PartnersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "a.button--primary-hollow[data-om-navcta='Partners']")
    private WebElement ourPartnersButton;

    @FindBy(css = ".partners-block__logo")
    private List<WebElement> partners;

    @FindBy(xpath = "//h3[contains(text(), 'Partners')]")
    private WebElement partnersPage;

    public void clickOnOurPartnersButton() {
        ourPartnersButton.click();
    }

    public void printPartners() {
        ArrayList<String> names = new ArrayList<String>();
        for (WebElement partner : partners) {
            names.add(partner.getAttribute("href").substring(39, partner.getAttribute("href").length() - 1));
        }

        Set<String> filtered = new LinkedHashSet<String>(names);
        for (String s : filtered) {
            System.out.println(s.substring(0, 1).toUpperCase() + s.substring(1));
        }
    }

    public String checkPage() {
        return partnersPage.getAttribute("textContent");
    }
}