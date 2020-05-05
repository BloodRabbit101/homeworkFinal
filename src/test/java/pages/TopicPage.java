package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.annotations.Element;
import pages.annotations.Page;

import java.lang.reflect.Method;

import static com.codeborne.selenide.Selenide.$;

@Page(title = "Случайная тема", url = "https://dev.n7lanit.ru/t")
public class TopicPage extends AbstractPage {

    @Element("Ответить")
    public WebElement getReply() {
        return $(By.xpath("//div[@class='col-xs-6 col-sm-4']/button"));
    }

    @Element("Текст")
    public WebElement getText() {
        return $(By.xpath("//textarea"));
    }

    @Element("Отправить ответ")
    public WebElement getReplySent() {
        return $(By.xpath("//button[@type='submit']"));
    }

    @Element("Очередной интересный комментарий")
    public WebElement getReplyChecked() throws NoSuchMethodException {

        TopicPage t = new TopicPage();
        Class<?> c = t.getClass();
        Method m = c.getMethod("getReplyChecked");
        Element e = m.getAnnotation(Element.class);

        return $(By.xpath(".//p[text()='" + e.value() + "']/ancestor::li/descendant::a[@class='item-title' and @href='/u/olga/138/']"));
    }

}
