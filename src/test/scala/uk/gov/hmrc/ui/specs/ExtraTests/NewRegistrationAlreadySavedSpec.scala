/*
 * Copyright 2026 HM Revenue & Customs
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

class NewRegistrationAlreadySavedSpec extends BaseSpec {

  lazy val registration = Registration
  lazy val auth         = Auth

  Feature("Saved registration already exists for tax reference entered in a new registration") {

    Scenario("UK based client with UK VRN - already saved - continue registration") {

      Given("the intermediary logs in to the NETP registration service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "multipleSavedNewRegistration")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary enters a UK VRN that already exists in a saved registration")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("client-has-vat-number")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("client-vat-number")
      registration.enterAnswer("112233445")

      Then("the intermediary is directed to the client-registration-already-pending page")
      registration.checkJourneyUrl("client-registration-already-pending")

      And("the intermediary selects yes to continue the saved registration")
      registration.clickLink("continueProgress")
      registration.continue()

      And("the intermediary is redirected to the correct page of their saved registration")
      registration.checkJourneyUrl("previous-country/1")
    }

    Scenario("UK based client with UK VRN - already saved - delete registration") {

      Given("the intermediary logs in to the NETP registration service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "multipleSavedNewRegistration")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary enters a UK VRN that already exists in a saved registration")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("client-has-vat-number")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("client-vat-number")
      registration.enterAnswer("112233445")

      Then("the intermediary is directed to the client-registration-already-pending page")
      registration.checkJourneyUrl("client-registration-already-pending")

      And("the intermediary selects no to delete the saved registration and start again")
      registration.clickLink("deleteProgress")
      registration.continue()

      And("the intermediary is redirected to the confirm-tax-details page")
      registration.checkJourneyUrl("confirm-tax-details")

      When("the intermediary clicks continue")
      registration.continue()

      Then("the intermediary is on the have-trading-name page")
      registration.checkJourneyUrl("have-trading-name")
    }

    Scenario("UK based client with UTR - already saved - continue registration") {

      Given("the intermediary logs in to the NETP registration service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "multipleSavedNewRegistration")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary enters a UTR that already exists in a saved registration")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("client-has-vat-number")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("client-business-name")
      registration.enterAnswer("Business-name with nino")
      registration.checkJourneyUrl("client-has-utr")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("client-utr-number")
      registration.enterAnswer("1122331122333")

      Then("the intermediary is directed to the client-registration-already-pending page")
      registration.checkJourneyUrl("client-registration-already-pending")

      And("the intermediary selects yes to continue the saved registration")
      registration.clickLink("continueProgress")
      registration.continue()

      And("the intermediary is redirected to the correct page of their saved registration")
      registration.checkJourneyUrl("trading-name-business-address/2")
    }

    Scenario("UK based client with UTR - already saved - delete registration") {

      Given("the intermediary logs in to the NETP registration service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "multipleSavedNewRegistration")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary enters a UTR that already exists in a saved registration")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("client-has-vat-number")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("client-business-name")
      registration.enterAnswer("Business-name with nino")
      registration.checkJourneyUrl("client-has-utr")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("client-utr-number")
      registration.enterAnswer("1122331122333")

      Then("the intermediary is directed to the client-registration-already-pending page")
      registration.checkJourneyUrl("client-registration-already-pending")

      And("the intermediary selects no to delete the saved registration and start again")
      registration.clickLink("deleteProgress")
      registration.continue()

      And("the intermediary is redirected to the client-address page")
      registration.checkJourneyUrl("client-address")

      And("the intermediary enters the remaining tax details")
      registration.checkJourneyUrl("client-address")
      registration.enterAddress("1 Street Name", "", "City", "", "")
      registration.checkJourneyUrl("confirm-tax-details")
      registration.continue()

      Then("the intermediary is on the have-trading-name page")
      registration.checkJourneyUrl("have-trading-name")
    }

    Scenario("UK based client with NINO - already saved - continue registration") {

      Given("the intermediary logs in to the NETP registration service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "multipleSavedNewRegistration")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary enters a NINO that already exists in a saved registration")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("client-has-vat-number")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("client-business-name")
      registration.enterAnswer("Business-name with nino")
      registration.checkJourneyUrl("client-has-utr")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("clients-nino-number")
      registration.enterAnswer("AA121212A")

      Then("the intermediary is directed to the client-registration-already-pending page")
      registration.checkJourneyUrl("client-registration-already-pending")

      And("the intermediary selects yes to continue the saved registration")
      registration.clickLink("continueProgress")
      registration.continue()

      And("the intermediary is redirected to the correct page of their saved registration")
      registration.checkJourneyUrl("eu-fixed-establishment")
    }

    Scenario("UK based client with NINO - already saved - delete registration") {

      Given("the intermediary logs in to the NETP registration service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "multipleSavedNewRegistration")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary enters a NINO that already exists in a saved registration")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("client-has-vat-number")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("client-business-name")
      registration.enterAnswer("Business-name with nino")
      registration.checkJourneyUrl("client-has-utr")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("clients-nino-number")
      registration.enterAnswer("AA121212A")

      Then("the intermediary is directed to the client-registration-already-pending page")
      registration.checkJourneyUrl("client-registration-already-pending")

      And("the intermediary selects no to delete the saved registration and start again")
      registration.clickLink("deleteProgress")
      registration.continue()

      And("the intermediary is redirected to the client-address page")
      registration.checkJourneyUrl("client-address")

      And("the intermediary enters the remaining tax details")
      registration.checkJourneyUrl("client-address")
      registration.enterAddress("1 Street Name", "", "City", "", "")
      registration.checkJourneyUrl("confirm-tax-details")
      registration.continue()

      Then("the intermediary is on the have-trading-name page")
      registration.checkJourneyUrl("have-trading-name")
    }

    Scenario("Non-UK based client with UK VRN - already saved - continue registration") {

      Given("the intermediary logs in to the NETP registration service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "multipleSavedNewRegistration")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary enters a UK VRN that already exists in a saved registration")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("client-has-vat-number")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("client-vat-number")
      registration.enterAnswer("544332211")

      Then("the intermediary is directed to the client-registration-already-pending page")
      registration.checkJourneyUrl("client-registration-already-pending")

      And("the intermediary selects yes to continue the saved registration")
      registration.clickLink("continueProgress")
      registration.continue()

      And("the intermediary is redirected to the correct page of their saved registration")
      registration.checkJourneyUrl("add-website-address")
    }

    Scenario("Non-UK based client with UK VRN - already saved - delete registration") {

      Given("the intermediary logs in to the NETP registration service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "multipleSavedNewRegistration")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary enters a UK VRN that already exists in a saved registration")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("client-has-vat-number")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("client-vat-number")
      registration.enterAnswer("544332211")

      Then("the intermediary is directed to the client-registration-already-pending page")
      registration.checkJourneyUrl("client-registration-already-pending")

      And("the intermediary selects no to delete the saved registration and start again")
      registration.clickLink("deleteProgress")
      registration.continue()

      And("the intermediary is redirected to continue entering tax details")
      registration.checkJourneyUrl("client-country-based")
      registration.selectCountry("Jamaica")
      registration.checkJourneyUrl("client-business-name")
      registration.enterAnswer("Jamaican Company")
      registration.checkJourneyUrl("client-address")
      registration.enterAddress("1 Street Name", "", "City-Name", "", "12345")
      registration.checkJourneyUrl("confirm-tax-details")
      registration.continue()

      Then("the intermediary is on the have-trading-name page")
      registration.checkJourneyUrl("have-trading-name")
    }

    Scenario("Non-UK based client with FTR - already saved - continue registration") {

      Given("the intermediary logs in to the NETP registration service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "multipleSavedNewRegistration")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary enters a UK VRN that already exists in a saved registration")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("client-has-vat-number")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("client-country-based")
      registration.selectCountry("Luxembourg")
      registration.checkJourneyUrl("client-tax-reference")
      registration.enterAnswer("123MCDONALD456")

      Then("the intermediary is directed to the client-registration-already-pending page")
      registration.checkJourneyUrl("client-registration-already-pending")

      And("the intermediary selects yes to continue the saved registration")
      registration.clickLink("continueProgress")
      registration.continue()

      And("the intermediary is redirected to the correct page of their saved registration")
      registration.checkJourneyUrl("declaration")
    }

    Scenario("Non-UK based client with FTR - already saved - delete registration") {

      Given("the intermediary logs in to the NETP registration service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "multipleSavedNewRegistration")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary enters a UK VRN that already exists in a saved registration")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("client-has-vat-number")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("client-country-based")
      registration.selectCountry("Luxembourg")
      registration.checkJourneyUrl("client-tax-reference")
      registration.enterAnswer("123MCDONALD456")

      Then("the intermediary is directed to the client-registration-already-pending page")
      registration.checkJourneyUrl("client-registration-already-pending")

      And("the intermediary selects no to delete the saved registration and start again")
      registration.clickLink("deleteProgress")
      registration.continue()

      And("the intermediary is redirected to continue entering tax details")
      registration.checkJourneyUrl("client-business-name")
      registration.enterAnswer("Luxembourg Company")
      registration.checkJourneyUrl("client-address")
      registration.enterAddress("1 Street Name", "Suburb", "City Name", "", "")
      registration.checkJourneyUrl("confirm-tax-details")
      registration.continue()

      Then("the intermediary is on the have-trading-name page")
      registration.checkJourneyUrl("have-trading-name")
    }
  }
}
