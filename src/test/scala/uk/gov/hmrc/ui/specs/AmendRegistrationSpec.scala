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

import uk.gov.hmrc.ui.pages.{AmendRegistration, Auth, Registration}

class AmendRegistrationSpec extends BaseSpec {

  lazy val registration      = Registration
  lazy val auth              = Auth
  lazy val amendRegistration = AmendRegistration

  Feature("Amend Registration journeys") {

    Scenario(
      "Intermediary can view a NETP registration for a UK based client with UK VRN and cannot amend registration details section"
    ) {

      Given("the intermediary views the NETP registration")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "ukBasedUkVrn")
      registration.checkJourneyUrl("change-your-registration")

      Then("the correct Registration details are displayed for a UK based client with a UK VRN")
      amendRegistration.checkIossNumber("IM9001144771")
      amendRegistration.checkRegistrationDetails("ukBasedUkVrn")
    }

    Scenario(
      "Intermediary can view a NETP registration for a UK based client with UTR and can amend registration details section"
    ) {

      Given("the intermediary views the NETP registration")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "ukBasedUtr")
      registration.checkJourneyUrl("change-your-registration")

      Then("the correct Registration details are displayed for a UK based client with a UTR")
      amendRegistration.checkIossNumber("IM9001144773")
      amendRegistration.checkRegistrationDetails("ukBasedUtr")

      When("the intermediary clicks change for Trading name")
      registration.selectChangeOrRemoveLink(
        "client-business-name\\?waypoints\\=change-your-registration"
      )

      Then("the intermediary can amend their client's business name")
      registration.checkJourneyUrl("client-business-name?waypoints=change-your-registration")
      registration.enterAnswer("Updated 3rd client name")
      registration.checkJourneyUrl("change-your-registration")
      amendRegistration.checkIossNumber("IM9001144773")

      When("the intermediary clicks change for Principal place of business address")
      registration.selectChangeOrRemoveLink(
        "client-address\\?waypoints\\=change-your-registration"
      )

      Then("the intermediary can amend their client's business address")
      registration.checkJourneyUrl("client-address?waypoints=change-your-registration")
      registration.updateField("line1", "1 New Address Line")
      registration.updateField("townOrCity", "New Town-Name")
      registration.updateField("postCode", "")
      registration.continue()
      registration.checkJourneyUrl("change-your-registration")
      amendRegistration.checkIossNumber("IM9001144773")

      Then("the correct Registration details following the amendment")
      amendRegistration.checkRegistrationDetails("ukBasedUtrAmended")
    }

    Scenario(
      "Intermediary can view a NETP registration for a UK based client with NINO and can amend registration details section"
    ) {

      Given("the intermediary views the NETP registration")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "ukBasedNino")
      registration.checkJourneyUrl("change-your-registration")

      Then("the correct Registration details are displayed for a UK based client with a NINO")
      amendRegistration.checkIossNumber("IM9001144778")
      amendRegistration.checkRegistrationDetails("ukBasedNino")

      When("the intermediary clicks change for Trading name")
      registration.selectChangeOrRemoveLink(
        "client-business-name\\?waypoints\\=change-your-registration"
      )

      Then("the intermediary can amend their client's business name")
      registration.checkJourneyUrl("client-business-name?waypoints=change-your-registration")
      registration.enterAnswer("Updated 8th client name")
      registration.checkJourneyUrl("change-your-registration")
      amendRegistration.checkIossNumber("IM9001144778")

      Then("the intermediary can amend their client's business address")
      registration.checkJourneyUrl("client-address?waypoints=change-your-registration")
      registration.updateField("line2", "New Suburb")
      registration.updateField("stateOrRegion", "")
      registration.continue()
      registration.checkJourneyUrl("change-your-registration")
      amendRegistration.checkIossNumber("IM9001144778")

      Then("the correct Registration details following the amendment")
      amendRegistration.checkRegistrationDetails("ukBasedNinoAmended")
    }

    Scenario(
      "Intermediary can view a NETP registration for a Non-UK based client with UK VRN and can amend registration details section"
    ) {

      Given("the intermediary views the NETP registration")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "nonUkBasedUkVrn")
      registration.checkJourneyUrl("change-your-registration")

      Then("the correct Registration details are displayed for a Non-UK based client with a UK VRN")
      amendRegistration.checkIossNumber("IM9001144775")
      amendRegistration.checkRegistrationDetails("nonUkBasedUkVrn")

      When("the intermediary clicks change for Country based in")
      registration.selectChangeOrRemoveLink(
        "client-country-based\\?waypoints\\=change-your-registration"
      )

      Then("the intermediary amends the country the client is based in")
      registration.checkJourneyUrl("client-country-based?waypoints=change-your-registration")
      registration.selectCountry("Christmas Island")
      registration.checkJourneyUrl("change-your-registration")
      amendRegistration.checkIossNumber("IM9001144775")

      When("the intermediary clicks change for Trading name")
      registration.selectChangeOrRemoveLink(
        "client-business-name\\?waypoints\\=change-your-registration"
      )

      Then("the intermediary can amend their client's business name")
      registration.checkJourneyUrl("client-business-name?waypoints=change-your-registration")
      registration.enterAnswer("New 5th client name")
      registration.checkJourneyUrl("change-your-registration")
      amendRegistration.checkIossNumber("IM9001144775")

      Then("the intermediary can amend their client's business address")
      registration.checkJourneyUrl("client-address?waypoints=change-your-registration")
      registration.updateField("line2", "New Suburb")
      registration.updateField("stateOrRegion", "State")
      registration.updateField("postCode", "")
      registration.continue()
      registration.checkJourneyUrl("change-your-registration")
      amendRegistration.checkIossNumber("IM9001144775")

      Then("the correct Registration details following the amendment")
      amendRegistration.checkRegistrationDetails("nonUkBasedUkVrnAmended")
    }

    Scenario(
      "Intermediary can view a NETP registration for a Non-UK based client with FTR and can amend registration details section"
    ) {

      Given("the intermediary views the NETP registration")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "nonUkBasedFtr")
      registration.checkJourneyUrl("change-your-registration")

      Then("the correct Registration details are displayed for a Non-UK based client with an FTR")
      amendRegistration.checkIossNumber("IM9001144777")
      amendRegistration.checkRegistrationDetails("nonUkBasedFtr")

      When("the intermediary clicks change for Country based in")
      registration.selectChangeOrRemoveLink(
        "client-country-based\\?waypoints\\=change-your-registration"
      )

      Then("the intermediary amends the country the client is based in")
      registration.checkJourneyUrl("client-country-based?waypoints=change-your-registration")
      registration.selectCountry("Canada")
      registration.checkJourneyUrl("change-your-registration")
      amendRegistration.checkIossNumber("IM9001144777")

      When("the intermediary clicks change for Trading name")
      registration.selectChangeOrRemoveLink(
        "client-business-name\\?waypoints\\=change-your-registration"
      )

      Then("the intermediary can amend their client's business name")
      registration.checkJourneyUrl("client-business-name?waypoints=change-your-registration")
      registration.enterAnswer("New 5th client name")
      registration.checkJourneyUrl("change-your-registration")
      amendRegistration.checkIossNumber("IM9001144777")

      When("the intermediary clicks change for National tax number")
      registration.selectChangeOrRemoveLink(
        "client-tax-reference\\?waypoints\\=change-your-registration"
      )

      Then("the intermediary can amend their client's national tax number")
      registration.checkJourneyUrl("client-tax-reference?waypoints=change-your-registration")
      registration.enterAnswer("CA112233")
      registration.checkJourneyUrl("change-your-registration")
      amendRegistration.checkIossNumber("IM9001144777")

      Then("the intermediary can amend their client's business address")
      registration.checkJourneyUrl("client-address?waypoints=change-your-registration")
      registration.updateField("line1", "200 Street Name")
      registration.updateField("postCode", "")
      registration.continue()
      registration.checkJourneyUrl("change-your-registration")
      amendRegistration.checkIossNumber("IM9001144777")

      Then("the correct Registration details following the amendment")
      amendRegistration.checkRegistrationDetails("nonUkBasedFtrAmended")
    }

    Scenario("Intermediary can amend contact details in a NETP registration") {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "amend")
      registration.checkJourneyUrl("change-your-registration")
      amendRegistration.checkIossNumber("IM9001144771")

      When("the intermediary clicks change for contact details")
      registration.selectChangeOrRemoveLink(
        "business-contact-details\\?waypoints\\=change-your-registration"
      )

      Then("the intermediary can update their phone number and email address")
      registration.checkJourneyUrl("business-contact-details?waypoints=change-your-registration")
      registration.updateField("telephoneNumber", "+441234567890")
      registration.updateField("emailAddress", "amend-test@email.com")
      registration.continue()

      And("the intermediary is on the change-your-registration page")
      registration.checkJourneyUrl("change-your-registration")
      amendRegistration.checkIossNumber("IM9001144771")
    }

    Scenario("Intermediary can amend and remove fixed establishments in a NETP registration") {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "amend")
      registration.checkJourneyUrl("change-your-registration")
      amendRegistration.checkIossNumber("IM9001144771")

      When("the intermediary clicks change for Countries established in")
      registration.selectChangeOrRemoveLink(
        "add-tax-details\\?waypoints\\=change-your-registration"
      )

      Then("the intermediary can amend an existing fixed establishment")
      registration.checkJourneyUrl("add-tax-details?waypoints=change-your-registration")
      registration.selectChangeOrRemoveLink(
        "check-tax-details\\/1\\?waypoints\\=change-your-registration"
      )
      registration.checkJourneyUrl("check-tax-details/1?waypoints=change-your-registration")
      registration.selectChangeOrRemoveLink(
        "registration-tax-type\\/1\\?waypoints\\=check-tax-details-1\\%2Cchange-your-registration"
      )
      registration.checkJourneyUrl(
        "registration-tax-type/1?waypoints=check-tax-details-1%2Cchange-your-registration"
      )
      registration.answerRegistrationType("Tax ID number")
      registration.checkJourneyUrl(
        "eu-tax-identification-number/1?waypoints=check-tax-details-1%2Cchange-your-registration"
      )
      registration.enterAnswer("NEW123")
      registration.checkJourneyUrl("check-tax-details/1?waypoints=change-your-registration")
      registration.continue()

      Then("the intermediary can remove an existing fixed establishment")
      registration.checkJourneyUrl("add-tax-details?waypoints=change-your-registration")
      registration.selectChangeOrRemoveLink(
        "remove-tax-details\\/2\\?waypoints\\=change-your-registration"
      )
      registration.checkJourneyUrl(
        "remove-tax-details/2?waypoints=change-your-registration"
      )
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("add-tax-details?waypoints=change-your-registration")
      registration.answerRadioButton("no")

      And("the intermediary is on the change-your-registration page")
      registration.checkJourneyUrl("change-your-registration")
      amendRegistration.checkIossNumber("IM9001144771")
    }

    Scenario("Intermediary can remove all fixed establishments in a NETP registration - yes to no") {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "ukBasedUkVrn")
      registration.checkJourneyUrl("change-your-registration")
      amendRegistration.checkIossNumber("IM9001144771")

      When("the intermediary clicks change for Fixed establishments in other countries")
      registration.selectChangeOrRemoveLink(
        "eu-fixed-establishment\\?waypoints\\=change-your-registration"
      )

      Then("the intermediary answers no on the eu-fixed-establishment page")
      registration.checkJourneyUrl("eu-fixed-establishment?waypoints=change-your-registration")
      registration.answerRadioButton("no")

      And("the intermediary answers yes on the remove-all-tax-details page")
      registration.checkJourneyUrl("remove-all-tax-details?waypoints=change-your-registration")
      registration.answerRadioButton("yes")

      And("the intermediary is on the change-your-registration page")
      registration.checkJourneyUrl("change-your-registration")
      amendRegistration.checkIossNumber("IM9001144771")
    }

    Scenario("Intermediary can add fixed establishments in a NETP registration - no to yes") {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "minimalAmend")
      registration.checkJourneyUrl("change-your-registration")
      amendRegistration.checkIossNumber("IM9001144881")

      When("the intermediary clicks change for Fixed establishments in other countries")
      registration.selectChangeOrRemoveLink(
        "eu-fixed-establishment\\?waypoints\\=change-your-registration"
      )

      Then("the intermediary answers yes on the eu-fixed-establishment page")
      registration.checkJourneyUrl("eu-fixed-establishment?waypoints=change-your-registration")
      registration.answerRadioButton("yes")

      And(
        "the intermediary selects which country their fixed establishment is in on the vat-registered-eu-country page"
      )
      registration.checkJourneyUrl("vat-registered-eu-country/1?waypoints=change-your-registration")
      registration.selectCountry("Sweden")

      And("the intermediary enters the fixed establishment details on the trading-name-business-address page")
      registration.checkJourneyUrl("trading-name-business-address/1?waypoints=change-your-registration")
      registration.enterFETradingName("Swedish Company")
      registration.enterAddress("123 Street Name", "", "Town", "", "SE123456")

      And("the intermediary selects the VAT Number registration type on the registration-tax-type page")
      registration.checkJourneyUrl("registration-tax-type/1?waypoints=change-your-registration")
      registration.answerRegistrationType("VAT number")

      And("the intermediary enters the VAT number on the eu-vat-number page")
      registration.checkJourneyUrl("eu-vat-number/1?waypoints=change-your-registration")
      registration.enterAnswer("SE012345678987")

      And("the intermediary continues through the check-tax-details page")
      registration.checkJourneyUrl("check-tax-details/1?waypoints=change-your-registration")
      registration.continue()

      Then("the intermediary selects yes on the add-tax-details page")
      registration.checkJourneyUrl("add-tax-details?waypoints=change-your-registration")
      registration.answerRadioButton("yes")

      And(
        "the intermediary selects which country their fixed establishment is in on the vat-registered-eu-country page"
      )
      registration.checkJourneyUrl("vat-registered-eu-country/2?waypoints=change-your-registration")
      registration.selectCountry("Romania")

      And("the intermediary enters the fixed establishment details on the trading-name-business-address page")
      registration.checkJourneyUrl("trading-name-business-address/2?waypoints=change-your-registration")
      registration.enterFETradingName("Romanian Company")
      registration.enterAddress("1 Road Name", "Suburb", "City", "Region-Name", "")

      And("the intermediary selects the Tax ID number registration type on the registration-tax-type page")
      registration.checkJourneyUrl("registration-tax-type/2?waypoints=change-your-registration")
      registration.answerRegistrationType("Tax ID number")

      And("the intermediary enters the Tax ID number on the eu-tax-identification-number page")
      registration.checkJourneyUrl("eu-tax-identification-number/2?waypoints=change-your-registration")
      registration.enterAnswer("R1 665544")

      And("the intermediary continues through the check-tax-details page")
      registration.checkJourneyUrl("check-tax-details/2?waypoints=change-your-registration")
      registration.continue()

      Then("the intermediary selects no on the add-tax-details page")
      registration.checkJourneyUrl("add-tax-details?waypoints=change-your-registration")
      registration.answerRadioButton("no")

      And("the intermediary is on the change-your-registration page")
      registration.checkJourneyUrl("change-your-registration")
      amendRegistration.checkIossNumber("IM9001144881")
    }

    Scenario("Intermediary can amend existing website details in a NETP registration") {

      Given("the intermediary accesses the IOSS NETP Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "minimalAmend")
      registration.checkJourneyUrl("change-your-registration")
      amendRegistration.checkIossNumber("IM9001144881")

      When("the intermediary clicks change for Trading websites")
      registration.selectChangeOrRemoveLink(
        "add-website-address\\?waypoints\\=change-your-registration"
      )

      Then("the intermediary can update their second website")
      registration.checkJourneyUrl("add-website-address?waypoints=change-your-registration")
      registration.selectChangeOrRemoveLink(
        "website-address\\/2\\?waypoints\\=change-add-website-address\\%2Cchange-your-registration"
      )
      registration.checkJourneyUrl("website-address/2?waypoints=change-add-website-address%2Cchange-your-registration")
      registration.enterAnswer("https://updatedwebsite.co")
      registration.checkJourneyUrl("add-website-address?waypoints=change-your-registration")

      And("the intermediary can remove their first website")
      registration.selectChangeOrRemoveLink(
        "remove-website-address\\/1\\?waypoints\\=change-your-registration"
      )
      registration.checkJourneyUrl("remove-website-address/1?waypoints=change-your-registration")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("add-website-address?waypoints=change-your-registration")
      registration.answerRadioButton("no")

      And("the intermediary is on the change-your-registration page")
      registration.checkJourneyUrl("change-your-registration")
      amendRegistration.checkIossNumber("IM9001144881")
    }
  }
}
