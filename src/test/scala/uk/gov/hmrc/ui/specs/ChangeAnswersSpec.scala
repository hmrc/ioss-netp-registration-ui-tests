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

class ChangeAnswersSpec extends BaseSpec {

  lazy val registration = Registration
  lazy val auth         = Auth

  Feature("Changing answers within the IOSS NETP Registration journeys") {

    Scenario("Intermediary changes NETP tax details from UK based to Non-UK based and changes country") {

      Given("the intermediary accesses the IOSS Intermediary Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true)
      registration.checkJourneyUrl("client-uk-based")

      And("the intermediary answers questions for a UK based NETP")
      registration.answerVatDetailsUkVrn()

      When(
        "the intermediary selects change for Based in UK on the confirm-vat-details page"
      )
      registration.checkJourneyUrl("confirm-vat-details")
      registration.selectChangeOrRemoveLink("client-uk-based\\?waypoints\\=check-vat-details")

      Then("the intermediary selects no on the client-uk-based page")
      registration.checkJourneyUrl("client-uk-based")
      registration.answerRadioButton("no")

      Then("the intermediary selects Cape Verde on the client-country-based page")
      registration.checkJourneyUrl("client-country-based")
      registration.selectCountry("Cape Verde")

      And(
        "the intermediary enters a business name on the client-business-name page"
      )
      registration.checkJourneyUrl("client-business-name")
      registration.enterAnswer("Business Name")

      And(
        "the intermediary enters a Tax Reference Number on the client-tax-reference page"
      )
      registration.checkJourneyUrl("client-tax-reference")
      registration.enterAnswer("123ABCDEF")

      And(
        "the intermediary enters an address on the client-address page"
      )
      registration.checkJourneyUrl("client-address")
      registration.enterAddress("1 Street Name", "", "City-Name", "", "12345")

      When(
        "the intermediary selects change for Country based in on the client-country-based page"
      )
      registration.checkJourneyUrl("confirm-vat-details")
      registration.selectChangeOrRemoveLink("client-country-based\\?waypoints\\=check-vat-details")

      Then("the intermediary selects Benin on the client-country-based page")
      registration.checkJourneyUrl("client-country-based")
      registration.clearCountry()
      registration.selectCountry("Benin")

      Then(
        "the intermediary selects continue on the confirm-vat-details page"
      )
      registration.checkJourneyUrl("confirm-vat-details")
      registration.continue()

      //      The rest of the journey is still in development

    }

    Scenario("Intermediary changes NETP tax details from Non-UK based to UK based with Vat Number") {

      Given("the intermediary accesses the IOSS Intermediary Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true)
      registration.checkJourneyUrl("client-uk-based")

      And("the intermediary answers questions for a Non-UK based NETP")
      registration.answerVatDetailsNonUk()

      When(
        "the intermediary selects change for Based in UK on the confirm-vat-details page"
      )
      registration.checkJourneyUrl("confirm-vat-details")
      registration.selectChangeOrRemoveLink("client-uk-based\\?waypoints\\=check-vat-details")

      Then("the intermediary selects yes on the client-uk-based page")
      registration.checkJourneyUrl("client-uk-based")
      registration.answerRadioButton("yes")

      Then("the intermediary selects yes on the client-has-vat-number page")
      registration.checkJourneyUrl("client-has-vat-number")
      registration.answerRadioButton("yes")

      And(
        "the intermediary enters a UK Vat Number on the client-vat-number page"
      )
      registration.checkJourneyUrl("client-vat-number")
      registration.enterAnswer("GB999888777")

      When(
        "the intermediary amends the UK Vat Number they just entered via the confirm-vat-details page"
      )
      registration.checkJourneyUrl("confirm-vat-details")
      registration.selectChangeOrRemoveLink("client-vat-number\\?waypoints\\=check-vat-details")

      And(
        "the intermediary adds a different UK Vat Number on the client-vat-number page"
      )
      registration.checkJourneyUrl("client-vat-number")
      registration.enterAnswer("412589652")

      Then(
        "the intermediary selects yes on the confirm-vat-details page"
      )
      registration.checkJourneyUrl("confirm-vat-details")
      registration.answerVatDetails("yes")

      //      The rest of the journey is still in development
    }

    Scenario("Intermediary changes NETP tax details from Non-UK based to UK based with UTR then amends Address") {

      Given("the intermediary accesses the IOSS Intermediary Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true)
      registration.checkJourneyUrl("client-uk-based")

      And("the intermediary answers questions for a Non-UK based NETP")
      registration.answerVatDetailsNonUk()

      When(
        "the intermediary selects change for Based in UK on the confirm-vat-details page"
      )
      registration.checkJourneyUrl("confirm-vat-details")
      registration.selectChangeOrRemoveLink("client-uk-based\\?waypoints\\=check-vat-details")

      Then("the intermediary selects yes on the client-uk-based page")
      registration.checkJourneyUrl("client-uk-based")
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

      When(
        "the intermediary selects change for Based in UK on the confirm-vat-details page"
      )
      registration.checkJourneyUrl("confirm-vat-details")
      registration.selectChangeOrRemoveLink("client-address\\?waypoints\\=check-vat-details")

      And(
        "the intermediary makes amendments to the address on the client-address page"
      )
      registration.checkJourneyUrl("client-address")
      registration.updateField("line2", "Suburb")
      registration.updateField("townOrCity", "New City")
      registration.continue()

      Then(
        "the intermediary selects continue on the confirm-vat-details page"
      )
      registration.checkJourneyUrl("confirm-vat-details")
      registration.continue()

      //      The rest of the journey is still in development
    }

    Scenario(
      "Intermediary changes NETP tax details from Non-UK based to UK based with NINO then amends Business Name"
    ) {

      Given("the intermediary accesses the IOSS Intermediary Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true)
      registration.checkJourneyUrl("client-uk-based")

      And("the intermediary answers questions for a Non-UK based NETP")
      registration.answerVatDetailsNonUk()

      When(
        "the intermediary selects change for Based in UK on the confirm-vat-details page"
      )
      registration.checkJourneyUrl("confirm-vat-details")
      registration.selectChangeOrRemoveLink("client-uk-based\\?waypoints\\=check-vat-details")

      Then("the intermediary selects yes on the client-uk-based page")
      registration.checkJourneyUrl("client-uk-based")
      registration.answerRadioButton("yes")

      Then("the intermediary selects no on the client-has-vat-number page")
      registration.checkJourneyUrl("client-has-vat-number")
      registration.answerRadioButton("no")

      And(
        "the intermediary enters a business name on the client-business-name page"
      )
      registration.checkJourneyUrl("client-business-name")
      registration.enterAnswer("Business name 123")

      Then("the intermediary selects no on the client-has-utr page")
      registration.checkJourneyUrl("client-has-utr")
      registration.answerRadioButton("no")

      And(
        "the intermediary enters a NINO on the clients-nino-number page"
      )
      registration.checkJourneyUrl("clients-nino-number")
      registration.enterAnswer("DD112233D")

      And(
        "the intermediary enters an address on the client-address page"
      )
      registration.checkJourneyUrl("client-address")
      registration.enterAddress("1 Street Name", "Suburb", "Town", "Region", "AA1 1AA")

      When(
        "the intermediary selects change for Client's Business Name on the confirm-vat-details page"
      )
      registration.checkJourneyUrl("confirm-vat-details")
      registration.selectChangeOrRemoveLink("client-business-name\\?waypoints\\=check-vat-details")

      Then("the intermediary amends the business name on the client-uk-based page")
      registration.checkJourneyUrl("client-business-name")
      registration.enterAnswer("A new and different business name")

      Then(
        "the intermediary selects continue on the confirm-vat-details page"
      )
      registration.checkJourneyUrl("confirm-vat-details")
      registration.continue()

      //      The rest of the journey is still in development

    }

    Scenario("Intermediary registers on behalf of a UK based NETP with a VAT Number") {

      Given("the intermediary accesses the IOSS Intermediary Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true)
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
      registration.answerVatDetails("yes")

      //      The rest of the journey is still in development
    }
  }
}
