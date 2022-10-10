package PagesObjets;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Alert;
import MapsObjets.MapObjetToolsQAAlerts;

public class PageObjetToolsQAAlerts extends MapObjetToolsQAAlerts
{

	public PageObjetToolsQAAlerts(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//METODO DESPLEGUE DE ALERTAS 
	public void desplegueAlertas(Properties propiedades,File rutaCarpeta)throws  Exception
	{
		try
		{
		//INVOCAMOS METODO SCROLL
		moverScroll(200,1);
		//INVOCAMOS METODO CLICK
		click(btnItemAlertas,rutaCarpeta);
		//INVOCAMOS METODO SCROLL
		moverScroll(200,1);
		//INVOCAMOS METODO CLICK
		click(btnAlerta,rutaCarpeta);
		tiempoEspera(2000);
		//INVOCAMOS METODO CLICK
		driver.switchTo().alert().accept();
		tiempoEspera(2000);
		//INVOCAMOS METODO CLICK
		click(btnTimeAlerta,rutaCarpeta);
		tiempoEspera(6000);
		//INVOCAMOS METODO CLICK
		driver.switchTo().alert().accept();
		tiempoEspera(2000);
		//INVOCAMOS METODO CLICK
		click(btnConfirmAlerta,rutaCarpeta);
		tiempoEspera(2000);
		driver.switchTo().alert().accept();
		tiempoEspera(2000);
		//INVOCAMOS METODO CLICK
		click(btnConfirmAlerta,rutaCarpeta);
		tiempoEspera(2000);
		driver.switchTo().alert().dismiss();
		//INVOCAMOS METODO CLICK
		click(btnpromtAlerta,rutaCarpeta);
		tiempoEspera(2000);
		//String texto=(String)propiedades.getProperty("text");
		driver.switchTo().alert().sendKeys("Automatizacion");
		//sendKeyAlerts(propiedades);
		driver.switchTo().alert().accept();
		captureScreen(rutaCarpeta,"click");
		tiempoEspera(5000);
		driver.switchTo().parentFrame();
		driver.close();
		}catch(Exception e)
		{
			System.out.println("Error:"+e);
		}
		
	}
	
	
}
