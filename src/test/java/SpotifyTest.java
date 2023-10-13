import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class SpotifyTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

     try {
          driver.get("https://open.spotify.com/");

          driver.findElement(By.xpath("//button[@data-testid='login-button']")).click();

          driver.findElement(By.xpath("//input[@placeholder='Email or username']"))
                  .sendKeys("tester.in.test.b12@gmail.com", Keys.TAB, "Test123!", Keys.ENTER);
          Assert.assertTrue(driver.findElement(By.xpath("//figure[@title='Tester']")).isDisplayed());

          driver.findElement(By.linkText("Search")).click();
          driver.findElement(By.xpath("//input[@data-testid='search-input']"))
                 .sendKeys("Adele Hello",Keys.ENTER);
          driver.findElement(By.xpath("//button[@aria-label='Play']")).click();

          Assert.assertTrue(driver.findElement(By.xpath("//a[@data-testid='context-item-link']")).getText()
                 .equals("Hello"));
          Assert.assertTrue(driver.findElement(By.xpath("//a[@data-testid='context-item-info-artist']")).
                 getText().equals("Adele"));
          driver.findElement(By.xpath("//div[@data-testid='placeholder-wrapper']")).click();
          driver.findElement(By.xpath("//button[@data-testid='user-widget-dropdown-logout']")).click();
          Assert.assertTrue(driver.findElement(By.xpath("//button[@data-testid='login-button']")).isDisplayed());

     }finally {
                 driver.quit();
        }

    }
}
