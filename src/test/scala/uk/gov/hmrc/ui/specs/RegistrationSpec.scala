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

class RegistrationSpec extends BaseSpec {

  lazy val registration = Registration
  lazy val auth         = Auth

  Feature("Registration journeys") {

    Scenario("Intermediary registers on behalf of a NETP using the IOSS NETP Registration service - full answers") {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      And("the intermediary answers all of the vat details questions as a UK Based NETP with VRN")
      registration.answerVatDetailsUkVrn()
      registration.checkJourneyUrl("confirm-vat-details")
      registration.continue()

      When("the intermediary selects yes on the have-uk-trading-name page")
      registration.checkJourneyUrl("have-uk-trading-name")
      registration.answerRadioButton("yes")

      Then("the intermediary adds the first trading name")
      registration.checkJourneyUrl("uk-trading-name/1")
      registration.enterAnswer("1st trading-name")

      And("the intermediary selects yes on the add-uk-trading-name page")
      registration.checkJourneyUrl("add-uk-trading-name")
      registration.answerRadioButton("yes")

      And("the intermediary adds the second trading name")
      registration.checkJourneyUrl("uk-trading-name/2")
      registration.enterAnswer("Another Trading Name!")

      And("the intermediary selects no on the add-uk-trading-name page")
      registration.checkJourneyUrl("add-uk-trading-name")
      registration.answerRadioButton("no")

      When("the intermediary selects yes on the previous-oss page")
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("yes")

      Then("the intermediary selects which country was it registered in on previous-country page")
      registration.checkJourneyUrl("previous-country/1")
      registration.selectCountry("Cyprus")

      When("the intermediary selects OSS on the first previous-scheme page for Cyprus")
      registration.checkJourneyUrl("previous-scheme/1/1")
      registration.answerSchemeType("OSS")

      And("the intermediary adds an OSS non-union scheme number")
      registration.checkJourneyUrl("previous-oss-scheme-number/1/1")
      registration.enterAnswer("EU111222333")

      When("the intermediary selects yes on the previous-scheme-answers/1 page")
      registration.checkJourneyUrl("previous-scheme-answers/1")
      registration.answerRadioButton("yes")

      When("the intermediary selects OSS on the second previous-scheme page for Cyprus")
      registration.checkJourneyUrl("previous-scheme/1/2")
      registration.answerSchemeType("OSS")

      And("the intermediary adds an OSS union scheme number")
      registration.checkJourneyUrl("previous-oss-scheme-number/1/2")
      registration.enterAnswer("CY44445555A")

      When("the intermediary selects yes on the previous-scheme-answers/1 page")
      registration.checkJourneyUrl("previous-scheme-answers/1")
      registration.answerRadioButton("yes")

      When("the intermediary selects IOSS on the third previous-scheme page for Cyprus")
      registration.checkJourneyUrl("previous-scheme/1/3")
      registration.answerSchemeType("IOSS")

      And("the intermediary adds an IOSS scheme number")
      registration.checkJourneyUrl("previous-ioss-number/1/3")
      registration.enterAnswer("IM1967773331")

      And("the intermediary selects continue after adding all three schemes for Cyprus")
      registration.checkJourneyUrl("previous-scheme-answers/1")
      registration.continue()

      And("the intermediary selects yes on the previous-schemes-overview page")
      registration.checkJourneyUrl("previous-schemes-overview")
      registration.answerRadioButton("yes")

      Then("the intermediary selects another country on the previous-country/2 page")
      registration.checkJourneyUrl("previous-country/2")
      registration.selectCountry("Poland")

      When("the intermediary selects IOSS on the first previous-scheme page for Poland")
      registration.checkJourneyUrl("previous-scheme/2/1")
      registration.answerSchemeType("IOSS")

      And("the intermediary adds an IOSS scheme number")
      registration.checkJourneyUrl("previous-ioss-number/2/1")
      registration.enterAnswer("IM6167773331")

      Then("the intermediary selects no on the previous-scheme-answers/2 page")
      registration.checkJourneyUrl("previous-scheme-answers/2")
      registration.answerRadioButton("no")

      And("the intermediary selects no on the previous-schemes-overview page")
      registration.checkJourneyUrl("previous-schemes-overview")
      registration.answerRadioButton("no")

      Then("the intermediary selects yes on the eu-fixed-establishment page")
      registration.checkJourneyUrl("eu-fixed-establishment")
      registration.answerRadioButton("yes")

      And(
        "the intermediary selects which country their fixed establishment is in on the vat-registered-eu-country page"
      )
      registration.checkJourneyUrl("vat-registered-eu-country/1")
      registration.selectCountry("Spain")

      And("the intermediary enters the fixed establishment details on the trading-name-business-address page")
      registration.checkJourneyUrl("trading-name-business-address/1")
      registration.enterFETradingName("Spanish Trading Name")
      registration.enterAddress("123 Street Name", "", "Town", "", "ES12345")

      And("the intermediary selects the VAT Number registration type on the registration-tax-type page")
      registration.checkJourneyUrl("registration-tax-type/1")
      registration.answerRegistrationType("VAT number")

      And("the intermediary enters the VAT number on the eu-vat-number page")
      registration.checkJourneyUrl("eu-vat-number/1")
      registration.enterAnswer("EST5554441B")

      And("the intermediary continues through the check-tax-details page")
      registration.checkJourneyUrl("check-tax-details/1")
      registration.continue()

      Then("the intermediary selects yes on the add-tax-details page")
      registration.checkJourneyUrl("add-tax-details")
      registration.answerRadioButton("yes")

      And(
        "the intermediary selects which country their fixed establishment is in on the vat-registered-eu-country page"
      )
      registration.checkJourneyUrl("vat-registered-eu-country/2")
      registration.selectCountry("Netherlands")

      And("the intermediary enters the fixed establishment details on the trading-name-business-address page")
      registration.checkJourneyUrl("trading-name-business-address/2")
      registration.enterFETradingName("Netherlands Trading Name")
      registration.enterAddress("1 Road Name", "Suburb", "City", "Region-Name", "NL5555 12")

      And("the intermediary selects the Tax ID number registration type on the registration-tax-type page")
      registration.checkJourneyUrl("registration-tax-type/2")
      registration.answerRegistrationType("Tax ID number")

      And("the intermediary enters the Tax ID number on the eu-tax-identification-number page")
      registration.checkJourneyUrl("eu-tax-identification-number/2")
      registration.enterAnswer("NL1 665544")

      And("the intermediary continues through the check-tax-details page")
      registration.checkJourneyUrl("check-tax-details/2")
      registration.continue()

      Then("the intermediary selects no on the add-tax-details page")
      registration.checkJourneyUrl("add-tax-details")
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

      Then("the intermediary answers no to add another client website address")
      registration.checkJourneyUrl("add-website-address")
      registration.answerRadioButton("no")

      Then("the intermediary enters credentials on contact-details page")
      registration.checkJourneyUrl("business-contact-details")
      registration.fillContactDetails("Testname", "12345678", "exampletest@mail.com")

      And("the intermediary continues through the check-your-answers page")
      registration.checkJourneyUrl("check-your-answers")
      registration.continue()

      When("the intermediary accepts the declaration")
      registration.checkJourneyUrl("declaration")
      registration.selectCheckbox()

      Then("the intermediary is on the client-application-complete page")
      registration.checkJourneyUrl("client-application-complete")
    }

    Scenario(
      "Intermediary registers on behalf of a NETP using the IOSS NETP Registration service - only mandatory answers"
    ) {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      And("the intermediary answers all of the vat details questions as a UK Based NETP with VRN")
      registration.answerVatDetailsUkVrn()
      registration.checkJourneyUrl("confirm-vat-details")
      registration.continue()

      When("the intermediary selects no on the have-uk-trading-name page")
      registration.checkJourneyUrl("have-uk-trading-name")
      registration.answerRadioButton("no")

      When("the intermediary selects no on the previous-oss page")
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("no")

      Then("the intermediary selects no on the eu-fixed-establishment page")
      registration.checkJourneyUrl("eu-fixed-establishment")
      registration.answerRadioButton("no")

      Then("the intermediary adds the first client website address")
      registration.checkJourneyUrl("website-address/1")
      registration.enterAnswer("www.1st-website.co.uk")

      Then("the intermediary answers yes to add another client website address")
      registration.checkJourneyUrl("add-website-address")
      registration.answerRadioButton("no")

      Then("the intermediary enters credentials on contact-details page")
      registration.checkJourneyUrl("business-contact-details")
      registration.fillContactDetails("Firstname Surname", "+44123456789", "test-email@test.co.uk")

      And("the intermediary continues through the check-your-answers page")
      registration.checkJourneyUrl("check-your-answers")
      registration.continue()

      When("the intermediary accepts the declaration")
      registration.checkJourneyUrl("declaration")
      registration.selectCheckbox()

      Then("the intermediary is on the client-application-complete page")
      registration.checkJourneyUrl("client-application-complete")
    }

  }
}
