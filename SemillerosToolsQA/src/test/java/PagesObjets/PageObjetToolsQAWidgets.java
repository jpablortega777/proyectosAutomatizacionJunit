package PagesObjets;

import java.awt.AWTException;
import java.io.File;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import MapsObjets.MapObjetToolsQAWidgets;

public class PageObjetToolsQAWidgets extends MapObjetToolsQAWidgets
{

	public PageObjetToolsQAWidgets(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//METODO DATE PICKER
	public void datePicker(File rutaCarpeta) throws Exception 
	{
		
		//MOVER SCROLL
		moverScroll(200, 1);
		//CLICK
		click(btnMenuDataPicker,rutaCarpeta);
		//CLICK
		click(selectDate,rutaCarpeta);
		tiempoEspera(1000);
		//CLICK
		click(selectDateMAgust,rutaCarpeta);
		tiempoEspera(3000);
		//CLICK
		click(selectDateD7,rutaCarpeta);
		tiempoEspera(2000);
		//CLICK
		click(dateTime,rutaCarpeta);
		tiempoEspera(3000);
		//CLICK
		click(btnDateMes,rutaCarpeta);
		tiempoEspera(2000);
		//CLICK
		click(dateTimeMes,rutaCarpeta);
		tiempoEspera(2000);
		//CLICK
		click(dateTimeDia,rutaCarpeta);
		tiempoEspera(2000);
		//CLICK
		click(dateTimeHora,rutaCarpeta);
		captureScreen(rutaCarpeta, null);
	}
	//METODO DETERMINAR HORA
	
	public void datePicketTest2(Properties propiedades,File rutaCarpeta) 
	{
		try {
		//MOVER SCROLL
		moverScroll(200, 1);
		//cLICK
		click(btnMenuDataPicker,rutaCarpeta);
		tiempoEspera(2000);
		//DELETE
		borrar(selectDate, rutaCarpeta);
		tiempoEspera(2000);
		//ENVIAR DATO selectDate
		sendkey(dateWidgest(1,1,1),selectDate,rutaCarpeta);
		//DELETE
		borrar(dateTime, rutaCarpeta);
		tiempoEspera(2000);
		//ENVIAR DATO dateTime
		sendkey(dateWidgest(1,1,1),dateTime,rutaCarpeta);
		tiempoEspera(2000);
		submit(dateTime, rutaCarpeta);
		
		}catch(Exception e) {
		System.out.println("Error="+e);
		}
	}
}
