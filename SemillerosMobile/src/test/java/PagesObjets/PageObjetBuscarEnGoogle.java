package PagesObjets;

import java.io.File;
import java.util.Properties;

import MapsObjets.MapObjetGoogle;
import UtilidadesExcel.ReadExcelFile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageObjetBuscarEnGoogle extends MapObjetGoogle{

	public PageObjetBuscarEnGoogle(AppiumDriver<MobileElement> driver) {
		super(driver);
		this.driver = (AppiumDriver)driver;
		// TODO Auto-generated constructor stub
	}
	// METODO PARA BUSCAR EN GOOGLE
	public void buscarGoogle(ReadExcelFile leer,Properties propiedades,File rutaCarpeta) throws Exception 
	{
		
		
		//INVOCAMOS EL METODO BORRAR 
		borrar(btnBuscar, rutaCarpeta);
		tiempoEspera(2000);
		//METODO CLICK EN EL BUSCADOR DE GOOGLE
		click(btnBuscar, rutaCarpeta);
		tiempoEspera(2000);
		//ENVIAMOS EL TEXTO QUE ESTA EN EXCEL LA URL 
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "google", 1, 2),btnBuscar, rutaCarpeta);
		tiempoEspera(2000);
		//METODO ENTER 
		enter(rutaCarpeta);
		tiempoEspera(2000);
	
		
	}
}
