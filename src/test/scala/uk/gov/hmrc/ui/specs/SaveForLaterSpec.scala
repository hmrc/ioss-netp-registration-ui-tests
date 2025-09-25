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
  lazy val auth = Auth

  Feature("Save and come back later journeys") {

    Scenario("Intermediary can save and continue an in-progress registration in the same session") {
    }
    
    Scenario("Intermediary can return to a saved registration where they have multiple saved registrations") {
      Given("the intermediary logs in to the NETP registration service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "multipleSaved")
      registration.checkDashboardJourneyUrl("your-account")

      And("the intermediary clicks the 'Continue a registration in progress' link on the dashboard")
      registration.clickLink("continue-saved-answers")

      Then("the intermediary is presented with a list of 5 saved registrations")
      registration.checkJourneyUrl("clients-continue-registration-selection")

    }
    
    Scenario("Intermediary can return to a saved registration where they have one saved registration") {
    }
    
    Scenario("Intermediary attempts to access saved registrations when they have no saved registrations") {
    }
    
    Scenario("Intermediary can delete a saved registration and start again") {
    }
    
    Scenario("Intermediary can return to a saved registration, submit their declaration and the registration is removed from the saved list") {
    }
  }
}
