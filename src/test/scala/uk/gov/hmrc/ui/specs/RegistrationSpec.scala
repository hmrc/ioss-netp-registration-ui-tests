
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

import uk.gov.hmrc.ui.pages.Registration

class RegistrationSpec extends BaseSpec {

  private val registration = Registration

  Feature("Registration journeys") {

    Scenario("Trader accesses the IOSS Intermediary NETP Registration Service") {

      Given("the trader accesses the IOSS Intermediary NETP Registration Service")
      registration.goToRegistrationJourney()

    }
  }
}