package PagesObjets;

import java.io.File;
import java.util.Properties;

import MapsObjets.MapObjetShopee;
import UtilidadesExcel.ReadExcelFile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageObjetShopee extends MapObjetShopee
{

	public PageObjetShopee(AppiumDriver<MobileElement> driver) {
		super(driver);
		this.driver = (AppiumDriver)driver;
		// TODO Auto-generated constructor stub
	}
	//METODO LOGIN 
	
	public void inicioSesion(ReadExcelFile leer,Properties propiedades,File rutaCarpeta) throws Exception
	{
		
		tiempoEspera(6000);
		click(btnYo, rutaCarpeta);
		tiempoEspera(2000);
		click(btnIniciarSesion, rutaCarpeta);
		tiempoEspera(2000);
		borrar(txtUser, rutaCarpeta);
		tiempoEspera(2000);
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "shopee", 1, 0),txtUser,rutaCarpeta);
		tiempoEspera(2000);
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "shopee", 1, 1),txtpass,rutaCarpeta);
		tiempoEspera(2000);
		click(btnLogin, rutaCarpeta);
		tiempoEspera(2000);
		click(btnInicio, rutaCarpeta);
		tiempoEspera(2000);

		
		
	}

}
