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

      When("the intermediary enters two trading names")
      registration.checkJourneyUrl("have-uk-trading-name")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("uk-trading-name/1")
      registration.enterAnswer("1")
      registration.checkJourneyUrl("add-uk-trading-name")
      registration.answerRadioButton("yes")
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

      And("the intermediary answers no for the EU registration sections of the registration journey")
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("eu-fixed-establishment")
      registration.answerRadioButton("no")

      Then("the intermediary adds the first client website address")
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

      Then("the intermediary completes the rest of the registration journey")
      registration.checkJourneyUrl("business-contact-details")
      registration.fillContactDetails("Firstname Surname", "+44123456789", "test-email@test.co.uk")
      registration.checkJourneyUrl("check-your-answers")
      registration.continue()
      registration.checkJourneyUrl("declaration")
      registration.selectCheckbox()
      registration.checkJourneyUrl("client-application-complete")
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

      Then("the intermediary enters the details for one country they were previously registered in")
      registration.checkJourneyUrl("previous-country/1")
      registration.selectCountry("Bulgaria")
      registration.checkJourneyUrl("previous-scheme/1/1")
      registration.answerSchemeType("OSS")
      registration.checkJourneyUrl("previous-oss-scheme-number/1/1")
      registration.enterAnswer("EU111222333")
      registration.checkJourneyUrl("previous-scheme-answers/1")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("previous-scheme/1/2")
      registration.answerSchemeType("OSS")
      registration.checkJourneyUrl("previous-oss-scheme-number/1/2")
      registration.enterAnswer("BG123456789")
      registration.checkJourneyUrl("previous-scheme-answers/1")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("previous-scheme/1/3")
      registration.answerSchemeType("IOSS")
      registration.checkJourneyUrl("previous-scheme-intermediary/1/3")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("previous-ioss-number/1/3")
      registration.enterAnswer("IM1001233211")
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

      And("the intermediary selects no on the previous-scheme-answers page")
      registration.checkJourneyUrl("previous-scheme-answers/1")
      registration.answerRadioButton("no")

      And("the intermediary adds details for another country with a previous registration")
      registration.checkJourneyUrl("previous-schemes-overview")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("previous-country/2")
      registration.selectCountry("Denmark")
      registration.checkJourneyUrl("previous-scheme/2/1")
      registration.answerSchemeType("IOSS")
      registration.checkJourneyUrl("previous-scheme-intermediary/2/1")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("previous-ioss-number/2/1")
      registration.enterAnswer("IM2087773331")
      registration.checkJourneyUrl("previous-scheme-answers/2")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("previous-scheme/2/2")
      registration.answerSchemeType("OSS")
      registration.checkJourneyUrl("previous-oss-scheme-number/2/2")
      registration.enterAnswer("DK12345678")
      registration.checkJourneyUrl("previous-scheme-answers/2")
      registration.answerRadioButton("no")

      And("the intermediary adds details for a third country they were previously registered in")
      registration.checkJourneyUrl("previous-schemes-overview")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("previous-country/3")
      registration.selectCountry("Greece")
      registration.checkJourneyUrl("previous-scheme/3/1")
      registration.answerSchemeType("OSS")
      registration.checkJourneyUrl("previous-oss-scheme-number/3/1")
      registration.enterAnswer("EU111222333")
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

      And("the intermediary completes the rest of the registration journey")
      registration.checkJourneyUrl("eu-fixed-establishment")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("website-address/1")
      registration.enterAnswer("www.1stwebsite.com")
      registration.checkJourneyUrl("add-website-address")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("business-contact-details")
      registration.fillContactDetails("Firstname Surname", "+44123456789", "test-email@test.co.uk")
      registration.checkJourneyUrl("check-your-answers")
      registration.continue()
      registration.checkJourneyUrl("declaration")
      registration.selectCheckbox()
      registration.checkJourneyUrl("client-application-complete")
    }

    Scenario("Intermediary changes EU registration details on their NETP registration") {

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

      When("the intermediary selects no on the previous-oss page")
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("no")

      Then("the intermediary selects yes on the eu-fixed-establishment page")
      registration.checkJourneyUrl("eu-fixed-establishment")
      registration.answerRadioButton("yes")

      And(
        "the intermediary adds fixed establishment details for the first country"
      )
      registration.checkJourneyUrl("vat-registered-eu-country/1")
      registration.selectCountry("Greece")
      registration.checkJourneyUrl("trading-name-business-address/1")
      registration.enterFETradingName("Greek Trading Name")
      registration.enterAddress("123 Street Name", "", "Town", "", "EL 12345")
      registration.checkJourneyUrl("registration-tax-type/1")
      registration.answerRegistrationType("VAT number")
      registration.checkJourneyUrl("eu-vat-number/1")
      registration.enterAnswer("EL987654321")
      registration.checkJourneyUrl("check-tax-details/1")
      registration.continue()

      Then("the intermediary adds details for a second country")
      registration.checkJourneyUrl("add-tax-details")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("vat-registered-eu-country/2")
      registration.selectCountry("Estonia")
      registration.checkJourneyUrl("trading-name-business-address/2")
      registration.enterFETradingName("Estonian Trading Name")
      registration.enterAddress("55 Test Avenue", "", "City", "", "E12541")
      registration.checkJourneyUrl("registration-tax-type/2")
      registration.answerRegistrationType("Tax ID number")
      registration.checkJourneyUrl("eu-tax-identification-number/2")
      registration.enterAnswer("E123S123B")
      registration.checkJourneyUrl("check-tax-details/2")
      registration.continue()

      When(
        "the intermediary selects change for Greece on the add-tax-details page"
      )
      registration.checkJourneyUrl("add-tax-details")
      registration.selectChangeOrRemoveLink("check-tax-details\\/1\\?waypoints\\=change-add-tax-details")

      And(
        "the intermediary selects change for Country on the check-tax-details page"
      )
      registration.checkJourneyUrl("check-tax-details/1?waypoints=change-add-tax-details")
      registration.selectChangeOrRemoveLink(
        "vat-registered-eu-country\\/1\\?waypoints\\=check-tax-details-1\\%2Cchange-add-tax-details"
      )

      And(
        "the intermediary selects a different country on the vat-registered-eu-country page"
      )
      registration.checkJourneyUrl("vat-registered-eu-country/1")
      registration.clearCountry()
      registration.selectCountry("France")

      And("the intermediary enters the fixed establishment details on the trading-name-business-address page")
      registration.checkJourneyUrl("trading-name-business-address/1")
      registration.enterFETradingName("French Trading Name")
      registration.enterAddress("123 Street Name", "", "Town", "", "FR12345")

      And("the intermediary selects the Tax ID number registration type on the registration-tax-type page")
      registration.checkJourneyUrl("registration-tax-type/1")
      registration.answerRegistrationType("Tax ID number")

      And("the intermediary enters the Tax ID number on the eu-tax-identification-number page")
      registration.checkJourneyUrl("eu-tax-identification-number/1")
      registration.enterAnswer("F121212FR")

      And("the intermediary continues through the check-tax-details page")
      registration.checkJourneyUrl("check-tax-details/1")
      registration.continue()

      Then("the intermediary selects yes on the add-tax-details page")
      registration.checkJourneyUrl("add-tax-details")
      registration.answerRadioButton("yes")

      And(
        "the intermediary selects which country their fixed establishment is in on the vat-registered-eu-country page"
      )
      registration.checkJourneyUrl("vat-registered-eu-country/3")
      registration.selectCountry("Finland")

      And("the intermediary enters the fixed establishment details on the trading-name-business-address page")
      registration.checkJourneyUrl("trading-name-business-address/3")
      registration.enterFETradingName("Finnish Trading Name")
      registration.enterAddress("55 Test Avenue", "", "City", "", "FIN12541")

      And("the intermediary selects the Tax ID number registration type on the registration-tax-type page")
      registration.checkJourneyUrl("registration-tax-type/3")
      registration.answerRegistrationType("Tax ID number")

      And("the intermediary enters the Tax ID number on the eu-tax-identification-number page")
      registration.checkJourneyUrl("eu-tax-identification-number/3")
      registration.enterAnswer("F1212521")

      And("the intermediary continues through the check-tax-details page")
      registration.checkJourneyUrl("check-tax-details/3")
      registration.continue()

      When("the intermediary selects remove on Estonia")
      registration.checkJourneyUrl("add-tax-details")
      registration.selectChangeOrRemoveLink("remove-tax-details\\/2")

      Then("the intermediary selects yes on the remove-tax-details/2 page")
      registration.checkJourneyUrl("remove-tax-details/2")
      registration.answerRadioButton("yes")

      When("the intermediary selects change on Finland")
      registration.checkJourneyUrl("add-tax-details")
      registration.selectChangeOrRemoveLink("check-tax-details\\/2\\?waypoints\\=change-add-tax-details")

      When("the intermediary selects change on Tax registration type")
      registration.checkJourneyUrl("check-tax-details/2?waypoints=change-add-tax-details")
      registration.selectChangeOrRemoveLink(
        "registration-tax-type\\/2\\?waypoints\\=check-tax-details-2\\%2Cchange-add-tax-details"
      )

      And("the intermediary changes the registration type to VAT number on the registration-tax-type page")
      registration.checkJourneyUrl("registration-tax-type/2?waypoints=check-tax-details-2%2Cchange-add-tax-details")
      registration.answerRegistrationType("VAT number")

      And("the intermediary enters the VAT number on the eu-vat-number page")
      registration.checkJourneyUrl("eu-vat-number/2")
      registration.enterAnswer("FI44447777")

      And("the intermediary continues through the check-tax-details page")
      registration.checkJourneyUrl("check-tax-details/2")
      registration.continue()

      Then("the intermediary selects no on the add-tax-details page")
      registration.checkJourneyUrl("add-tax-details")
      registration.answerRadioButton("no")

      Then("the intermediary completes the rest of the registration")
      registration.checkJourneyUrl("website-address/1")
      registration.enterAnswer("www.website1.co.uk")
      registration.checkJourneyUrl("add-website-address")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("business-contact-details")
      registration.fillContactDetails("Firstname Surname", "0123456789", "test-email@test.co.uk")
      registration.checkJourneyUrl("check-your-answers")
      registration.continue()
      registration.checkJourneyUrl("declaration")
      registration.selectCheckbox()
      registration.checkJourneyUrl("client-application-complete")
    }
  }
}
