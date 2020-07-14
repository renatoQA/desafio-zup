package pages;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.LogStatus;

import objects.ShopCartObject;

import org.junit.Assert;

import util.LogUtils;
import util.ReadJson;

public class ShopCartPage {

	WebDriver driver;
	ShopCartObject bag = new ShopCartObject();
	ReadJson read = new ReadJson();

	public ShopCartPage(WebDriver driver) {
		this.driver = driver;
	}

	public void validateProductBag() throws InterruptedException, FileNotFoundException, IOException, ParseException {

			String expected = read.readJson("expectedResult");
			driver.findElement(bag.pCheckItem).isDisplayed();
			driver.findElement(bag.pCheckItem).isEnabled();
			Assert.assertEquals(driver.findElement(bag.pCheckItem).getText(), expected);
			LogUtils.log(LogStatus.INFO, "Item adicionado ao carrinho : " + driver.findElement(bag.pCheckItem).getText());
			LogUtils.log(LogStatus.INFO, "Item retornado: " + expected);
			LogUtils.log(LogStatus.PASS, "Item adicionado com sucesso e validado o retorno!");

	}
}
