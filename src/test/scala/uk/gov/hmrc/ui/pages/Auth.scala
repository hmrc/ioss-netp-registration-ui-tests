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

object Auth extends BasePage {

  private val authUrl: String         = TestEnvironment.url("auth-login-stub") + "/auth-login-stub/gg-sign-in"
  private val registrationUrl: String =
    TestEnvironment.url("ioss-netp-registration-frontend")
  private val journeyUrl: String      = "/intermediary-netp"

  def goToAuthorityWizard(): Unit =
    get(authUrl)

  def loginUsingAuthorityWizard(): Unit = {

    getCurrentUrl should startWith(authUrl)

    sendKeys(By.name("redirectionUrl"), s"$registrationUrl$journeyUrl")

    selectByValue(By.id("affinityGroupSelect"), "Organisation")

    click(By.cssSelector("Input[value='Submit']"))

  }

}
