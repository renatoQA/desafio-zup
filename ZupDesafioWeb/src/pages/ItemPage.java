package pages;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.LogStatus;

import objects.ItemObject;
import util.LogUtils;
import util.ReadJson;

public class ItemPage {

	WebDriver driver;
	ItemObject productObjects = new ItemObject();
	ReadJson read = new ReadJson();

	public ItemPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Valida o retorno da busca e realiza um clique no item
	 */
	public void selectItem() {
			driver.findElement(productObjects.productItem).isDisplayed();
			driver.findElement(productObjects.productItem).isEnabled();
			driver.findElement(productObjects.productItem).click();
			LogUtils.log(LogStatus.INFO, "Produto Selecionado.");

	}
}
