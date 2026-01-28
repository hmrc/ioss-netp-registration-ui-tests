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

import uk.gov.hmrc.ui.pages.{AmendRegistration, Auth, Registration}
import uk.gov.hmrc.ui.specs.BaseSpec

class MultipleIntermediaryRegistrationSpec extends BaseSpec {

  lazy val registration      = Registration
  lazy val auth              = Auth
  lazy val amendRegistration = AmendRegistration

  Feature("Multiple Intermediary Registration journeys") {

    Scenario(
      "Intermediary can view NETP registrations across all of their Intermediary Registrations"
    ) {

      Given("the intermediary views a NETP registration for their current registration")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "multiplePreviousRegistrationsCurrent")
      registration.checkJourneyUrl("change-your-registration")

      Then("the correct Registration details are displayed")
      amendRegistration.checkIossNumber("IM9001144672")

      When("the intermediary submits the registration without amending any details")
      registration.clickSubmit()

      Then("the successful-amend page shows that no information in the registration has been amended")
      registration.checkJourneyUrl("successful-amend")
      amendRegistration.checkAmendedAnswers("noAmendedAnswers")

      Given("the intermediary views a NETP registration for their previous registration")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "multiplePreviousRegistrationsMiddle")
      registration.checkJourneyUrl("change-your-registration")

      Then("the correct Registration details are displayed")
      amendRegistration.checkIossNumber("IM9001144670")

      When("the intermediary submits the registration without amending any details")
      registration.clickSubmit()

      Then("the successful-amend page shows that no information in the registration has been amended")
      registration.checkJourneyUrl("successful-amend")
      amendRegistration.checkAmendedAnswers("noAmendedAnswers")

      Given("the intermediary views a NETP registration for their oldest previous registration")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "multiplePreviousRegistrationsOldest")
      registration.checkJourneyUrl("change-your-registration")

      Then("the correct Registration details are displayed")
      amendRegistration.checkIossNumber("IM9001144668")

      When("the intermediary submits the registration without amending any details")
      registration.clickSubmit()

      Then("the successful-amend page shows that no information in the registration has been amended")
      registration.checkJourneyUrl("successful-amend")
      amendRegistration.checkAmendedAnswers("noAmendedAnswers")
    }
  }
}
