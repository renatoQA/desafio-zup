package pages;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.LogStatus;

import objects.SearchObject;
import util.LogUtils;
import util.ReadJson;

public class SearchPage {

	WebDriver driver;
	SearchObject search = new SearchObject();
	ReadJson read = new ReadJson();

	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}


	/**
	 * Metodo que adiciona o produto a sacola
	 */
	public void addProductBag() {
		driver.findElement(search.btnBuy).click();
		LogUtils.log(LogStatus.INFO, "Item adicionado ao carrinho");
	}


}
