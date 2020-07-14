package cases;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.relevantcodes.extentreports.LogStatus;

import pages.*;
import util.LogUtils;
import util.ReadJson;

public class TestCase01 {
	
	static WebDriver driver;
	HomePage homePage;
	ShopCartPage shopCartPage ;
	ItemPage itemPage;
	SearchPage searchPage;
	ReadJson json;
	
	/*
	 * Configuração a ser executada antes do teste iniciar
	 */
	@BeforeEach
	public void beforeEach() throws MalformedURLException {
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		driver = new RemoteWebDriver(new URL("http:/localhost:4444/wd/hub"), options);
		homePage = new HomePage(driver);
		shopCartPage = new ShopCartPage(driver);
		itemPage = new ItemPage(driver);
		searchPage = new SearchPage(driver);
		json = new ReadJson();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	
	/*
	 * Teste ponta a ponta submarino adicionando item ao carrinho
	 */
	@Test
	public void test() throws InterruptedException, FileNotFoundException, IOException, ParseException {
		try {
			homePage.getUrl();
			homePage.findItem(json.readJson("item"));
			homePage.clickSearch();
			itemPage.selectItem();
			searchPage.addProductBag();
			shopCartPage.validateProductBag();
		} catch (Exception e) {
			LogUtils.log(LogStatus.ERROR, "Ocorreu um erro , por favor tente novamente!");
		}
	}
	
	/*
	 * Comandos executados após a finalização do teste
	 */
	@AfterEach
	public void afterEach() {
		driver.close();
		LogUtils.finishLog();
	}

}
