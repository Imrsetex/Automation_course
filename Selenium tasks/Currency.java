package PDFfiller_Automation.Lesson_4.SeleniumTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.Arrays;

public class Currency {
    /**
     * Написать программу которая будет:
     * 1. Заходить на сайты банков
     * 2. Записывать 2 переменные типа "double" - курс покупки\продажи валют (гривна\доллар)
     * 3. Посчитать средний курс валют, отдельно, покупки и продажи между всеми банками (вывести в консоль)
     * 4. Вывести в консоль банк с самым низким курсом покупки доллара
     * 5. Вывести в консоль банк с самым высоким курсом продажи
     * Список сайтов:
     * https://www.privat24.ua
     * https://my.ukrsibbank.com/ru/personal/operations/currency_exchange/
     * https://www.universalbank.com.ua/
     * http://www.oschadbank.ua/ua/
     * http://www.bank.gov.ua/control/uk/curmetal/detail/currency?period=daily (НБУ)
     **/

    private WebDriver driver;
    private String pb24 = "https://www.privat24.ua";
    private String ukrsibbankURL = "https://my.ukrsibbank.com/ru/personal/operations/currency_exchange/";
    private String monoBank = "https://www.universalbank.com.ua/";
    private String oschadBank = "http://www.oschadbank.ua/ua/";
    private String nbuUkraine = "https://www.bank.gov.ua/control/uk/curmetal/detail/currency?period=daily";

    private By privatBank = By.xpath("//*[@class='section-content rate'][1]");
    private By getukrSibBankPurchase = By.xpath("//*[@*='currency__table']/tbody/tr[1]/td[2]");
    private By getUkrSibBankExchange = By.xpath("//*[@*='currency__table']/tbody/tr[1]/td[3]");
    private By getMonoPurchase = By.xpath(".//td[@*='currency rise p-b-xs-2 p-y-1-sm']//following-sibling::td[1]");
    private By getMonoExchange = By.xpath("//table[1]/tbody[1]/tr[2]/td[3]");
    private By getOschadPurchase = By.xpath("//*[@*='buy-USD']");
    private By getOschadExchange = By.xpath("//*[@*='sell-USD']");
    private By getNbuCurrency = By.xpath("//td[contains(text(),'Долар США')]//following-sibling::td");

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test(testName = "Get currency from client banks")
    public void getCurrency() {

        //Go to Privat24 & get currency
        driver.get(pb24);
        String purchasePrivatUSD = driver.findElement(privatBank).getText().substring(0, 6);
        double doublePurshaseValuePB = Double.parseDouble(purchasePrivatUSD);
        System.out.println("[Privat24] Purchase rate USD: " + doublePurshaseValuePB);

        String sellPrivatUSD = driver.findElement(privatBank).getText().substring(9, 15);
        double doubleSellPrivatUSD = Double.parseDouble(sellPrivatUSD);
        System.out.println("[Privat24] Exchange rate USD: " + doubleSellPrivatUSD);

        //Go to UkrsibBank & get currency
        driver.get(ukrsibbankURL);
        String ukrsibPurchase = driver.findElement(getukrSibBankPurchase).getText();
        double doublePurshaseUkrsib = Double.parseDouble(ukrsibPurchase);

        String ukrsibExchange = driver.findElement(getUkrSibBankExchange).getText();
        double doubleExchangeUkrsib = Double.parseDouble(ukrsibExchange);
        System.out.println("[UkrsibBank] Purchase rate USD: " + doublePurshaseUkrsib
                + "\n[UkrsibBank] Exchange rate USD: " + doubleExchangeUkrsib);

        //Go to Monobank & get currency
        driver.get(monoBank);
        String monoPurchase = driver.findElement(getMonoPurchase).getText();
        double doublePurshaseMono = Double.parseDouble(monoPurchase);
        String monoExchange = driver.findElement(getMonoExchange).getText();
        double doubleExchangeMono = Double.parseDouble(monoExchange);
        System.out.println("[MonoBank] Purchase rate USD: " + doublePurshaseMono
                + "\n[MonoBank] Exchange rate USD: " + doubleExchangeMono);

        //Go to Oschad & get currency
        driver.get(oschadBank);
        String oschadPurchase = driver.findElement(getOschadPurchase).getText();
        double doublePurshaseOschad = Double.parseDouble(oschadPurchase);
        String oschadExchange = driver.findElement(getOschadExchange).getText();
        double doubleExchangeOschad = Double.parseDouble(oschadExchange);
        System.out.println("[OschadBank] Purchase rate USD: " + doublePurshaseOschad
                + "\n[OschadBank] Exchange rate USD: " + doubleExchangeOschad);

        //Go to NBU & get currency
        driver.get(nbuUkraine);
        String nbuCurrency = driver.findElement(getNbuCurrency).getText();
        double doubleNbuCurrency = Double.parseDouble(nbuCurrency);
        doubleNbuCurrency = Math.round(doubleNbuCurrency / 10.0);
        double result = (double) Math.round(doubleNbuCurrency / 10.0);
        doubleNbuCurrency = result;
        System.out.println("[NBU Bank] Official currency: " + doubleNbuCurrency);

        double[] arrPurchaseCourse = {doublePurshaseValuePB, doublePurshaseUkrsib, doublePurshaseMono, doublePurshaseOschad, doubleNbuCurrency};
        Arrays.sort(arrPurchaseCourse);
        double min = arrPurchaseCourse[0];
        double sumPurchase = 0.0;
        for (double x : arrPurchaseCourse) {
            sumPurchase += x;
        }
        double averagePurchase = sumPurchase / arrPurchaseCourse.length;
        System.out.print("\nСредний курс [Покупки USD] за сегодня: " + averagePurchase);
        System.out.println("\n-----------------------");

        double[] arrExchange = {doubleSellPrivatUSD, doubleExchangeUkrsib, doubleExchangeOschad, doubleNbuCurrency, doubleExchangeMono};
        Arrays.sort(arrExchange);
        double max = arrExchange[arrExchange.length - 1];
        double sumExchange = 0.0;
        for (double x : arrExchange) {
            sumExchange += x;
        }
        double averageExchange = sumExchange / arrExchange.length;
        System.out.print("\nСредний курс [Продаж USD] за сегодня: " + averageExchange);
        System.out.println("\n-----------------------");

        if (min == doublePurshaseValuePB) {
            System.out.println("Privat Bank minimum exchange rate " + doublePurshaseValuePB);
        } else if (min == doublePurshaseUkrsib) {
            System.out.println("UkrsibBank minimum exchange rate = " + doublePurshaseUkrsib);
        } else if (min == doublePurshaseMono) {
            System.out.println("MonoBank minimum exchange rate = " + doublePurshaseMono);
        } else if (min == doublePurshaseOschad) {
            System.out.println("OschadBank minimum exchange rate =  " + doublePurshaseMono);
        } else if (min == doubleNbuCurrency) {
            System.out.println("NBU min value  " + doubleNbuCurrency);
        }
        if (max == doubleSellPrivatUSD) {
            System.out.println("Privat Bank maximum exchange rate " + doubleSellPrivatUSD);
        } else if (max == doubleExchangeUkrsib) {
            System.out.println("UkrsibBank maximum exchange rate " + doubleExchangeUkrsib);
        } else if (max == doubleExchangeMono) {
            System.out.println("MonoBank maximum exchange rate " + doubleExchangeMono);
        } else if (max == doubleExchangeOschad) {
            System.out.println("OschadBank maximum exchange rate " + doubleExchangeOschad);
        } else if (max == doubleNbuCurrency) {
            System.out.println("NBU maximum exchange rate " + doubleNbuCurrency);
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
