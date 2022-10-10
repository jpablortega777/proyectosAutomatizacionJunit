package ClasesBase;

import java.io.File;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;


public class ClaseBase {
	
	protected static WebDriver driver;
	//CONSTRUCTOR DE LA CLASE BASE
	public ClaseBase(WebDriver driver) {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//METODO CONEXION PAGINA WEB EN CHROMEDRIVER
		public static WebDriver chromeDriverConnection() 
		{
			//SETEAR LAS OPCIONES DEL NAVEGADOR
			ChromeOptions chromeOptions= new ChromeOptions();
			chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			
			//SETEAR LAS PROPIEDADES DEL NAVEGADOR
			System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
			
			
			driver = new ChromeDriver();
			
			//MIXIMIZAR EL NAVEGADOR 
			driver.manage().window().maximize();
			return driver;
		}
		//METODO DEL CLICK
		public void click(By locator,File rutaCarpeta) throws Exception
		{
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			captureScreen(rutaCarpeta,nomTest);
			driver.findElement(locator).click();
			tiempoEspera(2000);
			
		}
		//METODO BORRAR
		public void borrar(By locator,File rutaCarpeta) throws Exception
		{
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			//driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
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
		public String fechaHora()
		{
			//TOMAMOS LA FECHA DEL SISTEMA 
			LocalDateTime fechaSistema = LocalDateTime.now();
			//DEFINIR FORMATO FECHA 
			DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyy-MM-dd-HHmmss");
			//DAR FORMATO A LA FECHA DEL SISTEMA
			String formatFecha = fecha.format(fechaSistema);
			return formatFecha;
		}
		//METODO CAPTURA DE HORA DEL SISTEMA 
		public String HoraSistema()
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
			File directorio = new File("./output/"+nomCarpeta);
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
		//METODO MOVER EL SCROLLBY
		public void moverScroll(int y,int numMovimiento) throws Exception
		{
			
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int i=0; i<=numMovimiento; i++) {
	    js.executeScript("window.scrollBy(0,"+y+")");
		}
	    tiempoEspera(2000);
		}
		//METODO ENVIAR DATOS A UN ALERTS
		public void sendKeyAlerts(Properties propiedades)
		{
			//driver.switchTo().alert().sendKeys(propiedades.getProperty("text"));
			driver.switchTo().alert().sendKeys("Automatizacion");
			driver.switchTo().alert().accept();
		}
		//METODO PARA LISTA DE MENU EN WIDGETS
		public List<WebElement> listaElementos(By locator) throws Exception
        {
          
            List<WebElement> elemento=driver.findElements(locator);
            return elemento;
            
        }
		//METODO ENVIA FECHA WIDGEST
		public String dateWidgest(int restYear,int restMes,int restDia) 
		{
			
				String[] fechaSeparada = fechaHora().split("-");
				int year=(Integer.parseInt(fechaSeparada[0]))-restYear;
				int mes=(Integer.parseInt(fechaSeparada[1]))-restMes;
				int dia=(Integer.parseInt(fechaSeparada[2]))-restDia;
				
				String Date=""+mes+"/"+dia+"/"+year+"";
				
			return Date;
		}
}
