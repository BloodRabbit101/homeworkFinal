package pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.annotations.Element;
import pages.annotations.Page;

import java.util.ArrayList;
import java.util.Collection;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Page(title = "Главная страница", url = "https://dev.n7lanit.ru")
public class MainPage extends AbstractPage {

    static ArrayList <String> href = new ArrayList<String>();
    static int i = 0;

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

    @Element("Успешность авторизации")
    public WebElement getAutorizationChecked() {

        return $(By.xpath("//li/a/img[@class='user-avatar']"));
    }

    @Element("Случайная тема")
    public WebElement getTopic() {
        ElementsCollection collection = $$(By.xpath(".//div[@class = 'col-sm-2 col-md-2 hidden-xs']/descendant::" +
                "span[text() = 'Неактивна']/parent::button[@data-toggle = 'dropdown']"));
        return collection.get((int) (collection.size() * Math.random()));
    }

    @Element("Подписаться")
    public WebElement getSubscribe() {

        WebElement webElement = $(By.xpath(".//div[@class = 'btn-group open']/descendant::button[text() = 'Подписаться']" +
                "/ancestor::div[@class = 'row thread-row']/descendant::a[@class = 'item-title thread-title']"));
        String s = webElement.getAttribute("href").substring(22);
        href.add(s);

        return $(By.xpath(".//div[@class = 'btn-group open']/descendant::button[text() = 'Подписаться']"));
    }

    @Element("Подписки")
    public WebElement getTopics() {

        return $(By.xpath("//a[@href = '/subscribed/']"));
    }

    @Element("Подписка на тему")
    public WebElement checkSubscribe () {

        return $(By.xpath("//a[@href = '" + href.get(i) + "']"));
    }

    @Element ("Отписаться")
    public WebElement getUnsubscribe () {
        WebElement webElement = $(By.xpath(".//a[@href = '" + href.get(i++) + "']/ancestor::div[@class = " +
                "'row thread-row']/descendant::div[@class = 'col-sm-2 col-md-2 hidden-xs']/div/div[1]/" +
                "descendant::span[text() = 'Активна']/parent::button[@data-toggle = 'dropdown']"));
        webElement.click();
        return $(By.xpath(".//div[@class = 'btn-group open']/descendant::button[text() = 'Отписаться ']"));
    }
}
