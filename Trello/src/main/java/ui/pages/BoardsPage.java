package ui.pages;

import ui.core.Elem;
import org.openqa.selenium.By;

public class BoardsPage {

    private static final String PATH = "/venom/boards";

    public Elem userButton = new Elem(By.xpath("//*[@*='header-member-menu-button']"), "User button");
    public Elem logoutBtn = new Elem(By.xpath("//*[@*='header-member-menu-logout']"));

    public Elem openBoard(String urlName) {
        return new Elem(By.cssSelector(".board-tile[href*='" + urlName + "']"), urlName);
    }

    public void open() {
    }

    public void isOpened() {
    }

    public void boardPart(String urlName) {
        new Elem(By.xpath(""), "test");
    }

    public void logOut() {
        userButton.isElementPresent();
        userButton.click();
        logoutBtn.isElementPresent();
        logoutBtn.click();
    }
}
