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
import org.junit.Assert
import uk.gov.hmrc.ui.pages.Registration._

object Registration extends BasePage {

  private val registrationUrl: String =
    TestEnvironment.url("ioss-netp-registration-frontend")
  private val journeyUrl: String      = "/pay-clients-vat-on-eu-sales/register-new-ioss-client"

  var urlCode        = ""
  var activationCode = ""

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
    checkJourneyUrl("client-has-vat-number")
    answerRadioButton("yes")
    checkJourneyUrl("client-vat-number")
    enterAnswer("GB123456789")
    checkJourneyUrl("client-country-based")
    selectCountry("Angola")
    checkJourneyUrl("client-business-name")
    enterAnswer("Business name")
    checkJourneyUrl("client-address")
    enterAddress("House Name", "Suburb", "City-Name", "", "12345")
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

  def selectCheckbox(): Unit = {
    click(By.id("declaration"))
    click(submitButton)
//    click(continueButton)
  }

  def selectNETPCheckbox(): Unit = {
    click(By.id("declaration"))
    click(submitButton)
  }

  def checkProblemPage(): Unit = {
    val h1 = Driver.instance.findElement(By.tagName("h1")).getText
    Assert.assertTrue(h1.equals("Sorry, there is a problem with the service"))
  }

  def answerSchemeType(answer: String): Unit = {
    answer match {
      case "OSS"  => click(By.id("value_0"))
      case "IOSS" => click(By.id("value_1"))
      case _      => throw new Exception("Option doesn't exist")
    }
    click(continueButton)
  }

  def enterFETradingName(tradingName: String): Unit =
    sendKeys(By.id("tradingName"), tradingName)

  def answerRegistrationType(answer: String): Unit = {
    answer match {
      case "VAT number"    => click(By.id("value_0"))
      case "Tax ID number" => click(By.id("value_1"))
      case _               => throw new Exception("Option doesn't exist")
    }
    click(continueButton)
  }

  def completeAndSubmitRegistrationCompulsoryAnswersOnly(): Unit = {
    completeRegistrationCompulsoryAnswersOnly()
    checkJourneyUrl("check-your-answers")
    continue()
    checkJourneyUrl("declaration")
    selectCheckbox()
    checkJourneyUrl("client-application-complete")
  }

  def completeRegistrationCompulsoryAnswersOnly(): Unit = {
    checkJourneyUrl("have-uk-trading-name")
    answerRadioButton("no")
    checkJourneyUrl("previous-oss")
    answerRadioButton("no")
    checkJourneyUrl("eu-fixed-establishment")
    answerRadioButton("no")
    checkJourneyUrl("website-address/1")
    enterAnswer("www.1st-website.co.uk")
    checkJourneyUrl("add-website-address")
    answerRadioButton("no")
    checkJourneyUrl("business-contact-details")
    fillContactDetails("Firstname Surname", "+44123456789", "test-email@test.co.uk")
  }

  def enterOnePreviousRegistration(): Unit = {
    checkJourneyUrl("previous-country/1")
    selectCountry("Cyprus")
    checkJourneyUrl("previous-scheme/1/1")
    answerSchemeType("OSS")
    checkJourneyUrl("previous-oss-scheme-number/1/1")
    enterAnswer("EU111222333")
    checkJourneyUrl("previous-scheme-answers/1")
    answerRadioButton("yes")
    checkJourneyUrl("previous-scheme/1/2")
    answerSchemeType("IOSS")
    checkJourneyUrl("previous-scheme-intermediary/1/2")
    answerRadioButton("no")
    checkJourneyUrl("previous-ioss-number/1/2")
    enterAnswer("IM1967773331")
    checkJourneyUrl("previous-scheme-answers/1")
    answerRadioButton("no")
    checkJourneyUrl("previous-schemes-overview")
    answerRadioButton("no")
  }

  def enterOneEuTaxDetails(): Unit = {
    checkJourneyUrl("vat-registered-eu-country/1")
    selectCountry("Spain")
    checkJourneyUrl("trading-name-business-address/1")
    enterFETradingName("Spanish Trading Name")
    enterAddress("123 Street Name", "", "Town", "", "ES12345")
    checkJourneyUrl("registration-tax-type/1")
    answerRegistrationType("VAT number")
    checkJourneyUrl("eu-vat-number/1")
    enterAnswer("EST5554441B")
    checkJourneyUrl("check-tax-details/1")
    continue()
    checkJourneyUrl("add-tax-details")
    answerRadioButton("no")
  }

  def enterTwoEuDetails(): Unit = {
    checkJourneyUrl("vat-registered-eu-country/1")
    selectCountry("Spain")
    checkJourneyUrl("trading-name-business-address/1")
    enterFETradingName("Spanish Trading Name")
    enterAddress("123 Street Name", "", "Town", "", "ES12345")
    checkJourneyUrl("registration-tax-type/1")
    answerRegistrationType("VAT number")
    checkJourneyUrl("eu-vat-number/1")
    enterAnswer("EST5554441B")
    checkJourneyUrl("check-tax-details/1")
    continue()
    checkJourneyUrl("add-tax-details")
    answerRadioButton("yes")
    checkJourneyUrl("vat-registered-eu-country/2")
    selectCountry("Netherlands")
    checkJourneyUrl("trading-name-business-address/2")
    enterFETradingName("Netherlands Trading Name")
    enterAddress("1 Road Name", "Suburb", "City", "Region-Name", "NL5555 12")
    checkJourneyUrl("registration-tax-type/2")
    answerRegistrationType("Tax ID number")
    checkJourneyUrl("eu-tax-identification-number/2")
    enterAnswer("NL1 665544")
    checkJourneyUrl("check-tax-details/2")
    continue()
    checkJourneyUrl("add-tax-details")
    answerRadioButton("no")
  }

  def enterTwoPreviousRegistrations(): Unit = {
    checkJourneyUrl("previous-country/1")
    selectCountry("Cyprus")
    checkJourneyUrl("previous-scheme/1/1")
    answerSchemeType("OSS")
    checkJourneyUrl("previous-oss-scheme-number/1/1")
    enterAnswer("EU111222333")
    checkJourneyUrl("previous-scheme-answers/1")
    answerRadioButton("yes")
    checkJourneyUrl("previous-scheme/1/2")
    answerSchemeType("OSS")
    checkJourneyUrl("previous-oss-scheme-number/1/2")
    enterAnswer("CY44445555A")
    checkJourneyUrl("previous-scheme-answers/1")
    answerRadioButton("yes")
    checkJourneyUrl("previous-scheme/1/3")
    answerSchemeType("IOSS")
    checkJourneyUrl("previous-scheme-intermediary/1/3")
    answerRadioButton("yes")
    checkJourneyUrl("previous-ioss-number/1/3")
    enterAnswer("IM1967773331")
    checkJourneyUrl("previous-scheme-answers/1")
    continue()
    checkJourneyUrl("previous-schemes-overview")
    answerRadioButton("yes")
    checkJourneyUrl("previous-country/2")
    selectCountry("Poland")
    checkJourneyUrl("previous-scheme/2/1")
    answerSchemeType("IOSS")
    checkJourneyUrl("previous-scheme-intermediary/2/1")
    answerRadioButton("no")
    checkJourneyUrl("previous-ioss-number/2/1")
    enterAnswer("IM6167773331")
    checkJourneyUrl("previous-scheme-answers/2")
    answerRadioButton("no")
    checkJourneyUrl("previous-schemes-overview")
    answerRadioButton("no")
  }

  def setUrlCode(): Unit = {
    val htmlBody = Driver.instance.findElement(By.tagName("body")).getText
    urlCode = htmlBody.split("/")(6).substring(0, 6)
  }

  def getUrlCode(): String =
    urlCode

  def setActivationCode(): Unit = {
    get(
      s"http://localhost:10181/pay-clients-vat-on-eu-sales/register-new-ioss-client/test-only/get-client-code/$urlCode"
    )
    val htmlBody = Driver.instance.findElement(By.tagName("body")).getText
    activationCode = htmlBody.split(":")(2).substring(1, 7)
  }

  def enterActivationCode(): Unit = {
    get(
      s"http://localhost:10181/pay-clients-vat-on-eu-sales/register-new-ioss-client/client-code-entry/$urlCode"
    )
    sendKeys(By.id("value"), activationCode)
    click(continueButton)
  }

}
