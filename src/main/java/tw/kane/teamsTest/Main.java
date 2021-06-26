package tw.kane.teamsTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\chromedriver.exe"
        );

        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");

        System.out.println(driver.getTitle());
    }
}
