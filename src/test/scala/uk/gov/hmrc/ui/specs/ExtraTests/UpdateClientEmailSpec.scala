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

package uk.gov.hmrc.ui.specs.ExtraTests

import uk.gov.hmrc.ui.pages.{Auth, Registration}
import uk.gov.hmrc.ui.specs.BaseSpec

class UpdateClientEmailSpec extends BaseSpec {

  lazy val registration = Registration
  lazy val auth         = Auth

  Feature("Update NETP email address journey") {

    Scenario("Intermediary can amend NETP email address when registration is pending") {

      Given("the intermediary logs in to the NETP registration service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "pending")
      registration.checkJourneyUrl("client-uk-based")

      When("The intermediary accesses their dashboard")
      registration.goToDashboard()
      registration.checkDashboardJourneyUrl("your-account")

      And("the intermediary clicks the '1 client awaiting activation' link on the dashboard")
      registration.clickLink("pending-client-singular")

      And("the intermediary is on the client-awaiting-activation page")
      registration.checkDashboardJourneyUrl("client-awaiting-activation")

      And("the intermediary selects the only client in the list")
      registration.selectClientLink("client-not-activated\\/4aa0d14f-4737-45a6-a3b4-051c95cc8cfe")

      And("the intermediary is on the client-not-activated page for the only client in the list")
      registration.checkJourneyUrl("client-not-activated/4aa0d14f-4737-45a6-a3b4-051c95cc8cfe")

      When("the intermediary selects the update email address link")
      registration.selectClientLink("update-client-email-address\\/4aa0d14f-4737-45a6-a3b4-051c95cc8cfe")

      And("the intermediary is on the update-client-email-address page")
      registration.checkJourneyUrl("update-client-email-address/4aa0d14f-4737-45a6-a3b4-051c95cc8cfe")

      When("the intermediary submits a new email address")
      registration.enterAnswer("newemail@test.com")

      Then("the intermediary is on the client-email-updated page")
      registration.checkJourneyUrl("client-email-updated/4aa0d14f-4737-45a6-a3b4-051c95cc8cfe")

      And("the NETP can login, agree to the declaration and submit their registration")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(false, false, "noVrnPending")
      registration.checkJourneyUrl("client-code-entry")
      registration.completeActivationCodePendingClient()
      registration.checkJourneyUrl("declaration-client")
      registration.selectNETPCheckbox()
      registration.checkJourneyUrl("successful-registration")
    }
  }
}
