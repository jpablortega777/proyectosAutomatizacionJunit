package PagesObjets;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import MapsObjets.MapObjetMercuryRegister;
import utilidadesExcel.ReadExcelFile;

public class PageMercuryRegister extends MapObjetMercuryRegister
{
	//CONSTRUCTOR
	public PageMercuryRegister(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//METODO LLENAR CAMPOS REGISTRO
	
	public void llenarCamposRegistro( ReadExcelFile leer, Properties propiedades, File rutaCarpeta) throws  Exception
	{
		
		//ENVIAMOS EL TEXTO AL CAMPO NOMBRE
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "mercurytours", 1, 0), txtNombre, rutaCarpeta);
		//ENVIAMOS EL TEXTO AL CAMPO APELLIDO
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "mercurytours", 1, 1), txtApellido, rutaCarpeta);
		//ENVIAMOS EL TEXTO AL CAMPO TELEFONO
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "mercurytours", 1, 2), txtTelefono, rutaCarpeta);
		//ENVIAMOS EL TEXTO AL CAMPO EMAIL
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "mercurytours", 1, 3), txtEmail, rutaCarpeta);
		//ENVIAMOS EL TEXTO DE LA DIRECCION
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "mercurytours", 1, 4), txtDireccion, rutaCarpeta);
		//ENVIAMOS EL TEXTO DE LA CIUDAD
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "mercurytours", 1, 5), txtCiudad, rutaCarpeta);
		//ENVIAMOS EL TEXTO DE LA PROVINCIA
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "mercurytours", 1, 6), txtProvincia, rutaCarpeta);
		//ENVIAMOS EL TEXTO DE LA CODIGO POSTAL
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "mercurytours", 1, 7), txtCodigoPostal, rutaCarpeta);
		//SELECTION OPTION DE PAIS 
		selectOption( leer.getCellValue(propiedades.getProperty("filePathExcel"), "mercurytours", 1, 8),selectOptPais, rutaCarpeta);
		//ENVIAMOS EL TEXTO DE EL NOMBRE DE USUARIO
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "mercurytours", 1, 9), txtUserNombre, rutaCarpeta);
		//ENVIAMOS EL TEXTO DE EL PASSWORD
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "mercurytours", 1, 10), txtPassword, rutaCarpeta);
		//ENVIAMOS EL TEXTO DE CONFIRMAR PASSWORD
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "mercurytours", 1, 11), txtConfirmPassword, rutaCarpeta);
		//BOTON ENVIAR REGISTRO
		click(btnEnviar, rutaCarpeta);
	}
	
	

}
