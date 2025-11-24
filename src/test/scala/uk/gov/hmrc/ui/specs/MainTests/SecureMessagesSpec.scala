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

import uk.gov.hmrc.ui.pages.{SecureMessage, Auth, Registration}
import uk.gov.hmrc.ui.specs.BaseSpec

class SecureMessagesSpec extends BaseSpec {

  lazy val registration      = Registration
  lazy val auth              = Auth
  lazy val secureMessage = SecureMessage

  Feature("Secure Message journeys") {

    Scenario(
      "NETP can view their secure messages - UK based with UK VRN"
    ) {

      Given("the NETP logs into their Government Gateway account")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(false, true, "secureMessagesUkBasedUkVrn")

      When ("the NETP accesses their secure message inbox")
      registration.checkJourneyUrl("secure-messages")
      
      Then("their secure messages are displayed")
      secureMessage.checkClientName("secureMessagesUkBasedUkVrn")
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
  }
}
