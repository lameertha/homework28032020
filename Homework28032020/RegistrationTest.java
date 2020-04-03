package Homework28032020;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utility.Utility;

import java.util.concurrent.TimeUnit;

import static junit.runner.Version.id;

public class RegistrationTest extends Utility {
    private String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void openbrowser(){
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        driver = new ChromeDriver(options);
        driver.manage().window().setPosition(new Point(-2000, 0));//display 2
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }
    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
        clickonElement(By.xpath("//a[@class='ico-register']"));
        String expectedText = "Your Personal Details";
        String actualText = getTextFromElement(By.xpath("//strong[contains(text(),'Your Personal Details')]"));
        Assert.assertEquals(expectedText,actualText);
        System.out.println("Expected message on the screen:" + expectedText);
        System.out.println("Actual message on the screen:" + actualText);
    }
    @Test
    public void verifyUserShouldRegisterSuccessfully(){
        clickonElement(By.xpath("//a[@class='ico-register']"));
        mouseHoverToElementAndClick(By.xpath("//input[@id='gender-female']"));
        sendTextToElement(By.id("FirstName"),"LAMEERTHA");
        sendTextToElement(By.id("LastName"),"THEVARAJAH");
        sendRandomEmailToNextField(By.id("Email"),"lamee58@gmail.com");
        sendRandomPasswordToNextField(By.id("Password"), "lamee123");
        sendTextToElement(By.id("ConfirmPassword"),"lamee123");
        clickonElement(By.id("register-button"));
        String expectedText= "Your registration completed";
        String actualText = getTextFromElement(By.xpath("//div[@class='result']"));
        Assert.assertEquals(expectedText,actualText);
        System.out.println("Expected message on the screen:" + expectedText);
        System.out.println("Actual message on the screen:" + actualText);
    }
    @After
    public void closebrowser(){
        driver.quit();
    }
}
