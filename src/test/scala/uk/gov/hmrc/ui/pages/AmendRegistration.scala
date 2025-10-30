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

object AmendRegistration extends BasePage {

  def checkRegistrationDetails(clientType: String): Unit = {
    val body = Driver.instance.findElement(By.tagName("body")).getText

    clientType match {

      // Note current change links added to checks but need adjusting accordingly in VEI-450/VEI-579
      case "ukBasedUkVrn"           =>
        Assert.assertTrue(
          body.contains(
            "Registration details\n" +
              "Based in UK Yes\n" +
              "Has UK VAT registration number Yes\n" +
              "UK VAT registration number 100000001\n" +
              "Principal place of business address 1 The Street\n" +
              "Some Town\n" +
              "AA11 1AA"
          )
        )
      case "ukBasedUtr"             =>
        Assert.assertTrue(
          body.contains(
            "Registration details\n" +
              "Based in UK Yes\n" +
              "Has UK VAT registration number No\n" +
              "Trading name Third Client Change\n" +
//          Hidden change text start
              "your Clients trading name\n" +
//          Hidden change text end
              "Has Unique Taxpayer Reference (UTR) number Yes\n" +
              "UTR number 1234567890\n" +
              "Principal place of business address Other Address Line 1\n" +
              "Other Address Line 2\n" +
              "Other Town or City\n" +
              "Other Region or State\n" +
              "NE11HM Change\n"
          )
        )
      case "ukBasedUtrAmended"      =>
        Assert.assertTrue(
          body.contains(
            "Registration details\n" +
              "Based in UK Yes\n" +
              "Has UK VAT registration number No\n" +
              "Trading name Updated 3rd client name Change\n" +
              //          Hidden change text start
              "your Clients trading name\n" +
              //          Hidden change text end
              "Has Unique Taxpayer Reference (UTR) number Yes\n" +
              "UTR number 1234567890\n" +
              "Principal place of business address 1 New Address Line\n" +
              "Other Address Line 2\n" +
              "New Town-Name\n" +
              "Other Region or State Change\n"
          )
        )
      case "ukBasedNino"            =>
        Assert.assertTrue(
          body.contains(
            "Registration details\n" +
              "Based in UK Yes\n" +
              "Has UK VAT registration number No" +
              "\nTrading name Eighth Client Change\n" +
//          Hidden change text start
              "your Clients trading name\n" +
//          Hidden change text end
              "Has Unique Taxpayer Reference (UTR) number No\n" +
              "National Insurance number (NINO) AA112211A\n" +
              "Principal place of business address Other Address Line 1\n" +
              "Other Address Line 2\n" +
              "Other Town or City\n" +
              "Other Region or State\n" +
              "NE11HM Change"
          )
        )
      case "ukBasedNinoAmended"     =>
        Assert.assertTrue(
          body.contains(
            "Registration details\n" +
              "Based in UK Yes\n" +
              "Has UK VAT registration number No" +
              "\nTrading name Updated 8th client name Change\n" +
              //          Hidden change text start
              "your Clients trading name\n" +
              //          Hidden change text end
              "Has Unique Taxpayer Reference (UTR) number No\n" +
              "National Insurance number (NINO) AA112211A\n" +
              "Principal place of business address Other Address Line 1\n" +
              "New Suburb\n" +
              "Other Town or City\n" +
              "NE11HM Change"
          )
        )
      case "nonUkBasedUkVrn"        =>
        Assert.assertTrue(
          body.contains(
            "Registration details\n" +
              "Based in UK No\n" +
              "Has UK VAT registration number Yes\n" +
              "UK VAT registration number 100000002\n" +
              "Country based in Spain Change\n" +
//          Hidden change text start
              "Country based in\n" +
//          Hidden change text end
              "Trading name in Spain Fifth Client Change\n" +
//          Hidden change text start
              "your Clients trading name\n" +
//          Hidden change text end
              "Principal place of business address 123 Street Name\n" +
              "Barcelona\n" +
              "ES123456 Change"
          )
        )
      case "nonUkBasedUkVrnAmended" =>
        Assert.assertTrue(
          body.contains(
            "Registration details\n" +
              "Based in UK No\n" +
              "Has UK VAT registration number Yes\n" +
              "UK VAT registration number 100000002\n" +
              "Country based in Christmas Island Change\n" +
              //          Hidden change text start
              "Country based in\n" +
              //          Hidden change text end
              "Trading name in Christmas Island New 5th client name Change\n" +
              //          Hidden change text start
              "your Clients trading name\n" +
              //          Hidden change text end
              "Principal place of business address 123 Street Name\n" +
              "New Suburb\n" +
              "Barcelona\n" +
              "State Change"
          )
        )
      case "nonUkBasedFtr"          =>
        Assert.assertTrue(
          body.contains(
            "Based in UK No\n" +
              "Has UK VAT registration number No\n" +
              "Country based in France Change\n" +
//          Hidden change text start
              "Country based in\n" +
//          Hidden change text end
              "National tax number FR112233 Change\n" +
//          Hidden change text start
              "your client's tax reference number\n" +
//          Hidden change text end
              "Trading name in France Seventh Client Change\n" +
//          Hidden change text start
              "your Clients trading name\n" +
//          Hidden change text end
              "Principal place of business address 100 Road Name\n" +
              "Suburb\n" +
              "Paris\n" +
              "Region\n" +
              "10050 Change"
          )
        )
      case "nonUkBasedFtrAmended"   =>
        Assert.assertTrue(
          body.contains(
            "Based in UK No\n" +
              "Has UK VAT registration number No\n" +
              "Country based in Canada Change\n" +
              //          Hidden change text start
              "Country based in\n" +
              //          Hidden change text end
              "National tax number CA112233 Change\n" +
              //          Hidden change text start
              "your client's tax reference number\n" +
              //          Hidden change text end
              "Trading name in Canada Seventh Client Change\n" +
              //          Hidden change text start
              "your Clients trading name\n" +
              //          Hidden change text end
              "Principal place of business address 200 Street Name\n" +
              "Suburb\n" +
              "Paris\n" +
              "Region Change"
          )
        )
      case _                        => throw new Exception("This client type does not exist")

    }
  }

  def checkIossNumber(iossNumber: String): Unit = {
    val body = Driver.instance.findElement(By.tagName("body")).getText
    Assert.assertTrue(body.contains(s"IOSS number: $iossNumber"))
  }
}
