package PagesObjets;

import java.io.File;

import org.openqa.selenium.WebDriver;

import MapsObjets.MapObjetMercuryHome;

public class PageMercuryHome extends MapObjetMercuryHome
{
	
	public PageMercuryHome(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

		//METODO INICIAL
		public void urlAccesoMercury(String url)
		{
			driver.get(url);
		}
		
		//METODO INGRESAR LINK REGISTER
		public void irLinkRegistro(File rutaCarpeta) throws Exception 
		{
			//CLICK EN LINK DE REGISTRO
			click(linkRegistro, rutaCarpeta);
		}

}
