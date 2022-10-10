package PagesObjets;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import MapsObjets.MapObjetPaginaPrincipal;
import utilidadesExcel.ReadExcelFile;



public class PagePaginaPrincipal extends MapObjetPaginaPrincipal
{
	
	public PagePaginaPrincipal(WebDriver driver) 
	{
		super(driver);
	}
	//METODO INICIAL
	public void urlAcceso(String url)
	{
		driver.get(url);
		
	}
	
	//METODO PRIMERA ETAPA DE ABRIR EL NAVEGADOR 
	public void busquedaCargarPagina(ReadExcelFile leer,Properties propiedades,File rutaCarpeta) 
	{
		try {
			
		//CLICK CERRAR COOKIES	
		closeCookie(btnCookie,rutaCarpeta);
		//TECLADO ESCRIBE DATOS DE BUSQUEDA
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "mercadolibre", 1, 0),txtBusqueda,rutaCarpeta);
		//TECLA ENTER
		submit(txtBusqueda,rutaCarpeta);
		tiempoEspera(2000);
		//CLICK CERRAR UBICACION
		click(closeUbicacion,rutaCarpeta);
		
		} catch(Exception e) 
		{
			imprimirMensaje(e);
		}
	}
	//METODO PRIMERA PRUEBA 
	/*
	public void seleccionInicial(String text) throws InterruptedException
	{
		try {
			//OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			//CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
			File rutaCarpeta = crearCarpeta(propiedades,nomTest);
		
			//INVOCA EL SIGUIENTE METODO
			//busquedaCargarPagina(text);
			//CLICK EN EL LINK DEL PRODUCTO
			click(linkProducto);
			//CLICK BOTON ADD A CARRITO
			click(btnAddCarrito);
			
		} catch (Exception e) {
			imprimirMensaje(e);
			// TODO: handle exception
		}
		
		
		
		
		
	}*/
	
		//METODO SEGUNDA PRUEBA 
		public void eligiendoPrimerElemento(ReadExcelFile leer,Properties propiedades,File rutaCarpeta) throws InterruptedException
		{
			try {
				
			
				//INVOCA EL SIGUIENTE METODO
				busquedaCargarPagina(leer,propiedades,rutaCarpeta);
				//CLICK EN EL LINK DEL PRODUCTO
				click(clickPrimerProducto,rutaCarpeta);
				//CLICK BOTON ADD A CARRITO
				click(btnAddCarrito,rutaCarpeta);
			} catch (Exception e) {
				imprimirMensaje(e);
				// TODO: handle exception
			}
			
			
			
			
			
		}
		
}
