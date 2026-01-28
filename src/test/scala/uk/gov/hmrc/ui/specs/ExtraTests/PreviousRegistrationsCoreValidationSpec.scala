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

class PreviousRegistrationsCoreValidationSpec extends BaseSpec {

  lazy val registration = Registration
  lazy val auth         = Auth

  Feature("Core Validation scenarios within the Previous Registrations section of the IOSS NETP Registration journey") {

    Scenario(
      "NETP NI VAT Number matches already active scheme"
    ) {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      When(
        "the intermediary enters an OSS scheme for NI with a VAT Number that is already active in another member state"
      )
      registration.answerVatDetailsUkVrn()
      registration.checkJourneyUrl("confirm-tax-details")
      registration.continue()
      registration.checkJourneyUrl("have-trading-name")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("previous-country/1")
      registration.selectCountry("Northern Ireland")
      registration.checkJourneyUrl("previous-scheme/1/1")
      registration.answerSchemeType("OSS")
      registration.checkJourneyUrl("previous-oss-scheme-number/1/1")
      registration.enterAnswer("XI100000003")

      Then(
        "the intermediary can continue with the registration journey"
      )
      registration.checkJourneyUrl("previous-scheme-answers/1")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("previous-schemes-overview")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("eu-fixed-establishment")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("website-address/1")
      registration.enterAnswer("www.1st-website.co.uk")
      registration.checkJourneyUrl("add-website-address")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("business-contact-details")
      registration.fillContactDetails("Firstname Surname", "+44123456789", "test-email@test.co.uk")
      registration.checkJourneyUrl("check-your-answers")
      registration.continue()
      registration.checkJourneyUrl("declaration")
      registration.selectCheckbox()
      registration.checkJourneyUrl("client-application-complete")

      And("the NETP can complete the declaration and submit the registration")
      registration.submitDeclarationAndRegistrationNETP()
    }

    Scenario(
      "NETP NI VAT Number matches quarantined scheme"
    ) {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary enters an OSS scheme for NI with a VAT Number that is quarantined in another member state")
      registration.answerVatDetailsUkVrn()
      registration.checkJourneyUrl("confirm-tax-details")
      registration.continue()
      registration.checkJourneyUrl("have-trading-name")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("previous-country/1")
      registration.selectCountry("Northern Ireland")
      registration.checkJourneyUrl("previous-scheme/1/1")
      registration.answerSchemeType("OSS")
      registration.checkJourneyUrl("previous-oss-scheme-number/1/1")
      registration.enterAnswer("XI600000014")

      Then(
        "the intermediary is on the other-country-excluded-and-quarantined page"
      )
      registration.checkJourneyUrl("other-country-excluded-and-quarantined?countryCode")
    }

    Scenario(
      "NETP Non-NI VAT Number matches already active scheme"
    ) {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      When(
        "the intermediary enters an OSS scheme for a non-NI country with a VAT Number that is already active in another member state"
      )
      registration.answerVatDetailsUkVrn()
      registration.checkJourneyUrl("confirm-tax-details")
      registration.continue()
      registration.checkJourneyUrl("have-trading-name")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("previous-country/1")
      registration.selectCountry("Lithuania")
      registration.checkJourneyUrl("previous-scheme/1/1")
      registration.answerSchemeType("OSS")
      registration.checkJourneyUrl("previous-oss-scheme-number/1/1")
      registration.enterAnswer("LT333344445")

      Then(
        "the intermediary can continue with the registration journey"
      )
      registration.checkJourneyUrl("previous-scheme-answers/1")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("previous-schemes-overview")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("eu-fixed-establishment")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("website-address/1")
      registration.enterAnswer("www.1st-website.co.uk")
      registration.checkJourneyUrl("add-website-address")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("business-contact-details")
      registration.fillContactDetails("Firstname Surname", "+44123456789", "test-email@test.co.uk")
      registration.checkJourneyUrl("check-your-answers")
      registration.continue()
      registration.checkJourneyUrl("declaration")
      registration.selectCheckbox()
      registration.checkJourneyUrl("client-application-complete")

      And("the NETP can complete the declaration and submit the registration")
      registration.submitDeclarationAndRegistrationNETP()
    }

    Scenario(
      "NETP Non-NI VAT Number matches quarantined scheme"
    ) {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      When(
        "the intermediary enters an OSS scheme for a non-NI country with a VAT Number that is quarantined in another member state"
      )
      registration.answerVatDetailsUkVrn()
      registration.checkJourneyUrl("confirm-tax-details")
      registration.continue()
      registration.checkJourneyUrl("have-trading-name")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("previous-country/1")
      registration.selectCountry("Lithuania")
      registration.checkJourneyUrl("previous-scheme/1/1")
      registration.answerSchemeType("OSS")
      registration.checkJourneyUrl("previous-oss-scheme-number/1/1")
      registration.enterAnswer("LT333344446")

      Then(
        "the intermediary is on the other-country-excluded-and-quarantined page"
      )
      registration.checkJourneyUrl("other-country-excluded-and-quarantined?countryCode")
    }

    Scenario(
      "NETP NI IOSS Number matches already active scheme"
    ) {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary enters an IOSS scheme for NI that is already active in another member state")
      registration.answerVatDetailsUkVrn()
      registration.checkJourneyUrl("confirm-tax-details")
      registration.continue()
      registration.checkJourneyUrl("have-trading-name")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("previous-country/1")
      registration.selectCountry("Northern Ireland")
      registration.checkJourneyUrl("previous-scheme/1/1")
      registration.answerSchemeType("IOSS")
      registration.checkJourneyUrl("previous-scheme-intermediary/1/1")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("previous-ioss-number/1/1")
      registration.enterAnswer("IM9009999998")

      Then(
        "the intermediary is on the client-already-registered page"
      )
      registration.checkJourneyUrl("client-already-registered")
    }

    Scenario(
      "NETP NI IOSS Number matches quarantined scheme"
    ) {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary enters an IOSS scheme for NI that is quarantined in another member state")
      registration.answerVatDetailsUkVrn()
      registration.checkJourneyUrl("confirm-tax-details")
      registration.continue()
      registration.checkJourneyUrl("have-trading-name")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("previous-country/1")
      registration.selectCountry("Northern Ireland")
      registration.checkJourneyUrl("previous-scheme/1/1")
      registration.answerSchemeType("IOSS")
      registration.checkJourneyUrl("previous-scheme-intermediary/1/1")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("previous-ioss-number/1/1")
      registration.enterAnswer("IM9003999993")

      Then(
        "the intermediary is on the other-country-excluded-and-quarantined page"
      )
      registration.checkJourneyUrl("other-country-excluded-and-quarantined?countryCode")
    }

    Scenario(
      "NETP Non-NI IOSS Number matches already active scheme"
    ) {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary enters an IOSS scheme for a non-NI country that is already active in another member state")
      registration.answerVatDetailsUkVrn()
      registration.checkJourneyUrl("confirm-tax-details")
      registration.continue()
      registration.checkJourneyUrl("have-trading-name")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("previous-country/1")
      registration.selectCountry("Sweden")
      registration.checkJourneyUrl("previous-scheme/1/1")
      registration.answerSchemeType("IOSS")
      registration.checkJourneyUrl("previous-scheme-intermediary/1/1")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("previous-ioss-number/1/1")
      registration.enterAnswer("IM7521122331")

      Then(
        "the intermediary is on the client-already-registered page"
      )
      registration.checkJourneyUrl("client-already-registered")
    }

    Scenario(
      "NETP Non-NI IOSS Number matches already active scheme - with exclusion that has reached effective date - can register"
    ) {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary enters an IOSS scheme for a non-NI country that is already active in another member state")
      registration.answerVatDetailsUkVrn()
      registration.checkJourneyUrl("confirm-tax-details")
      registration.continue()
      registration.checkJourneyUrl("have-trading-name")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("previous-country/1")
      registration.selectCountry("Sweden")
      registration.checkJourneyUrl("previous-scheme/1/1")
      registration.answerSchemeType("IOSS")
      registration.checkJourneyUrl("previous-scheme-intermediary/1/1")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("previous-ioss-number/1/1")
      registration.enterAnswer("IM7521122341")

      Then(
        "the intermediary is on the previous-scheme-answers/1 page"
      )
      registration.checkJourneyUrl("previous-scheme-answers/1")
    }

    Scenario(
      "NETP Non-NI IOSS Number matches already active scheme - with exclusion details that contain a reversal therefore are still registered - can not register"
    ) {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary enters an IOSS scheme for a non-NI country that is already active in another member state")
      registration.answerVatDetailsUkVrn()
      registration.checkJourneyUrl("confirm-tax-details")
      registration.continue()
      registration.checkJourneyUrl("have-trading-name")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("previous-country/1")
      registration.selectCountry("Sweden")
      registration.checkJourneyUrl("previous-scheme/1/1")
      registration.answerSchemeType("IOSS")
      registration.checkJourneyUrl("previous-scheme-intermediary/1/1")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("previous-ioss-number/1/1")
      registration.enterAnswer("IM7521122343")

      Then(
        "the intermediary is on the client-already-registered page"
      )
      registration.checkJourneyUrl("client-already-registered")
    }

    Scenario(
      "NETP Non-NI IOSS Number matches already active scheme - with exclusion has not reached exclusion effective date - can not register"
    ) {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary enters an IOSS scheme for a non-NI country that is already active in another member state")
      registration.answerVatDetailsUkVrn()
      registration.checkJourneyUrl("confirm-tax-details")
      registration.continue()
      registration.checkJourneyUrl("have-trading-name")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("previous-country/1")
      registration.selectCountry("Sweden")
      registration.checkJourneyUrl("previous-scheme/1/1")
      registration.answerSchemeType("IOSS")
      registration.checkJourneyUrl("previous-scheme-intermediary/1/1")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("previous-ioss-number/1/1")
      registration.enterAnswer("IM7521122342")

      Then(
        "the intermediary is on the client-already-registered page"
      )
      registration.checkJourneyUrl("client-already-registered")
    }

    Scenario(
      "NETP Non-NI IOSS Number matches quarantined scheme"
    ) {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary enters an IOSS scheme for a non-NI country that is quarantined in another member state")
      registration.answerVatDetailsUkVrn()
      registration.checkJourneyUrl("confirm-tax-details")
      registration.continue()
      registration.checkJourneyUrl("have-trading-name")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("previous-country/1")
      registration.selectCountry("Sweden")
      registration.checkJourneyUrl("previous-scheme/1/1")
      registration.answerSchemeType("IOSS")
      registration.checkJourneyUrl("previous-scheme-intermediary/1/1")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("previous-ioss-number/1/1")
      registration.enterAnswer("IM7521122332")

      Then(
        "the intermediary is on the other-country-excluded-and-quarantined page"
      )
      registration.checkJourneyUrl("other-country-excluded-and-quarantined?countryCode")
    }
  }
}
