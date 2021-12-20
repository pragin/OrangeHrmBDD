package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BrowserManager extends BasePage{
//    Decide if browser during runtime / hardcoded
//    String browserName = "chrome";
    String browserName = System.getProperty("browser");

    Boolean inCloud = false;
//    Boolean getInCloud = Boolean.parseBoolean(System.getProperty("cloud"));

    @BeforeMethod
    public void openBrowser(){
        if(inCloud){

        }else {
            if(browserName.equalsIgnoreCase("chrome")){
                System.setProperty("webdriver.chrome.driver","src/test/java/drivers/chromedriver.exe");
                driver = new ChromeDriver();
            }else if(browserName.equalsIgnoreCase("edge")){
                System.setProperty("webdriver.edge.driver","src/test/java/drivers/msedgedriver.exe");
                driver = new EdgeDriver();
            }else if(browserName.equalsIgnoreCase("firefox")){
                System.setProperty("webdriver.geko.driver","src/test/java/drivers/geckodriver.exe");
                driver = new FirefoxDriver();
            }else{
                System.out.format("Incorrect browser name : %s ", browserName  );
            }
        }
    }

    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }


}
