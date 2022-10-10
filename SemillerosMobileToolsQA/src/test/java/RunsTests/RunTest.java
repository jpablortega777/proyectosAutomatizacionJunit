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
import PagesObjets.PageObjetToolsQAAlertas;
import PagesObjets.PageObjetToolsQAHome;
import PagesObjets.PageObjetToolsQAWidgets;
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
	PageObjetBuscarEnGoogle pagGoogle;
	PageObjetToolsQAHome pagTQAHome;
	PageObjetToolsQAAlertas pagTQAAlertas;
	PageObjetToolsQAWidgets pagTQAWidgets;
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
				//SE GUARDA EL DRIVER
				driver=ClaseBase.appiumDriverConnetion(propiedades,leer,"google",1,4);
				//INSTANCIA LA CLASEBASE
				claseBase = new ClaseBase(driver);
				//INSTANCIA DE LA CLASE PageObjetBuscarEnGoogle
				pagGoogle= new PageObjetBuscarEnGoogle(driver);
				//INSTANCIA DE LA CLASE PageObjetToolsQAHome
				pagTQAHome= new PageObjetToolsQAHome(driver);
				//INSTANCIA DE LA CLASE PageObjetToolsQAAlertas
				pagTQAAlertas= new PageObjetToolsQAAlertas(driver); 
				//INSTANCIA DE LA CLASE PageObjetToolsQAWidgets
				pagTQAWidgets= new PageObjetToolsQAWidgets(driver); 
				
	}
	@Test
	public void testToolsQAAlertas() throws  Exception
	
	{
				if ((leer.getCellValue(propiedades.getProperty("filePathExcel"), "google", 1, 3)).equals("On")) 
				{
				
				//OBTENER EL NOMBRE DEL METODO A EJECUTAR
				String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
				//CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
				File rutaCarpeta = claseBase.crearCarpeta(propiedades,nomTest);
				//INICIO DE LA GRABACION DEL VIDEO
				MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
				//INGRESAMOS A LA PAGINA PRINCIPAL
				pagGoogle.buscarGoogle(leer,propiedades,rutaCarpeta);
				//PAGINA DE INICIO TOOLS QA
				pagTQAHome.selectAlerts(leer,propiedades,rutaCarpeta);
				//PAGINA DE TOOLS QA ALERTAS
				pagTQAAlertas.alertas(leer,propiedades,rutaCarpeta);
				//FINALIZA GRABACION DE VIDEO
				MyScreenRecorder.stopRecording();
				
				}else {
					driver=ClaseBase.appiumDriverConnetion(propiedades,leer,"google",1,4);
					pagGoogle.printConsola("No se ha selecionado la Automatización");
				}
				
				
	}
	@Test
	public void testToolsQAWidgets() throws  Exception
	
	{
			if ((leer.getCellValue(propiedades.getProperty("filePathExcel"), "google", 1, 3)).equals("On")) 
			{
				
				//OBTENER EL NOMBRE DEL METODO A EJECUTAR
				String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
				//CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
				File rutaCarpeta = claseBase.crearCarpeta(propiedades,nomTest);
				//INICIO DE LA GRABACION DEL VIDEO
				MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
				//INGRESAMOS A LA PAGINA PRINCIPAL
				pagGoogle.buscarGoogle(leer,propiedades,rutaCarpeta);
				//PAGINA DE INICIO TOOLS QA
				pagTQAHome.selectWidgets(leer,propiedades,rutaCarpeta);
				//PAGINA WIDGETS TOOLS QA
				pagTQAWidgets.widgets(leer, propiedades, rutaCarpeta);
				//FINALIZA GRABACION DE VIDEO
				MyScreenRecorder.stopRecording();		
						
			}else {
				driver=ClaseBase.appiumDriverConnetion(propiedades,leer,"google",1,4);
				pagGoogle.printConsola("No se ha selecionado la Automatización");
			}
				
				
	}
	
	@After
	public void cerrar()
	{
		driver.quit();
	}


}
