package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.*;


public class AppTest 
{
    @Before
    public void before(){

        System.setProperty("webdriver.chrome.driver", "/Users/BR/Documents/Java/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-save-password-bubble");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);

    }

    @After
    public void after(){
        System.out.println("Тест завершен");
        WebDriverRunner.closeWebDriver();
    }
    @Test
    public void logInAndLeaveInTwoRandomTopicsMessage() throws InterruptedException {

        // Шаг 1
        open("https://dev.n7lanit.ru/");
        $(By.xpath("//button[@class='btn navbar-btn btn-default btn-sign-in']")).should(Condition.visible).click();
        $(By.xpath("//div/input[@type='text']")).sendKeys("Olga");
        $(By.xpath("//div/input[@type='password']")).sendKeys("wuhnyq-gojfex-ronhE8");
        $(By.xpath("//button[@class='btn btn-primary btn-block']")).pressEnter();

        // Шаг 2
        $(By.xpath("//li/a/img[@class='user-avatar']")).should(Condition.visible);

        // Шаг 8
        for (int i=0; i<2; i++) {
            // Шаг 3
            ElementsCollection collection = $$(By.xpath(".//span[1][@class='thread-detail-replies']" +
                    "/ancestor::div[@class='media-body']/a"));
            collection.get((int) (collection.size() * Math.random())).click();

            // Шаг 4
            $(By.xpath("//button[@class='btn btn-primary btn-block btn-outline']")).should(Condition.visible).click();

            // Шаг 5
            $(By.xpath("//textarea")).sendKeys("Я пригласил вас, господа, с тем, чтобы сообщить вам " +
                    "пренеприятное известие: к нам едет ревизор.");
            $(By.xpath("//button[@type='submit']")).click();

            // Шаг 6
            $(By.xpath(".//p[text()='Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам " +
                    "едет ревизор.']/ancestor::li/descendant::a[@class='item-title' and @href='/u/olga/138/']"))
                    .should(Condition.visible);

            // Шаг 7
            $(By.xpath("//a[text()='Темы']")).click();
        }
    }
}
