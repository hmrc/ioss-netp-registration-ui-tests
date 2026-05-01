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

class NewRegistrationAlreadyPendingSpec extends BaseSpec {

  lazy val registration = Registration
  lazy val auth         = Auth

  Feature("Pending registration already exists for tax reference entered in a new registration") {

    Scenario("UK based client with UK VRN - already pending") {

      Given("the intermediary logs in to the NETP registration service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "newRegistrationsAlreadyPending")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary enters a UK VRN that already exists in a pending registration")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("client-has-vat-number")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("client-vat-number")
      registration.enterAnswer("GB123456777")

      Then("the intermediary is directed to the client-registration-pending-with-our-service page")
      registration.checkJourneyUrl("client-registration-pending-with-our-service/d3c3bdc6-31d5-454f-a26c-46fda84ecd89")

      When("the intermediary clicks the 'View pending registration' link")
      registration.selectCssLink("client-not-activated\\/d3c3bdc6-31d5-454f-a26c-46fda84ecd89")

      Then("the intermediary is on the client-not-activated/d3c3bdc6-31d5-454f-a26c-46fda84ecd89 page")
      registration.checkJourneyUrl("client-not-activated/d3c3bdc6-31d5-454f-a26c-46fda84ecd89")
      registration.checkAlreadyPending("ukVrn")

      When("the user clicks on the Return to your account link")
      registration.clickLink("return-to-your-account")

      Then("the user is on the intermediary dashboard")
      registration.checkDashboardJourneyUrl("your-account")
    }

    Scenario("UK based client with UTR - already pending") {

      Given("the intermediary logs in to the NETP registration service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "newRegistrationsAlreadyPending")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary enters a UTR that already exists in a pending registration")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("client-has-vat-number")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("client-business-name")
      registration.enterAnswer("Business-name with utr")
      registration.checkJourneyUrl("client-has-utr")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("client-utr-number")
      registration.enterAnswer("1234567888")

      Then("the intermediary is directed to the client-registration-pending-with-our-service page")
      registration.checkJourneyUrl("client-registration-pending-with-our-service/ddddccbd-0897-4967-a1ca-d0e297420f71")

      When("the intermediary clicks the 'View pending registration' link")
      registration.selectCssLink("client-not-activated\\/ddddccbd-0897-4967-a1ca-d0e297420f71")

      Then("the intermediary is on the client-not-activated/ddddccbd-0897-4967-a1ca-d0e297420f71 page")
      registration.checkJourneyUrl("client-not-activated/ddddccbd-0897-4967-a1ca-d0e297420f71")
      registration.checkAlreadyPending("ukUtr")

      When("the user clicks on the Return to your account link")
      registration.clickLink("return-to-your-account")

      Then("the user is on the intermediary dashboard")
      registration.checkDashboardJourneyUrl("your-account")
    }

    Scenario("UK based client with NINO - already pending") {

      Given("the intermediary logs in to the NETP registration service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "newRegistrationsAlreadyPending")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary enters a NINO that already exists in a pending registration")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("client-has-vat-number")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("client-business-name")
      registration.enterAnswer("Business-name with nino")
      registration.checkJourneyUrl("client-has-utr")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("clients-nino-number")
      registration.enterAnswer("QQ123444C")

      Then("the intermediary is directed to the client-registration-pending-with-our-service page")
      registration.checkJourneyUrl("client-registration-pending-with-our-service/f23cab87-db12-4dc8-9c1f-9f59a8b44598")

      When("the intermediary clicks the 'View pending registration' link")
      registration.selectCssLink("client-not-activated\\/f23cab87-db12-4dc8-9c1f-9f59a8b44598")

      Then("the intermediary is on the client-not-activated/f23cab87-db12-4dc8-9c1f-9f59a8b44598 page")
      registration.checkJourneyUrl("client-not-activated/f23cab87-db12-4dc8-9c1f-9f59a8b44598")
      registration.checkAlreadyPending("ukNino")

      When("the user clicks on the Return to your account link")
      registration.clickLink("return-to-your-account")

      Then("the user is on the intermediary dashboard")
      registration.checkDashboardJourneyUrl("your-account")
    }

    Scenario("Non-UK based client with UK VRN - already pending") {

      Given("the intermediary logs in to the NETP registration service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "newRegistrationsAlreadyPending")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary enters a UK VRN that already exists in a pending registration")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("client-has-vat-number")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("client-vat-number")
      registration.enterAnswer("123456888")

      Then("the intermediary is directed to the client-registration-pending-with-our-service page")
      registration.checkJourneyUrl("client-registration-pending-with-our-service/71e668f3-10c8-425d-a044-c8fd64dd0c9e")

      When("the intermediary clicks the 'View pending registration' link")
      registration.selectCssLink("client-not-activated\\/71e668f3-10c8-425d-a044-c8fd64dd0c9e")

      Then("the intermediary is on the client-not-activated/71e668f3-10c8-425d-a044-c8fd64dd0c9e page")
      registration.checkJourneyUrl("client-not-activated/71e668f3-10c8-425d-a044-c8fd64dd0c9e")
      registration.checkAlreadyPending("nonUkVrn")

      When("the user clicks on the Return to your account link")
      registration.clickLink("return-to-your-account")

      Then("the user is on the intermediary dashboard")
      registration.checkDashboardJourneyUrl("your-account")
    }

    Scenario("Non-UK based client with FTR - already pending") {

      Given("the intermediary logs in to the NETP registration service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "newRegistrationsAlreadyPending")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary enters a UK VRN that already exists in a pending registration")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("client-has-vat-number")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("client-country-based")
      registration.selectCountry("Luxembourg")
      registration.checkJourneyUrl("client-tax-reference")
      registration.enterAnswer("654654654")

      Then("the intermediary is directed to the client-registration-pending-with-our-service page")
      registration.checkJourneyUrl("client-registration-pending-with-our-service/52745e4d-f10d-40dd-8b93-926e7a77733c")

      When("the intermediary clicks the 'View pending registration' link")
      registration.selectCssLink("client-not-activated\\/52745e4d-f10d-40dd-8b93-926e7a77733c")

      Then("the intermediary is on the client-not-activated/52745e4d-f10d-40dd-8b93-926e7a77733c page")
      registration.checkJourneyUrl("client-not-activated/52745e4d-f10d-40dd-8b93-926e7a77733c")
      registration.checkAlreadyPending("nonUkFtr")

      When("the user clicks on the Return to your account link")
      registration.clickLink("return-to-your-account")

      Then("the user is on the intermediary dashboard")
      registration.checkDashboardJourneyUrl("your-account")
    }

    Scenario("UK based client with UK VRN - already pending with another intermediary") {

      Given("the intermediary logs in to the NETP registration service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "multipleSavedNewRegistration")
      registration.checkJourneyUrl("client-uk-based")

      When("the intermediary enters a UK VRN that already exists in a pending registration")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("client-has-vat-number")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("client-vat-number")
      registration.enterAnswer("123456777")

      Then("the intermediary is directed to the client-registration-pending-with-another-intermediary page")
      registration.checkJourneyUrl("client-registration-pending-with-another-intermediary")

      When("the user clicks on the Return to your account link")
      registration.clickLink("return-to-your-account")

      Then("the user is on the intermediary dashboard")
      registration.checkDashboardJourneyUrl("your-account")
    }
  }
}
