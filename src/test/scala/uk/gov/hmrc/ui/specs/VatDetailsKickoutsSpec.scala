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

class VatDetailsKickoutsSpec extends BaseSpec {

  lazy val registration = Registration
  lazy val auth         = Auth

  Feature("Vat Details Kickout Journeys") {

    Scenario("Not found for VAT details when intermediary registers on behalf of a UK based NETP with a VAT Number") {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary selects yes on the client-uk-based page")
      registration.answerRadioButton("yes")

      Then("the intermediary selects yes on the client-has-vat-number page")
      registration.checkJourneyUrl("client-has-vat-number")
      registration.answerRadioButton("yes")

      And(
        "the intermediary enters a UK Vat Number on the client-vat-number page"
      )
      registration.checkJourneyUrl("client-vat-number")
      registration.enterAnswer("900000001")

      Then(
        "the vat-number-not-found page is displayed"
      )
      registration.checkJourneyUrl("vat-number-not-found")
    }

    Scenario(
      "Internal server error for VAT details when intermediary registers on behalf of a UK based NETP with a VAT Number"
    ) {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary selects yes on the client-uk-based page")
      registration.answerRadioButton("yes")

      Then("the intermediary selects yes on the client-has-vat-number page")
      registration.checkJourneyUrl("client-has-vat-number")
      registration.answerRadioButton("yes")

      And(
        "the intermediary enters a UK Vat Number on the client-vat-number page"
      )
      registration.checkJourneyUrl("client-vat-number")
      registration.enterAnswer("800000001")

      Then(
        "the registration-service error page is displayed"
      )
      registration.checkJourneyUrl("registration-service-error")
    }

    Scenario(
      "Incomplete VAT details retrieved when intermediary registers on behalf of a UK based NETP with a VAT Number"
    ) {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary selects yes on the client-uk-based page")
      registration.answerRadioButton("yes")

      Then("the intermediary selects yes on the client-has-vat-number page")
      registration.checkJourneyUrl("client-has-vat-number")
      registration.answerRadioButton("yes")

      And(
        "the intermediary enters a UK Vat Number on the client-vat-number page"
      )
      registration.checkJourneyUrl("client-vat-number")
      registration.enterAnswer("700000001")

      Then(
        "the registration-service error page is displayed"
      )
      registration.checkJourneyUrl("registration-service-error")
    }

    Scenario(
      "Internal Server Error for Intermediary VAT details when intermediary logs into NETP Registration service"
    ) {

      Given(
        "the intermediary accesses the IOSS NETP Registration Service where an internal server error occurs on their vat details"
      )
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "notFound")

      Then("the intermediary is shown the sorry there is a problem page")
      registration.checkRegistrationUrl()
      registration.checkProblemPage()
    }

    Scenario("No VAT enrolment when intermediary logs into NETP Registration service") {

      Given(
        "the intermediary accesses the IOSS NETP Registration Service without a VAT enrolment"
      )
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, false, "notRequired")

      Then("the intermediary is shown the sorry there is a problem page")
      registration.checkRegistrationUrl()
      registration.checkProblemPage()
    }

    Scenario("Intermediary cannot register on behalf of a NETP with an expired VAT Number") {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary selects no on the client-uk-based page")
      registration.answerRadioButton("no")

      And("the intermediary selects yes on the client-has-vat-number page")
      registration.checkJourneyUrl("client-has-vat-number")
      registration.answerRadioButton("yes")

      And("the intermediary enters a UK Vat Number on the client-vat-number page")
      registration.checkJourneyUrl("client-vat-number")
      registration.enterAnswer("700000002")

      Then(
        "the expired-vrn-date page is displayed"
      )
      registration.checkJourneyUrl("expired-vrn-date")
    }
  }
}
