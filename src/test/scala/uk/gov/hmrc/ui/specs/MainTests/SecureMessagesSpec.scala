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

package uk.gov.hmrc.ui.specs.MainTests

import uk.gov.hmrc.ui.pages.{Auth, Registration, SecureMessage}
import uk.gov.hmrc.ui.specs.BaseSpec

class SecureMessagesSpec extends BaseSpec {

  lazy val registration  = Registration
  lazy val auth          = Auth
  lazy val secureMessage = SecureMessage

  Feature("Secure Message journeys") {

    Scenario(
      "NETP can view their secure messages - UK based with UK VRN"
    ) {

      Given("the NETP logs into their Government Gateway account")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(false, true, "secureMessagesUkBasedUkVrn")

      When("the NETP accesses their secure message inbox")
      registration.checkJourneyUrl("secure-messages")

      Then("their secure messages are displayed")
      secureMessage.checkClientName("secureMessagesUkBasedUkVrn")

      And("the NETP clicks on their unread message")
      secureMessage.selectSecureMessage("individual-secure-message\\/692d754281096a36213f1576")

      And("the NETP is viewing their message")
      registration.checkJourneyUrl("individual-secure-message/692d754281096a36213f1576")
      secureMessage.checkSecureMessagesHeading("Your intermediary has removed you from the VAT IOSS scheme")
    }

    Scenario(
      "NETP can view their secure messages - UK based with UTR"
    ) {

      Given("the NETP logs into their Government Gateway account")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(false, false, "secureMessagesUkBasedUtr")

      When("the NETP accesses their secure message inbox")
      registration.checkJourneyUrl("secure-messages")

      Then("their secure messages are displayed")
      secureMessage.checkClientName("secureMessagesUkBasedUtr")

      And("the NETP clicks on their unread message")
      secureMessage.selectSecureMessage("individual-secure-message\\/692d7a4a81096a36213f1577")

      And("the NETP is viewing their message")
      registration.checkJourneyUrl("individual-secure-message/692d7a4a81096a36213f1577")
      secureMessage.checkSecureMessagesHeading("We have excluded you from the VAT IOSS scheme")
    }

    Scenario(
      "NETP can view their secure messages - UK based with NINO"
    ) {

      Given("the NETP logs into their Government Gateway account")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(false, false, "secureMessagesUkBasedNino")

      When("the NETP accesses their secure message inbox")
      registration.checkJourneyUrl("secure-messages")

      Then("their secure messages are displayed")
      secureMessage.checkClientName("secureMessagesUkBasedNino")

      And("the NETP clicks on their unread message")
      secureMessage.selectSecureMessage("individual-secure-message\\/692d7ace81096a36213f1578")

      And("the NETP is viewing their message")
      registration.checkJourneyUrl("individual-secure-message/692d7ace81096a36213f1578")
      secureMessage.checkSecureMessagesHeading("We have excluded you from the VAT IOSS scheme")
    }

    Scenario(
      "NETP can view their secure messages - Non-UK based with UK VRN"
    ) {

      Given("the NETP logs into their Government Gateway account")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(false, true, "secureMessagesNonUkBasedUkVrn")

      When("the NETP accesses their secure message inbox")
      registration.checkJourneyUrl("secure-messages")

      Then("their secure messages are displayed")
      secureMessage.checkClientName("secureMessagesNonUkBasedUkVrn")

      And("the NETP clicks on their unread message")
      secureMessage.selectSecureMessage("individual-secure-message\\/692d7aef81096a36213f157b")

      And("the NETP is viewing their message")
      registration.checkJourneyUrl("individual-secure-message/692d7aef81096a36213f157b")
      secureMessage.checkSecureMessagesHeading("We have excluded you from the VAT IOSS scheme")
    }

    Scenario(
      "NETP can view their secure messages - Non-UK based with FTR"
    ) {

      Given("the NETP logs into their Government Gateway account")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(false, false, "secureMessagesNonUkBasedFtr")

      When("the NETP accesses their secure message inbox")
      registration.checkJourneyUrl("secure-messages")

      Then("their secure messages are displayed")
      secureMessage.checkClientName("secureMessagesNonUkBasedFtr")

      And("the NETP clicks on their unread message")
      secureMessage.selectSecureMessage("individual-secure-message\\/692d7ad981096a36213f1579")

      And("the NETP is viewing their message")
      registration.checkJourneyUrl("individual-secure-message/692d7ad981096a36213f1579")
      secureMessage.checkSecureMessagesHeading("We have excluded you from the VAT IOSS scheme")
    }

    Scenario(
      "NETP views secure messages inbox but has no messages"
    ) {

      Given("the NETP logs into their Government Gateway account")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(false, true, "secureMessagesNone")

      When("the NETP accesses their secure message inbox")
      registration.checkJourneyUrl("secure-messages")

      Then("there are no secure messages to display")
      secureMessage.checkClientName("secureMessagesNone")
    }

    Scenario(
      "Cannot view NETP secure messages inbox if not registered as a NETP"
    ) {

      Given("the NETP logs into their Government Gateway account to access the secure messages inbox")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(false, false, "noNetpEnrolment")

      Then("the NETP is on the cannot-use-not-an-netp page")
      registration.checkJourneyUrl("cannot-use-not-an-netp")
    }

    Scenario(
      "Intermediary cannot view NETP secure messages inbox"
    ) {

      Given("the intermediary logs into their Government Gateway account")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary manually accesses the NETP secure message inbox")
      registration.goToPage("secure-messages")

      Then("the intermediary is on the cannot-use-not-an-netp page")
      registration.checkJourneyUrl("cannot-use-not-an-netp")
    }
  }
}
