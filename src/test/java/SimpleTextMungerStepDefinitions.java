import static org.junit.Assert.assertEquals;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SimpleTextMungerStepDefinitions {
	private SimpleTextMunger stm;
	private String result;
	
	@Given("^I have an instance of my class$")
	public void I_have_an_instance_of_my_class(){
		stm = new SimpleTextMunger();
	}

	@When("^I call my method with \"([^\"]*)\"$")
	public void I_call_my_method_with_(String word){
		System.out.println("Entered word: " + word);
		result = stm.process(word);
		System.out.println("Munge word: " + result);
	}
	
	@Then("^I receive \"([^\"]*)\"$")
	public void I_receive(String expectedResult){
		assertEquals("The munge word should be " + expectedResult, expectedResult,result);
	}
}
