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

class RegistrationSpec extends BaseSpec {

  lazy val registration = Registration
  lazy val auth         = Auth

  Feature("Registration journeys") {

    Scenario("Intermediary registers on behalf of a NETP using the IOSS NETP Registration service - full answers") {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      And("the intermediary answers all of the vat details questions as a UK Based NETP with VRN")
      registration.answerVatDetailsUkVrn()
      registration.checkJourneyUrl("confirm-vat-details")
      registration.answerVatDetails("yes")

      When("the intermediary selects yes on the have-uk-trading-name page")
      // Manual navigation until fix goes in for confirm-vat-details page
      registration.goToPage("have-uk-trading-name")
      registration.checkJourneyUrl("have-uk-trading-name")
      registration.answerRadioButton("yes")

      Then("the intermediary adds the first trading name")
      registration.checkJourneyUrl("uk-trading-name/1")
      registration.enterAnswer("1st trading-name")

      And("the intermediary selects yes on the add-uk-trading-name page")
      registration.checkJourneyUrl("add-uk-trading-name")
      registration.answerRadioButton("yes")

      And("the intermediary adds the second trading name")
      registration.checkJourneyUrl("uk-trading-name/2")
      registration.enterAnswer("Another Trading Name!")

      And("the intermediary selects no on the add-uk-trading-name page")
      registration.checkJourneyUrl("add-uk-trading-name")
      registration.answerRadioButton("no")

//      The rest of the journey is not developed yet

//      manual navigation to website section until rest of journey is developed
      Then("the intermediary adds the first client website address")
      registration.goToPage("website-address/1")
      registration.checkJourneyUrl("website-address/1")
      registration.enterAnswer("www.first-website.com")

      Then("the intermediary answers yes to add another client website address")
      registration.checkJourneyUrl("add-website-address")
      registration.answerRadioButton("yes")

      Then("the intermediary adds the second client website address")
      registration.checkJourneyUrl("website-address/2")
      registration.enterAnswer("http://websiteno2.co.uk")

      Then("the intermediary answers no to add another client website address")
      registration.checkJourneyUrl("add-website-address")
      registration.answerRadioButton("no")

      Then("the intermediary enters credentials on contact-details page")
      registration.checkJourneyUrl("business-contact-details")
      registration.fillContactDetails("Testname", "12345678", "exampletest@mail.com")

      //  CYA to be added here when developed

      When("the intermediary accepts the declaration")
      registration.goToPage("declaration")
      registration.checkJourneyUrl("declaration")
      registration.selectCheckbox()

      // Registration Pending to be added here when developed
    }

    Scenario(
      "Intermediary registers on behalf of a NETP using the IOSS NETP Registration service - only mandatory answers"
    ) {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      And("the intermediary answers all of the vat details questions as a UK Based NETP with VRN")
      registration.answerVatDetailsUkVrn()
      registration.checkJourneyUrl("confirm-vat-details")
      registration.answerVatDetails("yes")

      When("the intermediary selects no on the have-uk-trading-name page")
      // Manual navigation until fix goes in for confirm-vat-details page
      registration.goToPage("have-uk-trading-name")
      registration.checkJourneyUrl("have-uk-trading-name")
      registration.answerRadioButton("no")

      //      The rest of the journey is not developed yet

      Then("the intermediary adds the first client website address")
      registration.goToPage("website-address/1")
      registration.checkJourneyUrl("website-address/1")
      registration.enterAnswer("www.1st-website.co.uk")

      Then("the intermediary answers yes to add another client website address")
      registration.checkJourneyUrl("add-website-address")
      registration.answerRadioButton("no")

      Then("the intermediary enters credentials on contact-details page")
      registration.checkJourneyUrl("business-contact-details")
      registration.fillContactDetails("Firstname Surname", "+44123456789", "test-email@test.co.uk")

      //  CYA to be added here when developed

      When("the intermediary accepts the declaration")
      registration.goToPage("declaration")
      registration.checkJourneyUrl("declaration")
      registration.selectCheckbox()

      // Registration Pending to be added here when developed
    }

  }
}
