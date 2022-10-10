package RunsTests;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;



import ClasesBase.ClaseBase;
import PagesObjets.PageObjetBuscarEnGoogle;
import PagesObjets.PageObjetCalculadoraOperaciones;
import PagesObjets.PageObjetMercadoLibreCrearCuenta;
import PagesObjets.PageObjetMercadoLibreHome;
import PagesObjets.PageObjetShopee;
import io.appium.java_client.AppiumDriver;
import UtilidadesExcel.MyScreenRecorder;
import UtilidadesExcel.ReadExcelFile;
import UtilidadesExcel.WriteExcelFile;



public class RunTest 
{
	@SuppressWarnings("rawtypes")
	private AppiumDriver driver;
	ClaseBase claseBase;
	ReadExcelFile leer;
	WriteExcelFile escribir;
	PageObjetCalculadoraOperaciones pagCalculadora;
	PageObjetShopee pagShopee;
	PageObjetBuscarEnGoogle pagGoogle;
	PageObjetMercadoLibreHome pagMLHome;
	PageObjetMercadoLibreCrearCuenta pagMLCuenta;
	Properties propiedades= new Properties();
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() 
	{
	
				
				//INSTACIAMOS LAS CLASES DE EXCEL PARA LEER Y ESCRIBIR
				leer = new ReadExcelFile();
				escribir = new WriteExcelFile();
				//CREAR VARIABLE TIPO INPUTSTREAM
				InputStream entrada=null;
				//VALIDAR SI NO GENERA ERROR AL NO ENCONTRAR EL ARCHIVO
				try 
				{
					//GUARDAMOS LOS DATOS DE PROPERTIES EN LA VALRIABLE ENTRADA 
					entrada = new FileInputStream("./Properties/datos.properties");
					propiedades.load(entrada);
				} 
				catch(Exception e)
				{
					e.printStackTrace();
					System.out.println(e);
				}
							
				
	}
	@Test
	public void testMercadoLibre() throws  Exception
	
	{
				if ((leer.getCellValue(propiedades.getProperty("filePathExcel"), "google", 1, 3)).equals("Si")) 
				{
				//SE GUARDA EL DRIVER
				driver=ClaseBase.appiumDriverConnetion(propiedades,leer,"google",1,4);
				//INSTANCIA LA CLASEBASE
				claseBase = new ClaseBase(driver);
				//INSTANCIA DE LA CLASE PageObjetBuscarEnGoogle
				pagGoogle= new PageObjetBuscarEnGoogle(driver);
				//INSTANCIA DE LA CLASE PageObjetMercadoLibreHome
				pagMLHome= new PageObjetMercadoLibreHome(driver);
				//INSTANCIA DE LA CLASE PageObjetMercadoLibreCrearCuenta
				pagMLCuenta= new PageObjetMercadoLibreCrearCuenta(driver); 
				//OBTENER EL NOMBRE DEL METODO A EJECUTAR
				String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
				//CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
				File rutaCarpeta = claseBase.crearCarpeta(propiedades,nomTest);
				//INICIO DE LA GRABACION DEL VIDEO
				MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
				//INGRESAMOS A LA PAGINA PRINCIPAL
				pagGoogle.buscarGoogle(leer,propiedades,rutaCarpeta);
				//PAGINA DE INICIO MERCADO LIBRE
				pagMLHome.mercadolibreHome(leer,propiedades,rutaCarpeta);
				//PAGINA DE MERCADO LIBRE CREAR CUENTA
				pagMLCuenta.mercadolibreHomeCrearCuenta(leer,propiedades,rutaCarpeta);
				//FINALIZA GRABACION DE VIDEO
				MyScreenRecorder.stopRecording();
				}else {
					driver=ClaseBase.appiumDriverConnetion(propiedades,leer,"google",1,4);
					pagGoogle.printConsola("No se ha selecionado la Automatización");
				}
				
				
	}/*
	@Test
	public void testShopee() throws  Exception
	
	{
				if ((leer.getCellValue(propiedades.getProperty("filePathExcel"), "shopee", 1, 3)).equals("Si")) 
				{
				//SE GUARDA EL DRIVER
				driver=ClaseBase.appiumDriverConnetion(propiedades,leer,"shopee",1,4);
				//INSTANCIA LA CLASEBASE
				claseBase = new ClaseBase(driver);
				pagShopee= new PageObjetShopee(driver);
				
				//OBTENER EL NOMBRE DEL METODO A EJECUTAR
				String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
				//CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
				File rutaCarpeta = claseBase.crearCarpeta(propiedades,nomTest);
				//INGRESAMOS A LA PAGINA PRINCIPAL
				pagShopee.inicioSesion(leer,propiedades,rutaCarpeta);
				}else {
					driver=ClaseBase.appiumDriverConnetion(propiedades,leer,"shopee",1,4);
					pagCalculadora.printConsola("No se ha selecionado la Automatización");
				}
				
				
	}/*
	
	@Test
	public void testCalcularadora() throws  Exception
	
	{
				if ((leer.getCellValue(propiedades.getProperty("filePathExcel"), "calculadora", 1, 3)).equals("Si")) 
				{
					//INSTANCIA LA CLASE PageObjetToolsQAHome
					driver=ClaseBase.appiumDriverConnetion(propiedades,leer,"calculadora",1,4);
					//INSTANCIA LA CLAGE PageMercuryHome
					claseBase = new ClaseBase(driver);
					pagCalculadora= new PageObjetCalculadoraOperaciones(driver);
					//OBTENER EL NOMBRE DEL METODO A EJECUTAR
					String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
					//CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
					File rutaCarpeta = claseBase.crearCarpeta(propiedades,nomTest);
					//INGRESAMOS A LA PAGINA PRINCIPAL
					pagCalculadora.operaciones(leer,propiedades, rutaCarpeta);
				}else {
					driver=ClaseBase.appiumDriverConnetion(propiedades,leer,"calculadora",1,4);
					pagCalculadora.printConsola("No se ha selecionado la Automatización");

				}		
	}*/
	
	
	
	@After
	public void cerrar()
	{
		driver.quit();
	}


}
