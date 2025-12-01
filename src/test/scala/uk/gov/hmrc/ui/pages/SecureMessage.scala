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

import org.junit.Assert
import org.openqa.selenium.By
import uk.gov.hmrc.selenium.webdriver.Driver

object SecureMessage extends BasePage {

  def checkClientName(clientType: String): Unit = {
    val body = Driver.instance.findElement(By.tagName("body")).getText

    clientType match {

      case "secureMessagesUkBasedUkVrn"    =>
        Assert.assertTrue(
          body.contains(
            "First Company\nIOSS number: IM9001144771"
          )
        )
      case "secureMessagesUkBasedUtr"      =>
        Assert.assertTrue(
          body.contains(
            "Third Client\nIOSS number: IM9001144773"
          )
        )
      case "secureMessagesNonUkBasedUkVrn" =>
        Assert.assertTrue(
          body.contains(
            "Fifth Client\nIOSS number: IM9001144775"
          )
        )
      case "secureMessagesNonUkBasedFtr"   =>
        Assert.assertTrue(
          body.contains(
            "Seventh Client\nIOSS number: IM9001144777"
          )
        )
      case "secureMessagesUkBasedNino"     =>
        Assert.assertTrue(
          body.contains(
            "Eighth Client\nIOSS number: IM9001144778"
          )
        )
      case "secureMessagesNone"            =>
        Assert.assertTrue(
          body.contains(
            "First Company\nIOSS number: IM9001144881"
          )
        )
      case _                               => throw new Exception("This client type does not exist")
    }
  }

  def selectSecureMessage(link: String): Unit =
    click(By.cssSelector(s"a[href*=$link]"))

  def checkSecureMessagesHeading(heading: String): Unit = {
    val heading = Driver.instance.findElement(By.tagName("h2")).getText
    Assert.assertTrue(heading.equals(heading))
  }
}
