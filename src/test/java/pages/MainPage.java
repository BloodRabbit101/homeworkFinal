package pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.annotations.Element;
import pages.annotations.Page;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Page(title = "Главная страница", url = "https://dev.n7lanit.ru")
public class MainPage extends AbstractPage {

    @Element("Войти")
    public WebElement getEnterTab() {

        return $(By.xpath("//button[@class='btn navbar-btn btn-default btn-sign-in']"));
    }

    @Element("Логин")
    public WebElement getLogin() {

        return $(By.xpath("//div/input[@type='text']"));
    }

    @Element("Пароль")
    public WebElement getPassword() {

        return $(By.xpath("//div/input[@type='password']"));
    }

    @Element("Авторизация")
    public WebElement getAutorization() {

        return $(By.xpath("//button[@class='btn btn-primary btn-block']"));
    }

    @Element("Проверка авторизации")
    public WebElement getAutorizationChecked() {

        return $(By.xpath("//li/a/img[@class='user-avatar']"));
    }

    @Element("Тема")
    public WebElement getTopic() {
        ElementsCollection collection = $$(By.xpath(".//span[1][@class='thread-detail-replies']" +
                "/ancestor::div[@class='media-body']/a"));
        return collection.get((int) (collection.size() * Math.random()));
    }

    @Element("Темы")
    public WebElement getTopics() {

        return $(By.xpath("//ul[@class='nav navbar-nav']/li/a[@href = '/']"));
    }
}
