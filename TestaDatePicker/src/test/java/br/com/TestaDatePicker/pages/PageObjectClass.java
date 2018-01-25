package br.com.TestaDatePicker.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class PageObjectClass extends PageObject{

	@FindBy(name = "selected_date")
	private WebElement campoDataEntrada;
	
	@FindBy(xpath = "//*[@id='ui-datepicker-div']/div/div/span[1]")
	private WebElement campoApresentaMes;
	
	@FindBy(xpath = "//*[@id='ui-datepicker-div']/table/tbody/tr/td/a")
	private List<WebElement> listaDias;
	
	@FindBy(xpath = "//*[@id='ui-datepicker-div']/div/a[2]")
	private WebElement botaoProximoMes;

	public WebElement getCampoDataEntrada() {
		return campoDataEntrada;
	}

	public WebElement getCampoApresentaMes() {
		return campoApresentaMes;
	}

	public List<WebElement> getListaDias() {
		return listaDias;
	}

	public WebElement getBotaoProximoMes() {
		return botaoProximoMes;
	}
}
