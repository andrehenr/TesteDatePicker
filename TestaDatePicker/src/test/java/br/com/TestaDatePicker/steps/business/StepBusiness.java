package br.com.TestaDatePicker.steps.business;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import io.openbdt.element.WebBrowserScreenElement;
import br.com.TestaDatePicker.pages.PageObjectClass;
import jxl.common.Logger;
import net.serenity_bdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;

@ContextConfiguration("/appcontext.xml")
public class StepBusiness {

	PageObjectClass page;
	private static Logger LOG = Logger.getLogger(StepBusiness.class);

	@Autowired
	private WebBrowserScreenElement viewElement; // OBJETO QUE CONT�M M�TODOS
													// PR�PRIOS DO FRAMEWORK

	@Step
	public void openHome(String url) {
		viewElement.open(url);
		viewElement.getDriver().manage().window().maximize();
	}

	public void selecionarData(String data) {
		viewElement.waitForElementIsPresent(10,page.getCampoDataEntrada());
		viewElement.click(page.getCampoDataEntrada());
		selcionarDataNoDatePicker(data,page.getCampoApresentaMes(),page.getBotaoProximoMes(),page.getListaDias(),35);

	}

	private void selcionarDataNoDatePicker(String dataCompleta, WebElement elementoContemMes,
			WebElement botaoProximoMes, List<WebElement> listaDosDias, int totalDiasDatePodeConter) {
			String[] data = dataCompleta.split(" ");
			String stringDia = data[0];
			String stringMes = data[2];
			Integer dia = Integer.valueOf(stringDia);
			boolean mesMudou = false;
			while(!elementoContemMes.getText().contains(stringMes)){
				viewElement.click(botaoProximoMes);
				mesMudou = true;
			}
			if(!mesMudou && listaDosDias.size() != totalDiasDatePodeConter){
				Integer primeiroDia = Integer.valueOf(listaDosDias.get(0).getText());
				if(dia >= primeiroDia && listaDosDias.get(dia - primeiroDia).getText().equals(dia.toString())){
						viewElement.click(listaDosDias.get(dia - primeiroDia));
				}
				else{
					LOG.info("A escolha de dia para esse mês foi incorreta");
				}
			}
			else{
				int i = 0;
				while(!listaDosDias.get(i).getText().equals("1")){
					listaDosDias.remove(i);
					i++;
				}
				try{
					if(listaDosDias.get(dia-1).getText().contains(dia.toString())){
						viewElement.click(listaDosDias.get(dia-1));
					}
					else{
						LOG.info("A escolha de dia para esse mês foi incorreta");
					}
				}
				catch(ArrayIndexOutOfBoundsException e){
					LOG.error("Erro ao selecionar um WebElement");
				}
			}
	}

}
