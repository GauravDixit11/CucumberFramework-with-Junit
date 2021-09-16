package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Base {

	public static WebDriver driver;
	public static Properties prop;
	int c;

	public static WebDriver getDriver() throws IOException,FileNotFoundException {
		
		prop = new Properties();
	
		
		String path = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(path+"//global.properties");
		prop.load(fis);
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		return driver;

	}

}
