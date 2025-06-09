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

import org.openqa.selenium.{By, Keys}
import org.openqa.selenium.support.ui.{ExpectedConditions, FluentWait}
import org.scalatest.matchers.should.Matchers.*
import uk.gov.hmrc.configuration.TestEnvironment
import uk.gov.hmrc.selenium.webdriver.Driver
import uk.gov.hmrc.ui.pages.Registration.continueButton

object Registration extends BasePage {

  private val registrationUrl: String =
    TestEnvironment.url("ioss-netp-registration-frontend")
  private val journeyUrl: String      = "/intermediary-netp"

  def goToRegistrationJourney(): Unit =
    get(registrationUrl + journeyUrl)

  def checkJourneyUrl(page: String): Unit =
    getCurrentUrl should startWith(s"$registrationUrl$journeyUrl/$page")

  def goToPage(page: String): Unit =
    get(s"$registrationUrl$journeyUrl/$page")

  def answerRadioButton(answer: String): Unit = {

    answer match {
      case "yes" => click(By.id("value"))
      case "no"  => click(By.id("value-no"))
      case _     => throw new Exception("Option doesn't exist")
    }
    click(continueButton)
  }

  def enterAnswer(answer: String): Unit =
    sendKeys(By.id("value"), answer)
    click(continueButton)

  def enterAddress(
    line1: String,
    line2: String,
    townOrCity: String,
    stateOrRegion: String,
    postCode: String
  ): Unit =
    sendKeys(By.id("line1"), line1)
    sendKeys(By.id("line2"), line2)
    sendKeys(By.id("townOrCity"), townOrCity)
    sendKeys(By.id("stateOrRegion"), stateOrRegion)
    sendKeys(By.id("postCode"), postCode)
    continue()

  def continue(): Unit =
    click(continueButton)

  def waitForElement(by: By): Unit =
    new FluentWait(Driver.instance).until(ExpectedConditions.presenceOfElementLocated(by))

  def selectCountry(country: String): Unit = {
    val inputId = "value"
    sendKeys(By.id(inputId), country)
    waitForElement(By.id(inputId))
    click(By.cssSelector("li#value__option--0"))
    click(continueButton)
  }

  def clearCountry(): Unit = {
    val input = Driver.instance.findElement(By.id("value")).getAttribute("value")
    if (input != null) {
      for (n <- input)
        Driver.instance.findElement(By.id("value")).sendKeys(Keys.BACK_SPACE)
    }
  }

  def answerVatDetailsUkVrn(): Unit = {
    answerRadioButton("yes")
    checkJourneyUrl("client-has-vat-number")
    answerRadioButton("yes")
    checkJourneyUrl("client-vat-number")
    enterAnswer("GB111222333")
  }

  def answerVatDetailsNonUk(): Unit = {
    answerRadioButton("no")
    checkJourneyUrl("client-country-based")
    selectCountry("Angola")
    checkJourneyUrl("client-business-name")
    enterAnswer("Business name")
    checkJourneyUrl("client-tax-reference")
    enterAnswer("BUS98765")
    checkJourneyUrl("client-address")
    enterAddress("House Name", "Suburb", "City-Name", "", "12345")
  }

  def answerVatDetails(answer: String): Unit = {
    answer match {
      case "yes" => click(By.id("value_0"))
      case "no"  => click(By.id("value_1"))
      case _     => throw new Exception("Option doesn't exist")
    }
    click(continueButton)
  }

  def selectChangeOrRemoveLink(link: String): Unit =
    click(By.cssSelector(s"a[href*=$link]"))

  def updateField(id: String, text: String): Unit =
    sendKeys(By.id(id), text)

  def fillContactDetails(name: String, phone: String, email: String): Unit = {
    sendKeys(By.id("fullName"), name)
    sendKeys(By.id("telephoneNumber"), phone)
    sendKeys(By.id("emailAddress"), email)
    click(continueButton)

  }
}
