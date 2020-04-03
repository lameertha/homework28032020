
package testCase;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import utility.Utility;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)



public class TestCase extends Utility {


    @Before

    public void openBrowser(){
        openingChromeBrowser("https://demostore.x-cart.com/");

    }



    @Test

    public void userShouldCreateNewAccount() throws InterruptedException {

        Thread.sleep(3000);
        clickonElement(By.xpath("//div[contains(@class,'header_bar-sign_in')]//button[contains(@class,'popup-button popup-login')]"));
        clickonElement(By.xpath("//a[@class='popup-button default-popup-button create-account-link']"));
        sendRandomEmail(By.xpath("//input[@name='login']"));
        Thread.sleep(2000);
        sendRandomPassword(By.xpath("//input[@name='password']"));
        sendRandomPasswordToNextField(By.xpath("//input[@name='password_conf']"),"text");
        clickonElement(By.xpath("//div[contains(@class,'button submit')]//button[contains(@class,'submit')]"));
        String expectedText = "My account";
        String actualText = getTextFromElement(By.xpath("//h1[@class='title']"));
        Assert.assertEquals(expectedText, actualText);
        System.out.println("Expected Message On The Screen : " + expectedText);
        System.out.println("Actual Message On The Screen : " + actualText);
        clickonElement(By.xpath("//a[contains(text(),'My account')]"));
        mouseHoverToElementAndClick(By.xpath("//ul[@class='account-links dropdown-menu']//span[contains(text(),'Log out')]"));
        String expectedText1 = "Sign in / sign up";
        String actualText1 = getTextFromElement(By.xpath("//div[contains(@class,'header_bar-sign_in')]//span[contains(text(),'Sign in')]"));
        System.out.println("Expected Message On The Screen : " + expectedText1);
        System.out.println("Actual Message On The Screen : " + actualText1);
    }

    @Test
    public void userShouldLoginSuccessfully () throws InterruptedException {
        clickonElement(By.xpath("//div[contains(@class,'header_bar-sign_in')]//button[contains(@class,'popup-button popup-login')]"));
        sendRandomEmailToNextField(By.xpath("//input[@name='login']"),"text");
        sendRandomPasswordToNextField(By.xpath("//input[@name='password']"),"text");
        clickonElement(By.xpath("//table[contains(@class,'login-form')]//button[contains(@class,'submit')]"));
        Thread.sleep(2000);
        String expectedText2= "My account";
        String actualText2 = getTextFromElement(By.xpath("//div[@class=\"dropdown header_bar-my_account\"]"));
        Assert.assertEquals(expectedText2,actualText2);
        System.out.println("Expected Message On The Screen : " + expectedText2);
        System.out.println("Actual Message On The Screen : " + actualText2);
        clickonElement(By.xpath("//a[contains(text(),'My account')]"));
        mouseHoverToElementAndClick(By.xpath("//ul[@class='account-links dropdown-menu']//span[contains(text(),'Log out')]"));
        String expectedText3 = "Sign in / sign up";
        String actualText3 =getTextFromElement(By.xpath("//div[contains(@class,'header_bar-sign_in')]//span[contains(text(),'Sign in')]"));
        System.out.println("Expected Message On The Screen : " + expectedText3);
        System.out.println("Actual Message On The Screen : " + actualText3);
    }


    @After

    public void clostBrowser(){
        driver.quit();
    }

}

