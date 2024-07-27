package bdd.webdriver;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class DOM {

    // static String screenshotDir = "C:\\Users\\cgarcia\\Documents\\Producción TI\\DevOps\\Selenium\\Java\\selenium-cucumber-jenkins-main\\src\\test\\resources\\evidencias\\";
    static String screenshotDir = "C:\\Users\\crist\\Documents\\Testing\\Evidencias\\"; //Server-1
    // static String screenshotDir = "C:\\Users\\Usuario\\Documents\\Testing\\Evidencias\\"; //Server-2

    private static WebDriver driver;

    public static WebDriver webDriver() {
        if (driver == null) {
            // String chromeDriverPath = "C:\\Users\\cgarcia\\Documents\\Producción TI\\DevOps\\Selenium\\Java\\selenium-cucumber-jenkins-main\\src\\test\\resources\\webdriver\\chromedriver.exe";
            String chromeDriverPath = "C:\\Users\\crist\\Documents\\Testing\\chromedriver.exe"; //Server-1
            // String chromeDriverPath = "C:\\Users\\Usuario\\Documents\\Testing\\chromedriver.exe"; //Server-2
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            driver = new ChromeDriver();
        }
        return driver;
    }

    public DOM() {
        PageFactory.initElements(webDriver(), this);
    }

    public static void inciarNavegador(String url) {
        webDriver().get(url);
        webDriver().manage().window().maximize();
    }


    public void takeScreenShot(Scenario scenario) {

        try {
            final byte[] screenshot = ((TakesScreenshot) webDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Captura de pantalla");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onclick(WebElement element) {
        element.click();
    }

    public void type(WebElement element, String text) {
        element.sendKeys(text);
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public void quitDriver() {
        webDriver().quit();
    }

}
