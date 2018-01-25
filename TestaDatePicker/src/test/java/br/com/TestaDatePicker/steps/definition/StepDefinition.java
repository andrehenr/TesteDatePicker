package br.com.TestaDatePicker.steps.definition;

import java.util.UUID;

import org.springframework.test.context.ContextConfiguration;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import br.com.TestaDatePicker.steps.business.StepBusiness;
import net.thucydides.core.annotations.Steps;

@ContextConfiguration("/appcontext.xml")
public class StepDefinition {

	@Steps
	StepBusiness stepB;
	
	@Given("^acesso ao site \"([^\"]*)\"$")
	public void acesso_ao_site(String url) {
	    stepB.openHome(url);
	}

	@When("^seleciono a data \"([^\"]*)\"$")
	public void seleciono_a_data(String data) {
	    stepB.selecionarData(data);
	}
}
