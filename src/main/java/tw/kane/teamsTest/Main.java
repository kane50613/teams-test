package tw.kane.teamsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\chromedriver.exe"
        );

        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get(System.getenv("URL"));

        driver.findElement(By.id("openTeamsClientInBrowser")).click();
        System.out.println("clicked first");
        driver.findElement(By.cssSelector("a[track-name=\"1104\"]")).click();
        System.out.println("clicked second");
    }
}
