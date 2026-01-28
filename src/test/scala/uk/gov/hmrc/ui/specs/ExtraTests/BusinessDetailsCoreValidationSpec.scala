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

class BusinessDetailsCoreValidationSpec extends BaseSpec {

  lazy val registration = Registration
  lazy val auth         = Auth

  Feature("Core Validation scenarios within the Business Details section of the IOSS NETP Registration journey") {

    Scenario(
      "NETP UK VAT Number matches already active scheme"
    ) {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary enters a UK VRN that is already active in another member state")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("client-has-vat-number")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("client-vat-number")
      registration.enterAnswer("333333333")

      Then(
        "the intermediary is on the client-already-registered page"
      )
      registration.checkJourneyUrl("client-already-registered")
    }

    Scenario(
      "NETP UK VAT Number matches already active scheme with exclusion that has reached exclusion effective date - can register"
    ) {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary enters a UK VRN that is already active in another member state")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("client-has-vat-number")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("client-vat-number")
      registration.enterAnswer("333333337")

      Then(
        "the intermediary is on the confirm-tax-details page"
      )
      registration.checkJourneyUrl("confirm-tax-details")
    }

    Scenario(
      "NETP UK VAT Number matches already active scheme with exclusion details containing a reversal therefore still registered - can not register"
    ) {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary enters a UK VRN that is already active in another member state")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("client-has-vat-number")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("client-vat-number")
      registration.enterAnswer("333333339")

      Then(
        "the intermediary is on the client-already-registered page"
      )
      registration.checkJourneyUrl("client-already-registered")
    }

    Scenario(
      "NETP UK VAT Number matches already active scheme with exclusion that has not reached exclusion effective date - can not register"
    ) {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary enters a UK VRN that is already active in another member state")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("client-has-vat-number")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("client-vat-number")
      registration.enterAnswer("333333338")

      Then(
        "the intermediary is on the client-already-registered page"
      )
      registration.checkJourneyUrl("client-already-registered")
    }

    Scenario(
      "NETP UK VAT Number matches already quarantined scheme"
    ) {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary enters a UK VRN that is quarantined in another member state")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("client-has-vat-number")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("client-vat-number")
      registration.enterAnswer("333333334")

      Then(
        "the intermediary is on the other-country-excluded-and-quarantined page"
      )
      registration.checkJourneyUrl("other-country-excluded-and-quarantined?countryCode")
    }

    Scenario(
      "NETP NINO matches already active scheme"
    ) {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary enters a NINO that is already active in another member state")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("client-has-vat-number")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("client-business-name")
      registration.enterAnswer("Business-name with nino")
      registration.checkJourneyUrl("client-has-utr")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("clients-nino-number")
      registration.enterAnswer("AA112233A")

      Then(
        "the intermediary is on the client-already-registered page"
      )
      registration.checkJourneyUrl("client-already-registered")
    }

    Scenario(
      "NETP NINO matches already active scheme with exclusion that has reached exclusion effective date - can register"
    ) {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary enters a NINO that is already active in another member state")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("client-has-vat-number")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("client-business-name")
      registration.enterAnswer("Business-name with nino")
      registration.checkJourneyUrl("client-has-utr")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("clients-nino-number")
      registration.enterAnswer("AA112234D")

      Then(
        "the intermediary is on the client-address page"
      )
      registration.checkJourneyUrl("client-address")
    }

    Scenario(
      "NETP NINO matches quarantined scheme"
    ) {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary enters a NINO that is quarantined in another member state")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("client-has-vat-number")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("client-business-name")
      registration.enterAnswer("Business-name with nino")
      registration.checkJourneyUrl("client-has-utr")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("clients-nino-number")
      registration.enterAnswer("AA112233B")

      Then(
        "the intermediary is on the other-country-excluded-and-quarantined page"
      )
      registration.checkJourneyUrl("other-country-excluded-and-quarantined?countryCode")
    }

    Scenario(
      "NETP UTR matches already active scheme"
    ) {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary enters a UTR that is already active in another member state")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("client-has-vat-number")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("client-business-name")
      registration.enterAnswer("Business-name with nino")
      registration.checkJourneyUrl("client-has-utr")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("client-utr-number")
      registration.enterAnswer("1112223331")

      Then(
        "the intermediary is on the client-already-registered page"
      )
      registration.checkJourneyUrl("client-already-registered")
    }

    Scenario(
      "NETP UTR matches already active scheme - with exclusion that has reached exclusion effective date - can register"
    ) {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary enters a UTR that is already active in another member state")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("client-has-vat-number")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("client-business-name")
      registration.enterAnswer("Business-name with nino")
      registration.checkJourneyUrl("client-has-utr")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("client-utr-number")
      registration.enterAnswer("1112223336")

      Then(
        "the intermediary is on the client-address page"
      )
      registration.checkJourneyUrl("client-address")
    }

    Scenario(
      "NETP UTR matches quarantined scheme"
    ) {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary enters a UTR that is quarantined in another member state")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("client-has-vat-number")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("client-business-name")
      registration.enterAnswer("Business-name with nino")
      registration.checkJourneyUrl("client-has-utr")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("client-utr-number")
      registration.enterAnswer("1112223332")

      Then(
        "the intermediary is on the other-country-excluded-and-quarantined page"
      )
      registration.checkJourneyUrl("other-country-excluded-and-quarantined?countryCode")
    }

    Scenario(
      "NETP FTR matches already active scheme"
    ) {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary enters an FTR that is already active in another member state")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("client-has-vat-number")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("client-country-based")
      registration.selectCountry("Luxembourg")
      registration.checkJourneyUrl("client-tax-reference")
      registration.enterAnswer("AB1122331")

      Then(
        "the intermediary is on the client-already-registered page"
      )
      registration.checkJourneyUrl("client-already-registered")
    }

    Scenario(
      "NETP FTR matches already active scheme - with exclusion that has reached exclusion effective date - can register"
    ) {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary enters an FTR that is already active in another member state")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("client-has-vat-number")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("client-country-based")
      registration.selectCountry("Luxembourg")
      registration.checkJourneyUrl("client-tax-reference")
      registration.enterAnswer("AB1122336")

      Then(
        "the intermediary is on the client-business-name page"
      )
      registration.checkJourneyUrl("client-business-name")
    }

    Scenario(
      "NETP FTR matches quarantined scheme"
    ) {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary enters an FTR that is quarantined in another member state")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("client-has-vat-number")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("client-country-based")
      registration.selectCountry("Luxembourg")
      registration.checkJourneyUrl("client-tax-reference")
      registration.enterAnswer("AB1122332")

      Then(
        "the intermediary is on the other-country-excluded-and-quarantined page"
      )
      registration.checkJourneyUrl("other-country-excluded-and-quarantined?countryCode")
    }
  }
}
