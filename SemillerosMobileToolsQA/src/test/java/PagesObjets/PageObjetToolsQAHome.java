package PagesObjets;

import java.io.File;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import MapsObjets.MapObjetToolsQAHome;
import UtilidadesExcel.ReadExcelFile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageObjetToolsQAHome extends MapObjetToolsQAHome
{

	public PageObjetToolsQAHome(AppiumDriver<MobileElement> driver) {
		super(driver);
		this.driver = (AppiumDriver)driver;// TODO Auto-generated constructor stub
	}
	//METODO HOME SELECCIONAR ALERTAS
	public void selectAlerts(ReadExcelFile leer,Properties propiedades,File rutaCarpeta) throws Exception 
	{
		//REALIZAMOS UN SCROLL PARA ENCONTRAR EL BOTON DEL CARRITO
		scrollVertical(rutaCarpeta,342,1878,610,2);
		tiempoEspera(5);
		//DAMOS CLICK AL PAIS SELECCIONADO
		click(btnAlertas, rutaCarpeta);
		tiempoEspera(5);		
		
	}
	//METODO HOME SELECCIONAR ALERTAS
	public void selectWidgets(ReadExcelFile leer,Properties propiedades,File rutaCarpeta) throws Exception 
	{
		//REALIZAMOS UN SCROLL PARA ENCONTRAR EL BOTON DEL CARRITO
		scrollVertical(rutaCarpeta,342,1878,610,3);
		tiempoEspera(5);
		//DAMOS CLICK AL PAIS SELECCIONADO
		click(btnWidgets, rutaCarpeta);
		tiempoEspera(5);		
			
	}

}
