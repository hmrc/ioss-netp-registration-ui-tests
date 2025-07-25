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

class EuTaxDetailsCoreValidationSpec extends BaseSpec {

  lazy val registration = Registration
  lazy val auth         = Auth

  Feature("Core Validation scenarios within the EU Tax Details section of the IOSS NETP Registration journey") {

    Scenario(
      "NETP EU VAT Number matches already active scheme"
    ) {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary enters an EU VAT Number that is already active in another member state")
      registration.answerRadioButton("yes")
      registration.answerVatDetailsUkVrn()
      registration.checkJourneyUrl("confirm-vat-details")
      registration.continue()
      registration.checkJourneyUrl("have-uk-trading-name")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("eu-fixed-establishment")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("vat-registered-eu-country/1")
      registration.selectCountry("Malta")
      registration.checkJourneyUrl("trading-name-business-address/1")
      registration.enterFETradingName("Malta Trading Name")
      registration.enterAddress("123 Street Name", "", "Town", "", "MT12345")
      registration.checkJourneyUrl("registration-tax-type/1")
      registration.answerRegistrationType("VAT number")
      registration.checkJourneyUrl("eu-vat-number/1")
      registration.enterAnswer("MT11122211")

      Then(
        "the intermediary is on the client-already-registered page"
      )
      registration.checkJourneyUrl("client-already-registered")
    }

    Scenario(
      "NETP EU VAT Number matches quarantined scheme"
    ) {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary enters an EU VAT Number that is quarantined in another member state")
      registration.answerRadioButton("yes")
      registration.answerVatDetailsUkVrn()
      registration.checkJourneyUrl("confirm-vat-details")
      registration.continue()
      registration.checkJourneyUrl("have-uk-trading-name")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("eu-fixed-establishment")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("vat-registered-eu-country/1")
      registration.selectCountry("Malta")
      registration.checkJourneyUrl("trading-name-business-address/1")
      registration.enterFETradingName("Malta Trading Name")
      registration.enterAddress("123 Street Name", "", "Town", "", "MT12345")
      registration.checkJourneyUrl("registration-tax-type/1")
      registration.answerRegistrationType("VAT number")
      registration.checkJourneyUrl("eu-vat-number/1")
      registration.enterAnswer("MT11122222")

      Then(
        "the intermediary is on the other-country-excluded-and-quarantined page"
      )
      registration.checkJourneyUrl("other-country-excluded-and-quarantined?countryCode")
    }

    Scenario(
      "NETP EU Tax ID matches already active scheme"
    ) {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary enters an EU Tax ID that is already active in another member state")
      registration.answerRadioButton("yes")
      registration.answerVatDetailsUkVrn()
      registration.checkJourneyUrl("confirm-vat-details")
      registration.continue()
      registration.checkJourneyUrl("have-uk-trading-name")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("eu-fixed-establishment")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("vat-registered-eu-country/1")
      registration.selectCountry("Portugal")
      registration.checkJourneyUrl("trading-name-business-address/1")
      registration.enterFETradingName("Portugal Trading Name")
      registration.enterAddress("123 Street Name", "", "Town", "", "PT12345")
      registration.checkJourneyUrl("registration-tax-type/1")
      registration.answerRegistrationType("Tax ID number")
      registration.checkJourneyUrl("eu-tax-identification-number/1")
      registration.enterAnswer("AA111222")

      Then(
        "the intermediary is on the client-already-registered page"
      )
      registration.checkJourneyUrl("client-already-registered")
    }

    Scenario(
      "NETP EU Tax ID matches quarantined scheme"
    ) {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary enters an EU Tax ID that is quarantined in another member state")
      registration.answerRadioButton("yes")
      registration.answerVatDetailsUkVrn()
      registration.checkJourneyUrl("confirm-vat-details")
      registration.continue()
      registration.checkJourneyUrl("have-uk-trading-name")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("eu-fixed-establishment")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("vat-registered-eu-country/1")
      registration.selectCountry("Portugal")
      registration.checkJourneyUrl("trading-name-business-address/1")
      registration.enterFETradingName("Portugal Trading Name")
      registration.enterAddress("123 Street Name", "", "Town", "", "PT12345")
      registration.checkJourneyUrl("registration-tax-type/1")
      registration.answerRegistrationType("Tax ID number")
      registration.checkJourneyUrl("eu-tax-identification-number/1")
      registration.enterAnswer("AB111222")

      Then(
        "the intermediary is on the other-country-excluded-and-quarantined page"
      )
      registration.checkJourneyUrl("other-country-excluded-and-quarantined?countryCode")
    }
  }
}
