package MapsObjets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ClaseBase.ClasesBase;

public class MapObjetCrearCuenta extends ClasesBase
{

	public MapObjetCrearCuenta(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	protected By linkCrearcuenta=By.xpath("//nav/a[text()='Crea tu cuenta']");
	protected By btnCookie=By.xpath("//div[@class='cookie-consent-banner-opt-out__actions']/button[text()='Entendido']");
	protected By btnCrearcuenta=By.xpath("//span[text()='Crear cuenta']");
	protected By btnCheckBox=By.id("terms-and-conds");
	protected By btnContinuar=By.xpath("//span[@class='andes-button__content']");
	protected By btnValidarEmail=By.xpath("//span[text()='Validar']");
	protected By txtEmail=By.name("email");
}
