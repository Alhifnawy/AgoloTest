package Web;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;

public class WebTest extends TestBase {

    @Test
    public void validateSubscriptionPackagesForEG() {
        test = extent.createTest("Validate Subscription Packages For EG");

        homePage.clickOnCountryListButton();
        homePage.selectCountry("eg");
        homePage.clickOnLanguageButton();

        String subType = homePage.GetSubscriptionType();
        String subPrice = homePage.GetSubscriptionPrice();
        String subCurrency = homePage.GetSubscriptionCurrency();

        writeToNotepad("Egypt:");
        writeToNotepad(subType);
        writeToNotepad(subPrice);
        writeToNotepad(subCurrency);

        test.log(Status.PASS, "Test Passed.");
    }
    @Test
    public void validateSubscriptionPackagesForUAE() {
        test = extent.createTest("Validate Subscription Packages For UAE");
        homePage.clickOnCountryListButton();
        homePage.selectCountry("sdfg");
        homePage.clickOnLanguageButton();

        String subType = homePage.GetSubscriptionType();
        String subPrice = homePage.GetSubscriptionPrice();
        String subCurrency = homePage.GetSubscriptionCurrency();

        writeToNotepad("UAE:");
        writeToNotepad(subType);
        writeToNotepad(subPrice);
        writeToNotepad(subCurrency);
        test.log(Status.PASS, "Test Passed");
    }
    @Test
    public void validateSubscriptionPackagesForYemen() {
        test = extent.createTest("Validate Subscription Packages For YEMEN");
        homePage.clickOnCountryListButton();
        homePage.selectCountry("ye");
        homePage.clickOnLanguageButton();

        String subType = homePage.GetSubscriptionType();
        String subPrice = homePage.GetSubscriptionPrice();
        String subCurrency = homePage.GetSubscriptionCurrency();

        writeToNotepad("Yemen:");
        writeToNotepad(subType);
        writeToNotepad(subPrice);
        writeToNotepad(subCurrency);
    }


    private static void writeToNotepad(String subscriptionDetails){
        String filename = "D:\\Company Interviews\\Agolo\\Automation\\subscription_details.txt";

        try {
            // Create a FileWriter object
            FileWriter writer = new FileWriter(filename, true);

            // Write text to the file
            writer.write("\n" + subscriptionDetails);

            // Close the writer
            writer.close();

            System.out.println("Text has been written to the Notepad file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
