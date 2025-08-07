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

class CheckYourAnswersSpec extends BaseSpec {

  lazy val registration = Registration
  lazy val auth         = Auth

  Feature("Changing answers via the check-your-answers page") {

    Scenario("Intermediary removes all trading names via remove-all-trading-names page") {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      And("the intermediary adds answers all the way through to the check-your-answers page")
      registration.answerVatDetailsUkVrn()
      registration.checkJourneyUrl("confirm-vat-details")
      registration.continue()
      registration.checkJourneyUrl("have-uk-trading-name")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("uk-trading-name/1")
      registration.enterAnswer("1st trading-name")
      registration.checkJourneyUrl("add-uk-trading-name")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("uk-trading-name/2")
      registration.enterAnswer("Another Trading Name!")
      registration.checkJourneyUrl("add-uk-trading-name")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("eu-fixed-establishment")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("website-address/1")
      registration.enterAnswer("www.1st-website.co.uk")
      registration.checkJourneyUrl("add-website-address")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("business-contact-details")
      registration.fillContactDetails("Firstname Surname", "+44123456789", "test-email@test.co.uk")

      When("the intermediary selects change for Have a different UK trading name on the check-your-answers page")
      registration.checkJourneyUrl("check-your-answers")
      registration.selectChangeOrRemoveLink("have-uk-trading-name\\?waypoints\\=check-your-answers")

      And("the intermediary changes the answer to no on the have-uk-trading-name page")
      registration.checkJourneyUrl("have-uk-trading-name?waypoints=check-your-answers")
      registration.answerRadioButton("no")

      Then("the intermediary selects yes on the remove-all-trading-names page")
      registration.checkJourneyUrl("remove-all-trading-names?waypoints=check-your-answers")
      registration.answerRadioButton("yes")

      And("the intermediary submits their registration successfully")
      registration.checkJourneyUrl("check-your-answers")
      registration.continue()
      registration.checkJourneyUrl("declaration")
      registration.selectCheckbox()
      registration.checkJourneyUrl("client-application-complete")

      And("the NETP can complete the declaration and submit the registration")
      registration.submitDeclarationAndRegistrationNETP()
    }

    Scenario(
      "Intermediary removes all previous registrations via remove-all-previous-intermediary-registrations page"
    ) {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      And("the intermediary adds answers all the way through to the check-your-answers page")
      registration.answerVatDetailsUkVrn()
      registration.checkJourneyUrl("confirm-vat-details")
      registration.continue()
      registration.checkJourneyUrl("have-uk-trading-name")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("yes")
      registration.enterTwoPreviousRegistrations()
      registration.checkJourneyUrl("eu-fixed-establishment")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("website-address/1")
      registration.enterAnswer("www.1st-website.co.uk")
      registration.checkJourneyUrl("add-website-address")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("business-contact-details")
      registration.fillContactDetails("Firstname Surname", "+44123456789", "test-email@test.co.uk")

      When(
        "the intermediary selects change for Previously registered for an IOSS scheme on the check-your-answers page"
      )
      registration.checkJourneyUrl("check-your-answers")
      registration.selectChangeOrRemoveLink("previous-oss\\?waypoints\\=check-your-answers")

      And("the intermediary changes the answer to no on the previous-oss page")
      registration.checkJourneyUrl("previous-oss?waypoints=check-your-answers")
      registration.answerRadioButton("no")

      Then("the intermediary selects yes on the remove-all-previous-registrations page")
      registration.checkJourneyUrl("remove-all-previous-registrations?waypoints=check-your-answers")
      registration.answerRadioButton("yes")

      And("the intermediary submits their registration successfully")
      registration.checkJourneyUrl("check-your-answers")
      registration.continue()
      registration.checkJourneyUrl("declaration")
      registration.selectCheckbox()
      registration.checkJourneyUrl("client-application-complete")

      And("the NETP can complete the declaration and submit the registration")
      registration.submitDeclarationAndRegistrationNETP()
    }

    Scenario("Intermediary removes all tax details via remove-all-tax-details page") {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      And("the intermediary adds answers all the way through to the check-your-answers page")
      registration.answerVatDetailsUkVrn()
      registration.checkJourneyUrl("confirm-vat-details")
      registration.continue()
      registration.checkJourneyUrl("have-uk-trading-name")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("eu-fixed-establishment")
      registration.answerRadioButton("yes")
      registration.enterTwoEuDetails()
      registration.checkJourneyUrl("website-address/1")
      registration.enterAnswer("www.1st-website.co.uk")
      registration.checkJourneyUrl("add-website-address")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("business-contact-details")
      registration.fillContactDetails("Firstname Surname", "+44123456789", "test-email@test.co.uk")

      When(
        "the intermediary selects change for Have a fixed establishment in an EU country on the check-your-answers page"
      )
      registration.checkJourneyUrl("check-your-answers")
      registration.selectChangeOrRemoveLink("eu-fixed-establishment\\?waypoints\\=check-your-answers")

      And("the intermediary changes the answer to no on the eu-fixed-establishment page")
      registration.checkJourneyUrl("eu-fixed-establishment?waypoints=check-your-answers")
      registration.answerRadioButton("no")

      Then("the intermediary selects yes on the remove-all-tax-details page")
      registration.checkJourneyUrl("remove-all-tax-details?waypoints=check-your-answers")
      registration.answerRadioButton("yes")

      And("the intermediary submits their registration successfully")
      registration.checkJourneyUrl("check-your-answers")
      registration.continue()
      registration.checkJourneyUrl("declaration")
      registration.selectCheckbox()
      registration.checkJourneyUrl("client-application-complete")

      And("the NETP can complete the declaration and submit the registration")
      registration.submitDeclarationAndRegistrationNETP()
    }

    Scenario("Intermediary adds details to all non-compulsory sections via check-your-answers") {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      And("the intermediary adds answers all the way through to the check-your-answers page")
      registration.answerVatDetailsUkVrn()
      registration.checkJourneyUrl("confirm-vat-details")
      registration.continue()
      registration.completeRegistrationCompulsoryAnswersOnly()

      Then("the intermediary adds a trading name to their registration")
      registration.checkJourneyUrl("check-your-answers")
      registration.selectChangeOrRemoveLink("have-uk-trading-name\\?waypoints\\=check-your-answers")
      registration.checkJourneyUrl("have-uk-trading-name?waypoints=check-your-answers")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("uk-trading-name/1")
      registration.enterAnswer("1st trading-name")
      registration.checkJourneyUrl("add-uk-trading-name")
      registration.answerRadioButton("no")

      Then("the intermediary adds a previous registration to their registration")
      registration.checkJourneyUrl("check-your-answers")
      registration.selectChangeOrRemoveLink("previous-oss\\?waypoints\\=check-your-answers")
      registration.checkJourneyUrl("previous-oss?waypoints=check-your-answers")
      registration.answerRadioButton("yes")
      registration.enterOnePreviousRegistration()

      Then("the intermediary adds EU tax details to their registration")
      registration.checkJourneyUrl("check-your-answers")
      registration.selectChangeOrRemoveLink("eu-fixed-establishment\\?waypoints\\=check-your-answers")
      registration.checkJourneyUrl("eu-fixed-establishment?waypoints=check-your-answers")
      registration.answerRadioButton("yes")
      registration.enterOneEuTaxDetails()

      And("the intermediary submits their registration successfully")
      registration.checkJourneyUrl("check-your-answers")
      registration.continue()
      registration.checkJourneyUrl("declaration")
      registration.selectCheckbox()
      registration.checkJourneyUrl("client-application-complete")

      And("the NETP can complete the declaration and submit the registration")
      registration.submitDeclarationAndRegistrationNETP()
    }

    Scenario(
      "Intermediary enters details throughout registration journey and changes them via check-your-answers"
    ) {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      And("the intermediary adds answers all the way through to the check-your-answers page")
      registration.answerVatDetailsUkVrn()
      registration.checkJourneyUrl("confirm-vat-details")
      registration.continue()
      registration.checkJourneyUrl("have-uk-trading-name")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("uk-trading-name/1")
      registration.enterAnswer("1st trading-name")
      registration.checkJourneyUrl("add-uk-trading-name")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("uk-trading-name/2")
      registration.enterAnswer("Another Trading Name!")
      registration.checkJourneyUrl("add-uk-trading-name")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("yes")
      registration.enterTwoPreviousRegistrations()
      registration.checkJourneyUrl("eu-fixed-establishment")
      registration.answerRadioButton("yes")
      registration.enterTwoEuDetails()
      registration.checkJourneyUrl("website-address/1")
      registration.enterAnswer("www.1st-website.co.uk")
      registration.checkJourneyUrl("add-website-address")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("business-contact-details")
      registration.fillContactDetails("Firstname Surname", "+44123456789", "test-email@test.co.uk")

      Then("the intermediary adds another trading name")
      registration.checkJourneyUrl("check-your-answers")
      registration.selectChangeOrRemoveLink("add-uk-trading-name\\?waypoints\\=check-your-answers")
      registration.checkJourneyUrl("add-uk-trading-name?waypoints=check-your-answers")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("uk-trading-name/3")
      registration.enterAnswer("another trading-name")
      registration.checkJourneyUrl("add-uk-trading-name?waypoints=check-your-answers")
      registration.answerRadioButton("no")

      Then("the intermediary adds another previous registration")
      registration.checkJourneyUrl("check-your-answers")
      registration.selectChangeOrRemoveLink(
        "previous-schemes-overview\\?waypoints\\=check-your-answers"
      )
      registration.checkJourneyUrl("previous-schemes-overview")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("previous-country/3")
      registration.selectCountry("Finland")
      registration.checkJourneyUrl("previous-scheme/3/1")
      registration.answerSchemeType("IOSS")
      registration.checkJourneyUrl("previous-scheme-intermediary/3/1")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("previous-ioss-number/3/1")
      registration.enterAnswer("IM2468787877")
      registration.checkJourneyUrl("previous-scheme-answers/3")
      registration.answerRadioButton("no")

      Then("the intermediary adds more tax details")
      registration.checkJourneyUrl("check-your-answers")
      registration.selectChangeOrRemoveLink(
        "add-tax-details\\?waypoints\\=check-your-answers"
      )
      registration.checkJourneyUrl("add-tax-details?waypoints=check-your-answers")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("vat-registered-eu-country/3")
      registration.selectCountry("Italy")
      registration.checkJourneyUrl("trading-name-business-address/3")
      registration.enterFETradingName("Roma Trading")
      registration.enterAddress("12 Piazza del Popolo", "", "Rome", "", "00187")
      registration.checkJourneyUrl("registration-tax-type/3")
      registration.answerRegistrationType("Tax ID number")
      registration.checkJourneyUrl("eu-tax-identification-number/3")
      registration.enterAnswer("ITA8888")
      registration.checkJourneyUrl("check-tax-details")
      registration.continue()
      registration.checkJourneyUrl("add-tax-details")
      registration.answerRadioButton("no")

      And("the intermediary submits their registration successfully")
      registration.checkJourneyUrl("check-your-answers")
      registration.continue()
      registration.checkJourneyUrl("declaration")
      registration.selectCheckbox()
      registration.checkJourneyUrl("client-application-complete")

      And("the NETP can complete the declaration and submit the registration")
      registration.submitDeclarationAndRegistrationNETP()
    }

    Scenario("Intermediary changes answers in compulsory sections via check-your-answers") {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      And("the intermediary adds answers all the way through to the check-your-answers page")
      registration.answerVatDetailsUkVrn()
      registration.checkJourneyUrl("confirm-vat-details")
      registration.continue()
      registration.completeRegistrationCompulsoryAnswersOnly()

      Then("the intermediary adds another website")
      registration.checkJourneyUrl("check-your-answers")
      registration.selectChangeOrRemoveLink("add-website-address\\?waypoints\\=check-your-answers")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("website-address/2")
      registration.enterAnswer("http://websiteno2.co.uk")
      registration.checkJourneyUrl("add-website-address")
      registration.answerRadioButton("no")

      Then("the intermediary changes some of their contact details")
      registration.checkJourneyUrl("check-your-answers")
      registration.selectChangeOrRemoveLink(
        "business-contact-details\\?waypoints\\=check-your-answers"
      )
      registration.checkJourneyUrl("business-contact-details?waypoints=check-your-answers")
      registration.updateField("emailAddress", "new-email@test.co.uk")
      registration.continue()

      And("the intermediary submits their registration successfully")
      registration.checkJourneyUrl("check-your-answers")
      registration.continue()
      registration.checkJourneyUrl("declaration")
      registration.selectCheckbox()
      registration.checkJourneyUrl("client-application-complete")

      And("the NETP can complete the declaration and submit the registration")
      registration.submitDeclarationAndRegistrationNETP()
    }
  }
}
