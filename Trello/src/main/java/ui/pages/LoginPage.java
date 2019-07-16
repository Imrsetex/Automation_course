package ui.pages;

import ui.core.Constants;
import ui.core.Elem;
import org.openqa.selenium.By;

import static org.testng.Assert.*;
import static ui.core.BrowserFactory.*;

public class LoginPage {

    private static final String PATH = "/login";

    public Elem emailField = new Elem(By.xpath("//input[@id='user']"), "Login Email");
    public Elem passwordField = new Elem(By.xpath("//input[@id='password']"), "Login password");
    public Elem loginBtn = new Elem(By.xpath("//input[@id='login']"), "Login Button");
    public Elem homeButton = new Elem(By.xpath("//*[@*='header-boards-menu-button']"), "Home button");

    public void open() {
        get(Constants.URL + PATH);
        assertTrue(isOpened(), "Page 'Login' [" + PATH + "] not Opened");
    }

    public boolean isOpened() {
        return loginBtn.isElementPresent() && driver().getCurrentUrl().equals(Constants.URL + PATH);
    }

    public void login(String email, String password) throws InterruptedException {
        emailField.type(email);
        passwordField.type(password);
        loginBtn.click();
        homeButton.isElementPresent();
    }
}
