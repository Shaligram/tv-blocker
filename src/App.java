import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import java.time.Duration;




public class App {

    //private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws Exception {
       // System.setProperty("webdriver.chrome.driver",
        //      "D://Personal//Airtel//zip//chromedriver-win64-119//chromedriver-win64//chromedriver.exe");

        System.setProperty("webdriver.chrome.driver",
                "D://rough//chromedriver-win64//chromedriver.exe");
                
                

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
        options.setBinary("C:\\Users\\prakashsh\\AppData\\Local\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
        /*
         * options.addArguments("--allow-running-insecure-content");
         * options.addArguments("--test-type");
         * options.addArguments("--start-maximized");
         * options.addArguments("disable-infobars");
         */
        options.addArguments("--ignore-certificate-errors");
        //options.addArguments("--headless");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://192.168.1.1/");
        // driver.findElement(By.id("details-button")).click();
        // driver.findElement(By.id("proceed-link")).click();
        // explicit wait - to wait for the compose button to be click-able
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='btn_login']")));

        WebElement txtname = driver.findElement(By.xpath("//*[@class='username']"));
        txtname.sendKeys("admin");
        WebElement txtpass = driver.findElement(By.xpath("//*[@class='password']"));
        txtpass.sendKeys("admin");
        WebElement btn = driver.findElement(By.xpath("//*[@class='btn_login']"));
        btn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Security')]")));
        System.out.println("Login Success");

        driver.findElement(By.xpath("//span[contains(text(),'Security')]")).click();
        driver.findElement(By.xpath("//*[text()='MAC Filter']")).click();
        Thread.sleep(3000);
       
        System.out.println(args[0]);
        int n = Integer.parseInt(args[0]);

        if(n==1)
        {
            /* https://www.selenium.dev/documentation/webdriver/waits/ */
            driver.findElement(By.xpath("//*[@name='add']")).click();
            Select mac = new Select(driver.findElement(By.xpath("//*[@name='hostName']")));
            mac.selectByValue("N/A(D4:91:aa:aa:aa:66)");
            driver.findElement(By.name("btnApply")).click();
            Thread.sleep(2000);
            System.out.println("added");
        } else {
            driver.findElement(By.xpath("//*[text()='D4:91:aa:aa:aa:66']")).click();
            driver.findElement(By.xpath("//*[@name='delete']")).click();
            System.out.println("deleted");
        }

        driver.findElement(By.xpath("//*[text()='Logout']")).click();
        Thread.sleep(1000);
        System.out.println("logout");
        driver.close();

    }
}