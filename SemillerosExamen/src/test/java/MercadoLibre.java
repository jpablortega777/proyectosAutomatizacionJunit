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

public class MercadoLibre {
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
			driver.get("https://www.mercadolibre.com.co/");
		}
		
		@Test
		public void iniciarPrueba() throws InterruptedException  
		{
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
			//ACEPTAR COOKIE
			WebElement btnCookie = driver.findElement(By.xpath("//div[@class='cookie-consent-banner-opt-out__actions']/button[text()='Entendido']"));
			btnCookie.click();
			//CREAR UN OBJETO DE LA PAGINA PRINCIPAL
			WebElement txtBusqueda = driver.findElement(By.xpath("//*[@id='cb1-edit']"));
			//LIMPIAR LA CAJA DE TEXTO DE BUSQUEDA
			txtBusqueda.clear();
			//ENVIAR UN VALOR A BUSCAR
			txtBusqueda.sendKeys("cadena oro");
			txtBusqueda.submit();
			Thread.sleep(1000);
			//CLICK EN EL CLOSE DE UBICACION
			WebElement closeUbicacion = driver.findElement(By.xpath("//button[@class='andes-tooltip-button-close']"));
			closeUbicacion.click();
			
			
			
			//CLICK EN EL LINK DEL PRODUCTO 
			WebElement linkProducto = driver.findElement(By.xpath("//*[@src='https://http2.mlstatic.com/D_NQ_NP_915069-MCO48941383812_012022-V.webp']"));
			linkProducto.click();
			Thread.sleep(10000);
			
			
			//CLICK EN ADD CARRITO
			
			WebElement botonAddCarrito = driver.findElement(By.xpath("//button/span[text()='Agregar al carrito']"));
			botonAddCarrito.click();
			
			//AGREGAMOS UN RETARDO DE 1,5S 			
			//wait.until(ExpectedConditions.elementToBeClickable(botonAddCarrito));
			//Thread.sleep(1500);
			
			//CLICK EN EL BOTON "CREAR CUENTA"
			
			WebElement btnCrearcuenta = driver.findElement(By.xpath("//span[text()='Crear cuenta']"));
			Thread.sleep(2000);
			btnCrearcuenta.click();
			
		
			
			//CLICK EN BOTON "ACEPTAR  TERMINOS Y CONDICIONES"
			WebElement btnCheckBox = driver.findElement(By.id("terms-and-conds"));
			Thread.sleep(1500);
			btnCheckBox.click();
			
			//CLICK EN EL BOTON "CONTINUAR"
			WebElement btnContinuar = driver.findElement(By.xpath("//span[@class='andes-button__content']"));
			btnContinuar.click();
			//CLICK EN EL BOTON "VALIDAR-EMAIL"
			WebElement btnValidarEmail = driver.findElement(By.xpath("//span[text()='Validar']"));
			btnValidarEmail.click();
			/*
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
			*/
		
		}
		@After
		public void cerrarNavegador() 
		{
			//driver.quit();
		}


}
