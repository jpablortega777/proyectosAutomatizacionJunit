package PagesObjets;

import java.io.File;
import java.util.Properties;

import MapsObjets.MapObjetMercadoLibreHome;
import UtilidadesExcel.ReadExcelFile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageObjetMercadoLibreHome extends MapObjetMercadoLibreHome
{

	public PageObjetMercadoLibreHome(AppiumDriver<MobileElement> driver) {
		super(driver);
		this.driver = (AppiumDriver)driver;// TODO Auto-generated constructor stub
	}
	//METODO HOME
	
	public void mercadolibreHome(ReadExcelFile leer,Properties propiedades,File rutaCarpeta) throws Exception 
	{
		//DAMOS CLICK AL PAIS SELECCIONADO
		click(linkPais, rutaCarpeta);
		tiempoEspera(2000);
		//CLICK EN EL BUSCADOR DE MERCADO LIBRE
		click(Buscar, rutaCarpeta);
		//ENVIAMOS EL TEXT A BUSCAR DESDE EL EXCEL
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "google", 1, 1),txtBuscar, rutaCarpeta);
		tiempoEspera(2000);
		//DAMOS ENTER
		enter(rutaCarpeta);
		tiempoEspera(2000);
		//CLICK EN EL PRIMER PRODUCTO QUE APAREZCA
		click(linkProducto, rutaCarpeta);
		tiempoEspera(2000);
		//REALIZAMOS UN SCROLL PARA ENCONTRAR EL BOTON DEL CARRITO
		scrollVertical(rutaCarpeta,551,1759,555,1);
		//CLICK EN ADD A CARRITO
		click(btnAddCarrito, rutaCarpeta);
		tiempoEspera(2000);
	}

}
