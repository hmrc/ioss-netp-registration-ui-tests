

package uk.gov.hmrc.ui.pages

import org.openqa.selenium.By
import org.scalatest.matchers.should.Matchers.*
import uk.gov.hmrc.configuration.TestEnvironment

object Auth extends BasePage {

  private val authUrl: String      = TestEnvironment.url("auth-login-stub") + "auth-login-stub/gg-sign-in"
  private val registration: String =
    TestEnvironment.url("ioss-netp-registration-frontend")

  private val journeyUrl: String   = "/intermediary-netp"

  def gotToAuthorityWizard(): Unit =
    get(authUrl)

  def checkAuthUrl(): Unit =
    getCurrentUrl should startWith(authUrl)

  def loginUsingAuthorityWizard(vrn: String): Unit = {

    getCurrentUrl should startWith(authUrl)

    sendKeys(By.name("redirectionUrl"), s"$registration$journeyUrl")
    
    selectByValue(By.id("affinityGroupSelect"), "Organisation")
    
    sendKeys(By.id("enrolment[0].name"), "HMRC-MTD-VAT")
    sendKeys(By.id("input-0-0-name"), "VRN")
    sendKeys(By.id("input-0-0-value"), "100000001")
    
    click(By.cssSelector("Input[value='Submit']"))

  }
}
