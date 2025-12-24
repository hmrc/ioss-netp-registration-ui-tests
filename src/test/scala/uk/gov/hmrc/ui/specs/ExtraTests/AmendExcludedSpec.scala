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

class AmendExcludedSpec extends BaseSpec {

  lazy val registration      = Registration
  lazy val auth              = Auth
  lazy val amendRegistration = AmendRegistration

  Feature("Amend Registration for Excluded trader journeys") {

    Scenario(
      "Intermediary can only amend the contact details for a NETP registration where the client is UK based with UK VRN and has left the service"
    ) {

      Given("the intermediary views the NETP registration")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "ukExcluded")
      registration.checkJourneyUrl("change-your-registration")
      amendRegistration.checkIossNumber("IM9001144772")

      Then("the correct change links are available on the change-your-registration page")
      amendRegistration.checkChangeLinksExcluded("ukExcluded")

      When("the intermediary submits the registration without amending any details")
      registration.clickSubmit()

      Then("the successful-amend page shows that no information in the registration has been amended")
      registration.checkJourneyUrl("successful-amend")
      amendRegistration.checkAmendedAnswers("noAmendedAnswers")
    }

    Scenario(
      "Intermediary can only amend the contact details for a NETP registration where the client is Non-UK based with FTR and has left the service"
    ) {

      Given("the intermediary views the NETP registration")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "ftrExcluded")
      registration.checkJourneyUrl("change-your-registration")
      amendRegistration.checkIossNumber("IM9001144776")

      Then("the correct change links are available on the change-your-registration page")
      amendRegistration.checkChangeLinksExcluded("ftrExcluded")

      And("the intermediary amends the contact details")
      registration.selectChangeOrRemoveLink(
        "business-contact-details\\?waypoints\\=change-your-registration"
      )
      registration.checkJourneyUrl("business-contact-details?waypoints=change-your-registration")
      registration.updateField("fullName", "New Name")
      registration.updateField("telephoneNumber", "+441234567890")
      registration.updateField("emailAddress", "amend-test@email.com")
      registration.continue()

      And("the intermediary is on the change-your-registration page")
      registration.checkJourneyUrl("change-your-registration")
      amendRegistration.checkIossNumber("IM9001144776")

      Then("the intermediary submits the registration with the amended details")
      registration.clickSubmit()

      Then("the successful-amend page shows the correct details in the registration have been amended")
      registration.checkJourneyUrl("successful-amend")
      amendRegistration.checkAmendedAnswers("ftrExcluded")
    }

    Scenario(
      "Correct exclusion messages displayed for an HMRC excluded NETP"
    ) {

      Given("the intermediary views the NETP registration")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "hmrcExcluded")
      registration.checkJourneyUrl("change-your-registration")
      amendRegistration.checkIossNumber("IM9001144774")

      Then("the correct exclusion messages are displayed on the change-your-registration page")
      amendRegistration.checkChangeLinksExcluded("hmrcExcluded")
    }
  }
}
