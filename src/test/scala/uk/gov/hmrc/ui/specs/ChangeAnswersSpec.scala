package uk.gov.hmrc.ui.specs

import uk.gov.hmrc.ui.pages.{Auth, Registration}

class ChangeAnswersSpec extends BaseSpec {

  private val registration = RegistrationSpec()
  private val auth         = Auth

  Feature("Registration journey Change answers") {

    Scenario("Intermediary changes and removes answers whilst using the intermediary-netp Registration Service"){

      Given("Intermediary changes and removes answers whilst using the IOSS")
      auth.loginUsingAuthorityWizard("100000001")
      registration.checkJourneyUrl("intermediary-netp-registered")

//      manually navigate to the url
      When("the intermediary selects yes if business registered for tax in EU countries on vat-registered-eu page")
      registration.goToPage("tax-in-eu")
      registration.answerRadioButton("yes")

      And("the intermediary selects Greece on the first vat-registered-eu-country page")
      registration.checkJourneyUrl("vat-registered-eu-country/1")
      registration.selectCountry("Greece")

      And("the intermediary selects yes on the first eu-fixed-establishment page")
      registration.checkJourneyUrl("vat-registered-eu-fixed-establishment/1")
      registration.answerRadioButton("yes")

      And("the intermediary selects VAT number on the first registration-tax-type page")
      registration.checkJourneyUrl("registration-tax-type/1")
      registration.selectRegistrationType("vat number")

      And("the intermediary adds the VAT registration number for Greece")
      registration.checkJourneyUrl("vat-registered-eu-vat-number/1")
      registration.enterAnswer("GE12345678")

      And("the intermediary adds the trading name for Greece")
      registration.checkJourneyUrl("vat-registered-eu-trading-name/1")
      registration.enterAnswer("GE Trade")

      And("the intermediary adds the fixed establishment address for Denmark")
      registration.checkJourneyUrl("vat-registered-eu-fixed-establishment-address/1")
      registration.enterFixedEstablishmentAddress("6 Street Name", "", "Corfu Town", "", "GR555CE")

      And("the intermediary selects continue on the check your answers for Greece")
      registration.checkJourneyUrl("vat-registered-eu-check-your-answers")
      registration.continue()
      
      Then("the intermediary selects yes to you added tax details for eu country on vat-registered-eu-list page")
      registration.checkJourneyUrl("vat-registered-eu-list")
      registration.answerRadioButton("yes")
      
      And("the intermediary selects Belgium on the second eu country on vat-registered-eu-country page")
      registration.checkJourneyUrl("vat-registered-eu-country/2")
      registration.selectCountry("Belgium")
    
      And("the intermediary selects yes on the second eu-fixed-establishment page")
      registration.checkJourneyUrl("vat-registered-eu-fixed-establishment/2")
      registration.answerRadioButton("yes")

      And("the intermediary selects the sort of registration on the vat-registered-eu-sort-of-registration page")
      registration.checkJourneyUrl("vat-registered-eu-sort-of-registration/2")
      registration.selectRegistrationType("Tax ID number")

      And("the intermediary adds the tax identification number for Belgium")
      registration.checkJourneyUrl("vat-registered-eu-tax-reference-number/2")
      registration.enterAnswer("unique tax id number BEL 123 456")
      registration.checkJourneyUrl("vat-registered-eu-trading-name/2")
      registration.enterAnswer("Bel -1234567")

      And("the intermediary adds the fixed establishment address for Belgium")
      registration.checkJourneyUrl("vat-registered-eu-fixed-establishment-address/2")
      registration.enterFixedEstablishmentAddress("2 Street Name", "", "Beltown", "", "")
      registration.continue()
      
      Then("the intermediary checks your answers for Belgium on vat-registered-eu-check-your-answers page")
      registration.checkJourneyUrl("vat-registered-eu-check-your-answers")
      
      And("the intermediary clicks change on the Tax Id number for Belgium on vat-registered-eu-check-your-answers page")
      registartion.checkJourneyUrl()

//      And("the intermediary clicks change on the add-uk-trading-name page for first trading name")
//      registration.checkJourneyUrl("add-uk-trading-name")
//      registration.selectChangeOrRemoveLink("uk-trading-name\\/1\\?waypoints\\=change-add-uk-trading-name")
//
//      And("the intermediary amends the first trading name")
//      registration.checkJourneyUrl("uk-trading-name/1?waypoints=change-add-uk-trading-name")
//      registration.enterAnswer("a different first trading name")
      
//      And("the intermediary selects continue on the check-tax-details page")
//      registration.checkJourneyUrl("vat-registered-eu-check-tax-details")
//      registration.continue()


    }

  }







































}
