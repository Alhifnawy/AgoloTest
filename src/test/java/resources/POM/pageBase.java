//package resources.POM;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.PageFactory;
//
//public class pageBase {
//
//    protected WebDriver driver;
//
//    public pageBase(WebDriver driver) {
//        PageFactory.initElements(driver, this);
//    }
//}

package resources.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class pageBase {

    protected WebDriver driver;

    public pageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}