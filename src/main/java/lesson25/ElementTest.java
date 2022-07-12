package lesson25;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementTest {
    String url = "https://demoqa.com/elements";

    @Test
    public void workWithElement() {
        System.setProperty("webdriver.chrome.driver","D:\\Learning\\RobotDreams\\Chromdriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get(url);
        driver.findElement(By.id("item-4")).click();
        driver.findElement(By.xpath("//button[text()='Click Me']")).click();
        String dynamicMessage = driver.findElement(By.xpath("//p[@id='dynamicClickMessage']")).getText();
        System.out.println(dynamicMessage);
        driver.quit();
    }
}
