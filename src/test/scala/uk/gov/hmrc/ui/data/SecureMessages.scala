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

object SecureMessages {
  val yesterday  = LocalDate.now().minusDays(1)
  val twoDaysAgo = LocalDate.now().minusDays(2)

  val data: List[String] =
    List(
      """
        |{
        |  "_id": {
        |    "$oid": "69246e3fcebde6006211a37d"
        |  },
        |  "externalRef": {
        |    "id": "AJD181061218716662285",
        |    "source": "gmc"
        |  },
        |  "recipient": {
        |    "regime": "ioss",
        |    "identifier": {
        |      "name": "HMRC-IOSS-NETP",
        |      "value": "IM9001144771"
        |    },
        |    "email": "test@mail.com"
        |  },
        |  "messageType": "mailout-batch",
        |  "validFrom": {
        |    "$date": "2025-11-24T00:00:00.000Z"
        |  },
        |  "content": [
        |    {
        |      "lang": "en",
        |      "subject": "Import One Stop Shop (IOSS)",
        |      "body": "test email - unique ID 888157739986447684"
        |    }
        |  ],
        |  "alertDetails": {
        |    "templateId": "new_message_alert_ioss_netp",
        |    "recipientName": {
        |      "line1": "Bob",
        |      "line2": "Jones"
        |    },
        |    "data": {
        |      "email": "test@mail.com",
        |      "issueDate": "2025-11-24",
        |      "language": "en",
        |      "subject": "Import One Stop Shop (IOSS)"
        |    }
        |  },
        |  "details": {
        |    "formId": "M08aGIOSS",
        |    "sourceData": "test-source-data",
        |    "batchId": "IOSSMessage"
        |  },
        |  "emailAddress": "test@mail.com",
        |  "hash": "eOrAhGTaOcGXAWzQADrSC9HGf5akewkIhHuO7fHmG/o=",
        |  "status": "deferred",
        |  "verificationBrake": false
        |}
        |""".stripMargin,
      """
        |{
        |  "_id": {
        |    "$oid": "69246e3fcebde6006211a37e"
        |  },
        |  "externalRef": {
        |    "id": "AJD780534887615573644",
        |    "source": "gmc"
        |  },
        |  "recipient": {
        |    "regime": "ioss",
        |    "identifier": {
        |      "name": "HMRC-IOSS-NETP",
        |      "value": "IM9001144771"
        |    },
        |    "email": "test@mail.com"
        |  },
        |  "messageType": "mailout-batch",
        |  "validFrom": {
        |    "$date": "2025-11-24T00:00:00.000Z"
        |  },
        |  "content": [
        |    {
        |      "lang": "en",
        |      "subject": "Import One Stop Shop (IOSS)",
        |      "body": "test email - unique ID 256419182537714058"
        |    }
        |  ],
        |  "alertDetails": {
        |    "templateId": "new_message_alert_ioss_netp",
        |    "recipientName": {
        |      "line1": "Bob",
        |      "line2": "Jones"
        |    },
        |    "data": {
        |      "email": "test@mail.com",
        |      "issueDate": "2025-11-24",
        |      "language": "en",
        |      "subject": "Import One Stop Shop (IOSS)"
        |    }
        |  },
        |  "details": {
        |    "formId": "M08aGIOSS",
        |    "sourceData": "test-source-data",
        |    "batchId": "IOSSMessage"
        |  },
        |  "emailAddress": "test@mail.com",
        |  "hash": "A9RRV8/ekp7oNVxs+00IWfSv21Qr2cL6GKyshhjad+o=",
        |  "status": "deferred",
        |  "verificationBrake": false,
        |  "readTime": {
        |    "$date": "2025-11-24T17:17:45.618Z"
        |  }
        |}
        |""".stripMargin,
      """
        |{
        |  "_id": {
        |    "$oid": "692484b1cebde6006211a37f"
        |  },
        |  "externalRef": {
        |    "id": "AJD145909658771934790",
        |    "source": "gmc"
        |  },
        |  "recipient": {
        |    "regime": "ioss",
        |    "identifier": {
        |      "name": "HMRC-IOSS-NETP",
        |      "value": "IM9001144773"
        |    },
        |    "email": "test@mail.com"
        |  },
        |  "messageType": "mailout-batch",
        |  "validFrom": {
        |    "$date": "2025-11-24T00:00:00.000Z"
        |  },
        |  "content": [
        |    {
        |      "lang": "en",
        |      "subject": "Import One Stop Shop (IOSS)",
        |      "body": "test email - unique ID 191561492504837935"
        |    }
        |  ],
        |  "alertDetails": {
        |    "templateId": "new_message_alert_ioss_netp",
        |    "recipientName": {
        |      "line1": "Bob",
        |      "line2": "Jones"
        |    },
        |    "data": {
        |      "email": "test@mail.com",
        |      "issueDate": "2025-11-24",
        |      "language": "en",
        |      "subject": "Import One Stop Shop (IOSS)"
        |    }
        |  },
        |  "details": {
        |    "formId": "M08aGIOSS",
        |    "sourceData": "test-source-data",
        |    "batchId": "IOSSMessage"
        |  },
        |  "emailAddress": "test@mail.com",
        |  "hash": "MGFyW5hLbJjH3Vg/3+iVgfgyf3S6a18Sz4aL7uq3q9E=",
        |  "status": "deferred",
        |  "verificationBrake": false
        |}
        |""".stripMargin,
      """
        |{
        |  "_id": {
        |    "$oid": "692484b6cebde6006211a380"
        |  },
        |  "externalRef": {
        |    "id": "AJD552635945595982579",
        |    "source": "gmc"
        |  },
        |  "recipient": {
        |    "regime": "ioss",
        |    "identifier": {
        |      "name": "HMRC-IOSS-NETP",
        |      "value": "IM9001144778"
        |    },
        |    "email": "test@mail.com"
        |  },
        |  "messageType": "mailout-batch",
        |  "validFrom": {
        |    "$date": "2025-11-24T00:00:00.000Z"
        |  },
        |  "content": [
        |    {
        |      "lang": "en",
        |      "subject": "Import One Stop Shop (IOSS)",
        |      "body": "test email - unique ID 260084776616468190"
        |    }
        |  ],
        |  "alertDetails": {
        |    "templateId": "new_message_alert_ioss_netp",
        |    "recipientName": {
        |      "line1": "Bob",
        |      "line2": "Jones"
        |    },
        |    "data": {
        |      "email": "test@mail.com",
        |      "issueDate": "2025-11-24",
        |      "language": "en",
        |      "subject": "Import One Stop Shop (IOSS)"
        |    }
        |  },
        |  "details": {
        |    "formId": "M08aGIOSS",
        |    "sourceData": "test-source-data",
        |    "batchId": "IOSSMessage"
        |  },
        |  "emailAddress": "test@mail.com",
        |  "hash": "ahiGMku9oIUWuYv+3PstIdMa6hGVImsg9tmmbsepjGg=",
        |  "status": "deferred",
        |  "verificationBrake": false
        |}
        |""".stripMargin,
      """
        |{
        |  "_id": {
        |    "$oid": "692484bacebde6006211a381"
        |  },
        |  "externalRef": {
        |    "id": "AJD365401524631857065",
        |    "source": "gmc"
        |  },
        |  "recipient": {
        |    "regime": "ioss",
        |    "identifier": {
        |      "name": "HMRC-IOSS-NETP",
        |      "value": "IM9001144777"
        |    },
        |    "email": "test@mail.com"
        |  },
        |  "messageType": "mailout-batch",
        |  "validFrom": {
        |    "$date": "2025-11-24T00:00:00.000Z"
        |  },
        |  "content": [
        |    {
        |      "lang": "en",
        |      "subject": "Import One Stop Shop (IOSS)",
        |      "body": "test email - unique ID 646454626047628365"
        |    }
        |  ],
        |  "alertDetails": {
        |    "templateId": "new_message_alert_ioss_netp",
        |    "recipientName": {
        |      "line1": "Bob",
        |      "line2": "Jones"
        |    },
        |    "data": {
        |      "email": "test@mail.com",
        |      "issueDate": "2025-11-24",
        |      "language": "en",
        |      "subject": "Import One Stop Shop (IOSS)"
        |    }
        |  },
        |  "details": {
        |    "formId": "M08aGIOSS",
        |    "sourceData": "test-source-data",
        |    "batchId": "IOSSMessage"
        |  },
        |  "emailAddress": "test@mail.com",
        |  "hash": "bjSUBOgwWw1eEgnhoPKViRzAvPRVY4NS3/kg7IUBRbY=",
        |  "status": "deferred",
        |  "verificationBrake": false
        |}
        |""".stripMargin,
      """
        |{
        |  "_id": {
        |    "$oid": "692484bdcebde6006211a382"
        |  },
        |  "externalRef": {
        |    "id": "AJD188578214805874919",
        |    "source": "gmc"
        |  },
        |  "recipient": {
        |    "regime": "ioss",
        |    "identifier": {
        |      "name": "HMRC-IOSS-NETP",
        |      "value": "IM9001144775"
        |    },
        |    "email": "test@mail.com"
        |  },
        |  "messageType": "mailout-batch",
        |  "validFrom": {
        |    "$date": "2025-11-24T00:00:00.000Z"
        |  },
        |  "content": [
        |    {
        |      "lang": "en",
        |      "subject": "Import One Stop Shop (IOSS)",
        |      "body": "test email - unique ID 668183357912841584"
        |    }
        |  ],
        |  "alertDetails": {
        |    "templateId": "new_message_alert_ioss_netp",
        |    "recipientName": {
        |      "line1": "Bob",
        |      "line2": "Jones"
        |    },
        |    "data": {
        |      "email": "test@mail.com",
        |      "issueDate": "2025-11-24",
        |      "language": "en",
        |      "subject": "Import One Stop Shop (IOSS)"
        |    }
        |  },
        |  "details": {
        |    "formId": "M08aGIOSS",
        |    "sourceData": "test-source-data",
        |    "batchId": "IOSSMessage"
        |  },
        |  "emailAddress": "test@mail.com",
        |  "hash": "SIHzVo5/Ug0Hv4liLvTZH7lfWvF7KiTbtkWp6umVGxI=",
        |  "status": "deferred",
        |  "verificationBrake": false
        |}
        |""".stripMargin,
      """
        |{
        |  "_id": {
        |    "$oid": "692484c4cebde6006211a383"
        |  },
        |  "externalRef": {
        |    "id": "AJD193870787310220192",
        |    "source": "gmc"
        |  },
        |  "recipient": {
        |    "regime": "ioss",
        |    "identifier": {
        |      "name": "HMRC-IOSS-NETP",
        |      "value": "IM9001144881"
        |    },
        |    "email": "test@mail.com"
        |  },
        |  "messageType": "mailout-batch",
        |  "validFrom": {
        |    "$date": "2025-11-24T00:00:00.000Z"
        |  },
        |  "content": [
        |    {
        |      "lang": "en",
        |      "subject": "Import One Stop Shop (IOSS)",
        |      "body": "test email - unique ID 720751826372567126"
        |    }
        |  ],
        |  "alertDetails": {
        |    "templateId": "new_message_alert_ioss_netp",
        |    "recipientName": {
        |      "line1": "Bob",
        |      "line2": "Jones"
        |    },
        |    "data": {
        |      "email": "test@mail.com",
        |      "issueDate": "2025-11-24",
        |      "language": "en",
        |      "subject": "Import One Stop Shop (IOSS)"
        |    }
        |  },
        |  "details": {
        |    "formId": "M08aGIOSS",
        |    "sourceData": "test-source-data",
        |    "batchId": "IOSSMessage"
        |  },
        |  "emailAddress": "test@mail.com",
        |  "hash": "jblmljhKR9wznR6ozUk/1256WVc2ooHqK4v1gw1dAM0=",
        |  "status": "deferred",
        |  "verificationBrake": false
        |}
        |""".stripMargin
    )
}
