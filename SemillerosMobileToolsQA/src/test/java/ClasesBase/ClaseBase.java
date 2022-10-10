package ClasesBase;

import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
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
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import UtilidadesExcel.ReadExcelFile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
//import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.android.nativekey.AndroidKey;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class ClaseBase {
	
	@SuppressWarnings("rawtypes")
	protected AppiumDriver driver;
	//CONSTRUCTOR DE LA CLASE BASE
	public ClaseBase(AppiumDriver<MobileElement> driver) {
		super();
	}
	
	//METODO CONEXION PAGINA WEB EN CHROMEDRIVER
	@SuppressWarnings("rawtypes")
	public static AppiumDriver appiumDriverConnetion(Properties propiedades, ReadExcelFile leer, String nomHoja, int row, int colum)
    {
        AppiumDriver driver = null;
        try
        {
            // CREARLAS CAPABILITYS DEL MOVIL
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", propiedades.getProperty("platformName"));
            caps.setCapability("deviceName",propiedades.getProperty("deviceName"));
            caps.setCapability("platformVersion",propiedades.getProperty("platformVersion"));
            caps.setCapability("appPackage", (leer.getCellValue(propiedades.getProperty("filePathExcel"), ""+nomHoja+"", row, colum)));
            caps.setCapability("appActivity", (leer.getCellValue(propiedades.getProperty("filePathExcel"), ""+nomHoja+"", row, colum+1)));
            caps.setCapability("noReset", propiedades.getProperty("noReset"));
            caps.setCapability("autoGrantPermissions", propiedades.getProperty("autoGrantPermissions"));
            
            //INSTANCIAR APPIUM DRIVER
            try
            {
                printConsola("cargando capability de appium, favor esperar ....");
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);                    
                
            }
            catch (MalformedURLException e)
            {
                printConsola(e.getMessage());
            }
        return driver;
        }
        catch (Exception e)
        {
            printConsola(e.getMessage());
        }
        return driver;
    }
		//METODO DEL CLICK
		public void click(By locator,File rutaCarpeta) throws Exception
		{
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			
			driver.findElement(locator).click();
			tiempoEspera(2);
			captureScreen(rutaCarpeta,nomTest);
			
		}
		//METODO BORRAR
		public void borrar(By locator,File rutaCarpeta) throws Exception
		{
			try {
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			driver.findElement(locator).clear();
			//driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			tiempoEspera(5);
			captureScreen(rutaCarpeta,nomTest);
			}catch(Exception e) {
				imprimirMensaje(e);
			}
		}
		//METODO ENVIAR TEXTO
		public void sendkey(String inputText, By locator,File rutaCarpeta) throws Exception
		{
			try {
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			
			driver.findElement(locator).sendKeys(inputText);
			tiempoEspera(2);
			captureScreen(rutaCarpeta,nomTest);
			}catch(Exception e) {
				imprimirMensaje(e);
			}
		}
		//METODO ENTER SUBMIN
		public void submit(By locator,File rutaCarpeta) throws Exception
		{
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			driver.findElement(locator).submit();
			tiempoEspera(2);
			captureScreen(rutaCarpeta,nomTest);
		}
		//METODO ENTER
		public void enter(File rutaCarpeta)throws Exception
		{
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
			tiempoEspera(2);
			captureScreen(rutaCarpeta,nomTest);
		}
		//METODO TIEMPO DE ESPERA
		public void tiempoEspera(long tiempo) throws InterruptedException
		{
			//Thread.sleep(tiempo);
			driver.manage().timeouts().implicitlyWait(tiempo, TimeUnit.SECONDS);
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
			tiempoEspera(2);
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
		public void captureScreen(File rutaCarpeta, String nomTest)throws WebDriverException
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
		//METODO IMPRIMER EN CONSOLA
		public static void printConsola(String mensaje) 
		{
			System.out.println(mensaje);
		}
		//METODO PARA REMPLAZAR XPATH
		public By localizadorVariable(By locator,String valor) 
		{
			String nuevoXpath=locator.toString().replace("{0}", valor);
			nuevoXpath=nuevoXpath.replace("By.xpath:", "");
			By localizador= By.xpath(nuevoXpath);
			return localizador;
		}
		//METODO RECORRER STRING
		public void numIngresadosCalculadora(String num,By locator,File rutaCarpeta) throws Exception
		{
			
			for(int i=0;i<num.length();i++) 
			{
				click(localizadorVariable(locator,String.valueOf(num.charAt(i))), rutaCarpeta);
			}
			
		}
		//METODO SCROLL PARA TELEFONO MOBILE
		public void scrollVertical(File rutaFile, int xini,int yini, int yfinal, int iteraciones) throws Exception
	    {
	        
	        for (int i = 1 ;i<=iteraciones;i++)
	        {
	            @SuppressWarnings("rawtypes")
	            TouchAction touch = new TouchAction(driver);
	            touch.press(PointOption.point(xini,yini))
	            .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
	            .moveTo(PointOption.point(xini,yfinal))
	            .release().perform();

	        }
	    }
	
				
}
