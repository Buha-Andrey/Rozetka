package provectus.rozetka;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest {
	
	public static WebDriver driver; 
	
	@Test
	public void login () {
	
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32_\\chromedriver.exe" );
	
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rozetka.com.ua/");
		
		//Selecting city
		driver.findElement(By.xpath("//a[contains(@class, 'header-cities__link link-dashed')]")).click();
		driver.findElement(By.xpath("//ul[contains(@class, 'header-location__popular')]/descendant::a[contains(text(), 'Одесса ')]")).click();
		//Searching the conditioners
		driver.findElement(By.xpath("//div[contains(@class, 'header-search js-app-search-suggest')]/descendant::input")).sendKeys("Кондиционер");
		driver.findElement(By.xpath("//div[contains(@class, 'header-search js-app-search-suggest')]/descendant::button[contains(text(), 'Найти')]")).click();
		//Picking two first air conditioners
		driver.findElement(By.xpath("//div[contains(@class, 'g-i-tile-l g-i-tile-catalog-hover-left-side clearfix')]/div[1]/descendant::a[contains(text(), 'Кондиционер')]")).click();
		driver.findElement(By.xpath("//ul[contains(@class, 'detail-tools')]/descendant::span[contains(text(), 'Добавить')]")).click();
		driver.findElement(By.xpath("//meta[contains(@content, '3')]/preceding-sibling::span[contains(text(), 'Кондиционеры')]")).click();
		driver.findElement(By.xpath("//div[contains(@class, 'g-i-tile-l g-i-tile-catalog-hover-left-side clearfix')]/div[2]/descendant::a[contains(text(), 'Кондиционер')]")).click();
		driver.findElement(By.xpath("//ul[contains(@class, 'detail-tools')]/descendant::span[contains(text(), 'Добавить')]")).click();
		//Comparing both conditioners 	
		driver.findElement(By.xpath("//span[contains(text(), 'Сравнение')]")).click();
		driver.findElement(By.xpath("//span[contains(text(), 'Сравнить ')]")).click();
		
		Assert.assertEquals(true,  driver.findElement(By.xpath("//div[contains(@class, 'comparison-title')]/h1[contains(text(), 'Сравниваем')]/span[contains(text(), 'Кондиционеры')]")).isDisplayed());
		driver.quit();
		
	}
	
}
