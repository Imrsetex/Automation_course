import org.testng.annotations.Test;
import ui.core.BrowserFactory;
import ui.pages.BoardsPage;
import ui.pages.LoginPage;

public class TestLogin extends BrowserFactory {

    private LoginPage loginPage = new LoginPage();
    private BoardsPage boardsPage = new BoardsPage();

    @Test
    public void login() throws InterruptedException {
        loginPage.open();
        loginPage.isOpened();
        loginPage.login("selectmaxqa@gmail.com", "123qwerty");
        boardsPage.openBoard("VENOM");
    }

    @Test
    public void logout() throws InterruptedException{
        loginPage.open();
        loginPage.isOpened();
        loginPage.login("selectmaxqa@gmail.com", "123qwerty");
        boardsPage.openBoard("VENOM");
        boardsPage.isOpened();
        boardsPage.logOut();
    }
}
