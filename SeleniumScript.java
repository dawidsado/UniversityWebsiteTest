package SeleniumTestScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;

class SeleniumTestScript {
    // Using external library-Selenium I will sign into my student account and check my current schedule
    // Basic script to test the school website

    private static void loginToSchoolAccount(ChromeDriver driver){
        // Separate method to log into my gakko account,can be useful in regressive tests

        driver.get("https://adfs.pjwstk.edu.pl/adfs/oauth2/authorize/?client_id=dfbccf57-9d86-4eac-aff7-1485aee6206e&redirect_uri=https%3A%2F%2Fgakko.pja.edu.pl%2Fsignin-oidc&response_type=id_token&scope=openid%20profile&response_mode=form_post&nonce=637820867821023158.YzQ0MzMzMGMtOWQ4OS00ZDlhLWJhZWQtNWUyOTY3MzBhYjNhNjJlYjlmMmMtMjk0ZS00MGEyLTkwMTAtMzcyMTVjN2MxMThj&state=CfDJ8DB_915JIwtGkCYNHAavSAGyYB_JP3UGMTpgXzkXQNUTtxO3-D8Ac1HSE-a0pu_s0EMf5Tu10YY04F4lk1bfR8TnfYhy9RFL7NnOFBni9FF5OpVJEJg_J0kaOq_gUodpsdCuREJzX0WePUTIIxrSa_Hj7SMZY1twpjGALsQxKpMGDiLS3R4k7taB3nkESiPCcAN3aCKlPxWYtpjyz00ZOBhJ_OEAVR1A9ssUmi_DyN4HMa5TUqA8ltvOmhZt_GTrn-DZpfGzNLutj7ZXGZG9bwxms0i8qbjwgNLAzc1tgQeiWNaCHyyHqF6Fm-dIvWBJpw&x-client-SKU=ID_NETSTANDARD2_0&x-client-ver=6.8.0.0");

        WebElement emailInput = driver.findElement(By.id("userNameInput"));

        emailInput.sendKeys("s24681@pjwstk.edu.pl");

        driver.findElement(By.id("passwordInput")).sendKeys(ConstantPassword.getPassword()); //Password set as constant variable in other class

        driver.findElement(By.id("submitButton")).click();
    }

    private static void checkingMySchedule(ChromeDriver driver){
        // Another logging method to website where is located schedule of my group

        driver.get("https://gakko.pja.edu.pl/dashboard");

        driver.findElements(By.cssSelector(".kt-menu__link-text")).get(16).click();

        driver.get("https://planzajec.pjwstk.edu.pl/Logowanie.aspx");

        driver.findElement(By.id("ContentPlaceHolder1_Login1_UserName")).sendKeys("s24681");

        driver.findElement(By.id("ContentPlaceHolder1_Login1_Password")).sendKeys(ConstantPassword.getPassword());

        driver.findElement(By.id("ContentPlaceHolder1_Login1_LoginButton")).click();

        driver.findElements(By.cssSelector("a[href='#']")).get(4).click();

    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/dawidsado_/Desktop/Selenium/chromedriver");

        ChromeDriver driver = new ChromeDriver();

        // 1.
        loginToSchoolAccount(driver);

        // 2.
        checkingMySchedule(driver);




    }
}
