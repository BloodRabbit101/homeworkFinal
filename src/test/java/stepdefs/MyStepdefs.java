package stepdefs;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import cucumber.api.java.ru.И;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class MyStepdefs {

    @И("^Открываем ресурс, проходим авторизацию$")
    public void открываемРесурсПроходимАвторизацию() {
        open("https://dev.n7lanit.ru/");
        $(By.xpath("//button[@class='btn navbar-btn btn-default btn-sign-in']")).should(Condition.visible).click();
        $(By.xpath("//div/input[@type='text']")).sendKeys("Olga");
        $(By.xpath("//div/input[@type='password']")).sendKeys("wuhnyq-gojfex-ronhE8");
        $(By.xpath("//button[@class='btn btn-primary btn-block']")).pressEnter();
    }

    @И("Проверяем что авторизация выполнена успешно")
    public void проверяемЧтоАвторизацияВыполненаУспешно() {
        $(By.xpath("//li/a/img[@class='user-avatar']")).should(Condition.visible);
    }

    @И("Выбираем случайную тему, не являющуюся опросом, открываем ее")
    public void выбираемСлучайнуюТемуНеЯвляющуюсяОпросомОткрываемЕе() {
        ElementsCollection collection = $$(By.xpath(".//span[1][@class='thread-detail-replies']" +
                "/ancestor::div[@class='media-body']/a"));
        collection.get((int) (collection.size() * Math.random())).click();
    }

    @И("Нажимаем на кнопку «Ответить»")
    public void нажимаемНаКнопкуОтветить() {
        $(By.xpath("//button[@class='btn btn-primary btn-block btn-outline']")).should(Condition.visible).click();
    }

    @И("Вводим текст, нажимаем на кнопку «отправить»")
    public void вводимТекстНажимаемНаКнопкуОтправить() {
        $(By.xpath("//textarea")).sendKeys("Я пригласил вас, господа, с тем, чтобы сообщить вам " +
                "пренеприятное известие: к нам едет ревизор.");
        $(By.xpath("//button[@type='submit']")).click();
    }

    @И("Проверяем, что сообщение отображается в теме")
    public void проверяемЧтоСообщениеОтображаетсяВТеме() {
        $(By.xpath(".//p[text()='Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам " +
                "едет ревизор.']/ancestor::li/descendant::a[@class='item-title' and @href='/u/olga/138/']"))
                .should(Condition.visible);
    }

    @И("Переходим на вкладку «Темы»")
    public void переходимНаВкладкуТемы() {
        $(By.xpath("//a[text()='Темы']")).click();
    }
}
