package resources.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends pageBase{

    public HomePage(WebDriver driver) {
        super(driver);
    }
    String country;
    By languageBtn = By.id("translation-btn");
    By countryBtn = By.id("country");
//    By selectCountry = By.id(countryID);
    By subscriptionPlanNameLite = By.id("name-lite");
    By subscriptionPriceLite = By.xpath("//*[@id=\"currency-lite\"]/b");
    By subscriptionCurrencyLite = By.xpath("//*[@id=\"currency-lite\"]/i");

    public void navigateToURL(String url) {
        driver.get(url);
    }

    public void clickOnCountryListButton(){
        driver.findElement(countryBtn).click();
    }
    public void clickOnLanguageButton(){
        driver.findElement(languageBtn).click();
    }

    public void selectCountry(String Country){
        By countryBtn = By.id(Country);
        driver.findElement(countryBtn).click();
    }

//    public void validateSubscriptionPackages(String country) {
//        countryInput.clear();
//        countryInput.sendKeys(country);
//    }

    public String GetSubscriptionType(){
        String type = driver.findElement(subscriptionPlanNameLite).getText();

        return type;
    }

    public String GetSubscriptionPrice(){
        String price = driver.findElement(subscriptionPriceLite).getText();

        return price;
    }
    public String GetSubscriptionCurrency(){
        String currency = driver.findElement(subscriptionCurrencyLite).getText();

        return currency;
    }
}
