import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends Page {
//Matthias De Baets
    public HomePage(WebDriver driver){
        super(driver);
        super.driver.get(getPath() + "Controller?command=Home");
    }

    public void login(){
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
    }

    public void logout(){
        WebElement logoutButton = driver.findElement(By.id("logout"));
        logoutButton.click();
    }

    public String getSuccesMessage(){
        WebElement succes = driver.findElement(By.cssSelector(".alert-succes ul li"));
        return succes.getText();
    }

    public String getErrorMessage(){
        WebElement error = driver.findElement(By.cssSelector(".alert-danger ul li"));
        return error.getText();
    }

    public void setUsername(String username){
        WebElement usernameField = driver.findElement(By.id("userid"));
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void setPassword(String password){
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }
}
