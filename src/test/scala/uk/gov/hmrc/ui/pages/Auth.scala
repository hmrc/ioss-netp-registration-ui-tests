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

package uk.gov.hmrc.ui.pages

import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import org.scalatest.matchers.should.Matchers.*
import uk.gov.hmrc.configuration.TestEnvironment
import uk.gov.hmrc.ui.pages.Registration.*

object Auth extends BasePage {

  private val authUrl: String         = TestEnvironment.url("auth-login-stub") + "/auth-login-stub/gg-sign-in"
  private val registrationUrl: String =
    TestEnvironment.url("ioss-netp-registration-frontend")
  private val journeyUrl: String      = "/pay-clients-vat-on-eu-sales/register-new-ioss-client"
  private val dashboardUrl: String    =
    TestEnvironment.url(
      "ioss-intermediary-dashboard-frontend"
    ) + "/pay-clients-vat-on-eu-sales/manage-ioss-returns-payments-clients"

  def goToAuthorityWizard(): Unit =
    get(authUrl)
    fluentWait.until(ExpectedConditions.urlContains(authUrl))

  def loginUsingAuthorityWizard(withIntEnrolment: Boolean, withVatEnrolment: Boolean, accountType: String): Unit = {

    getCurrentUrl should startWith(authUrl)

    if (accountType == "noVrn") {
      sendKeys(By.name("redirectionUrl"), s"$registrationUrl$journeyUrl/client-code-start/${getUrlCode()}")
    } else if (accountType == "noVrnPending") {
      sendKeys(By.name("redirectionUrl"), s"$registrationUrl$journeyUrl/client-code-start/BRJRZF")
    } else if (accountType == "multipleSaved" || accountType == "oneSaved" || accountType == "noSaved") {
      sendKeys(By.name("redirectionUrl"), dashboardUrl)
    } else if (accountType == "amend") {
      sendKeys(By.name("redirectionUrl"), s"$registrationUrl$journeyUrl/start-amend-journey/IM9001144771")
    } else {
      sendKeys(By.name("redirectionUrl"), s"$registrationUrl$journeyUrl")
    }

    selectByValue(By.id("affinityGroupSelect"), "Organisation")

    if (withVatEnrolment) {
      sendKeys(By.id("enrolment[0].name"), "HMRC-MTD-VAT")
      sendKeys(By.id("input-0-0-name"), "VRN")
      if (accountType == "notFound") {
        sendKeys(By.id("input-0-0-value"), "900000001")
      } else if (accountType == "multipleSaved") {
        sendKeys(By.id("input-0-0-value"), "100000111")
      } else if (accountType == "oneSaved") {
        sendKeys(By.id("input-0-0-value"), "100000222")
      } else {
        sendKeys(By.id("input-0-0-value"), "100000001")
      }
    }
    if (withIntEnrolment) {
      sendKeys(By.id("enrolment[1].name"), "HMRC-IOSS-INT")
      sendKeys(By.id("input-1-0-name"), "IntNumber")
      if (accountType == "pending") {
        sendKeys(By.id("input-1-0-value"), "IN9001112223")
      } else if (accountType == "multipleSaved") {
        sendKeys(By.id("input-1-0-value"), "IN9001114567")
      } else if (accountType == "oneSaved") {
        sendKeys(By.id("input-1-0-value"), "IN9002224567")
      } else {
        sendKeys(By.id("input-1-0-value"), "IN9001234567")
      }
    }
    click(By.cssSelector("Input[value='Submit']"))
  }

}
