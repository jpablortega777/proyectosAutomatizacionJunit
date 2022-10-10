package MapsObjets;

import org.openqa.selenium.By;

import ClasesBase.ClaseBase;
import io.appium.java_client.AppiumDriver;

public class MapObjetShopee extends ClaseBase
{

	public MapObjetShopee(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//ELEMENTOS A MAPEAR
	//protected By btnYo=By.xpath("//android.widget.FrameLayout[@resource-id='com.shopee.co:id/bottom_bar_item']//android.widget.TextView[@text='Yo']");
	protected By btnYo=By.xpath("(//android.widget.ImageView[@resource-id='com.shopee.co:id/tab_animation_icon'])[4]");
	protected By btnIniciarSesion=By.xpath("//android.widget.TextView[@text='Iniciar sesión']");
	protected By txtUser=By.xpath("(//android.widget.EditText)[1]");
	protected By txtpass=By.xpath("(//android.widget.EditText)[2]");
	protected By btnLogin=By.xpath("//android.widget.TextView[@resource-id='com.shopee.co:id/btnLogin']");
	protected By btnInicio=By.xpath("(//android.widget.LinearLayout)[1]");
}
