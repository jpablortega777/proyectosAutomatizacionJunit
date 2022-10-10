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
import PagesObjets.PageObjetToolsQAAlerts;
import PagesObjets.PageObjetToolsQAHome;
import PagesObjets.PageObjetToolsQAWidgets;
import UtilidadesExcel.MyScreenRecorder;


public class RunTest 
{
	private WebDriver driver;
	ClaseBase claseBase;
	
	PageObjetToolsQAHome pagHome;
	PageObjetToolsQAAlerts pagAlerts;
	PageObjetToolsQAWidgets pagWidgets;
	Properties propiedades= new Properties();
	
	@Before
	public void setUp() 
	{
	
				

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
				
				driver= ClaseBase.chromeDriverConnection();
				//INSTANCIA LA CLASE PageObjetToolsQAHome
				pagHome=new PageObjetToolsQAHome(driver);
				//INSTANCIA LA CLAGE PageMercuryHome
				pagAlerts= new PageObjetToolsQAAlerts(driver);
				//INSTANCIA LA CLAGE PageObjetToolsQAWidgets
				pagWidgets= new PageObjetToolsQAWidgets(driver);
				//INSTANCIA LA CLAGE ClaseBase
				claseBase = new ClaseBase(driver);
				//driver= paginas.chromeDriverConnection();
				
				
				//pagWidgets.datePicketTest2();
				
	}
	@Test
	public void testToolsQAAlerts() throws  Exception
	
	{
				//CARGAMOS LA URL DE TOOLS QA
				pagHome.urlAcceso(propiedades.getProperty("url"));
				//OBTENER EL NOMBRE DEL METODO A EJECUTAR
				String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
				//CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
				File rutaCarpeta = claseBase.crearCarpeta(propiedades,nomTest);
				//INICIO DE LA GRABACION DEL VIDEO
				MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
				//INGRESAMOS A LA PAGINA PRINCIPAL
				pagHome.accessoAlertsFrameWindows(rutaCarpeta);
				//
				pagAlerts.desplegueAlertas(propiedades,rutaCarpeta);
				//FINALIZA GRABACION DE VIDEO
				MyScreenRecorder.stopRecording();
	}
	/*
	@Test
	public void testToolsQAWidgets() throws  Exception
	
	{
				//OBTENER EL NOMBRE DEL METODO A EJECUTAR
				String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
				//CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
				File rutaCarpeta = claseBase.crearCarpeta(propiedades,nomTest);
				//INICIO DE LA GRABACION DEL VIDEO
				MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
				//INGRESAMOS A LA PAGINA PRINCIPAL
				pagHome.accessoWidgets(rutaCarpeta);
				//
				pagWidgets.datePicker(rutaCarpeta);
				//pagAlerts.desplegueAlertas(propiedades,rutaCarpeta);
				//FINALIZA GRABACION DE VIDEO
				MyScreenRecorder.stopRecording();
	}*/
	@Test
	public void test2ToolsQAWidgets() throws  Exception
	
	{
				//CARGAMOS LA URL DE TOOLS QA
				pagHome.urlAcceso(propiedades.getProperty("url"));
				//OBTENER EL NOMBRE DEL METODO A EJECUTAR
				String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
				//CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
				File rutaCarpeta = claseBase.crearCarpeta(propiedades,nomTest);
				//INICIO DE LA GRABACION DEL VIDEO
				MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
				//INGRESAMOS A LA PAGINA PRINCIPAL
				pagHome.accessoWidgets(rutaCarpeta);
				//
				//pagWidgets.datePicker(rutaCarpeta);
				//pagAlerts.desplegueAlertas(propiedades,rutaCarpeta);
				pagWidgets.datePicketTest2(propiedades,rutaCarpeta);
				//FINALIZA GRABACION DE VIDEO
				MyScreenRecorder.stopRecording();
	}
	
	
	@After
	public void cerrar()
	{
		driver.quit();
	}


}
