package stepDefs

import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When

class PracticeBDDSyntax {

    @Given("User enters this {string}")
    public void verifySomething(){

    }

    @When("User enters that {string}")
    public void doSomething(){

    }

    @Then
    public void doSomethingMore(){

    }
}
