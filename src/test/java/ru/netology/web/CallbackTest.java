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
    private WebDriver driver;

    @BeforeAll
    public static void setUpAll() {
        System.setProperty("webdriver.chrome.driver", "./driver/win/chromedriver.exe");
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
        driver.findElement(By.className("checkbox_box")).click();
        driver.findElement(By.tagName("button")).click();
        String actualText = driver.findElement(By.className("alert-success")).getText();
        String expectedText = "Ваша заявкауспешно отправлена! Наш менеджер свяжится с вами в ближайшее время";
        assertEquals(actualText, expectedText, "Текст сообщения не совпадает");
    }


}
