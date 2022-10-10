package MapsObjets;

import org.openqa.selenium.By;

import ClasesBase.ClaseBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapObjetGoogle extends ClaseBase{

	public MapObjetGoogle(AppiumDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//ELEMENTOS MAPEADOS
	protected By btnBuscar=By.xpath("//android.widget.EditText[@resource-id='com.android.chrome:id/url_bar']");
	}
