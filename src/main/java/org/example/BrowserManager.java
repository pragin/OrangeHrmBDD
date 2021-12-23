package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserManager extends BasePage{
//    Decide if browser during runtime / hardcoded
    String browserName = "edge";
//    String browserName = System.getProperty("browser");

    Boolean inCloud = false;
//    Boolean getInCloud = Boolean.parseBoolean(System.getProperty("cloud"));

//    Browserstack config
    public static final String AUTOMATE_USERNAME = "prag_5lCXPe";
    public static final String AUTOMATE_ACCESS_KEY = "T9bWxLzv28xBw7zH2rnw";
    public static final String BROWSERSTACK_URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    LoadProp loadProp = new LoadProp();

    public void openBrowser(){

        if(inCloud){
            DesiredCapabilities caps = new DesiredCapabilities();

            if(browserName.equalsIgnoreCase("chrome")){
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("browser", "Chrome");
                caps.setCapability("browser_version", "latest");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "3.14.0");
            }else if(browserName.equalsIgnoreCase("edge")){
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("browser", "Edge");
                caps.setCapability("browser_version", "latest");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "3.14.0");

            }else if(browserName.equalsIgnoreCase("firefox")){
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("browser", "Firefox");
                caps.setCapability("browser_version", "latest");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "3.10.0");
            }else if(browserName.equalsIgnoreCase("safari")){
                caps.setCapability("os", "OS X");
                caps.setCapability("os_version", "Catalina");
                caps.setCapability("browser", "Safari");
                caps.setCapability("browser_version", "13.0");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "3.14.0");
            }else{
                System.out.format("Incorrect browser : %s",browserName);
            }


            try {
                driver = new RemoteWebDriver(new URL(BROWSERSTACK_URL), caps);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

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

        //Maximise the browser window
        driver.manage().window().maximize();
        //Wait for homepage to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Type Url
        driver.get(loadProp.getProperty("url"));
    }

    public void closeBrowser(){
//        driver.close();
    }


}
