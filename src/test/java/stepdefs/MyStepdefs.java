package stepdefs;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import cucumber.api.java.ru.И;
import org.openqa.selenium.By;

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

    @И("На странице {string} нажимаем на кнопку {string}, вводим логин {string} {string} и " +
            "пароль {string} {string}, авторизуемся {string}")
    public void наСтраницеНажимаемНаКнопкуВводимЛогинИПарольАвторизуемся(String title, String tabName, String login,
                                                                         String name, String password,
                                                                         String passwordValue, String send) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        getPageByTitle(title).getElementByName(tabName).click();
        getPageByTitle(title).getElementByName(login).sendKeys(name);
        getPageByTitle(title).getElementByName(password).sendKeys(passwordValue);
        getPageByTitle(title).getElementByName(send).click();
    }

    @И("На странице {string} проверяем успешность авторизации {string}")
    public void наСтраницеПроверяемУспешностьАвторизации(String title, String check) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        getPageByTitle(title).getElementByName(check).isDisplayed();
    }

    @И("На странице {string} выбираем случайную тему {string}")
    public void наСтраницеВыбираемСлучайнуюТему(String title, String topic) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        getPageByTitle(title).getElementByName(topic).click();
    }

    @И("На странице {string} нажимаем на кнопку {string}")
    public void наСтраницеНажимаемНаКнопку(String title, String reply) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        getPageByTitle(title).getElementByName(reply).click();
    }

    @И("На странице {string} в поле {string} вводим {string}, нажимаем на кнопку {string}")
    public void наСтраницеВПолеВводимНажимаемНаКнопку(String title, String textArea, String text, String send) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        getPageByTitle(title).getElementByName(textArea).sendKeys(text);
        getPageByTitle(title).getElementByName(send).click();
    }

    @И("Проверяем отображение сообщения {string} на странице {string}")
    public void проверяемОтображениеСообщенияНаСтранице(String message, String title) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        getPageByTitle(title).getElementByName(message).isDisplayed();
    }

    @И("Переходим на вкладку {string} на странице {string}")
    public void переходимНаВкладкуНаСтранице(String topics, String title) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        getPageByTitle(title).getElementByName(topics).click();
    }
}
