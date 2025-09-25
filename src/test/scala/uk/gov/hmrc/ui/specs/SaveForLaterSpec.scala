/*
 * Copyright 2025 HM Revenue & Customs
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

package uk.gov.hmrc.ui.specs

import uk.gov.hmrc.ui.pages.{Auth, Registration}

class SaveForLaterSpec extends BaseSpec {

  lazy val registration = Registration
  lazy val auth         = Auth

  Feature("Save and come back later journeys") {

    Scenario("Intermediary can save and continue an in-progress registration in the same session") {}

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

//      Will be developed in VEI-515
//      Then("the intermediary is redirected back to the dashboard")
//      registration.checkDashboardJourneyUrl("your-account")
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

      //      Will be developed in VEI-515
      //      Then("the intermediary is redirected back to the dashboard")
      //      registration.checkDashboardJourneyUrl("your-account")
    }

    Scenario(
      "Intermediary can return to a saved registration, submit their declaration and the registration is removed from the saved list"
    ) {}
  }
}
