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

package uk.gov.hmrc.ui.data

import java.time.LocalDate

object PendingRegistration {
  val yesterday = LocalDate.now().minusDays(1)

  val data: List[String] =
    List(
      s"""
        |{
        |  "_id": {
        |    "$$oid": "68b6f0801ca3d6d1c1bade84"
        |  },
        |  "journeyId": "4aa0d14f-4737-45a6-a3b4-051c95cc8cfe",
        |  "uniqueUrlCode": "BRJRZF",
        |  "data": "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",
        |  "lastUpdated": {
        |    "$$date": "${yesterday}T13:26:24.550Z"
        |  },
        |  "uniqueActivationCode": "b2OBU6fosDFRW1YPVUVPSt2NxsCNDEM4HYA/OdsquYylBuOO4rQ=",
        |  "intermediaryDetails": {
        |    "intermediaryNumber": "IN9001112223",
        |    "intermediaryName": "Intermediary Company Name"
        |  }
        |}
        |""".stripMargin
    )
}
