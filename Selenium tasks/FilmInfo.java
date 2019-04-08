package PDFfiller_Automation.Lesson_4.SeleniumTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class FilmInfo {
    /***
     * Написать программу которая выведет на экран информацию о фильме.
     * Ссылка на страницу фильма: https://www.imdb.com/title/tt0111161/
     * 1. Название фильма
     * 2. Дата выхода
     * 3. Продолжительность фильма в минутах. Продолжительность фильма в секундах.
     * 4. Рейтинг фильма
     * 5. Жанр
     * 6. Ссылку на трейлер фильма
     * 7. Ссылку на постер фильма
     * 8. Директора фильма
     * 9. 5 Актеров фильма
     * 10. Рейтинг Metascore
     * 11. Кол-во ревью (отдельно пользовательских, отдельно критиков, сумму пользовательских и критиков)
     * 12. Названия 3х "похожих" фильмов
     * **/

    private WebDriver driver;
    private String URL = "https://www.imdb.com/title/tt0111161";
    private By releaseDate = By.xpath("//*[@title='See more release dates']");
    private By runtime = By.xpath("//*[@*='inline']//following-sibling::time");
    private By ratingValue = By.xpath("//*[@*='ratingValue']//*[@*='ratingValue']");
    private By getGenre = By.xpath("//div[@class='see-more inline canwrap']//*[contains(text(), 'Drama')]");
    private By getLink = By.xpath("//div[@class='slate']//a[@data-video]");
    private By getPoster = By.xpath("//div[@class='poster']//img[@alt]");
    private By directorOfFilm = By.xpath("//a[@href='/name/nm0001104/?ref_=tt_ov_dr']");
    private By metaScore = By.xpath("//div[@*='metacriticScore score_favorable titleReviewBarSubItem']/span");
    private By userReviews = By.xpath("//*[@href='reviews?ref_=tt_ov_rt']");
    private By criticReviews = By.xpath("//*[@href='externalreviews?ref_=tt_ov_rt'] ");
    private By relatedFilms = By.xpath("//*[@class='list_name']//a");

    private By TimRobbins = By.xpath("//a[@href='/name/nm0000209/?ref_=tt_cl_t1']");
    private By MorganFreeman = By.xpath("//a[@href='/name/nm0000151/?ref_=tt_cl_t2']");
    private By BobGunton = By.xpath("//a[@href='/name/nm0348409/?ref_=tt_cl_t3']");
    private By WilliamSadler = By.xpath("//a[contains(text(),'William Sadler')]");
    private By ClancyBrown = By.xpath("//a[contains(text(),'Clancy Brown')]");

    private int formatToInt;
    private int seconds = 60;
    private String link;
    private String posterLink;
    private int formatToIntUserReview;
    private int formatToIntCriticalReview;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @Test
    public void getFilmInformation() {
        String title = driver.getTitle();
        System.out.println("1. Название фильма: " + title.substring(0, 17));
        System.out.println("2. Дата выхода: " + driver.findElement(releaseDate).getText());
        String getRuntime = driver.findElement(runtime).getText();
        System.out.println("3. Продолжительность фильма в минутах: " + getRuntime.substring(0, 3));

        formatToInt = Integer.valueOf(getRuntime.substring(0, 3));

        System.out.println("3.2 Продолжительность фильма в секундах: " + formatToInt * seconds);
        System.out.println("4. Рейтинг фильма: " + driver.findElement(ratingValue).getText());
        System.out.println("5. Жанр: " + driver.findElement(getGenre).getText());
        link = driver.findElement(getLink).getAttribute("href");

        System.out.println("6. Ссылка на трейлер фильма: " + link);
        posterLink = driver.findElement(getPoster).getAttribute("src");
        System.out.println("7. Ссылка на постер фильма: " + posterLink);
        System.out.println("8. Директора фильма: " + driver.findElement(directorOfFilm).getText());

        System.out.println("9. 5 Актеров фильма: 1. " + driver.findElement(TimRobbins).getText()
                + " 2. " + driver.findElement(MorganFreeman).getText() + " 3. " + driver.findElement(BobGunton).getText()
                + " 4. " + driver.findElement(WilliamSadler).getText() + " 5. " + driver.findElement(ClancyBrown).getText());
        System.out.println("10. Рейтинг Metascore: " + driver.findElement(metaScore).getText());

        String userReview = driver.findElement(userReviews).getText().substring(0, 5).replaceAll("[^0-9]+", "");
        formatToIntUserReview = Integer.parseInt(userReview);
        System.out.println("\n11.(1) Пользовательских ревью| = " + userReview);

        String criticalReview = driver.findElement(criticReviews).getText().substring(0, 3);
        formatToIntCriticalReview = Integer.valueOf(criticalReview);
        System.out.println("11.(2) Ревью критиков| = " + criticalReview);
        System.out.println("11.(3) Cумма пользовательских и критиков| = " + (formatToIntUserReview + formatToIntCriticalReview));

        List<WebElement> listRelatedFilms = driver.findElements(relatedFilms);
        System.out.println("\n12.(1) Related video: ---| " + listRelatedFilms.get(0).getText() + " |---"
                + "\n12.(2) Related video: ---| " + listRelatedFilms.get(1).getText() + " |---"
                + "\n12.(3) Related video: ---| " + listRelatedFilms.get(2).getText() + " |---");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
