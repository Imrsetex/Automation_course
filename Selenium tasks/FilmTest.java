package PDFfiller_Automation.Lesson_4.SeleniumTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class FilmTest {
    /**
     * Написать программу которая будет отображать кол-во мест в зале кинотеатра:
     * <p>
     * Кол-во мест в зале ???
     * Кол-во мест занятых
     * Кол-во мест свободных
     * % Занятых мест от “всего мест в зале”
     * % Свободных мест от “всего мест в зале”
     * <p>
     * Что делает программа:
     * <p>
     * Переходим на http://liniakino.com/showtimes/aladdin/
     * Выбираем фильм “Дамбо” - ближайший сеанс.
     * Открываем схему зала
     * Считаем места
     * Выводим результат в консоль
     **/

    private WebDriver driver;
    private By filmName = By.xpath("//*[text()='Дамбо']");
    private By buyTicket = By.xpath("//input[@type='button']");
    private By selectFirstScene = By.xpath("//li/a[1]");
    private By closeModal = By.xpath("//div[@class='window']//div");
    private By iframe = By.cssSelector("#vkino-widget > iframe");
    private By seatAllow = By.xpath(".//*[@*='seat seat-color1']");
    private By seatAll = By.xpath("//*[starts-with(@id,'hseat')]");
    private By seatOccupied = By.xpath(".//html//*[@*='seat seat-occupied']");
    private String filmTitle;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    @Step("Open films theater and select [Dambo] film")
    public void visitСinemaTheatrePage() throws InterruptedException, IndexOutOfBoundsException {
        driver.get("http://liniakino.com/showtimes/aladdin/");
        if (driver.findElement(filmName).isDisplayed()) {

            filmTitle = driver.findElement(filmName).getText();
            System.out.println("Your selected film name – " + filmTitle);
            driver.findElement(filmName).click();

            if (driver.findElement(buyTicket).isDisplayed()) {
                driver.findElement(buyTicket).click();
            }
            if (driver.findElement(selectFirstScene).isDisplayed()) {
                driver.findElement(selectFirstScene).click();
            }
        }
        driver.findElement(iframe).isDisplayed();
        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
        Thread.sleep(5000);
        driver.findElement(closeModal).isDisplayed();
        driver.findElement(closeModal).click();

        List<WebElement> allSeatsZone = driver.findElements(seatAll);
        System.out.println("Select all seats in the hall: " + allSeatsZone.size());
        int allSeatsNum = allSeatsZone.size();

        List<WebElement> listAvalaibleSeats = driver.findElements(seatAllow);
        int avalaibleSeatsNum = listAvalaibleSeats.size();
        System.out.println("All available seats numbers: " + listAvalaibleSeats.size());

        List<WebElement> listSeatsOccupied = driver.findElements(seatOccupied);
        System.out.println("Select all occupied seats " + listSeatsOccupied.size());
        int busySeatsNum = listSeatsOccupied.size();

        float percentBusySeats = busySeatsNum * 100f / allSeatsNum;
        System.out.println("% of occupied seats from all seats in the hall : " + percentBusySeats);

        float percentAvalaibleSeats = avalaibleSeatsNum * 100f / allSeatsNum;
        System.out.println("% of available seats from all seats in the hall : " + percentAvalaibleSeats);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
