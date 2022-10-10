package MapsObjets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ClasesBase.ClaseBase;
import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.MobileElement;

public class MapObjetCalculadoraOperaciones extends ClaseBase
{

	public MapObjetCalculadoraOperaciones(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//ELEMENTOS DE CALCULADORA
	protected By btnBorrar=By.xpath("//android.widget.ImageView[@content-desc='borrar']");
	protected By btnIgual=By.xpath("//android.widget.ImageView[@content-desc='igual a']");
	protected By btnsNumeros=By.xpath("//android.widget.TextView[@text='{0}']");
	protected By btnOperaciones=By.xpath("//android.widget.ImageView[@content-desc='{0}']");
	
	
}
