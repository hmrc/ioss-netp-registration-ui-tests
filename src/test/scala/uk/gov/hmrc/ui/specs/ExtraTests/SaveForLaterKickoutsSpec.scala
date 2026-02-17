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

package uk.gov.hmrc.ui.specs.ExtraTests

import uk.gov.hmrc.ui.pages.{Auth, Registration}
import uk.gov.hmrc.ui.specs.BaseSpec

class SaveForLaterKickoutsSpec extends BaseSpec {

  lazy val registration = Registration
  lazy val auth         = Auth

  Feature("Save and come back later kickout journeys") {

    Scenario("Intermediary returns to a saved NETP registration where the VRN has now expired") {
      Given("the intermediary logs in to the NETP registration service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "saveKickouts")
      registration.checkDashboardJourneyUrl("your-account")

      And("the intermediary clicks the 'Continue a registration in progress' link on the dashboard")
      registration.clickLink("continue-saved-answers")

      When("the intermediary selects the first saved registration")
      registration.checkJourneyUrl("clients-continue-registration-selection")
      registration.selectSavedRegistration("first")
      registration.checkJourneyUrl("clients-continue-registration")

      Then("the intermediary answers yes to continue the registration")
      registration.selectContinueRegistration("continueProgress")

      And("the intermediary is redirected to the expired-vrn-date page")
      registration.checkJourneyUrl("expired-vrn-date")
    }

    Scenario("Intermediary returns to a saved NETP registration where the FTR is now already active in another country") {
      Given("the intermediary logs in to the NETP registration service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "saveKickouts")
      registration.checkDashboardJourneyUrl("your-account")

      And("the intermediary clicks the 'Continue a registration in progress' link on the dashboard")
      registration.clickLink("continue-saved-answers")

      When("the intermediary selects the second saved registration")
      registration.checkJourneyUrl("clients-continue-registration-selection")
      registration.selectSavedRegistration("second")
      registration.checkJourneyUrl("clients-continue-registration")

      Then("the intermediary answers yes to continue the registration")
      registration.selectContinueRegistration("continueProgress")

      And("the intermediary is redirected to the client-already-registered page")
      registration.checkJourneyUrl("client-already-registered")
    }

    Scenario("Intermediary returns to a saved NETP registration where the previous NI OSS scheme is quarantined") {
      Given("the intermediary logs in to the NETP registration service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "saveKickouts")
      registration.checkDashboardJourneyUrl("your-account")

      And("the intermediary clicks the 'Continue a registration in progress' link on the dashboard")
      registration.clickLink("continue-saved-answers")

      When("the intermediary selects the third saved registration")
      registration.checkJourneyUrl("clients-continue-registration-selection")
      registration.selectSavedRegistration("third")

      Then("the intermediary answers yes to continue the registration")
      registration.checkJourneyUrl("clients-continue-registration")
      registration.selectContinueRegistration("continueProgress")

      And("the intermediary is redirected to the other-country-excluded-and-quarantined page")
      registration.checkJourneyUrl("other-country-excluded-and-quarantined?countryCode")
    }

    Scenario("Intermediary returns to a saved NETP registration where a fixed establishment is now still active in another country") {
      Given("the intermediary logs in to the NETP registration service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "saveKickouts")
      registration.checkDashboardJourneyUrl("your-account")

      And("the intermediary clicks the 'Continue a registration in progress' link on the dashboard")
      registration.clickLink("continue-saved-answers")

      When("the intermediary selects the fourth saved registration")
      registration.checkJourneyUrl("clients-continue-registration-selection")
      registration.selectSavedRegistration("fourth")

      Then("the intermediary answers yes to continue the registration")
      registration.checkJourneyUrl("clients-continue-registration")
      registration.selectContinueRegistration("continueProgress")

      And("the intermediary is redirected to the client-already-registered page")
      registration.checkJourneyUrl("client-already-registered")
    }
  }
}
