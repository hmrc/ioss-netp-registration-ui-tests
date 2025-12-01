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
       {
        |  "_id": {
        |    "$oid": "692d754281096a36213f1576"
        |  },
        |  "externalRef": {
        |    "id": "AJD532671479477964534",
        |    "source": "gmc"
        |  },
        |  "recipient": {
        |    "regime": "ioss",
        |    "identifier": {
        |      "name": "HMRC-IOSS-NETP",
        |      "value": "IM9001144771"
        |    },
        |    "email": "test@test.com"
        |  },
        |  "messageType": "mailout-batch",
        |  "validFrom": {
        |    "$date": "2025-12-01T00:00:00.000Z"
        |  },
        |  "content": [
        |    {
        |      "lang": "en",
        |      "subject": "Your intermediary has removed you from the VAT IOSS scheme",
        |      "body": "PHAgY2xhc3M9ImdvdnVrLWJvZHkiPllvdXIgaW50ZXJtZWRpYXJ5IGFza2VkIHVzIHRvIHJlbW92ZSB5b3VyIGJ1c2luZXNzIGZyb20gdGhlIFZBVCBJbXBvcnQgT25lIFN0b3AgU2hvcCAoSU9TUykgc2NoZW1lLjwvcD4NCjxwIGNsYXNzPSJnb3Z1ay1ib2R5Ij5UaGlzIG1lYW5zIHRoZXkgd2lsbCBubyBsb25nZXIgbWFuYWdlIHlvdXIgSU9TUyBWQVQgUmV0dXJucyBvciBwYXltZW50cy48L3A+DQo8cCBjbGFzcz0iZ292dWstYm9keSI+WW91ciBpbnRlcm1lZGlhcnkgbXVzdCBjb21wbGV0ZSBhbnkgb3V0c3RhbmRpbmcgSU9TUyBWQVQgUmV0dXJucyBmb3IgeW91IGFuZCBhIGZpbmFsIHJldHVybiBmb3IgSmFudWFyeSAyMDI0LjwvcD4NCjxwIGNsYXNzPSJnb3Z1ay1ib2R5Ij5Zb3VyIElPU1MgbnVtYmVyIGlzOiBJTTkwMDExNDQ3NzE8L3A+"
        |    }
        |  ],
        |  "alertDetails": {
        |    "templateId": "new_message_alert_ioss_netp",
        |    "recipientName": {
        |      "line1": "Test",
        |      "line2": "Test"
        |    },
        |    "data": {
        |      "email": "test@test.com",
        |      "issueDate": "2025-12-01",
        |      "language": "en",
        |      "subject": "Your intermediary has removed you from the VAT IOSS scheme"
        |    }
        |  },
        |  "details": {
        |    "formId": "M08aGIOSS",
        |    "sourceData": "test-source-data",
        |    "batchId": "IOSSMessage"
        |  },
        |  "emailAddress": "test@test.com",
        |  "hash": "ZL4eQV5PaPvU/FW9mZVqa8hGNXZRJnaldu04nhBMZ2U=",
        |  "status": "deferred",
        |  "verificationBrake": false
        |}
        |""".stripMargin,
      """
        |{
        |  "_id": {
        |    "$oid": "692d7a4a81096a36213f1577"
        |  },
        |  "externalRef": {
        |    "id": "AJD111907242490479434",
        |    "source": "gmc"
        |  },
        |  "recipient": {
        |    "regime": "ioss",
        |    "identifier": {
        |      "name": "HMRC-IOSS-NETP",
        |      "value": "IM9001144773"
        |    },
        |    "email": "test@test.com"
        |  },
        |  "messageType": "mailout-batch",
        |  "validFrom": {
        |    "$date": "2025-12-01T00:00:00.000Z"
        |  },
        |  "content": [
        |    {
        |      "lang": "en",
        |      "subject": "We have excluded you from the VAT IOSS scheme",
        |      "body": "PHAgY2xhc3M9ImdvdnVrLWJvZHkiPldlIGhhdmUgZXhjbHVkZWQgeW91ciBidXNpbmVzcyBmcm9tIHRoZSBWQVQgSW1wb3J0IE9uZSBTdG9wIFNob3AgKElPU1MpIHNjaGVtZSwgYmVjYXVzZSB5b3UgaGF2ZSBub3QgY29tcGxpZWQgd2l0aCB0aGUgcnVsZXMuPC9wPg0KPHAgY2xhc3M9ImdvdnVrLWJvZHktbCI+WW91ciBidXNpbmVzcyB3aWxsIG5vdCBiZSBhYmxlIHRvIHVzZSBvciBqb2luIGFueSBPbmUgU3RvcCBTaG9wIHNjaGVtZXMgaW4gdGhlIFVLIG9yIHRoZSBFVSB1bnRpbCAyOSBKYW51YXJ5IDIwMjQuIDwvcD4NCjxwIGNsYXNzPSJnb3Z1ay1ib2R5Ij5Zb3VyIGludGVybWVkaWFyeSBtdXN0IGNvbXBsZXRlIGFueSBvdXRzdGFuZGluZyBJT1NTIFZBVCBSZXR1cm5zIGZvciB5b3UgYW5kIGEgZmluYWwgcmV0dXJuIGZvciBKYW51YXJ5IDIwMjQuIDwvcD4NCjxoMiBjbGFzcz0iZ292dWstaGVhZGluZy1sIj5XaGF0IHRvIGRvIGlmIHlvdSBkaXNhZ3JlZSA8L2gyPg0KPHAgY2xhc3M9ImdvdnVrLWJvZHkiPllvdSBjYW4gZWl0aGVyOiA8L3A+DQo8dWwgY2xhc3M9Imxpc3QgbGlzdC1idWxsZXQgZ292dWstbGlzdCBnb3Z1ay1saXN0LS1idWxsZXQiPg0KPGxpPmFzayBmb3IgYSByZXZpZXcgb3IgPC9saT4NCjxsaT5hcHBlYWwgdG8gYW4gaW5kZXBlbmRlbnQgdHJpYnVuYWwgPC9saT4NCjwvdWw+DQo8cCBjbGFzcz0iZ292dWstYm9keSI+WW91IG11c3QgZG8gdGhpcyBieSAyOSBKYW51YXJ5IDIwMjQuIDwvcD4NCjxwIGNsYXNzPSJnb3Z1ay1ib2R5Ij5JZiB5b3UgYXBwZWFsIHRvIGEgdHJpYnVuYWwsIHlvdSBjYW5ub3QgYXNrIGZvciBhIHJldmlldy4gPC9wPg0KPHAgY2xhc3M9ImdvdnVrLWJvZHkiPllvdSBtYXkgYmUgYWJsZSB0byByZXNvbHZlIG1vc3QgZGlzcHV0ZXMgYnkgYSByZXZpZXcsIHdpdGhvdXQgdGhlIG5lZWQgZm9yIGEgdHJpYnVuYWwuIEl0IG1heSBhbHNvIGJlIHF1aWNrZXIgYW5kIGxlc3MgZXhwZW5zaXZlLjwvcD4NCjxwIGNsYXNzPSJnb3Z1ay1ib2R5Ij48YSBocmVmPSJodHRwczovL3d3dy5nb3YudWsvdGF4LWFwcGVhbHMiIGNsYXNzPSJnb3Z1ay1saW5rIiB0YXJnZXQ9IlxfYmxhbmsiPk1vcmUgaW5mb3JtYXRpb24gYWJvdXQgeW91ciBhcHBlYWwgYW5kIHJldmlldyByaWdodHMgKG9wZW5zIGluIGEgbmV3IHRhYik8L2E+PC9wPg0KPHAgY2xhc3M9ImdvdnVrLWJvZHkiPllvdSBjYW4gYXNrIGZvciBhIGNvcHkgYnkgY2FsbGluZyAwMzAwIDIwMCAzNjEwLiA8L3A+DQo8cCBjbGFzcz0iZ292dWstYm9keSI+SWYgeW91IGJlbGlldmUgdGhpcyBpcyBhbiBlcnJvciwgY29udGFjdCB5b3VyIGludGVybWVkaWFyeS4gWW91ciBJT1NTIG51bWJlciBpczogSU05MDAxMTQ0NzczPC9wPg=="
        |    }
        |  ],
        |  "alertDetails": {
        |    "templateId": "new_message_alert_ioss_netp",
        |    "recipientName": {
        |      "line1": "Test",
        |      "line2": "Test"
        |    },
        |    "data": {
        |      "email": "test@test.com",
        |      "issueDate": "2025-12-01",
        |      "language": "en",
        |      "subject": "We have excluded you from the VAT IOSS scheme"
        |    }
        |  },
        |  "details": {
        |    "formId": "M08aGIOSS",
        |    "sourceData": "test-source-data",
        |    "batchId": "IOSSMessage"
        |  },
        |  "emailAddress": "test@test.com",
        |  "hash": "rxZlHehk9iXEIrUGuAWK45M8Flqc7HSe9FSLYLl6fQ4=",
        |  "status": "deferred",
        |  "verificationBrake": false
        |}
        |""".stripMargin,
      """
        |{
        |  "_id": {
        |    "$oid": "692d7ace81096a36213f1578"
        |  },
        |  "externalRef": {
        |    "id": "AJD679251823031855574",
        |    "source": "gmc"
        |  },
        |  "recipient": {
        |    "regime": "ioss",
        |    "identifier": {
        |      "name": "HMRC-IOSS-NETP",
        |      "value": "IM9001144778"
        |    },
        |    "email": "test@test.com"
        |  },
        |  "messageType": "mailout-batch",
        |  "validFrom": {
        |    "$date": "2025-12-01T00:00:00.000Z"
        |  },
        |  "content": [
        |    {
        |      "lang": "en",
        |      "subject": "We have excluded you from the VAT IOSS scheme",
        |      "body": "PHAgY2xhc3M9ImdvdnVrLWJvZHkiPldlIGhhdmUgZXhjbHVkZWQgeW91ciBidXNpbmVzcyBmcm9tIHRoZSBWQVQgSW1wb3J0IE9uZSBTdG9wIFNob3AgKElPU1MpIHNjaGVtZSwgYmVjYXVzZSB5b3UgaGF2ZSBub3QgY29tcGxpZWQgd2l0aCB0aGUgcnVsZXMuPC9wPg0KPHAgY2xhc3M9ImdvdnVrLWJvZHktbCI+WW91ciBidXNpbmVzcyB3aWxsIG5vdCBiZSBhYmxlIHRvIHVzZSBvciBqb2luIGFueSBPbmUgU3RvcCBTaG9wIHNjaGVtZXMgaW4gdGhlIFVLIG9yIHRoZSBFVSB1bnRpbCAyOSBKYW51YXJ5IDIwMjQuIDwvcD4NCjxwIGNsYXNzPSJnb3Z1ay1ib2R5Ij5Zb3VyIGludGVybWVkaWFyeSBtdXN0IGNvbXBsZXRlIGFueSBvdXRzdGFuZGluZyBJT1NTIFZBVCBSZXR1cm5zIGZvciB5b3UgYW5kIGEgZmluYWwgcmV0dXJuIGZvciBKYW51YXJ5IDIwMjQuIDwvcD4NCjxoMiBjbGFzcz0iZ292dWstaGVhZGluZy1sIj5XaGF0IHRvIGRvIGlmIHlvdSBkaXNhZ3JlZSA8L2gyPg0KPHAgY2xhc3M9ImdvdnVrLWJvZHkiPllvdSBjYW4gZWl0aGVyOiA8L3A+DQo8dWwgY2xhc3M9Imxpc3QgbGlzdC1idWxsZXQgZ292dWstbGlzdCBnb3Z1ay1saXN0LS1idWxsZXQiPg0KPGxpPmFzayBmb3IgYSByZXZpZXcgb3IgPC9saT4NCjxsaT5hcHBlYWwgdG8gYW4gaW5kZXBlbmRlbnQgdHJpYnVuYWwgPC9saT4NCjwvdWw+DQo8cCBjbGFzcz0iZ292dWstYm9keSI+WW91IG11c3QgZG8gdGhpcyBieSAyOSBKYW51YXJ5IDIwMjQuIDwvcD4NCjxwIGNsYXNzPSJnb3Z1ay1ib2R5Ij5JZiB5b3UgYXBwZWFsIHRvIGEgdHJpYnVuYWwsIHlvdSBjYW5ub3QgYXNrIGZvciBhIHJldmlldy4gPC9wPg0KPHAgY2xhc3M9ImdvdnVrLWJvZHkiPllvdSBtYXkgYmUgYWJsZSB0byByZXNvbHZlIG1vc3QgZGlzcHV0ZXMgYnkgYSByZXZpZXcsIHdpdGhvdXQgdGhlIG5lZWQgZm9yIGEgdHJpYnVuYWwuIEl0IG1heSBhbHNvIGJlIHF1aWNrZXIgYW5kIGxlc3MgZXhwZW5zaXZlLjwvcD4NCjxwIGNsYXNzPSJnb3Z1ay1ib2R5Ij48YSBocmVmPSJodHRwczovL3d3dy5nb3YudWsvdGF4LWFwcGVhbHMiIGNsYXNzPSJnb3Z1ay1saW5rIiB0YXJnZXQ9IlxfYmxhbmsiPk1vcmUgaW5mb3JtYXRpb24gYWJvdXQgeW91ciBhcHBlYWwgYW5kIHJldmlldyByaWdodHMgKG9wZW5zIGluIGEgbmV3IHRhYik8L2E+PC9wPg0KPHAgY2xhc3M9ImdvdnVrLWJvZHkiPllvdSBjYW4gYXNrIGZvciBhIGNvcHkgYnkgY2FsbGluZyAwMzAwIDIwMCAzNjEwLiA8L3A+DQo8cCBjbGFzcz0iZ292dWstYm9keSI+SWYgeW91IGJlbGlldmUgdGhpcyBpcyBhbiBlcnJvciwgY29udGFjdCB5b3VyIGludGVybWVkaWFyeS4gWW91ciBJT1NTIG51bWJlciBpczogSU05MDAxMTQ0Nzc4PC9wPg=="
        |    }
        |  ],
        |  "alertDetails": {
        |    "templateId": "new_message_alert_ioss_netp",
        |    "recipientName": {
        |      "line1": "Test",
        |      "line2": "Test"
        |    },
        |    "data": {
        |      "email": "test@test.com",
        |      "issueDate": "2025-12-01",
        |      "language": "en",
        |      "subject": "We have excluded you from the VAT IOSS scheme"
        |    }
        |  },
        |  "details": {
        |    "formId": "M08aGIOSS",
        |    "sourceData": "test-source-data",
        |    "batchId": "IOSSMessage"
        |  },
        |  "emailAddress": "test@test.com",
        |  "hash": "OOHig0jL0ZOsfwmt1do3cuPZX1RRWRTjlqvOUhYibEw=",
        |  "status": "deferred",
        |  "verificationBrake": false
        |}
        |""".stripMargin,
      """
        |{
        |  "_id": {
        |    "$oid": "692d7ad981096a36213f1579"
        |  },
        |  "externalRef": {
        |    "id": "AJD748918736735882122",
        |    "source": "gmc"
        |  },
        |  "recipient": {
        |    "regime": "ioss",
        |    "identifier": {
        |      "name": "HMRC-IOSS-NETP",
        |      "value": "IM9001144777"
        |    },
        |    "email": "test@test.com"
        |  },
        |  "messageType": "mailout-batch",
        |  "validFrom": {
        |    "$date": "2025-12-01T00:00:00.000Z"
        |  },
        |  "content": [
        |    {
        |      "lang": "en",
        |      "subject": "We have excluded you from the VAT IOSS scheme",
        |      "body": "PHAgY2xhc3M9ImdvdnVrLWJvZHkiPldlIGhhdmUgZXhjbHVkZWQgeW91ciBidXNpbmVzcyBmcm9tIHRoZSBWQVQgSW1wb3J0IE9uZSBTdG9wIFNob3AgKElPU1MpIHNjaGVtZSwgYmVjYXVzZSB5b3UgaGF2ZSBub3QgY29tcGxpZWQgd2l0aCB0aGUgcnVsZXMuPC9wPg0KPHAgY2xhc3M9ImdvdnVrLWJvZHktbCI+WW91ciBidXNpbmVzcyB3aWxsIG5vdCBiZSBhYmxlIHRvIHVzZSBvciBqb2luIGFueSBPbmUgU3RvcCBTaG9wIHNjaGVtZXMgaW4gdGhlIFVLIG9yIHRoZSBFVSB1bnRpbCAyOSBKYW51YXJ5IDIwMjQuIDwvcD4NCjxwIGNsYXNzPSJnb3Z1ay1ib2R5Ij5Zb3VyIGludGVybWVkaWFyeSBtdXN0IGNvbXBsZXRlIGFueSBvdXRzdGFuZGluZyBJT1NTIFZBVCBSZXR1cm5zIGZvciB5b3UgYW5kIGEgZmluYWwgcmV0dXJuIGZvciBKYW51YXJ5IDIwMjQuIDwvcD4NCjxoMiBjbGFzcz0iZ292dWstaGVhZGluZy1sIj5XaGF0IHRvIGRvIGlmIHlvdSBkaXNhZ3JlZSA8L2gyPg0KPHAgY2xhc3M9ImdvdnVrLWJvZHkiPllvdSBjYW4gZWl0aGVyOiA8L3A+DQo8dWwgY2xhc3M9Imxpc3QgbGlzdC1idWxsZXQgZ292dWstbGlzdCBnb3Z1ay1saXN0LS1idWxsZXQiPg0KPGxpPmFzayBmb3IgYSByZXZpZXcgb3IgPC9saT4NCjxsaT5hcHBlYWwgdG8gYW4gaW5kZXBlbmRlbnQgdHJpYnVuYWwgPC9saT4NCjwvdWw+DQo8cCBjbGFzcz0iZ292dWstYm9keSI+WW91IG11c3QgZG8gdGhpcyBieSAyOSBKYW51YXJ5IDIwMjQuIDwvcD4NCjxwIGNsYXNzPSJnb3Z1ay1ib2R5Ij5JZiB5b3UgYXBwZWFsIHRvIGEgdHJpYnVuYWwsIHlvdSBjYW5ub3QgYXNrIGZvciBhIHJldmlldy4gPC9wPg0KPHAgY2xhc3M9ImdvdnVrLWJvZHkiPllvdSBtYXkgYmUgYWJsZSB0byByZXNvbHZlIG1vc3QgZGlzcHV0ZXMgYnkgYSByZXZpZXcsIHdpdGhvdXQgdGhlIG5lZWQgZm9yIGEgdHJpYnVuYWwuIEl0IG1heSBhbHNvIGJlIHF1aWNrZXIgYW5kIGxlc3MgZXhwZW5zaXZlLjwvcD4NCjxwIGNsYXNzPSJnb3Z1ay1ib2R5Ij48YSBocmVmPSJodHRwczovL3d3dy5nb3YudWsvdGF4LWFwcGVhbHMiIGNsYXNzPSJnb3Z1ay1saW5rIiB0YXJnZXQ9IlxfYmxhbmsiPk1vcmUgaW5mb3JtYXRpb24gYWJvdXQgeW91ciBhcHBlYWwgYW5kIHJldmlldyByaWdodHMgKG9wZW5zIGluIGEgbmV3IHRhYik8L2E+PC9wPg0KPHAgY2xhc3M9ImdvdnVrLWJvZHkiPllvdSBjYW4gYXNrIGZvciBhIGNvcHkgYnkgY2FsbGluZyAwMzAwIDIwMCAzNjEwLiA8L3A+DQo8cCBjbGFzcz0iZ292dWstYm9keSI+SWYgeW91IGJlbGlldmUgdGhpcyBpcyBhbiBlcnJvciwgY29udGFjdCB5b3VyIGludGVybWVkaWFyeS4gWW91ciBJT1NTIG51bWJlciBpczogSU05MDAxMTQ0Nzc3PC9wPg=="
        |    }
        |  ],
        |  "alertDetails": {
        |    "templateId": "new_message_alert_ioss_netp",
        |    "recipientName": {
        |      "line1": "Test",
        |      "line2": "Test"
        |    },
        |    "data": {
        |      "email": "test@test.com",
        |      "issueDate": "2025-12-01",
        |      "language": "en",
        |      "subject": "We have excluded you from the VAT IOSS scheme"
        |    }
        |  },
        |  "details": {
        |    "formId": "M08aGIOSS",
        |    "sourceData": "test-source-data",
        |    "batchId": "IOSSMessage"
        |  },
        |  "emailAddress": "test@test.com",
        |  "hash": "JR5rz2JEiLxCMJ6u4G2EruQXu6U3Ng2y+2uWr6j6lkw=",
        |  "status": "deferred",
        |  "verificationBrake": false
        |}
        |""".stripMargin,
      """
        |{
        |  "_id": {
        |    "$oid": "692d7aef81096a36213f157b"
        |  },
        |  "externalRef": {
        |    "id": "AJD408742363344484010",
        |    "source": "gmc"
        |  },
        |  "recipient": {
        |    "regime": "ioss",
        |    "identifier": {
        |      "name": "HMRC-IOSS-NETP",
        |      "value": "IM9001144775"
        |    },
        |    "email": "test@test.com"
        |  },
        |  "messageType": "mailout-batch",
        |  "validFrom": {
        |    "$date": "2025-12-01T00:00:00.000Z"
        |  },
        |  "content": [
        |    {
        |      "lang": "en",
        |      "subject": "We have excluded you from the VAT IOSS scheme",
        |      "body": "PHAgY2xhc3M9ImdvdnVrLWJvZHkiPldlIGhhdmUgZXhjbHVkZWQgeW91ciBidXNpbmVzcyBmcm9tIHRoZSBWQVQgSW1wb3J0IE9uZSBTdG9wIFNob3AgKElPU1MpIHNjaGVtZSwgYmVjYXVzZSB5b3UgaGF2ZSBub3QgY29tcGxpZWQgd2l0aCB0aGUgcnVsZXMuPC9wPg0KPHAgY2xhc3M9ImdvdnVrLWJvZHktbCI+WW91ciBidXNpbmVzcyB3aWxsIG5vdCBiZSBhYmxlIHRvIHVzZSBvciBqb2luIGFueSBPbmUgU3RvcCBTaG9wIHNjaGVtZXMgaW4gdGhlIFVLIG9yIHRoZSBFVSB1bnRpbCAyOSBKYW51YXJ5IDIwMjQuIDwvcD4NCjxwIGNsYXNzPSJnb3Z1ay1ib2R5Ij5Zb3VyIGludGVybWVkaWFyeSBtdXN0IGNvbXBsZXRlIGFueSBvdXRzdGFuZGluZyBJT1NTIFZBVCBSZXR1cm5zIGZvciB5b3UgYW5kIGEgZmluYWwgcmV0dXJuIGZvciBKYW51YXJ5IDIwMjQuIDwvcD4NCjxoMiBjbGFzcz0iZ292dWstaGVhZGluZy1sIj5XaGF0IHRvIGRvIGlmIHlvdSBkaXNhZ3JlZSA8L2gyPg0KPHAgY2xhc3M9ImdvdnVrLWJvZHkiPllvdSBjYW4gZWl0aGVyOiA8L3A+DQo8dWwgY2xhc3M9Imxpc3QgbGlzdC1idWxsZXQgZ292dWstbGlzdCBnb3Z1ay1saXN0LS1idWxsZXQiPg0KPGxpPmFzayBmb3IgYSByZXZpZXcgb3IgPC9saT4NCjxsaT5hcHBlYWwgdG8gYW4gaW5kZXBlbmRlbnQgdHJpYnVuYWwgPC9saT4NCjwvdWw+DQo8cCBjbGFzcz0iZ292dWstYm9keSI+WW91IG11c3QgZG8gdGhpcyBieSAyOSBKYW51YXJ5IDIwMjQuIDwvcD4NCjxwIGNsYXNzPSJnb3Z1ay1ib2R5Ij5JZiB5b3UgYXBwZWFsIHRvIGEgdHJpYnVuYWwsIHlvdSBjYW5ub3QgYXNrIGZvciBhIHJldmlldy4gPC9wPg0KPHAgY2xhc3M9ImdvdnVrLWJvZHkiPllvdSBtYXkgYmUgYWJsZSB0byByZXNvbHZlIG1vc3QgZGlzcHV0ZXMgYnkgYSByZXZpZXcsIHdpdGhvdXQgdGhlIG5lZWQgZm9yIGEgdHJpYnVuYWwuIEl0IG1heSBhbHNvIGJlIHF1aWNrZXIgYW5kIGxlc3MgZXhwZW5zaXZlLjwvcD4NCjxwIGNsYXNzPSJnb3Z1ay1ib2R5Ij48YSBocmVmPSJodHRwczovL3d3dy5nb3YudWsvdGF4LWFwcGVhbHMiIGNsYXNzPSJnb3Z1ay1saW5rIiB0YXJnZXQ9IlxfYmxhbmsiPk1vcmUgaW5mb3JtYXRpb24gYWJvdXQgeW91ciBhcHBlYWwgYW5kIHJldmlldyByaWdodHMgKG9wZW5zIGluIGEgbmV3IHRhYik8L2E+PC9wPg0KPHAgY2xhc3M9ImdvdnVrLWJvZHkiPllvdSBjYW4gYXNrIGZvciBhIGNvcHkgYnkgY2FsbGluZyAwMzAwIDIwMCAzNjEwLiA8L3A+DQo8cCBjbGFzcz0iZ292dWstYm9keSI+SWYgeW91IGJlbGlldmUgdGhpcyBpcyBhbiBlcnJvciwgY29udGFjdCB5b3VyIGludGVybWVkaWFyeS4gWW91ciBJT1NTIG51bWJlciBpczogSU05MDAxMTQ0Nzc1PC9wPg=="
        |    }
        |  ],
        |  "alertDetails": {
        |    "templateId": "new_message_alert_ioss_netp",
        |    "recipientName": {
        |      "line1": "Test",
        |      "line2": "Test"
        |    },
        |    "data": {
        |      "email": "test@test.com",
        |      "issueDate": "2025-12-01",
        |      "language": "en",
        |      "subject": "We have excluded you from the VAT IOSS scheme"
        |    }
        |  },
        |  "details": {
        |    "formId": "M08aGIOSS",
        |    "sourceData": "test-source-data",
        |    "batchId": "IOSSMessage"
        |  },
        |  "emailAddress": "test@test.com",
        |  "hash": "XBOLjsV2c/RL1PvpX4M+dSL/UWqH+WCoCEEtMTIPVcA=",
        |  "status": "deferred",
        |  "verificationBrake": false
        |}
        |""".stripMargin
    )
}
