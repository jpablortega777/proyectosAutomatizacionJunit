package ClaseBase;

import java.io.File;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class ClasesBase 
{
	protected static WebDriver driver;

	public ClasesBase(WebDriver driver) {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//METODO PAGINA PRINCIPAL
	public static WebDriver chromeDriverConnection() 
	{
		//SETEAR LAS OPCIONES DEL NAVEGADOR
		ChromeOptions chromeOptions= new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
		//SETEAR LAS PROPIEDADES DEL NAVEGADOR
		System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Desktop\\Semillero periferia/chromedriver.exe");
		driver = new ChromeDriver();
		
		//MIXIMIZAR EL NAVEGADOR 
		driver.manage().window().maximize();
		return driver;
	}
	
	//METODO DEL CLICK
	public void click(By locator,File rutaCarpeta) throws Exception
	{
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		driver.findElement(locator).click();
		tiempoEspera(2000);
		captureScreen(rutaCarpeta,nomTest);
	}
	//METODO BORRAR
	public void borrar(By locator,File rutaCarpeta) throws Exception
	{
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		driver.findElement(locator).clear();
		tiempoEspera(2000);
		captureScreen(rutaCarpeta,nomTest);
	}
	//METODO ENVIAR TEXTO
	public void sendkey(String inputText, By locator,File rutaCarpeta) throws Exception
	{
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		driver.findElement(locator).sendKeys(inputText);
		tiempoEspera(2000);
		captureScreen(rutaCarpeta,nomTest);
	}
	//METODO ENTER SUBMIN
	public void submit(By locator,File rutaCarpeta) throws Exception
	{
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		driver.findElement(locator).submit();
		tiempoEspera(2000);
		captureScreen(rutaCarpeta,nomTest);
	}
	//METODO TIEMPO DE ESPERA
	public void tiempoEspera(long tiempo) throws InterruptedException
	{
		Thread.sleep(tiempo);
	}
	//IMPRIMIR MENSAJE CONSOLA
	public void imprimirMensaje(Exception mensaje) 
	{
		System.out.print(mensaje);
	}
	//METODO ENTER CLOSE COOKIE
	public void closeCookie(By locator,File rutaCarpeta)throws Exception
	{
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		captureScreen(rutaCarpeta,nomTest);
		driver.findElement(locator).click();
		tiempoEspera(2000);
		captureScreen(rutaCarpeta,nomTest);
	}
	//METODO CAPTURA DE LA FECHA DEL SISTEMA
	public static String fechaHora()
	{
		//TOMAMOS LA FECHA DEL SISTEMA 
		LocalDateTime fechaSistema = LocalDateTime.now();
		//DEFINIR FORMATO FECHA 
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
		//DAR FORMATO A LA FECHA DEL SISTEMA
		String formatFecha = fecha.format(fechaSistema);
		return formatFecha;
	}
	//METODO CAPTURA DE LA FECHA DEL SISTEMA
		public static String fechaHora2()
		{
			//TOMAMOS LA FECHA DEL SISTEMA 
			LocalDateTime fechaSistema = LocalDateTime.now();
			//DEFINIR FORMATO FECHA 
			DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			//DAR FORMATO A LA FECHA DEL SISTEMA
			String formatFecha = fecha.format(fechaSistema);
			return formatFecha;
		}
	//METODO PARA ELIMINAR ARCHIVOS
		public void eliminarArchivo(String rutaImagen)
		{
			File fichero = new File(rutaImagen);
			fichero.delete();
		}
	//METODO CAPTURA DE HORA DEL SISTEMA 
	public static String HoraSistema()
	{
		//TOMAMOS LA FECHA DEL SISTEMA 
		LocalTime horaSistema = LocalTime.now();
		//DEFINIR FORMATO FECHA 
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("HHmmss");
		//DAR FORMATO A LA FECHA DEL SISTEMA
		String hora = fecha.format(horaSistema);
		return hora;
	}
	//METODO CAPTURA DE SCREENSHOT
	public void captureScreen(File rutaCarpeta, String nomTest) throws Exception
	{
		try
		{
		String hora = HoraSistema();
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(rutaCarpeta+"\\"+nomTest+""+hora+".png"));
		String rutaImagen = new File(rutaCarpeta+"\\"+hora+".png").toString();
		}catch(Exception e)
		{
			System.out.println(e);}
	}
	//METODO CREAR CARPETA
	public File crearCarpeta(Properties propiedades, String nomTest)
	{
		//ALMACENAMOS LA FECHA DEL SISTEMA 
		String fecha = fechaHora();
		//CREAMOS EL NOMBRE DE LA CARPETA 
		String nomCarpeta = nomTest+"-"+fecha;
		//OBTENEMOS LA RUTA DE ALOJAMIENTO DE SALIDA Y EL NOMBRE DEL TEST A EJECUTAR
		File directorio = new File("./Output/"+nomCarpeta);
		//CREAMOS LA CARPETA
		directorio.mkdir();
		return directorio;
	}
	//METODO BUSCAR EN LISTA 
	public void selectOption( String inputText, By locator,File rutaCarpeta) throws Exception
	{
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		//CAPTURAMOS LA LISTA 
		Select selectList= new Select(driver.findElement(locator));
		//HACEMOS VISIBLE EL TEXTO DE ENTRADA
		selectList.selectByVisibleText(inputText);
		tiempoEspera(2000);
		captureScreen(rutaCarpeta,nomTest);
			
	}

}
