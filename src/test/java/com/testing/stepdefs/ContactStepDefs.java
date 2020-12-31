package com.testing.stepdefs;

import com.testing.utils.BaseTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactStepDefs extends BaseTest {

    @When("the user adds a new contact")
    public void the_user_adds_a_new_contact(DataTable dataTable) {
        contact.addNewContact(dataTable);
        contactList.verifyContactListPageOpens();
    }

    @Then("a new Contact {string} is created successfully")
    public void a_new_Contact_is_created_successfully(String newContact) {
        contactList.verifyNewContact(newContact);
    }
}
