/*
 * Copyright 2023 HM Revenue & Customs
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

package uk.gov.hmrc.ui.pages

import org.openqa.selenium.By
import org.scalatest.matchers.should.Matchers.*
import uk.gov.hmrc.configuration.TestEnvironment
import uk.gov.hmrc.ui.pages.Registration._

object Auth extends BasePage {

  private val authUrl: String         = TestEnvironment.url("auth-login-stub") + "/auth-login-stub/gg-sign-in"
  private val registrationUrl: String =
    TestEnvironment.url("ioss-netp-registration-frontend")
  private val journeyUrl: String      = "/pay-clients-vat-on-eu-sales/register-new-ioss-client"

  def goToAuthorityWizard(): Unit =
    get(authUrl)

  def loginUsingAuthorityWizard(withIntEnrolment: Boolean, withVatEnrolment: Boolean, vrnType: String): Unit = {

    getCurrentUrl should startWith(authUrl)

    if (vrnType == "noVrn") {
      sendKeys(By.name("redirectionUrl"), s"$registrationUrl$journeyUrl/client-code-start/${getUrlCode()}")
    } else {
      sendKeys(By.name("redirectionUrl"), s"$registrationUrl$journeyUrl")
    }

    selectByValue(By.id("affinityGroupSelect"), "Organisation")

    if (withVatEnrolment) {
      sendKeys(By.id("enrolment[0].name"), "HMRC-MTD-VAT")
      sendKeys(By.id("input-0-0-name"), "VRN")
      if (vrnType == "notFound") {
        sendKeys(By.id("input-0-0-value"), "900000001")
      } else {
        sendKeys(By.id("input-0-0-value"), "100000001")
      }
    }
    if (withIntEnrolment) {
      sendKeys(By.id("enrolment[1].name"), "HMRC-IOSS-INT")
      sendKeys(By.id("input-1-0-name"), "IntNumber")
      if (vrnType == "pending") {
        sendKeys(By.id("input-1-0-value"), "IN9001112223")
      } else {
        sendKeys(By.id("input-1-0-value"), "IN9001234567")
      }
    }
    click(By.cssSelector("Input[value='Submit']"))
  }

}
