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

class KickoutsSpec extends BaseSpec {

  lazy val registration = Registration
  lazy val auth         = Auth

  Feature("General Kickout Journeys") {

    Scenario("Cannot access NETP Registration journey without being registered on the Intermediary service") {

      Given("a user who is not registered on the Intermediary service accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(false, true, "standard")

      Then("the intermediary is on the cannot-use-this-service page")
      registration.checkJourneyUrl("cannot-use-this-service")
    }

    Scenario("NETP cannot access amend registration journey") {

      Given("a NETP logs into their secure messages inbox")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(false, false, "secureMessagesUkBasedUkVrn")
      registration.checkJourneyUrl("secure-messages")

      When("the NETP manually navigates to the amend registration url")
      registration.goToPage("start-amend-journey/IM9001144771")

      Then("the NETP is on the cannot-use-this-service page")
      registration.checkJourneyUrl("cannot-use-this-service")
    }

    Scenario("Excluded Intermediary cannot access the NETP Registration journey") {

      Given("an excluded Intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "excludedIntermediary")

      Then("the intermediary is on the cannot-use-this-service page")
      registration.checkJourneyUrl("cannot-use-this-service")
    }

    Scenario(
      "Intermediary cannot access amend registration for a client not registered to them"
    ) {

      Given("the intermediary attempts to access amend registration for a client not registered to them")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "notAClient")

      Then("the intermediary is presented with the access-denied page")
      registration.checkJourneyUrl("access-denied")
    }

    Scenario("Intermediary cannot access pending registrations for clients not assigned to them") {

      Given("the intermediary attempts to access a pending registration for a client not registered to them")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "pendingNotClient")

      Then("the intermediary is presented with the access-denied page")
      registration.checkJourneyUrl("access-denied")
    }
  }
}
