package pages;

import java.io.FileNotFoundException;
import com.relevantcodes.extentreports.*;

import objects.HomeObject;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

import util.LogUtils;
import util.ReadJson;

public class HomePage {

	WebDriver driver;
	HomeObject homeObjects = new HomeObject();
	ReadJson read = new ReadJson();

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Maximiza o navegador e acessa o site informando no arquivo Json
	 * 
	 * @throws InterruptedException
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public void getUrl() throws FileNotFoundException, IOException, ParseException {
		String url = read.readJson("url");
		driver.get(url);
		LogUtils.log(LogStatus.INFO, "Website acessado com sucesso!");
	}

	/**
	 * Realiza o input do texto de pesquisa na barra de busca
	 * @param product
	 * @throws InterruptedException
	 */
	public void findItem(String product) throws InterruptedException {
		driver.findElement(homeObjects.inputSearchBar).sendKeys(product);
		LogUtils.log(LogStatus.INFO, "Item digitado na barra de busca");

	}

	/**
	 * Realiza a busca do produto informado
	 */
	public void clickSearch() {
		driver.findElement(homeObjects.btnSearch).click();
		LogUtils.log(LogStatus.INFO, "Busca feita do produto");
	}

}
