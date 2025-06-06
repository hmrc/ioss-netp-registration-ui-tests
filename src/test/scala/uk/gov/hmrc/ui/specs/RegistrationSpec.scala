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

    Scenario("Intermediary registers on behalf of a NETP using the IOSS NETP Registration service") {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard()
      registration.checkJourneyUrl("client-uk-based")

      And("the intermediary answers all of the vat details questions as a UK Based NETP with VRN")
      registration.answerVatDetailsUkVrn()
      registration.checkJourneyUrl("confirm-vat-details")
      registration.answerVatDetails("yes")

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

      //      The rest of the journey is not developed yet
//      manually navigate to the Url

      Then("the intermediary enters credentials on contact-details page")
      registration.goToPage("business-contact-details")
      registration.checkJourneyUrl("business-contact-details")
      registration.fillContactDetails("Testname", "12345678", "exampletest@mail.com")

      //      The rest of the journey is not developed yet
    }
  }
}
