import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Lino {
	//CREAR OBJETO TIPO WEBDRIVER
		private WebDriver driver;
		
		//CREAR ANOTACIONES JUNIT
		@Before
		public void navegadorChrome() 
		{
			//SETEAR LAS PROPIEDADES DEL EJECUTABLE DE CHROME
			System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Desktop\\Semillero periferia/chromedriver.exe");
			//DECLARAR EL OBJERTO DRIVER TIPO CHROMEDIVER
			driver = new ChromeDriver();
			//MAXIMIZAR VENTANA DE NAVEGADOR 
			driver.manage().window().maximize();
			
			//INGRESAR LA URL DE PAGINA DE ACCESO
			driver.get("https://www.linio.com.co/");
		}
		
		@Test
		public void iniciarPrueba() throws InterruptedException  
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
			//CREAR UN OBJETO DE LA PAGINA PRINCIPAL
			WebElement txtBusqueda = driver.findElement(By.xpath("//div/div/input[@name='q']"));
			//LIMPIAR LA CAJA DE TEXTO DE BUSQUEDA
			txtBusqueda.clear();
			//ENVIAR UN VALOR A BUSCAR
			txtBusqueda.sendKeys("cadena oro");
			txtBusqueda.submit();
			//CLICK EN EL LINK DEL PRODUCTO 
			WebElement linkProducto = driver.findElement(By.xpath("//a/div/p/span[text()='Cadena Singapur 50m + Dije Cruz Oro Lami...']"));
			linkProducto.click();
			//CLICK EN ADD CARRITO
			WebElement botonAddCarrito = driver.findElement(By.xpath("//button[@id='buy-now']"));
			//CLICK EN ADD CARRITO
			botonAddCarrito.click();
			//AGREGAMOS UN RETARDO DE 1,5S 			
			//wait.until(ExpectedConditions.elementToBeClickable(botonAddCarrito));
			Thread.sleep(1500);
			//CLICK EN EL BOTON "IR AL CARRITO"
			WebElement botonIralCarrito = driver.findElement(By.xpath("//div[@class='alert alert-body']/div/a[@class='btn btn-sm btn-go-to-cart added-product'][text()='Ir al carrito']"));
			botonIralCarrito.click();
			//CLICK EN BOTON "PROCESAR COMPRA"
			WebElement botonProcesarCompra = driver.findElement(By.xpath("//a[@class='btn btn-lg btn-primary summary-btn-process-pay col-md-12']"));
			//CREAMOS UN RETARDO DE 5 SEGUNDOS
			wait.until(ExpectedConditions.elementToBeClickable(botonProcesarCompra));
			botonProcesarCompra.click();
			//CLICK EN EL ENLACE "CREAR CUENTA"
			WebElement linkCuenta = driver.findElement(By.xpath("//a[text()='Crear cuenta']"));
			linkCuenta.click();
			//-----APARTIR DE AQUI SE HACE LA SECUENCIA DE LLENAR LOS CAMPOS------------------//
			//ESCRIBIR EN EL CAMPO NOMBRE
			WebElement txtNombre = driver.findElement(By.xpath("//input[@id='registration_firstName']"));
			txtNombre.clear();
			txtNombre.sendKeys("Juan Pablo");
			//ESCRIBIR EN EL CAMPO APELLIDO
			WebElement txtApellido = driver.findElement(By.xpath("//input[@id='registration_lastName']"));
			txtApellido.clear();
			txtApellido.sendKeys("Ortega");
			//ESCRIBIR EN EL CAMPO EMAIL
			WebElement txtEmail = driver.findElement(By.xpath("//input[@id='registration_email']"));
			txtEmail.clear();
			txtEmail.sendKeys("jpablortega777@gmail.com");
			//ESCRIBIR EN EL CAMPO PASSWORD
			WebElement txtPassword = driver.findElement(By.xpath("//input[@id='registration_password']"));
			txtPassword.clear();
			txtPassword.sendKeys("12345678");
			//ESCRIBIR EN EL CAMPO CEDULA
			WebElement txtCedula = driver.findElement(By.xpath("//input[@id='registration_nationalRegistrationNumber']"));
			txtCedula.clear();
			txtCedula.sendKeys("12345678");
			//SELECCIONAR CHECK TERMINOS Y CONDICIONES
			WebElement checkboxTerminos = driver.findElement(By.xpath("//label[@for='registration_acceptTerms']"));
			checkboxTerminos.click();
			//SELECCIONAR CHECK ACUMULAR PUNTOS
			WebElement checkboxAcumularPuntos = driver.findElement(By.xpath("//label[@for='registration_cmrPointsAcceptedSubscription']"));
			checkboxAcumularPuntos.click();
			
		
		}
		@After
		public void cerrarNavegador() 
		{
			driver.quit();
		}


}
