package tw.kane.teamsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Chrome extends Thread {

    int id;
    String prefix;

    public Chrome(int id) {
        this.id = id;
        this.prefix = String.format("[%s]", id);
    }

    @Override
    public void run() {
        System.out.println("[+] Start init thread " + id);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--mute-audio");
        options.setHeadless(true);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get(System.getenv("TEAMS"));
        System.out.println(prefix + " connected");

        driver.findElement(By.id("openTeamsClientInBrowser")).click();
        System.out.println(prefix + " clicked first");
        driver.findElement(By.cssSelector("a[track-name=\"1104\"]")).click();
        System.out.println(prefix + " clicked second");

        Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));

        while(true) {
            try {
                Thread.sleep(Long.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
