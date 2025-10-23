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

class AmendRegistrationSpec extends BaseSpec {

  lazy val registration = Registration
  lazy val auth         = Auth

  Feature("Amend Registration journeys") {

//    Scenario("Intermediary can amend contact details in a NETP registration") {
//
//      Given("the intermediary accesses the IOSS NETP Registration Service")
//      auth.goToAuthorityWizard()
//      auth.loginUsingAuthorityWizard(true, true, "amend")
//      registration.checkJourneyUrl("change-your-registration?iossNumber=IM9001144771")
//
//      When("the intermediary clicks change for contact details")
//      registration.selectChangeOrRemoveLink(
//        "business-contact-details\\?waypoints\\=change-your-registration-IM9001144771"
//      )
//
//      Then("the intermediary can update their phone number and email address")
//      registration.checkJourneyUrl("business-contact-details?waypoints=change-your-registration-IM9001144771")
//      registration.updateField("telephoneNumber", "+441234567890")
//      registration.updateField("emailAddress", "amend-test@email.com")
//      registration.continue()
//
//      And("the intermediary is redirected to the change-your-registration page for the NETP")
//      registration.checkJourneyUrl("change-your-registration?iossNumber=IM9001144771")
//    }
//
  }
}
