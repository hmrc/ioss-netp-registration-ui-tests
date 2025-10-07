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

class RegistrationFailureSpec extends BaseSpec {

  lazy val registration = Registration
  lazy val auth         = Auth

  Feature("Registration failure journeys") {

    Scenario("ETMP failure when NETP submits registration") {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      And("the intermediary completes and submits the registration")
      registration.answerVatDetailsRegistrationFailures("666000001")
      registration.checkJourneyUrl("confirm-tax-details")
      registration.continue()
      registration.completeAndSubmitRegistrationCompulsoryAnswersOnly()
      registration.setUrlCode()

      Given("the NETP can login and complete the activation")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(false, false, "noVrn")
      registration.checkJourneyUrl("client-code-entry")
      registration.setActivationCode()
      registration.enterActivationCode()
      registration.checkJourneyUrl("declaration-client")

      When("the NETP accepts the declaration")
      registration.selectNETPCheckbox()

      Then("the NETP is on the error-submitting-registration page")
      registration.checkJourneyUrl("error-submitting-registration")
    }

    Scenario("Enrolment failure when NETP submits registration") {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      And("the intermediary completes and submits the registration")
      registration.answerVatDetailsRegistrationFailures("666000000")
      registration.checkJourneyUrl("confirm-tax-details")
      registration.continue()
      registration.completeAndSubmitRegistrationCompulsoryAnswersOnly()
      registration.setUrlCode()

      Given("the NETP can login and complete the activation")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(false, false, "noVrn")
      registration.checkJourneyUrl("client-code-entry")
      registration.setActivationCode()
      registration.enterActivationCode()
      registration.checkJourneyUrl("declaration-client")

      When("the NETP accepts the declaration")
      registration.selectNETPCheckbox()

      Then("the NETP is on the error-submitting-registration page")
      registration.checkJourneyUrl("error-submitting-registration")
    }
  }
}
