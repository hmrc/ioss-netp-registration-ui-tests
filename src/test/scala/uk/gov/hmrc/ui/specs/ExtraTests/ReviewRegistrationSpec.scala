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

import uk.gov.hmrc.ui.pages.{AmendRegistration, Auth, IOSSReturn, Registration}
import uk.gov.hmrc.ui.specs.BaseSpec

class ReviewRegistrationSpec extends BaseSpec {

  lazy val registration      = Registration
  lazy val auth              = Auth
  lazy val amendRegistration = AmendRegistration
  lazy val iossReturn        = IOSSReturn

  Feature("Change date over two years journeys") {

    Scenario("Client's registration has not been updated for two years - no amendments") {

      Given("the intermediary starts a return for their client")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "returnChangeDate")
      iossReturn.checkReturnsJourneyUrl("IM9002221223/2025-M3/start-return")
      registration.answerRadioButton("yes")

      When("the intermediary is on the review-registration page")
      iossReturn.checkReturnsJourneyUrl("IM9002221223/review-registration")

      And("the intermediary clicks on the Review their registration details link")
      registration.selectCssLink("start-amend-journey\\/IM9002221223")

      Then("the intermediary is redirected to review the client's registration")
      registration.checkJourneyUrl("change-your-registration")
      registration.checkAmendHeading("review")

      And("the intermediary submits the registration without amending any details")
      registration.clickSubmit()
      registration.checkJourneyUrl("successful-amend")

      And("the amend confirmation page shows no amended details")
      amendRegistration.checkAmendedAnswers("noAmendedAnswers")
    }

    Scenario("Client's registration has not been updated for two years - with amendments") {

      Given("the intermediary starts a return for their client")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "returnChangeDate")
      iossReturn.checkReturnsJourneyUrl("IM9002221223/2025-M3/start-return")
      registration.answerRadioButton("yes")

      When("the intermediary is on the review-registration page")
      iossReturn.checkReturnsJourneyUrl("IM9002221223/review-registration")

      And("the intermediary clicks on the Review their registration details link")
      registration.selectCssLink("start-amend-journey\\/IM9002221223")

      Then("the intermediary is redirected to review the client's registration")
      registration.checkJourneyUrl("change-your-registration")
      registration.checkAmendHeading("review")

      And("the intermediary amends the registration")
      registration.selectChangeOrRemoveLink(
        "add-website-address\\?waypoints\\=change-your-registration"
      )
      registration.checkJourneyUrl("add-website-address?waypoints=change-your-registration")
      registration.selectChangeOrRemoveLink(
        "website-address\\/2\\?waypoints\\=change-add-website-address\\%2Cchange-your-registration"
      )
      registration.checkJourneyUrl("website-address/2?waypoints=change-add-website-address%2Cchange-your-registration")
      registration.enterAnswer("https://updatedwebsite.co")
      registration.checkJourneyUrl("add-website-address?waypoints=change-your-registration")
      registration.answerRadioButton("no")

      And("the intermediary submits the registration")
      registration.checkJourneyUrl("change-your-registration")
      registration.clickSubmit()
      registration.checkJourneyUrl("successful-amend")

      And("the amend confirmation page shows the amended details")
      amendRegistration.checkAmendedAnswers("reviewRegistration")
    }
  }
}
