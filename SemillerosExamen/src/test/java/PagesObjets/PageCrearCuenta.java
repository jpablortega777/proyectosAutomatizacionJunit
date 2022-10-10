package PagesObjets;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import MapsObjets.MapObjetCrearCuenta;
import utilidadesExcel.ReadExcelFile;

public class PageCrearCuenta extends MapObjetCrearCuenta
{

	public PageCrearCuenta(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void cuenta(ReadExcelFile leer,Properties propiedades,File rutaCarpeta)
	{
		try {
		//CLICK EN EL CHECKBOX	
		click(btnCheckBox,rutaCarpeta);
		//CLICK BOTON CONTINUAR
		click(btnContinuar,rutaCarpeta);
		//CLICK BOTON VALIDAR EMAIL
		click(btnValidarEmail,rutaCarpeta);
		//INGRESAMOS EL COOREO ELECTRONICO
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "mercadolibre", 2, 1),txtEmail,rutaCarpeta);
		
		} catch (Exception e) {
			imprimirMensaje(e);
			// TODO: handle exception
		}
	}
	public void crearCuenta(ReadExcelFile leer,Properties propiedades,File rutaCarpeta) throws InterruptedException 
	{
		try {
			
		
			//CLICK BOTON CREARCUENTA
			click(btnCrearcuenta,rutaCarpeta);
			//INVOCA EL METODO CUENTA
			cuenta(leer,propiedades,rutaCarpeta);
			//driver.close();
		} catch (Exception e) {
			imprimirMensaje(e);
			// TODO: handle exception
		}
		
	}
	
	public void crearCuentaLink(ReadExcelFile leer,Properties propiedades,File rutaCarpeta) throws InterruptedException 
	{
		try {
			//CLICK BOTON COOKIES
			click(btnCookie,rutaCarpeta);
			//CLICK LINK CREARCUENTA
			click(linkCrearcuenta,rutaCarpeta);
			//INVOCA EL METODO CUENTA
			cuenta(leer,propiedades,rutaCarpeta);
			//driver.close();
		} catch (Exception e) {
			imprimirMensaje(e);
			// TODO: handle exception
		}
		
	}
}
