package PagesObjets;

import java.io.File;
import java.util.Properties;

import MapsObjets.MapObjetMercadoLibreCrearCuenta;
import UtilidadesExcel.ReadExcelFile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageObjetMercadoLibreCrearCuenta extends MapObjetMercadoLibreCrearCuenta
{

	public PageObjetMercadoLibreCrearCuenta(AppiumDriver<MobileElement> driver) {
		super(driver);
		this.driver = (AppiumDriver)driver;// TODO Auto-generated constructor stub
	}
	//METODO CREAR CUENTA
	public void mercadolibreHomeCrearCuenta(ReadExcelFile leer,Properties propiedades,File rutaCarpeta) throws Exception 
	{
		//CLICK EN BOTON CREAR CUENTA
		click(btnCrearCuenta, rutaCarpeta);
		tiempoEspera(2000);
		//SELECCIONAMOS EL CHECK BOX
		click(checkAutorizacion, rutaCarpeta);
		tiempoEspera(2000);
		//OPRIMIMOS EL BOTON CONTINUAR
		click(btnContinuar, rutaCarpeta);
		tiempoEspera(2000);
		//CLICK EN EL BOTON VALIDAR
		click(btnValidar, rutaCarpeta);
		tiempoEspera(2000);
		//ENVIAMOS LA DIRECCION DE CORREO ELECTRONICO
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "google", 1, 0),txtEmail, rutaCarpeta);
		tiempoEspera(2000);
	}

}
