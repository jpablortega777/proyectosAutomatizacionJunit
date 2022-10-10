package PagesObjets;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import MapsObjets.MapObjetCalculadoraOperaciones;
import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.MobileElement;
import UtilidadesExcel.ReadExcelFile;

public class PageObjetCalculadoraOperaciones extends MapObjetCalculadoraOperaciones
{

	public PageObjetCalculadoraOperaciones(AppiumDriver driver) {
		super(driver);
		this.driver = (AppiumDriver)driver;// TODO Auto-generated constructor stub
	}

	public void operaciones(ReadExcelFile leer,Properties propiedades, File rutaCarpeta) throws  Exception
	{
		
		//CLICK EN BOTON BORRAR
		click(btnBorrar, rutaCarpeta);
		//SEPARAMOS LOS DATOS TIMPO STRING
		//INGRESO DE NUMEROS A LA CALCULADORA
		numIngresadosCalculadora(leer.getCellValue(propiedades.getProperty("filePathExcel"), "calculadora", 1, 0),btnsNumeros,rutaCarpeta);
		//CLICK EN LA OPERACION MATEMATICA
		click(localizadorVariable(btnOperaciones,leer.getCellValue(propiedades.getProperty("filePathExcel"), "calculadora", 1, 1)), rutaCarpeta);
		//INGRESO DE NUMEROS A LA CALCULADORA		
		numIngresadosCalculadora(leer.getCellValue(propiedades.getProperty("filePathExcel"), "calculadora", 1, 2),btnsNumeros,rutaCarpeta);		
		//CLICK EN EL BOTON IGUAL
		click(btnIgual, rutaCarpeta);
	}
	
	
	
}
