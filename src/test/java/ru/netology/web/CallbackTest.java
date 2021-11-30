package ru.netology.web;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CallbackTest {
     WebDriver driver;

    @BeforeAll
    public static void setUpAll() {
        //WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "./driver/win/chromedriver.exe");
    }

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    public void shouldReturnForm() {
        driver.get("http://localhost:9999");
        System.out.println("");
//        driver.findElement().sendKeys("Васильев Василий");
//        driver.findElement().sendKeys("+75145684789");
        List<WebElement> textFields = driver.findElements(By.className("input__control"));
        textFields.get(0).sendKeys("Васильев Василий");
        textFields.get(1).sendKeys("+75145684789");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.tagName("button")).click();
        String actualText = driver.findElement(By.className("App_appContainer__3jRx1")).getText();
        String expectedText = "Заявка на дебетовую карту\n" +
                "  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        assertEquals(actualText, expectedText, "Текст сообщения не совпадает");
    }

    @Test
    public void shouldReturnForm2() {
        driver.get("http://localhost:9999");
        System.out.println("");
        driver.findElement(By.cssSelector("[type='text']")).sendKeys("Арнольд Смирнов");
        driver.findElement(By.cssSelector("[type='tel']")).sendKeys("+75214444789");
//        List<WebElement> textFields = driver.findElements(By.className("input__control"));
//        textFields.get(0).sendKeys("Васильев Василий");
//        textFields.get(1).sendKeys("+75145684789");
        driver.findElement(By.cssSelector(".checkbox__box")).click();
        driver.findElement(By.cssSelector("button")).click();
        String actualText = driver.findElement(By.cssSelector(".App_appContainer__3jRx1")).getText();
        String expectedText = "Заявка на дебетовую карту\n" +
                "  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        assertEquals(actualText, expectedText, "Текст сообщения не совпадает");
    }
}
