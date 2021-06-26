package tw.kane.teamsTest;

public class Main {
    public static void main(String[] args) {
        System.setProperty(
                "webdriver.chrome.driver",
                System.getenv("CHROME_DRIVER")
        );

        if(args.length == 0) {
            System.out.println("please enter chrome thread amount");
            return;
        }

        int threadCount = Integer.parseInt(args[0]);

        for(int i = 1; i <= threadCount; i++)
            new Chrome(i).start();
    }
}
