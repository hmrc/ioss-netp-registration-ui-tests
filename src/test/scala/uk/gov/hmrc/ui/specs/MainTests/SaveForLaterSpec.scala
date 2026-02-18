/*
 * Copyright 2026 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.ui.specs.MainTests

import uk.gov.hmrc.ui.pages.{Auth, Registration}
import uk.gov.hmrc.ui.specs.BaseSpec

class SaveForLaterSpec extends BaseSpec {

  lazy val registration = Registration
  lazy val auth         = Auth

  Feature("Save and come back later journeys") {

    Scenario("Intermediary can return to a saved registration where they have multiple saved registrations") {
      Given("the intermediary logs in to the NETP registration service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "multipleSaved")
      registration.checkDashboardJourneyUrl("your-account")

      And("the intermediary clicks the 'Continue a registration in progress' link on the dashboard")
      registration.clickLink("continue-saved-answers")

      Then("the intermediary is presented with a list of 5 saved registrations")
      registration.checkJourneyUrl("clients-continue-registration-selection")
      registration.checkSavedRegistrationsHeading("fiveSaved")
      registration.checkSavedRegistrationsList("five")

      When("the intermediary selects the first saved registration")
      registration.selectSavedRegistration("first")
      registration.checkJourneyUrl("clients-continue-registration")
      registration.checkSavedRegistrationsHeading("oneOfFive")

      Then("the intermediary answers yes to continue the registration")
      registration.selectContinueRegistration("continueProgress")

      And("the intermediary is redirected to the correct page of their saved registration")
      registration.checkJourneyUrl("previous-country/1")
    }

    Scenario("Intermediary can return to a saved registration where they have one saved registration") {
      Given("the intermediary logs in to the NETP registration service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "oneSaved")
      registration.checkDashboardJourneyUrl("your-account")

      And("the intermediary clicks the 'Continue a registration in progress' link on the dashboard")
      registration.clickLink("continue-saved-answers")

      Then("the intermediary is presented with one saved registration")
      registration.checkJourneyUrl("clients-continue-registration")
      registration.checkSavedRegistrationsHeading("oneSaved")
    }

    Scenario("Intermediary attempts to access saved registrations when they have no saved registrations") {

      Given("the intermediary logs in to the NETP registration service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "noSaved")
      registration.checkDashboardJourneyUrl("your-account")

      Then("there is no 'Continue a registration in progress' link available on the dashboard")
      registration.checkSavedRegistrationsLink()

      When("if the intermediary manually navigates to the saved registration link")
      registration.goToSavedRegistrationJourney()

      Then("the intermediary is redirected back to the dashboard")
      registration.checkDashboardJourneyUrl("your-account")
    }

    Scenario("Intermediary can delete a saved registration and start again") {
      Given("the intermediary logs in to the NETP registration service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "multipleSaved")
      registration.checkDashboardJourneyUrl("your-account")

      And("the intermediary clicks the 'Continue a registration in progress' link on the dashboard")
      registration.clickLink("continue-saved-answers")

      Then("the intermediary is presented with a list of 5 saved registrations")
      registration.checkJourneyUrl("clients-continue-registration-selection")
      registration.checkSavedRegistrationsHeading("fiveSaved")
      registration.checkSavedRegistrationsList("five")

      When("the intermediary selects the fifth saved registration")
      registration.selectSavedRegistration("fifth")
      registration.checkJourneyUrl("clients-continue-registration")
      registration.checkSavedRegistrationsHeading("fiveOfFive")

      Then("the intermediary answers no to delete the registration")
      registration.selectContinueRegistration("deleteProgress")

      Then("the intermediary is redirected back to the dashboard")
      registration.checkDashboardJourneyUrl("your-account")
    }

    Scenario(
      "Intermediary can return to a saved registration, submit their declaration and the registration is removed from the saved list"
    ) {
      Given("the intermediary logs in to the NETP registration service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "multipleSaved")
      registration.checkDashboardJourneyUrl("your-account")

      And("the intermediary clicks the 'Continue a registration in progress' link on the dashboard")
      registration.clickLink("continue-saved-answers")

      Then("the intermediary is presented with a list of 5 saved registrations")
      registration.checkJourneyUrl("clients-continue-registration-selection")
      registration.checkSavedRegistrationsHeading("fiveSaved")
      registration.checkSavedRegistrationsList("five")

      When("the intermediary selects the third saved registration")
      registration.selectSavedRegistration("third")
      registration.checkJourneyUrl("clients-continue-registration")
      registration.checkSavedRegistrationsHeading("threeOfFive")

      Then("the intermediary answers yes to continue the registration")
      registration.selectContinueRegistration("continueProgress")
      registration.checkJourneyUrl("trading-name-business-address/2")

      And("the intermediary can complete the rest of the registration and submit their declaration")
      registration.enterFETradingName("Finland Trading Name")
      registration.enterAddress("1 Road Name", "Suburb", "City", "Region-Name", "")
      registration.checkJourneyUrl("registration-tax-type/2")
      registration.answerRegistrationType("Tax ID number")
      registration.checkJourneyUrl("eu-tax-identification-number/2")
      registration.enterAnswer("123123123")
      registration.checkJourneyUrl("check-tax-details/2")
      registration.continue()
      registration.checkJourneyUrl("add-tax-details")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("website-address/1")
      registration.enterAnswer("http://websiteone.net")
      registration.checkJourneyUrl("add-website-address")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("business-contact-details")
      registration.fillContactDetails("Test-Name Test", "01123456789", "email@test.com")
      registration.checkJourneyUrl("check-your-answers")
      registration.continue()
      registration.checkJourneyUrl("declaration")
      registration.selectCheckbox()
      registration.checkJourneyUrl("client-application-complete")

      When("The intermediary returns to their list of saved registrations")
      registration.goToDashboard()
      registration.checkDashboardJourneyUrl("your-account")
      registration.clickLink("continue-saved-answers")

      Then("The registration that was submitted previously is no longer showing in the saved registrations list")
      registration.checkJourneyUrl("clients-continue-registration-selection")
      registration.checkSavedRegistrationsHeading("fourSaved")
      registration.checkSavedRegistrationsList("four")
    }

    Scenario("Intermediary can save and continue an in-progress registration in the same session") {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      And("the intermediary answers all of the vat details questions as a UK Based NETP with VRN")
      registration.answerVatDetailsUkVrn()
      registration.checkJourneyUrl("confirm-tax-details")

      When("the intermediary clicks the Save and come back later button")
      registration.saveRegistration()

      And("the intermediary is informed their registration has been saved")
      registration.checkJourneyUrl("progress-saved")

      And("the intermediary clicks on the continue registration link")
      registration.clickLink("continueToYourRegistration")

      Then("the intermediary is returned to the last page they saved on")
      registration.checkJourneyUrl("confirm-tax-details")
      registration.continue()

      And(
        "the intermediary can add details to the trading name section, save their progress and return to the correct pages"
      )
      registration.checkJourneyUrl("have-trading-name")
      registration.saveRegistration()
      registration.checkJourneyUrl("progress-saved")
      registration.clickLink("continueToYourRegistration")
      registration.checkJourneyUrl("have-trading-name")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("trading-name/1")
      registration.enterAnswer("1st trading-name")
      registration.checkJourneyUrl("add-trading-name")
      registration.saveRegistration()
      registration.checkJourneyUrl("progress-saved")
      registration.clickLink("continueToYourRegistration")
      registration.checkJourneyUrl("add-trading-name")
      registration.answerRadioButton("no")

      When(
        "the intermediary can add details to the previous registrations section, save their progress and return to the correct pages"
      )
      registration.checkJourneyUrl("previous-oss")
      registration.saveRegistration()
      registration.checkJourneyUrl("progress-saved")
      registration.clickLink("continueToYourRegistration")
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("previous-country/1")
      registration.saveRegistration()
      registration.checkJourneyUrl("progress-saved")
      registration.clickLink("continueToYourRegistration")
      registration.checkJourneyUrl("previous-country/1")
      registration.selectCountry("Cyprus")
      registration.checkJourneyUrl("previous-scheme/1/1")
      registration.saveRegistration()
      registration.checkJourneyUrl("progress-saved")
      registration.clickLink("continueToYourRegistration")
      registration.checkJourneyUrl("previous-scheme/1/1")
      registration.answerSchemeType("OSS")
      registration.checkJourneyUrl("previous-oss-scheme-number/1/1")
      registration.saveRegistration()
      registration.checkJourneyUrl("progress-saved")
      registration.clickLink("continueToYourRegistration")
      registration.checkJourneyUrl("previous-oss-scheme-number/1/1")
      registration.enterAnswer("EU111222333")
      registration.checkJourneyUrl("previous-scheme-answers/1")
      registration.saveRegistration()
      registration.checkJourneyUrl("progress-saved")
      registration.clickLink("continueToYourRegistration")
      registration.checkJourneyUrl("previous-scheme-answers/1")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("previous-scheme/1/2")
      registration.saveRegistration()
      registration.checkJourneyUrl("progress-saved")
      registration.clickLink("continueToYourRegistration")
      registration.checkJourneyUrl("previous-scheme/1/2")
      registration.answerSchemeType("OSS")
      registration.checkJourneyUrl("previous-oss-scheme-number/1/2")
      registration.saveRegistration()
      registration.checkJourneyUrl("progress-saved")
      registration.clickLink("continueToYourRegistration")
      registration.checkJourneyUrl("previous-oss-scheme-number/1/2")
      registration.enterAnswer("CY44445555A")
      registration.checkJourneyUrl("previous-scheme-answers/1")
      registration.saveRegistration()
      registration.checkJourneyUrl("progress-saved")
      registration.clickLink("continueToYourRegistration")
      registration.checkJourneyUrl("previous-scheme-answers/1")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("previous-scheme/1/3")
      registration.saveRegistration()
      registration.checkJourneyUrl("progress-saved")
      registration.clickLink("continueToYourRegistration")
      registration.checkJourneyUrl("previous-scheme/1/3")
      registration.answerSchemeType("IOSS")
      registration.checkJourneyUrl("previous-scheme-intermediary/1/3")
      registration.saveRegistration()
      registration.checkJourneyUrl("progress-saved")
      registration.clickLink("continueToYourRegistration")
      registration.checkJourneyUrl("previous-scheme-intermediary/1/3")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("previous-ioss-number/1/3")
      registration.saveRegistration()
      registration.checkJourneyUrl("progress-saved")
      registration.clickLink("continueToYourRegistration")
      registration.checkJourneyUrl("previous-ioss-number/1/3")
      registration.enterAnswer("IM1967773331")
      registration.checkJourneyUrl("previous-scheme-answers/1")
      registration.continue()
      registration.checkJourneyUrl("previous-schemes-overview")
      registration.saveRegistration()
      registration.checkJourneyUrl("progress-saved")
      registration.clickLink("continueToYourRegistration")
      registration.checkJourneyUrl("previous-schemes-overview")
      registration.answerRadioButton("no")

      Then(
        "the intermediary can add details to the fixed establishments section, save their progress and return to the correct pages"
      )
      registration.checkJourneyUrl("eu-fixed-establishment")
      registration.saveRegistration()
      registration.checkJourneyUrl("progress-saved")
      registration.clickLink("continueToYourRegistration")
      registration.checkJourneyUrl("eu-fixed-establishment")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("vat-registered-eu-country/1")
      registration.saveRegistration()
      registration.checkJourneyUrl("progress-saved")
      registration.clickLink("continueToYourRegistration")
      registration.checkJourneyUrl("vat-registered-eu-country/1")
      registration.selectCountry("Spain")
      registration.checkJourneyUrl("trading-name-business-address/1")
      registration.saveRegistration()
      registration.checkJourneyUrl("progress-saved")
      registration.clickLink("continueToYourRegistration")
      registration.checkJourneyUrl("trading-name-business-address/1")
      registration.enterFETradingName("Spanish Trading Name")
      registration.enterAddress("123 Street Name", "", "Town", "", "ES12345")
      registration.checkJourneyUrl("registration-tax-type/1")
      registration.saveRegistration()
      registration.checkJourneyUrl("progress-saved")
      registration.clickLink("continueToYourRegistration")
      registration.checkJourneyUrl("registration-tax-type/1")
      registration.answerRegistrationType("VAT number")
      registration.checkJourneyUrl("eu-vat-number/1")
      registration.saveRegistration()
      registration.checkJourneyUrl("progress-saved")
      registration.clickLink("continueToYourRegistration")
      registration.checkJourneyUrl("eu-vat-number/1")
      registration.enterAnswer("EST5554441B")
      registration.checkJourneyUrl("check-tax-details/1")
      registration.saveRegistration()
      registration.checkJourneyUrl("progress-saved")
      registration.clickLink("continueToYourRegistration")
      registration.checkJourneyUrl("check-tax-details/1")
      registration.continue()
      registration.checkJourneyUrl("add-tax-details")
      registration.saveRegistration()
      registration.checkJourneyUrl("progress-saved")
      registration.clickLink("continueToYourRegistration")
      registration.checkJourneyUrl("add-tax-details")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("vat-registered-eu-country/2")
      registration.selectCountry("Netherlands")
      registration.checkJourneyUrl("trading-name-business-address/2")
      registration.enterFETradingName("Netherlands Trading Name")
      registration.enterAddress("1 Road Name", "Suburb", "City", "Region-Name", "NL5555 12")
      registration.checkJourneyUrl("registration-tax-type/2")
      registration.saveRegistration()
      registration.checkJourneyUrl("progress-saved")
      registration.clickLink("continueToYourRegistration")
      registration.checkJourneyUrl("registration-tax-type/2")
      registration.answerRegistrationType("Tax ID number")
      registration.checkJourneyUrl("eu-tax-identification-number/2")
      registration.saveRegistration()
      registration.checkJourneyUrl("progress-saved")
      registration.clickLink("continueToYourRegistration")
      registration.checkJourneyUrl("eu-tax-identification-number/2")
      registration.enterAnswer("NL1 665544")
      registration.checkJourneyUrl("check-tax-details/2")
      registration.continue()
      registration.checkJourneyUrl("add-tax-details")
      registration.answerRadioButton("no")

      Then(
        "the intermediary can add details to the websites section, save their progress and return to the correct pages"
      )
      registration.checkJourneyUrl("website-address/1")
      registration.saveRegistration()
      registration.checkJourneyUrl("progress-saved")
      registration.clickLink("continueToYourRegistration")
      registration.checkJourneyUrl("website-address/1")
      registration.enterAnswer("www.first-website.com")
      registration.checkJourneyUrl("add-website-address")
      registration.saveRegistration()
      registration.checkJourneyUrl("progress-saved")
      registration.clickLink("continueToYourRegistration")
      registration.checkJourneyUrl("add-website-address")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("website-address/2")
      registration.saveRegistration()
      registration.checkJourneyUrl("progress-saved")
      registration.clickLink("continueToYourRegistration")
      registration.checkJourneyUrl("website-address/2")
      registration.enterAnswer("http://websiteno2.co.uk")
      registration.checkJourneyUrl("add-website-address")
      registration.answerRadioButton("no")

      Then(
        "the intermediary can add details to the websites section, save their progress and return to the correct pages"
      )
      registration.checkJourneyUrl("business-contact-details")
      registration.saveRegistration()
      registration.checkJourneyUrl("progress-saved")
      registration.clickLink("continueToYourRegistration")
      registration.checkJourneyUrl("business-contact-details")
      registration.fillContactDetails("Testname", "12345678", "exampletest@mail.com")

      And("the intermediary continues through the check-your-answers page")
      registration.checkJourneyUrl("check-your-answers")
      registration.saveRegistration()
      registration.checkJourneyUrl("progress-saved")
      registration.clickLink("continueToYourRegistration")
      registration.checkJourneyUrl("check-your-answers")
      registration.continue()

      When("the intermediary accepts the declaration")
      registration.checkJourneyUrl("declaration")
      registration.saveRegistration()
      registration.checkJourneyUrl("progress-saved")
      registration.clickLink("continueToYourRegistration")
      registration.checkJourneyUrl("declaration")
      registration.selectCheckbox()

      Then("the intermediary is on the client-application-complete page")
      registration.checkJourneyUrl("client-application-complete")
      registration.setUrlCode()

      Given("the NETP can login and access the activation code page")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(false, false, "noVrn")
      registration.checkJourneyUrl("client-code-entry")

      When("the NETP submits their activation code")
      registration.setActivationCode()
      registration.enterActivationCode()

      And("the NETP agrees to the declaration and submits the registration")
      registration.checkJourneyUrl("declaration-client")
      registration.selectNETPCheckbox()

      Then("the NETP is on the successful-registration page")
      registration.checkJourneyUrl("successful-registration")
    }
  }
}
