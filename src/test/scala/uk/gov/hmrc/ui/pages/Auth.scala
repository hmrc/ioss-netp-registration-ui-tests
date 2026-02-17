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

    val redirectUrl = accountType match {
      case "noVrn"                                                   =>
        s"$registrationUrl$journeyUrl/client-code-start/${getUrlCode()}"
      case "noVrnPending"                                            =>
        s"$registrationUrl$journeyUrl/client-code-start/BRJRZF"
      case "multipleSaved" | "oneSaved" | "noSaved" | "saveKickouts" =>
        dashboardUrl
      case "amend" | "ukBasedUkVrn"                                  =>
        s"$registrationUrl$journeyUrl/start-amend-journey/IM9001144771"
      case "ukBasedUtr"                                              =>
        s"$registrationUrl$journeyUrl/start-amend-journey/IM9001144773"
      case "ukBasedNino"                                             =>
        s"$registrationUrl$journeyUrl/start-amend-journey/IM9001144778"
      case "nonUkBasedUkVrn"                                         =>
        s"$registrationUrl$journeyUrl/start-amend-journey/IM9001144775"
      case "nonUkBasedFtr"                                           =>
        s"$registrationUrl$journeyUrl/start-amend-journey/IM9001144777"
      case "ukExcluded"                                              =>
        s"$registrationUrl$journeyUrl/start-amend-journey/IM9001144772"
      case "hmrcExcluded"                                            =>
        s"$registrationUrl$journeyUrl/start-amend-journey/IM9001144774"
      case "ftrExcluded"                                             =>
        s"$registrationUrl$journeyUrl/start-amend-journey/IM9001144776"
      case "minimalAmend" | "notAClient"                             =>
        s"$registrationUrl$journeyUrl/start-amend-journey/IM9001144881"
      case "selfExcludedFuture"                                      =>
        s"$registrationUrl$journeyUrl/start-amend-journey/IM9002223331"
      case "hmrcExcludedFuture"                                      =>
        s"$registrationUrl$journeyUrl/start-amend-journey/IM9002223332"
      case "reversal"                                                =>
        s"$registrationUrl$journeyUrl/start-amend-journey/IM9002223333"
      case "failureAmend"                                            =>
        s"$registrationUrl$journeyUrl/start-amend-journey/IM9002222222"
      case "multiplePreviousRegistrationsCurrent"                    =>
        s"$registrationUrl$journeyUrl/start-amend-journey/IM9001144672"
      case "multiplePreviousRegistrationsMiddle"                     =>
        s"$registrationUrl$journeyUrl/start-amend-journey/IM9001144670"
      case "multiplePreviousRegistrationsOldest"                     =>
        s"$registrationUrl$journeyUrl/start-amend-journey/IM9001144668"
      case "excludedIntermediaryExcludedNETP"                        =>
        s"$registrationUrl$journeyUrl/start-amend-journey/IM9000306831"
      case "secureMessagesUkBasedUkVrn" | "secureMessagesUkBasedUtr" | "secureMessagesUkBasedNino" |
          "secureMessagesNonUkBasedUkVrn" | "secureMessagesNonUkBasedFtr" | "secureMessagesNone" | "noNetpEnrolment" =>
        s"$registrationUrl$journeyUrl/secure-messages"
      case "pendingNotClient"                                        =>
        s"$registrationUrl$journeyUrl/client-not-activated/6bf0b5aa-c9f1-4860-8bf4-a428c033c954"
      case _                                                         =>
        s"$registrationUrl$journeyUrl"
    }

    sendKeys(By.name("redirectionUrl"), redirectUrl)

    selectByValue(By.id("affinityGroupSelect"), "Organisation")

    if (withVatEnrolment) {
      sendKeys(By.id("enrolment[0].name"), "HMRC-MTD-VAT")
      sendKeys(By.id("input-0-0-name"), "VRN")

      val vrn = accountType match {
        case "notFound"      => "900000001"
        case "multipleSaved" => "100000111"
        case "oneSaved"      => "100000222"
        case "saveKickouts"  => "100000333"
        case _               => "100000001"
      }
      sendKeys(By.id("input-0-0-value"), vrn)
    }

    if (withIntEnrolment) {
      sendKeys(By.id("enrolment[1].name"), "HMRC-IOSS-INT")
      sendKeys(By.id("input-1-0-name"), "IntNumber")
      val intermediaryNumber = accountType match {
        case "pending" | "pendingNotClient"                                   => "IN9001112223"
        case "multipleSaved"                                                  => "IN9001114567"
        case "oneSaved"                                                       => "IN9002224567"
        case "saveKickouts"                                                   => "IN9008888888"
        case "minimalAmend"                                                   => "IN9008888887"
        case "failureAmend"                                                   => "IN900666001"
        case "excludedIntermediary" | "excludedIntermediaryExcludedNETP"      => "IN9000306831"
        case multiple if multiple.startsWith("multiplePreviousRegistrations") => "IN9002230002"
        case "selfExcludedFuture" | "hmrcExcludedFuture" | "reversal"         => "IN9002223331"
        case _                                                                => "IN9001234567"
      }
      sendKeys(By.id("input-1-0-value"), intermediaryNumber)
    }

    if (accountType startsWith "secureMessages") {
      sendKeys(By.id("enrolment[1].name"), "HMRC-IOSS-NETP")
      sendKeys(By.id("input-1-0-name"), "IOSSNumber")

      val iossNumber = accountType match {
        case "secureMessagesUkBasedUkVrn"    => "IM9001144771"
        case "secureMessagesUkBasedUtr"      => "IM9001144773"
        case "secureMessagesUkBasedNino"     => "IM9001144778"
        case "secureMessagesNonUkBasedFtr"   => "IM9001144777"
        case "secureMessagesNonUkBasedUkVrn" => "IM9001144775"
        case _                               => "IM9001144881"
      }

      sendKeys(By.id("input-1-0-value"), iossNumber)
    }

    if (accountType startsWith "multiplePreviousRegistrations") {
      sendKeys(By.id("enrolment[2].name"), "HMRC-IOSS-INT")
      sendKeys(By.id("input-2-0-name"), "IntNumber")
      sendKeys(By.id("input-2-0-value"), "IN9001230002")

      sendKeys(By.id("enrolment[3].name"), "HMRC-IOSS-INT")
      sendKeys(By.id("input-3-0-name"), "IntNumber")
      sendKeys(By.id("input-3-0-value"), "IN9000230002")
    }

    click(By.cssSelector("Input[value='Submit']"))
  }

}
