package RunsPruebas;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import ClaseBase.ClasesBase;
import PagesObjets.PageCrearCuenta;
import PagesObjets.PageMercuryHome;
import PagesObjets.PageMercuryRegister;
import PagesObjets.PagePaginaPrincipal;
import utilidadesExcel.GenerarReportePdf;
import utilidadesExcel.MyScreenRecorder;
import utilidadesExcel.ReadExcelFile;
import utilidadesExcel.WriteExcelFile;

public class RunPrueba {

	private WebDriver driver;
	PagePaginaPrincipal paginas;
	PageCrearCuenta crearCuenta;
	Properties propiedades= new Properties();
	ReadExcelFile leer;
	WriteExcelFile escribir;
	ClasesBase claseBase;
	PageMercuryHome pagMercuryHome;
	PageMercuryRegister pagMercuryRegister;
	GenerarReportePdf generarReportePdf;
	
	@Before
	public void setUp() throws Exception
	{
		
		
		//INSTACIAMOS LAS CLASES DE EXCEL
		leer = new ReadExcelFile();
		escribir = new WriteExcelFile();
		//CREAR VARIABLE TIPO INPUTSTREAM
		InputStream entrada=null;
		//INSTANCIAMOS CLASEBASE
		claseBase = new ClasesBase(driver);
		//INSTANCIAR CLASE REPORTES
		generarReportePdf = new GenerarReportePdf();
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
		
		driver= ClasesBase.chromeDriverConnection();
		//INSTANCIA LA CLASE PagePaginaPrincipal
		paginas=new PagePaginaPrincipal(driver);
		//INSTANCIA LA CLAGE PageMercuryHome
		pagMercuryHome= new PageMercuryHome(driver);
		//INSTANCIA LA CLAGE PageMercuryRegister
		pagMercuryRegister= new PageMercuryRegister(driver);
		//driver= paginas.chromeDriverConnection();
		
		crearCuenta= new PageCrearCuenta(driver);
		//TRAEMOS EL VALOR DE LA PROPIEDAD URL
		//paginas.urlAcceso(leer.getCellValue(propiedades.getProperty("filePathExcel"), "mercadolibre", 1, 2));
		
		
		
		//paginas.urlAcceso(propiedades.getProperty("url"));
		//TRAEMOS EL VALOR DE LA PROPIEDAD DEL TEXTO A BUSCAR
		//paginas.textBusqueda(propiedades.getProperty("textBuscar"));
		
		
		
	}
	/*
	@Test
	public void test() throws Exception
	{ 
		//INGRESAMOS A LA PAGINA PRINCIPAL
		paginas.busquedainicial();
		
		//CREAR UNA CUENTA
		crearCuenta.crearCuenta();
	}
	*/
	
	@Test
	public void testMercadoLibreLinkCuenta() throws Exception
	{ 
		//TRAEMOS EL VALOR DE LA PROPIEDAD URL
		paginas.urlAcceso(leer.getCellValue(propiedades.getProperty("filePathExcel"), "mercadolibre", 1, 2));
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		//CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
		File rutaCarpeta = claseBase.crearCarpeta(propiedades,nomTest);
		//INGRESAMOS A LA PAGINA PRINCIPAL
		//paginas.busquedainicial();
		//INICIO DE LA GRABACION DEL VIDEO
		MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
		//INICIA CREACION DE REPORTE PDF
		generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);
		//CREAR UNA CUENTA
		crearCuenta.crearCuentaLink(leer,propiedades,rutaCarpeta);
		//FINALIZA GRABACION DE VIDEO
		MyScreenRecorder.stopRecording();
		//INICIA CREACION DE REPORTE PDF
		generarReportePdf.cerrarPalntilla();
	}
	
	/*
	@Test
	public void testMercadolibre() throws Exception
	{ 
		//TRAEMOS EL VALOR DE LA PROPIEDAD URL
		paginas.urlAcceso(leer.getCellValue(propiedades.getProperty("filePathExcel"), "mercadolibre", 1, 2));
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		//CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
		File rutaCarpeta = claseBase.crearCarpeta(propiedades,nomTest);
		//
		
		//INGRESAMOS A LA PAGINA PRINCIPAL POR MEDIO DEL METODO ELIGIENDOPRIMERELEMNTO
		paginas.eligiendoPrimerElemento(leer,propiedades,rutaCarpeta);
		//CREAR UNA CUENTA
		crearCuenta.crearCuenta(leer,propiedades,rutaCarpeta);
	}
	*/
	@Test
	public void testMercuryTours() throws Exception
	{ 
		//URL  MERCURY TOURS
		pagMercuryHome.urlAccesoMercury(leer.getCellValue(propiedades.getProperty("filePathExcel"), "mercurytours", 1, 12));
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		//CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
		File rutaCarpeta = claseBase.crearCarpeta(propiedades,nomTest);
		//INICIA CREACION DE REPORTE PDF
		generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);
		//INICIO DE LA GRABACION DEL VIDEO
		MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
		//INVOCAMOS EL METODO IR REGISTER QUE ESTA EN HOME
		pagMercuryHome.irLinkRegistro(rutaCarpeta);
		//INVOCAMOS EL METODO llenarCamposRegistro
		pagMercuryRegister.llenarCamposRegistro(leer,propiedades,rutaCarpeta);
		//FINALIZA GRABACION DE VIDEO
		MyScreenRecorder.stopRecording();
		//INICIA CREACION DE REPORTE PDF
		generarReportePdf.cerrarPalntilla();
		//String x=leer.getCellValue(propiedades.getProperty("filePathExcel"), "mercurytours", 1, 12);
		//((JavascriptExecutor)driver).executeScript("window.open("+"'"+x+"'"+")");	
		
	}
	@After
	public void cerrar()
	{
		driver.quit();
	}
	
	
	
}
