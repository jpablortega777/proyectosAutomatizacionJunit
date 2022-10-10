package MapsObjets;

import org.openqa.selenium.By;

import ClasesBase.ClaseBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapObjetToolsQAHome extends ClaseBase
{

	public MapObjetToolsQAHome(AppiumDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//ELEMENTOS A MAPEAR
	protected By btnAlertas=By.xpath("//android.widget.TextView[@text='Alertas, marco y ventanas']");
	protected By btnWidgets=By.xpath("//android.widget.TextView[@text='Widgets']");
	
}
