package PagesObjets;

import java.io.File;
import java.util.Properties;

import MapsObjets.MapObjetToolsQAWidgets;
import UtilidadesExcel.ReadExcelFile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageObjetToolsQAWidgets extends MapObjetToolsQAWidgets
{

	public PageObjetToolsQAWidgets(AppiumDriver<MobileElement> driver) {
		super(driver);
		this.driver = (AppiumDriver)driver;
	}
	//METODO WIDGETS
	
	public void widgets(ReadExcelFile leer,Properties propiedades,File rutaCarpeta) 
	{
		try {
			
			//CLICK EN BOTON DATAPICKER
			click(btnDataPicker, rutaCarpeta);
			tiempoEspera(15);
			//REALIZAMOS UN SCROLL PARA ENCONTRAR EL BOTON DEL CARRITO
			scrollVertical(rutaCarpeta,550,600,1300,2);
			tiempoEspera(10);
			//ENVIAMOS DATA
			borrar(txtSelectDate, rutaCarpeta);
			tiempoEspera(10);
			//ENVIAMOS EL DATO DE LA FECHA DEL SISTEMA MENOS UN MES Y UN YEAR Y UN DIA
			sendkey(dateWidgest(1,1,1), txtSelectDate, rutaCarpeta);
			tiempoEspera(10);
			//OPRIMIMOS ENTER
			enter(rutaCarpeta);
			tiempoEspera(10);
			//FUNCION DE BORRAR CAMPO DATATIME
			borrar(txtDateTime, rutaCarpeta);
			tiempoEspera(10);
			//ENVIAMOS EL DATO DE LA FECHA DEL SISTEMA MENOS UN MES Y UN YEAR Y UN DIA
			sendkey(dateWidgest(1,1,1), txtDateTime, rutaCarpeta);
			tiempoEspera(10);
			//OPRIMIMOS ENTER
			enter(rutaCarpeta);
			tiempoEspera(10);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
