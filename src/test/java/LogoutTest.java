import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

// Matthias De Baets
public class LogoutTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\matth\\Desktop\\Semester 3\\Web 3\\Chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void clean() {
        driver.quit();
    }

    @Test
    public void test_Logged_In_User_Can_Log_Out_Using_Log_out_Button(){
        HomePage home = PageFactory.initElements(driver, HomePage.class);
        home.setUsername("admin");
        home.setPassword("admin");
        home.login();
        home.logout();
        Assert.assertEquals("U bent succesvol uitgelogd!", home.getSuccesMessage());
    }

    @Test
    public void test_Unknown_User_Cannot_Log_Out_When_Not_Logged_In(){
        HomePage home = PageFactory.initElements(driver, HomePage.class);
        driver.get(home.getPath() + "Controller?command=Logout");
        Assert.assertEquals("U bent niet ingelogd.", home.getErrorMessage());
    }

    @Test
    public void test_Logged_In_User_Cannot_Log_Out_Using_URL_Manipulation(){
        HomePage home = PageFactory.initElements(driver, HomePage.class);
        home.setUsername("admin");
        home.setPassword("admin");
        home.login();
        driver.get(home.getPath() + "Controller?command=Logout");
        Assert.assertEquals("Dit is niet de juiste manier om uit te loggen.", home.getErrorMessage());
    }

    @Test
    public void test_Logged_In_User_Logs_Out_Succesfully_With_Succes_Message(){
        HomePage home = PageFactory.initElements(driver, HomePage.class);
        home.setUsername("admin");
        home.setPassword("admin");
        home.login();
        home.logout();
        Assert.assertEquals("U bent succesvol uitgelogd!", home.getSuccesMessage());
    }
}
