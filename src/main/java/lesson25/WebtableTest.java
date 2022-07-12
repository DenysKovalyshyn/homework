package lesson25;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class WebtableTest {
    String url = "https://demoqa.com/webtables";

    @Test
    public void workWithWebTable() {
        System.setProperty("webdriver.chrome.driver","D:\\Learning\\RobotDreams\\Chromdriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get(url);
        driver.findElement(By.id("addNewRecordButton")).click();
        // adding new record
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Denys");
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Kovalyshyn");
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("test@t.com");
        driver.findElement(By.xpath("//input[@id='age']")).sendKeys("33");
        driver.findElement(By.xpath("//input[@id='salary']")).sendKeys("100");
        driver.findElement(By.xpath("//input[@id='department']")).sendKeys("TestLab");
        driver.findElement(By.xpath("//*[@id='submit']")).click();
        //checking if new record is visible
        driver.findElement(By.xpath("//*[contains(text(), 'TestLab')]"));
        //editing record
        driver.findElement(By.xpath("//span[@id='edit-record-4']")).click();
        driver.findElement(By.xpath("//input[@id='department']")).clear();
        driver.findElement(By.xpath("//input[@id='department']")).sendKeys("TestLab brand NEW");
        driver.findElement(By.xpath("//*[@id='submit']")).click();
        //check if edited data is visible
        driver.findElement(By.xpath("//*[contains(text(), 'TestLab brand NEW')]"));

        driver.quit();
    }
}
