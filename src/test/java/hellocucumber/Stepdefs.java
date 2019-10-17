package hellocucumber;

import static org.junit.Assert.assertTrue;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.Abonne;
import model.Adresse;
import service.IAbonneService;

public class Stepdefs {
	
	Adresse adresse = new Adresse("adr", "pays", "designation", new Date());
	Abonne abonne = new Abonne(adresse, "nom", "prenom");
	@Autowired
	IAbonneService iAbonneService;
	String exceptionMessage;
	@Given("^Un abonné avec une adresse principale active en France")
	public void unAbonneAvecUneAdresseActiveEnFrance(Integer id) throws Exception {
		
		String pays ="";
		String designation ="" ;
	//	Abonne abonne = Abonne.findByID(id); // mock
		if (abonne != null) {
			 pays= abonne.getAdresse().getPays();
			 designation = abonne.getAdresse().getDesignation();
		}
		assertTrue(pays=="France " && designation=="Principale");
	}
	@When("^Un conseiller connecté à <canal> modifie l'adresse de l'abonné sans date d'effet")
	public void unConseillerConnecteModifieLAdresseSansDateDEffet(String adresse ,Abonne abonne)  {
	try {
	this.iAbonneService.modifAbonneAdresse(abonne, adresse);
	}catch(Exception e) {
	exceptionMessage = e.getMessage();
	}
	}
	@Then("l'adresse de l'abonné modifiée est enregistrée sur l'ensemble des contrats de l'abonné")
	public void lAadressedeLAbonneModifieeEtEnregistre(String email) throws Exception {
	assertTrue(exceptionMessage== null);
	}

}
