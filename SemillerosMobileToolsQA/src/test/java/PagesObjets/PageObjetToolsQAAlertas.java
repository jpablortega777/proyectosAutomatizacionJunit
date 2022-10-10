package PagesObjets;

import java.io.File;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import MapsObjets.MapObjetToolsQAAlertas;
import UtilidadesExcel.ReadExcelFile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageObjetToolsQAAlertas extends MapObjetToolsQAAlertas
{

	public PageObjetToolsQAAlertas(AppiumDriver<MobileElement> driver) {
		super(driver);
		this.driver = (AppiumDriver)driver;// TODO Auto-generated constructor stub
	}
	//METODO CREAR CUENTA
	public void alertas(ReadExcelFile leer,Properties propiedades,File rutaCarpeta) throws Exception 
	{
		try {
			//CLICK EN BOTON CREAR CUENTA
			click(linkAlertas, rutaCarpeta);
			tiempoEspera(15);
			//REALIZAMOS UN SCROLL PARA ENCONTRAR EL BOTON DEL CARRITO
			scrollVertical(rutaCarpeta,550,600,1300,2);
			tiempoEspera(15);
			Thread.sleep(2000);
			//REALIZAMOS UN SCROLL PARA ENCONTRAR EL BOTON DEL CARRITO
			scrollVertical(rutaCarpeta,880,1000,500,2);
			tiempoEspera(10);
			//CLICK EN BOTON CREAR CUENTA
			click(btnAlerta, rutaCarpeta);
			tiempoEspera(10);
			//CLICK EN BOTON ACEPTAR ALERTA
			click(btnAceptarAlerta, rutaCarpeta);
			tiempoEspera(10);
			//CLICK EN BOTON TIMER ALERTA
			click(btnTimerAlerta,rutaCarpeta);
			tiempoEspera(10);
			//CLICK EN BOTON ACEPTAR ALERTA TIMER
			click(btnAceptarTimerAlerta,rutaCarpeta);
			tiempoEspera(10);
			//CLICK EN BOTON CONFIRMAR ALERTA
			click(btnConfirmacionAlerta,rutaCarpeta);
			tiempoEspera(10);
			//CLICK BOTON ACEPTAR CONFIRMACION
			click(btnAceptarConfirmAlerta,rutaCarpeta);
			tiempoEspera(10);
			//CLICK BOTON CONFIRMAR ALERTA
			click(btnConfirmacionAlerta,rutaCarpeta);
			tiempoEspera(10);
			//CLICK BOTON CANCELAR CONFIRMACION
			click(btnCancelarConfirmAlerta,rutaCarpeta);
			tiempoEspera(10);
			//CLICK BOTON ENVIAR TEXTO ALERTA
			click(btnTextAlerta,rutaCarpeta);
			tiempoEspera(10);
			//ENVIAR TEXTO DEL EXCEL EN EL CAMPO TEXT
			sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "toolsqa", 1, 0), txtAlerta, rutaCarpeta);
			tiempoEspera(10);
			//CLICK EN ACEPTAR PARA ENVIAR TEXTO
			click(btnAceptarText,rutaCarpeta);
			tiempoEspera(10);
			} catch (Exception e) {
				System.out.println(e);
			}
		
		
	}
	
}
