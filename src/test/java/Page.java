import org.openqa.selenium.WebDriver;

//Matthias De Baets
public abstract class Page {

    WebDriver driver;
    String path = "http://localhost:8081/Deelopdracht_1_war_exploded/";

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getPath() {
        return path;
    }

    public String getTitle () {
        return driver.getTitle();
    }

}