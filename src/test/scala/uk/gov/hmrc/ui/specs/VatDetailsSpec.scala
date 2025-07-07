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

class VatDetailsSpec extends BaseSpec {

  lazy val registration = Registration
  lazy val auth         = Auth

  Feature("UK and Non-UK Vat Details Variations") {

    Scenario("Intermediary registers on behalf of a UK based NETP with a VAT Number") {

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
      registration.enterAnswer("111222333")

      Then(
        "the intermediary selects yes on the confirm-vat-details page"
      )
      registration.checkJourneyUrl("confirm-vat-details")
      registration.continue()

      And("the intermediary completes the rest of the journey")
      registration.completeRegistrationCompulsoryAnswersOnly()
    }

    Scenario("Intermediary registers on behalf of a UK based NETP with a UTR") {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary selects yes on the client-uk-based page")
      registration.answerRadioButton("yes")

      Then("the intermediary selects no on the client-has-vat-number page")
      registration.checkJourneyUrl("client-has-vat-number")
      registration.answerRadioButton("no")

      And(
        "the intermediary enters a business name on the client-business-name page"
      )
      registration.checkJourneyUrl("client-business-name")
      registration.enterAnswer("Business name 123")

      Then("the intermediary selects yes on the client-has-utr page")
      registration.checkJourneyUrl("client-has-utr")
      registration.answerRadioButton("yes")

      And(
        "the intermediary enters a UTR on the client-utr-number page"
      )
      registration.checkJourneyUrl("client-utr-number")
      registration.enterAnswer("1112223334")

      And(
        "the intermediary enters an address on the client-address page"
      )
      registration.checkJourneyUrl("client-address")
      registration.enterAddress("1 Street Name", "", "City", "", "")

      Then(
        "the intermediary selects continue on the confirm-vat-details page"
      )
      registration.checkJourneyUrl("confirm-vat-details")
      registration.continue()

      And("the intermediary completes the rest of the journey")
      registration.completeRegistrationCompulsoryAnswersOnly()
    }

    Scenario("Intermediary registers on behalf of a UK based NETP with a NINO") {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary selects yes on the client-uk-based page")
      registration.answerRadioButton("yes")

      Then("the intermediary selects no on the client-has-vat-number page")
      registration.checkJourneyUrl("client-has-vat-number")
      registration.answerRadioButton("no")

      And(
        "the intermediary enters a business name on the client-business-name page"
      )
      registration.checkJourneyUrl("client-business-name")
      registration.enterAnswer("Business-name 22!")

      Then("the intermediary selects no on the client-has-utr page")
      registration.checkJourneyUrl("client-has-utr")
      registration.answerRadioButton("no")

      And(
        "the intermediary enters a NINO on the clients-nino-number page"
      )
      registration.checkJourneyUrl("clients-nino-number")
      registration.enterAnswer("AA112233C")

      And(
        "the intermediary enters an address on the client-address page"
      )
      registration.checkJourneyUrl("client-address")
      registration.enterAddress("1 Street Name", "Suburb", "Town", "Region", "AA1 1AA")

      Then(
        "the intermediary selects continue on the confirm-vat-details page"
      )
      registration.checkJourneyUrl("confirm-vat-details")
      registration.continue()

      And("the intermediary completes the rest of the journey")
      registration.completeRegistrationCompulsoryAnswersOnly()
    }

    Scenario("Intermediary registers on behalf of a Non-UK based NETP with a UK VAT registration number") {

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
      registration.enterAnswer("741221471")

      Then("the intermediary selects Jamaica on the client-country-based page")
      registration.checkJourneyUrl("client-country-based")
      registration.selectCountry("Jamaica")

      And(
        "the intermediary enters a business name on the client-business-name page"
      )
      registration.checkJourneyUrl("client-business-name")
      registration.enterAnswer("Jamaican Company")

      And(
        "the intermediary enters an address on the client-address page"
      )
      registration.checkJourneyUrl("client-address")
      registration.enterAddress("1 Street Name", "", "City-Name", "", "12345")

      Then(
        "the intermediary selects continue on the confirm-vat-details page"
      )
      registration.checkJourneyUrl("confirm-vat-details")
      registration.continue()

      And("the intermediary completes the rest of the journey")
      registration.completeRegistrationCompulsoryAnswersOnly()
    }

    Scenario("Intermediary registers on behalf of a Non-UK based NETP without a UK VAT registration number") {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary selects no on the client-uk-based page")
      registration.answerRadioButton("no")

      And("the intermediary selects yes on the client-has-vat-number page")
      registration.checkJourneyUrl("client-has-vat-number")
      registration.answerRadioButton("no")

      Then("the intermediary selects Jamaica on the client-country-based page")
      registration.checkJourneyUrl("client-country-based")
      registration.selectCountry("Luxembourg")

      And(
        "the intermediary enters a Tax Reference Number on the client-tax-reference page"
      )
      registration.checkJourneyUrl("client-tax-reference")
      registration.enterAnswer("LUX 123")

      And(
        "the intermediary enters a business name on the client-business-name page"
      )
      registration.checkJourneyUrl("client-business-name")
      registration.enterAnswer("Luxembourg Company")

      And(
        "the intermediary enters an address on the client-address page"
      )
      registration.checkJourneyUrl("client-address")
      registration.enterAddress("1 Street Name", "Suburb", "City Name", "", "")

      Then(
        "the intermediary selects continue on the confirm-vat-details page"
      )
      registration.checkJourneyUrl("confirm-vat-details")
      registration.continue()

      And("the intermediary completes the rest of the journey")
      registration.completeRegistrationCompulsoryAnswersOnly()
    }
  }
}
