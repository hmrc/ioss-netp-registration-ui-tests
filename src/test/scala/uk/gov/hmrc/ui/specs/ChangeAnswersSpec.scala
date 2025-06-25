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

    Scenario(
      "Intermediary changes NETP tax details from UK based to Non-UK based and changes country then removes UK VAT number"
    ) {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
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

      And("the intermediary selects yes on the client-has-vat-number page")
      registration.checkJourneyUrl("client-has-vat-number")
      registration.answerRadioButton("yes")

      And("the intermediary enters a UK Vat Number on the client-vat-number page")
      registration.checkJourneyUrl("client-vat-number")
      registration.enterAnswer("741221471")

      Then("the intermediary selects Cape Verde on the client-country-based page")
      registration.checkJourneyUrl("client-country-based")
      registration.selectCountry("Cape Verde")

      And(
        "the intermediary enters a business name on the client-business-name page"
      )
      registration.checkJourneyUrl("client-business-name")
      registration.enterAnswer("Business Name")

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

      When(
        "the intermediary selects change for UK VAT Number on the client-has-vat-number page"
      )
      registration.checkJourneyUrl("confirm-vat-details")
      registration.selectChangeOrRemoveLink("client-has-vat-number\\?waypoints\\=check-vat-details")

      And("the intermediary selects no on the client-has-vat-number page")
      registration.checkJourneyUrl("client-has-vat-number")
      registration.answerRadioButton("no")

      Then("the intermediary selects Benin on the client-country-based page")
      registration.checkJourneyUrl("client-country-based")
      registration.clearCountry()
      registration.selectCountry("Benin")

      And(
        "the intermediary enters a National Tax Number on the client-tax-reference page"
      )
      registration.checkJourneyUrl("client-tax-reference")
      registration.enterAnswer("123ABCDEF")

      And(
        "the intermediary enters a business name on the client-business-name page"
      )
      registration.checkJourneyUrl("client-business-name")
      registration.enterAnswer("Business Name")

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

      //      The rest of the journey is still in development

    }

    Scenario("Intermediary changes NETP tax details from Non-UK based with National Tax Number to UK VAT Number") {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary selects no on the client-uk-based page")
      registration.answerRadioButton("no")

      And("the intermediary selects yes on the client-has-vat-number page")
      registration.checkJourneyUrl("client-has-vat-number")
      registration.answerRadioButton("no")

      Then("the intermediary selects Argentina on the client-country-based page")
      registration.checkJourneyUrl("client-country-based")
      registration.selectCountry("Argentina")

      And(
        "the intermediary enters a National Tax Number on the client-tax-reference page"
      )
      registration.checkJourneyUrl("client-tax-reference")
      registration.enterAnswer("AR123T")

      And(
        "the intermediary enters a business name on the client-business-name page"
      )
      registration.checkJourneyUrl("client-business-name")
      registration.enterAnswer("Argentina Company")

      And(
        "the intermediary enters an address on the client-address page"
      )
      registration.checkJourneyUrl("client-address")
      registration.enterAddress("1 Street Name", "Suburb", "City Name", "", "")

      When(
        "the intermediary selects change for UK VAT Number on the client-has-vat-number page"
      )
      registration.checkJourneyUrl("confirm-vat-details")
      registration.selectChangeOrRemoveLink("client-has-vat-number\\?waypoints\\=check-vat-details")

      And("the intermediary selects yes on the client-has-vat-number page")
      registration.checkJourneyUrl("client-has-vat-number")
      registration.answerRadioButton("yes")

      And("the intermediary enters a UK Vat Number on the client-vat-number page")
      registration.checkJourneyUrl("client-vat-number")
      registration.enterAnswer("741221471")

      Then("the intermediary selects Argentina on the client-country-based page")
      registration.checkJourneyUrl("client-country-based")
      registration.clearCountry()
      registration.selectCountry("Argentina")

      And(
        "the intermediary enters a business name on the client-business-name page"
      )
      registration.checkJourneyUrl("client-business-name")
      registration.enterAnswer("Argentina Company")

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

      //      The rest of the journey is still in development

    }

    Scenario("Intermediary changes NETP tax details from Non-UK based to UK based with Vat Number") {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
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
      registration.continue()

      //      The rest of the journey is still in development
    }

    Scenario("Intermediary changes NETP tax details from Non-UK based to UK based with UTR then amends Address") {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
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

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
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

    Scenario("Intermediary changes trading name and website details on their NETP registration") {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      And("the intermediary answers questions for a UK based NETP")
      registration.answerVatDetailsUkVrn()

      When(
        "the intermediary selects change for Based in UK on the confirm-vat-details page"
      )
      registration.checkJourneyUrl("confirm-vat-details")
      registration.continue()

      When("the intermediary selects yes on the have-uk-trading-name page")
      registration.checkJourneyUrl("have-uk-trading-name")
      registration.answerRadioButton("yes")

      Then("the intermediary adds the first trading name")
      registration.checkJourneyUrl("uk-trading-name/1")
      registration.enterAnswer("1")

      And("the intermediary selects yes on the add-uk-trading-name page")
      registration.checkJourneyUrl("add-uk-trading-name")
      registration.answerRadioButton("yes")

      And("the intermediary adds the second trading name")
      registration.checkJourneyUrl("uk-trading-name/2")
      registration.enterAnswer("2")

      Then("the intermediary selects change on the second trading name")
      registration.checkJourneyUrl("add-uk-trading-name")
      registration.selectChangeOrRemoveLink("uk-trading-name\\/2\\?waypoints\\=change-add-uk-trading-name")

      And("the intermediary updates the second trading name")
      registration.checkJourneyUrl("uk-trading-name/2")
      registration.enterAnswer("A new 2nd trading name")

      Then("the intermediary selects remove on the first trading name")
      registration.checkJourneyUrl("add-uk-trading-name")
      registration.selectChangeOrRemoveLink("remove-uk-trading-name\\/1")

      Then("the intermediary answers yes on the remove-uk-trading-name/1 page")
      registration.checkJourneyUrl("remove-uk-trading-name/1")
      registration.answerRadioButton("yes")

      And("the intermediary selects no on the add-uk-trading-name page")
      registration.checkJourneyUrl("add-uk-trading-name")
      registration.answerRadioButton("no")

      And("the intermediary selects no on the previous-oss page")
      //      temporary manual navigation
      registration.goToPage("previous-oss")
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("no")

      //      manual navigation to website section until rest of journey is developed
      Then("the intermediary adds the first client website address")
      registration.goToPage("website-address/1")
      registration.checkJourneyUrl("website-address/1")
      registration.enterAnswer("www.first-website.com")

      Then("the intermediary answers yes to add another client website address")
      registration.checkJourneyUrl("add-website-address")
      registration.answerRadioButton("yes")

      Then("the intermediary adds the second client website address")
      registration.checkJourneyUrl("website-address/2")
      registration.enterAnswer("http://websiteno2.co.uk")

      Then("the intermediary selects change on the second client website address")
      registration.checkJourneyUrl("add-website-address")
      registration.selectChangeOrRemoveLink("website-address\\/2\\?waypoints\\=change-add-website-address")

      Then("the intermediary changes the second client website address")
      registration.checkJourneyUrl("website-address/2")
      registration.enterAnswer("www.website1.com")

      Then("the intermediary selects remove on the first client website address")
      registration.checkJourneyUrl("add-website-address")
      registration.selectChangeOrRemoveLink("remove-website-address\\/1")

      Then("the intermediary answers yes on the remove-website-address/1 page")
      registration.checkJourneyUrl("remove-website-address/1")
      registration.answerRadioButton("yes")

      Then("the intermediary answers yes to add another client website address")
      registration.checkJourneyUrl("add-website-address")
      registration.answerRadioButton("yes")

      Then("the intermediary adds another client website address")
      registration.checkJourneyUrl("website-address/2")
      registration.enterAnswer("newnumbertwo-website.test")

      Then("the intermediary answers no to add another client website address")
      registration.checkJourneyUrl("add-website-address")
      registration.answerRadioButton("no")

      //      The rest of the journey is still in development
    }

    Scenario("Intermediary changes previous registration details on their NETP registration") {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      And("the intermediary answers questions for a UK based NETP")
      registration.answerVatDetailsUkVrn()

      When(
        "the intermediary selects change for Based in UK on the confirm-vat-details page"
      )
      registration.checkJourneyUrl("confirm-vat-details")
      registration.continue()

      When("the intermediary selects no on the have-uk-trading-name page")
      registration.checkJourneyUrl("have-uk-trading-name")
      registration.answerRadioButton("no")

      When("the intermediary selects yes on the previous-oss page")
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("yes")

      Then("the intermediary selects which country was it registered in on previous-country page")
      registration.checkJourneyUrl("previous-country/1")
      registration.selectCountry("Bulgaria")

      When("the intermediary selects OSS on the first previous-scheme page for Bulgaria")
      registration.checkJourneyUrl("previous-scheme/1/1")
      registration.answerSchemeType("OSS")

      And("the intermediary adds an OSS non-union scheme number")
      registration.checkJourneyUrl("previous-oss-scheme-number/1/1")
      registration.enterAnswer("EU111222333")

      When("the intermediary selects yes on the previous-scheme-answers/1 page")
      registration.checkJourneyUrl("previous-scheme-answers/1")
      registration.answerRadioButton("yes")

      When("the intermediary selects OSS on the second previous-scheme page for Bulgaria")
      registration.checkJourneyUrl("previous-scheme/1/2")
      registration.answerSchemeType("OSS")

      And("the intermediary adds an OSS union scheme number")
      registration.checkJourneyUrl("previous-oss-scheme-number/1/2")
      registration.enterAnswer("BG123456789")

      When("the intermediary selects yes on the previous-scheme-answers/1 page")
      registration.checkJourneyUrl("previous-scheme-answers/1")
      registration.answerRadioButton("yes")

      When("the intermediary selects IOSS on the third previous-scheme page for Bulgaria")
      registration.checkJourneyUrl("previous-scheme/1/3")
      registration.answerSchemeType("IOSS")

      And("the intermediary adds an IOSS scheme number")
      registration.checkJourneyUrl("previous-ioss-number/1/3")
      registration.enterAnswer("IM1001233211")

      And("the intermediary selects continue after adding all three schemes for Bulgaria")
      registration.checkJourneyUrl("previous-scheme-answers/1")
      registration.continue()

      When(
        "the intermediary selects change for Bulgaria on the previous-schemes-overview page"
      )
      registration.checkJourneyUrl("previous-schemes-overview")
      registration.selectChangeOrRemoveLink(
        "previous-scheme-answers\\/1\\?waypoints\\=change-previous-schemes-overview"
      )

      And(
        "the intermediary selects remove for the OSS union scheme on the remove-previous-scheme page"
      )
      registration.checkJourneyUrl("previous-scheme-answers/1?waypoints=change-previous-schemes-overview")
      registration.selectChangeOrRemoveLink(
        "remove-previous-scheme\\/1\\/3\\?waypoints\\=change-previous-schemes-overview"
      )

      Then("the intermediary answers yes on the remove-previous-scheme page")
      registration.checkJourneyUrl("remove-previous-scheme/1/3?waypoints=change-previous-schemes-overview")
      registration.answerRadioButton("yes")

//      Currently skipping this page
//      And("the intermediary selects no on the previous-scheme-answers page")
//      registration.checkJourneyUrl("previous-scheme-answers/1")
//      registration.answerRadioButton("no")

      And("the intermediary selects yes on the previous-schemes-overview page")
      registration.checkJourneyUrl("previous-schemes-overview")
      registration.answerRadioButton("yes")

      Then("the intermediary selects another country on the previous-country/2 page")
      registration.checkJourneyUrl("previous-country/2")
      registration.selectCountry("Denmark")

      When("the intermediary selects IOSS on the first previous-scheme page for Denmark")
      registration.checkJourneyUrl("previous-scheme/2/1")
      registration.answerSchemeType("IOSS")

      And("the intermediary adds an IOSS scheme number")
      registration.checkJourneyUrl("previous-ioss-number/2/1")
      //      Currently still remembering IOSS number from first scheme
      registration.enterAnswer("IM2087773331")

      Then("the intermediary selects yes on the previous-scheme-answers/2 page")
      registration.checkJourneyUrl("previous-scheme-answers/2")
      registration.answerRadioButton("yes")

      When("the intermediary selects OSS on the second previous-scheme page for Denmark")
      registration.checkJourneyUrl("previous-scheme/2/2")
      registration.answerSchemeType("OSS")

      And("the intermediary adds an OSS union scheme number")
      registration.checkJourneyUrl("previous-oss-scheme-number/2/2")
      registration.enterAnswer("DK12345678")

      Then("the intermediary selects no on the previous-scheme-answers/2 page")
      registration.checkJourneyUrl("previous-scheme-answers/2")
      registration.answerRadioButton("no")

      And("the intermediary selects yes on the previous-schemes-overview page")
      registration.checkJourneyUrl("previous-schemes-overview")
      registration.answerRadioButton("yes")

      Then("the intermediary selects which country was it registered in on previous-country page")
      registration.checkJourneyUrl("previous-country/3")
      registration.selectCountry("Greece")

      When("the intermediary selects OSS on the first previous-scheme page for Greece")
      registration.checkJourneyUrl("previous-scheme/3/1")
      registration.answerSchemeType("OSS")

      And("the intermediary adds an OSS non-union scheme number")
      registration.checkJourneyUrl("previous-oss-scheme-number/3/1")
      registration.enterAnswer("EU111222333")

      When("the intermediary selects no on the previous-scheme-answers/3 page")
      registration.checkJourneyUrl("previous-scheme-answers/3")
      registration.answerRadioButton("no")

      When(
        "the intermediary selects remove for Greece on the previous-schemes-overview page"
      )
      registration.checkJourneyUrl("previous-schemes-overview")
      registration.selectChangeOrRemoveLink("remove-registration\\/3")

      Then("the intermediary selects yes on the remove-registration/3 page")
      registration.checkJourneyUrl("remove-registration/3")
      registration.answerRadioButton("yes")

      And("the intermediary selects no on the previous-schemes-overview page")
      registration.checkJourneyUrl("previous-schemes-overview")
      registration.answerRadioButton("no")

      //      The rest of the journey is still in development
    }
  }
}
