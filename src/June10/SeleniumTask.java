package June10;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;


public class SeleniumTask {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/vafa/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15000));

        driver.get("http://qa-duotify.us-east-2.elasticbeanstalk.com/register.php");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Welcome to Duotify!";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        Thread.sleep(4000);

        driver.findElement(By.id("hideLogin")).click();
        int num = (int) (3+Math.random()*999);

        driver.findElement(By.name("username")).sendKeys("vafahuseynli" + num);
        driver.findElement(By.name("firstName")).sendKeys("Vafa");
        driver.findElement(By.name("lastName")).sendKeys("Huseynli");

        int num1 = (int) (3+Math.random()*999);

        driver.findElement(By.name("email")).sendKeys("vafa" + num1 + "huseynli" + num1 + "@gmail.com");
        driver.findElement(By.name("email2")).sendKeys("vafa" + num1 + "huseynli" + num1 + "@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys("Mydecember92");
        driver.findElement(By.name("password2")).sendKeys("Mydecember92");

        driver.findElement(By.name("registerButton")).click();

        String actualURL = driver.getPageSource();
        String expectedURL = "http://qa-duotify.us-east-2.elasticbeanstalk.com/browse.php?";
        Assert.assertFalse(actualURL.contains(expectedURL));

        String username = driver.findElement(By.id("nameFirstAndLast")).getText();
        Assert.assertFalse(username.contains("vafa huseynli"));
        Thread.sleep(4000);
        driver.findElement(By.id("nameFirstAndLast")).click();
        Thread.sleep(4000);
        username = driver.findElement(By.className("userInfo")).getText();
        Assert.assertFalse(username.contains("vafa huseynli"));
        Thread.sleep(4000);
        driver.findElement(By.id("rafael")).click();

        actualURL = driver.getPageSource();
        expectedURL = "http://qa-duotify.us-east-2.elasticbeanstalk.com/browse.php";
        Assert.assertFalse(actualURL.contains(expectedURL));
        Thread.sleep(4000);

        driver.findElement(By.id("loginUsername")).sendKeys("vafahuseynli");
        driver.findElement(By.id("loginPassword")).sendKeys("Mydecember92");
        driver.findElement(By.name("loginButton")).click();
        String title = driver.getTitle();
        Assert.assertFalse(title.contains("You Might Also Like"));
        driver.findElement(By.id("nameFirstAndLast")).click();
        Thread.sleep(4000);
        driver.findElement(By.id("rafael")).click();
        driver.quit();



    }
}

