package com.tau.steps;

import com.tau.base.BaseUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class Steps extends BaseUtil {

    private BaseUtil baseUtil;

    public Steps(BaseUtil util) {
        this.baseUtil = util;
    }

    private WebDriver driver;

    @Before()
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Given("I am in the login page of the Para Bank Application")
    public void i_am_in_the_login_page_of_the_para_bank_application() {

        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }



    /*@When("I enter valid {string} and {string}")
    public void i_enter_valid_credential(String username, String password) {
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("username")).submit();
    }*/

    /*@When("I enter valid credentials")
    public void i_enter_valid_credentials(DataTable table) {
        List<String> loginForm = table.asList();

        driver.findElement(By.name("username")).sendKeys(loginForm.get(0));
        driver.findElement(By.name("password")).sendKeys(loginForm.get(1));
        driver.findElement(By.name("username")).submit();
    }*/

    @When("I enter valid {string} and {string} with {string}")
    public void i_enter_valid_credential(String username, String password, String userFullName) {
        baseUtil.userFullName = userFullName;

        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("username")).submit();
    }


    @Then("I should be taken to the Overview page")
    public void i_should_be_taken_to_the_overview_page() throws Exception {
        Thread.sleep(5000);

        String actualuserFullName = driver.findElement(By.className("smallText")).getText().toString();

        System.out.println(baseUtil.userFullName.toString());

        assertTrue(actualuserFullName, actualuserFullName.contains(baseUtil.userFullName));

        driver.findElement(By.linkText("Log Out")).click();

        driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/h1")).isDisplayed();
        driver.findElement(By.linkText("Log Out")).click();
    }

    @After()
    public void teardown() {
        driver.quit();
    }

}
