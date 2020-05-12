package stepdefs;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import cucumber.api.java.ru.И;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.MainPage;

import java.lang.reflect.InvocationTargetException;

import static com.codeborne.selenide.SelenideElement.*;
import static com.codeborne.selenide.Selenide.*;
import static pages.AbstractPage.getPageByTitle;
import static pages.AbstractPage.getUrlByTitle;

public class MyStepdefs {

    @И("Открываем страницу {string}")
    public void открываемСтраницу(String site) throws ClassNotFoundException {
        open(getUrlByTitle(site));
    }

    @И("На странице {string} нажимаем на кнопку {string}")
    public void наСтраницеНажимаемНаКнопку(String title, String button) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException, InterruptedException {
        getPageByTitle(title).getElementByName(button).click();
        Thread.sleep(1000);
    }

    @И("На странице {string} вводим логин {string} {string}")
    public void наСтраницеВводимЛогин(String title, String login, String name) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        getPageByTitle(title).getElementByName(login).sendKeys(name);
    }

    @И("На странице {string} пароль {string} {string}")
    public void наСтраницеПароль(String title, String password, String passwordValue) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        getPageByTitle(title).getElementByName(password).sendKeys(passwordValue);
    }

    @И("На странице {string} авторизуемся {string}")
    public void наСтраницеАвторизуемся(String title, String send) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        getPageByTitle(title).getElementByName(send).click();
    }

    @И("На странице {string} проверяем {string}")
    public void наСтраницеПроверяем(String title, String check) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        getPageByTitle(title).getElementByName(check).isDisplayed();
    }

    @И("На странице {string} выбираем случайную тему {string}")
    public void наСтраницеВыбираемСлучайнуюТему(String title, String topic) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException, InterruptedException {
        getPageByTitle(title).getElementByName(topic).click();
        Thread.sleep(1000);
    }

    @И("На странице {string} переходим на вкладку {string}")
    public void наСтраницеПереходимНаВкладку(String title, String subscribes) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException, InterruptedException {
        getPageByTitle(title).getElementByName(subscribes).click();
        Thread.sleep(1000);
    }
}
