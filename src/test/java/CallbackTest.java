import org.junit.jupiter.api.BeforeAll;

public class CallbackTest {

    @BeforeAll
    public static void setUpAll() {
        System.setProperty("webdriver.chrome.driver", "./driver/win/chromedriver.exe");

     }
}
