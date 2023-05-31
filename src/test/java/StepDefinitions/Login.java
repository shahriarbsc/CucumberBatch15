package StepDefinitions;

import Pages.LoginPage;
import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static io.cucumber.core.internal.com.fasterxml.jackson.databind.type.LogicalType.Map;


public class Login extends CommonMethods {

/*
    @Given("open the browser and launch HRMS application")
    public void open_the_browser_and_launch_hrms_application() {

        openBrowserAndLaunchApplication();

    }
*/

    @When("user enters valid email and valid password")
    public void user_enters_valid_email_and_valid_password() {

    //    LoginPage login = new LoginPage();


        //driver.findElement(By.id("txtUsername")).sendKeys(ConfigReader.getPropertyValue("username"));

        //   WebElement usernameTextBox = driver.findElement(By.id("txtUsername"));
        sendText(login.usernameTextBox, ConfigReader.getPropertyValue("username"));

        //driver.findElement(By.id("txtUsername")).sendKeys(ConfigReader.getPropertyValue("username"));
        //  WebElement passwordTextBox = driver.findElement(By.id("txtPassword"));
        sendText(login.passwordTextBox, ConfigReader.getPropertyValue("password"));

        //driver.findElement(By.id("txtPassword")).sendKeys(ConfigReader.getPropertyValue("password"));

    }

    @When("click on login button")
    public void click_on_login_button() {
        //WebElement loginBtn = driver.findElement(By.id("btnLogin"));

  //      LoginPage login = new LoginPage();
        doClick(login.loginBtn);


    }

    @Then("user is logged in successfully into the application")
    public void user_is_logged_in_successfully() {
        boolean userloggedIn = driver.findElement(By.xpath("//a[contains(text(), 'Welcome')]")).isDisplayed();
        if (userloggedIn) {
            System.out.println("User is logged in Successfully");
        }

    }

    @Then("Close the browser")
    public void close_the_browser() {
        closeBrowser(); // calling methods
    }

    @When("user enters valid {string} and valid {string}")
    public void user_enters_valid_and_valid(String username, String password) {

//        LoginPage login = new LoginPage();

        //WebElement usernameTextBox = driver.findElement(By.id("txtUsername"));
        sendText(login.usernameTextBox, username);

        //WebElement passwordTextBox = driver.findElement(By.id("txtPassword"));
        sendText(login.passwordTextBox, password);

    }

    @When("user enters username and password and verifies login")
    public void user_enters_username_and_password_and_verifies_login(DataTable dataTable) {
        //LoginPage login = new LoginPage();

        // every method we create login method and calling it here.

        List<Map<String, String>> userCredentials = dataTable.asMaps();

        for (Map<String, String> userCreds : userCredentials) {
            // method for capturing the key
            String username = userCreds.get("username");
            String password = userCreds.get("password");
            //       WebElement usernameTextBox = driver.findElement(By.id("txtUsername"));
            sendText(login.usernameTextBox, username);
            //     WebElement passwordTextBox = driver.findElement(By.id("txtPassword"));
            sendText(login.passwordTextBox, password);
            //   WebElement loginBtn = driver.findElement(By.id("btnLogin"));
            doClick(login.loginBtn);

            // WebElement welcomeIcon = driver.findElement(By.id("welcome"));
            doClick(login.welcomeIcon);
            //WebElement logoutLink = driver.findElement(By.xpath("//a[text()='Logout']"));
            doClick(login.logoutLink);

        }

    }
}