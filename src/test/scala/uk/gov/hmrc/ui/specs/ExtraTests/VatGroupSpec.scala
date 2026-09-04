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

import uk.gov.hmrc.ui.pages.{AmendRegistration, Auth, Registration}
import uk.gov.hmrc.ui.specs.BaseSpec

class VatGroupSpec extends BaseSpec {

  lazy val registration      = Registration
  lazy val auth              = Auth
  lazy val amendRegistration = AmendRegistration

  Feature("Vat Group Journeys") {

    Scenario("Registration journey for NETP who is a VAT group - no previous registrations") {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      And("the intermediary answers all of the vat details questions as a UK Based NETP with VRN that is a VAT group")
      registration.answerVatDetailsVatGroup()
      registration.checkJourneyUrl("confirm-tax-details")
      registration.continue()

      And("the intermediary selects no on the have-trading-name page")
      registration.checkJourneyUrl("have-trading-name")
      registration.answerRadioButton("no")

      And("the intermediary selects no on the previous-oss page")
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("no")

      Then("the intermediary leaves the client website address blank")
      registration.checkJourneyUrl("website-address/1")
      registration.continue()

      Then("the intermediary enters credentials on contact-details page")
      registration.checkJourneyUrl("business-contact-details")
      registration.fillContactDetails("Firstname Surname", "+44123456789", "iossint@iossint.hmrc.gov.uk")

      And("the fixed establishment section is not shown on the check-your-answers page")
      registration.checkJourneyUrl("check-your-answers")
      registration.noFixedEstablishments()

      And("the intermediary continues through the check-your-answers page")
      registration.noWebsitesAdded()
      registration.continue()

      When("the intermediary accepts the declaration")
      registration.checkJourneyUrl("declaration")
      registration.selectCheckbox()

      Then("the intermediary is on the client-application-complete page")
      registration.checkJourneyUrl("client-application-complete")

      And("the NETP can complete the declaration and submit the registration")
      registration.submitDeclarationAndRegistrationNETP()
    }

    Scenario("Registration journey for NETP who is a VAT group - has previous registrations") {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")
      registration.checkJourneyUrl("client-uk-based")

      And("the intermediary answers all of the vat details questions as a UK Based NETP with VRN that is a VAT group")
      registration.answerVatDetailsVatGroup()
      registration.checkJourneyUrl("confirm-tax-details")
      registration.continue()

      And("the intermediary selects no on the have-trading-name page")
      registration.checkJourneyUrl("have-trading-name")
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

      When("the intermediary selects no on the previous-scheme-answers/1 page")
      registration.checkJourneyUrl("previous-scheme-answers/1")
      registration.answerRadioButton("no")

      And("the intermediary selects no on the previous-schemes-overview page")
      registration.checkJourneyUrl("previous-schemes-overview")
      registration.answerRadioButton("no")

      Then("the intermediary leaves the client website address blank")
      registration.checkJourneyUrl("website-address/1")
      registration.continue()

      Then("the intermediary enters credentials on contact-details page")
      registration.checkJourneyUrl("business-contact-details")
      registration.fillContactDetails("Firstname Surname", "+44123456789", "iossint@iossint.hmrc.gov.uk")

      And("the fixed establishment section is not shown on the check-your-answers page")
      registration.checkJourneyUrl("check-your-answers")
      registration.noFixedEstablishments()

      And("the intermediary continues through the check-your-answers page")
      registration.noWebsitesAdded()
      registration.continue()

      When("the intermediary accepts the declaration")
      registration.checkJourneyUrl("declaration")
      registration.selectCheckbox()

      Then("the intermediary is on the client-application-complete page")
      registration.checkJourneyUrl("client-application-complete")

      And("the NETP can complete the declaration and submit the registration")
      registration.submitDeclarationAndRegistrationNETP()
    }

    Scenario(
      "Amend registration where the NETP had fixed establishments in their registration but is now a VAT group"
    ) {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "amendVatGroupYes")

//      Intercept page to be added in a later ticket
      And("the intermediary is on the change-your-registration page")
      registration.checkJourneyUrl("change-your-registration")
      amendRegistration.checkIossNumber("IM9002111002")
      registration.noAmendments()
      registration.noFixedEstablishments()

      When("the intermediary removes a trading name")
      registration.selectChangeOrRemoveLink(
        "add-trading-name\\?waypoints\\=change-your-registration"
      )
      registration.checkJourneyUrl("add-trading-name?waypoints=change-your-registration")
      registration.selectChangeOrRemoveLink(
        "remove-trading-name\\/1\\?waypoints\\=change-your-registration"
      )
      registration.checkJourneyUrl("remove-trading-name/1?waypoints=change-your-registration")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("add-trading-name?waypoints=change-your-registration")
      registration.answerRadioButton("no")

      And("the intermediary is on the change-your-registration page")
      registration.checkJourneyUrl("change-your-registration")
      amendRegistration.checkIossNumber("IM9002111002")

      When("the intermediary submits the amended registration")
      registration.clickSubmit()

      Then("the successful-amend page is displayed")
      registration.checkJourneyUrl("successful-amend")
    }

    Scenario(
      "NETP submits their declaration where they previously were a VAT Group when the Intermediary registered however they are no longer a VAT group"
    ) {

      Given("the NETP logs into the service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(false, false, "vatGroupYesToNoPending")

      When("the NETP enters their activation code and submits the declaration")
      registration.checkJourneyUrl("client-code-entry")
      registration.completeActivationCodePendingClient("LFTRLQ")
      registration.checkJourneyUrl("declaration-client")
      registration.selectNETPCheckbox()

      Then("the NETP is on the successful-registration page")
      registration.checkJourneyUrl("successful-registration")
    }

    Scenario(
      "NETP submits their declaration where they previously were not a VAT Group and had fixed establishments when the Intermediary registered however they are now are a VAT group"
    ) {

      Given("the NETP logs into the service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(false, false, "vatGroupNoToYesPending")

      When("the NETP enters their activation code and submits the declaration")
      registration.checkJourneyUrl("client-code-entry")
      registration.completeActivationCodePendingClient("HVHDXC")
      registration.checkJourneyUrl("declaration-client")
      registration.selectNETPCheckbox()

      Then("the NETP is on the successful-registration page")
      registration.checkJourneyUrl("successful-registration")
    }
  }
}
