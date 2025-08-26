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

class ResendActivationCodeSpec extends BaseSpec {

  lazy val registration = Registration
  lazy val auth         = Auth

  Feature("NETP resend activation code journey") {

    Scenario("NETP can resend activation code and submit their registration") {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      And("the intermediary answers all of the vat details questions as a UK Based NETP with VRN")
      registration.answerVatDetailsUkVrn()
      registration.checkJourneyUrl("confirm-vat-details")
      registration.continue()

      And("the intermediary completes the rest of the journey")
      registration.completeAndSubmitRegistrationCompulsoryAnswersOnly()
      registration.setUrlCode()

      Given("the NETP can login and access the activation code page")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(false, false, "noVrn")
      registration.checkJourneyUrl("client-code-entry")

      When("the NETP expands the I have not received the email section")
      registration.expandDetails()

      Then("the NETP clicks the request a new code link")
      registration.clickResendCodeLink()

      And("the NETP submits their activation code")
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
