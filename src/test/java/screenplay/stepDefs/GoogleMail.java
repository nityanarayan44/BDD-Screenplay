//---------------------------------
// Package
//---------------------------------
package screenplay.stepDefs;

//---------------------------------
// Import Section
//---------------------------------
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import screenplay.config.Configuration;
import screenplay.tasks.login.google.GMailLogin;
import screenplay.tasks.mail.gmail.OpenMail;
import screenplay.tasks.mail.gmail.SendMail;

//---------------------------------
// Class
//---------------------------------
public class GoogleMail {

	//---------------------------------
	// Step Functions
	//---------------------------------
	
	@When("^User logIn to gmail as \"([^\"]*)\"$")
	public void googleLoginAccessAsUser(String user){
	    // LogIn to the Google Mail 
		theActorInTheSpotlight().attemptsTo( GMailLogin.with( Configuration.getValueFromConfigurations(user) ) );
	}
	
	@Then("^User open the mail from \"([^\"]*)\"$")
	public void openMailFromSender(String sender){
		// Open mail
		theActorInTheSpotlight().attemptsTo( OpenMail.from( Configuration.getValueFromConfigurations(sender) ) );
	}
	
	@Then("^User compose the mail \"([^\"]*)\" with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void composeMailFor(String reciever, String subject, String body){
		// Send mail
		theActorInTheSpotlight().attemptsTo( 
				SendMail.with(
						Configuration.getValueFromConfigurations(reciever),
						Configuration.getValueFromConfigurations(subject),
						Configuration.getValueFromConfigurations(body)
				)
		);
	}
	
	@Then("^User should see list of mails$")
	public void shouldSeeLandingPage(){
		//
	}
} 