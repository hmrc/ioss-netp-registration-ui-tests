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

  private val registration = Registration
  private val auth         = Auth

  Feature("Registration journeys") {

    Scenario(" Intermediary accesses the IOSS NETP Registration Service") {

      Given("the intermediary accesses the IOSS Intermediary NETP Registration Service")
      auth.gotToAuthorityWizard()
      auth.loginUsingAuthorityWizard("100000001")
      registration.checkJourneyUrl("intermediary-netp-registered")
      
//    manually navigate to the url 
      When("the intermediary selects yes if business registered for tax in EU countries on vat-registered-eu page")
      registration.goToPage("tax-in-eu")
      registration.answerRadioButton("yes")

      And("the intermediary selects Greece on the first vat-registered-eu-country page")
      registration.checkJourneyUrl("vat-registered-eu-country/1")
      registration.selectCountry("Greece")

      And("the intermediary selects yes on the first eu-fixed-establishment page")
      registration.checkJourneyUrl("vat-registered-eu-fixed-establishment/1")
      registration.answerRadioButton("yes")

      And("the intermediary selects VAT number on the first registration-tax-type page")
      registration.checkJourneyUrl("registration-tax-type/1")
      registration.selectRegistrationType("vat number")

      And("the intermediary adds the VAT registration number for Greece")
      registration.checkJourneyUrl("vat-registered-eu-vat-number/1")
      registration.enterAnswer("GE12345678")

      And("the intermediary adds the trading name for Greece")
      registration.checkJourneyUrl("vat-registered-eu-trading-name/1")
      registration.enterAnswer("GE Trade")

      And("the intermediary adds the fixed establishment address for Greece")
      registration.checkJourneyUrl("vat-registered-eu-fixed-establishment-address/1")
      registration.enterFixedEstablishmentAddress("6 Street Name", "", "Corfu Town", "", "GE555CE")

      And("the intermediary selects continue on the check-tax-details page")
      registration.checkJourneyUrl("vat-registered-eu-check-tax-details")
      registration.continue()

      And("the intermediary selects yes on the add-tax-details page")
      registration.checkJourneyUrl("add-tax-details")
      registration.answerRadioButton("yes")

      And("the intermediary selects Belgium on the second eu-tax page")
      registration.checkJourneyUrl("eu-tax/2")
      registration.selectCountry("Belgium")

      And("the intermediary selects yes on the second eu-fixed-establishment page")
      registration.checkJourneyUrl("vat-registered-eu-fixed-establishment/2")
      registration.answerRadioButton("yes")

      And("the intermediary selects tax id number on the second registration-tax-type page")
      registration.checkJourneyUrl("registration-tax-type/2")
      registration.selectRegistrationType("unique tax id number")

      And("the intermediary adds the tax identification number for Belgium")
      registration.checkJourneyUrl("eu-tax-identification-number/2")
      registration.enterAnswer("unique tax id number BEL 123 456")
      registration.checkJourneyUrl("eu-trading-name/2")
      registration.enterAnswer("Bel -1234567")

      And("the intermediary adds the fixed establishment address for Belgium")
      registration.checkJourneyUrl("vat-registered-eu-fixed-establishment-address/2")
      registration.enterFixedEstablishmentAddress("1 Street Name", "", "Beltown", "", "")

      And("the intermediary selects continue on the check-tax-details page")
      registration.checkJourneyUrl("vat-registered-eu-check-tax-details")
      registration.continue()
      
      And("the intermediary selects no on the add-tax-details page")
      registration.checkJourneyUrl("add-tax-details")
      registration.answerRadioButton("no")

//     the rest of the journey is yet to be developed
    }
    
    Scenario("Intermediary says no on the IOSS  NETP Registration Service") {

      Given("the intermediary accesses the IOSS Intermediary NETP Registration Service")
      auth.gotToAuthorityWizard()
      auth.loginUsingAuthorityWizard("100000001")
      registration.checkJourneyUrl("intermediary-netp-Notregistered")

      //    manually navigate to the url 
      When("the intermediary selects no if business registered for tax in EU countries on vat-registered-eu page")
      registration.checkJourneyUrl("tax-in-eu")
      registration.answerRadioButton("no")

    }
  }
}
