import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sooofffttt {

	public WebDriver driver;
	SoftAssert softassert = new SoftAssert();

	public static final int numbersOfTry = 10;
	
	public static final int numbers_in_inventory = 3 ; 

	@BeforeTest()
	public void Hi_This_is_before_test() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://smartbuy-me.com/smartbuystore/en/");

	}

	@Test()

	public void test_number_one() throws InterruptedException {

		for (int i = 0; i < numbersOfTry; i++) {
			if (i == numbers_in_inventory) {
				break;
			}
			else {
				driver.findElement(By.xpath(
						"//*[@id=\"newtab-Featured\"]/div/div[1]/div/div/div/div[3]/div/div[3]/div[1]/div/div/form[1]/div[1]/button"))
						.click();

				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

				driver.findElement(By.xpath("//*[@id=\"addToCartLayer\"]/a[2]")).click();
				
			}


			
			
		}

		String textofThePrice = driver
				.findElement(By.xpath(
						"//*[@id=\"newtab-Featured\"]/div/div[1]/div/div/div/div[3]/div/div[2]/div[2]/div/div/span[3]"))
				.getText();

		String[] name = textofThePrice.split("JOD");
		String formattedName = name[0].trim().replace(",", ".");

		Double price_configured = Double.parseDouble(formattedName);
//
		Double expected_Total_Price = price_configured * numbersOfTry;

		driver.findElement(
				By.xpath("/html/body/main/header/div[4]/div/nav/div/div[3]/div/ul/li[1]/div/div/div[1]/a/div[2]"))
				.click();

		String TextTotal = driver.findElement(By.xpath("//*[@id=\"cboxLoadedContent\"]/div/div/div[2]/div[1]"))
				.getText();


		String[] updated = TextTotal.split(".000");
//
		String updatedd = updated[0].trim().replace(",", ".").replace("Total", "");
//
		Double hello = Double.parseDouble(updatedd);
//
//		System.out.println(expected_Total_after);
//
//		softassert.assertEquals(expected_Total_Price, expected_Total_after, "goal");

		


	}

}
