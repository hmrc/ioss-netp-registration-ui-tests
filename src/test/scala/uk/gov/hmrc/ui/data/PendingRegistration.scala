/*
 * Copyright 2026 HM Revenue & Customs
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
        |    "$$oid": "69c3bfb61d28d177b82d66d2"
        |  },
        |  "journeyId": "edd256ce-a345-4236-b810-da8c0944b85f",
        |  "uniqueUrlCode": "RNPMMN",
        |  "data": "tL7qSMQHUL1VMhPRQvT1y1KhSDBUMPdQN8mODOZA7DGJZxb2h7ym8HeQnZgQW712pdkD/MTkg2MLy+RW8+QIPlmFmj/CdA9wA2VB0mfzG6hpAKdl5f6Wm7XQ01cmO7ePp07QlkERiW1h2Px4egmW3GmeEFmSAXFpVKNXTPJ0IymFh0bGVg5t4eh0eTJIMESC5Hs6R4T0oz6gMAGle/lOhFMJDdi5PtudBFlJv0wfZcz5ZQLcvLxqODnKk4SQ1QTxM9+Mc+ptL3h05b9T6rkhYQcV/lPNnTEfcfHd+HsmDYK6fBO8isLtW5jEeMkIpmjmRjE4vXbjdrZOWU9VEMCMDjlRdKX7Hdp6B7Bmz3a/qg6nhm/HZUaxTjZ7AHM6Fz0Qftyk9p5hselCmh8YXl5MJ3m5uf5djBtPCtTqiJq+IMsWSN+wfAqLuJ+A9UMt4Qa22uzK9UVloY1cGMggHzfWy+z3ckomB91nCzHIomCf2hDw8rb3cjfr9YFuI8Oyny+cu1nkO5qvwnRb0Wv2ozg4Yxpwx8nPWGU1KSntFyuHD9ZQA1Qg4BsTGrGRIlDla7tGJAYOYMzzaYlIB8eLNOxq6qYR/i+xWnDDJ84DFTVu0tMae0SJn3Zu25xw9k/MSAPdFCcZXMfsAEBIGBoyH/ihcF8QThDRgSWSvXpaq+5+lNl59JRK24s1ehGnLxyQX5dDGxBrvYXCOkVHBqinv2lqF27wSBrkCOWw6u4s3cIpg59AM9qsJWA6qQOkWdLE2judZwGwflF7YbqcdVLVET20N48WehxTaJqPrxvKn68Xgt9JzKpd/IBlztAdmZi38YnsDCioN2r9RKXaz0HJxX8SMa0HPLK7sKY7XiR0EKERHO2qK5yKS3Ayz9qYJRQn3CGORUHIOwKCi+K+iuW6aFHEqpLKwqzejD3jwgrpUFE40DTg2iEomXN0doltn98V4tlLWRpN8NXlDL7GjzFyY3OoVhArsPmBxEkHbu9/69TL2bn57MlsXSj9ys2RYyASTw5oJeRPy9oKVNehJQRzuCZVJYn+W4nv6B/2d+FV6QGU9SRMkQ/jDS1AOBM/jrIqjy4Ejf0/lNNRLpkwuavkdTX7ww9AN/ylKbF46B59NlVGd79uKDgwGO8EoPSdC92PdTOfVDxDX8NYJTcEqiHhVl7ZNo10T74cnGkgedBO6kFuc0RcCvT0HrL/yvPOy0thQwEdPFzMqHiwYGdy0hNy1tnAJj4CNdLH4yRePhVwqbjJzU0aChpQa/uwOWVKfxsHFZVZ+v59gFztD8oL3N1alCd7HyxAvTXHj8dszXhmICGUSx9xpzrbLqzoj27lS83FjaohhpfqgvwTdhYOkxhemUC+byhRRX+FudMrEe7QQs6WwKlCZDF5rVx/1A52nWDVtrZ2wIm4JJL7fYa4a28V2UqplZ2mYIBxt4UXUlblBVgeVsX0SKfr4oHheL/irNSR1tOvmkKC/i1JJpGze7EbBIU5K0XO4HKKDszz4eNCVs2G/yk6ZIZTuvdOJ2Zvsc+kwNjdR5xMCR2IaoUrLYiPu9xg9MulHloGQ9AyJQHYziJXgdmH4gfYUlwQk0heT3QGsNz86fzaSc2GZXjkHmw0eQiv5sygCwlE4XoOhN8yt6tCwXU03g39TDRww9DrwmnqUJbkrENU/FxpVj+Q4aMQBfqveTX+lVh/SCTegKqdLA5+r6JmFtv760wmpQmujE1aclcTQ3fiPwfqhA1NbGfbcRc2pq8VG+kcZcTseHeLc5wO7/2pnOhj4lDgyyfJ4wo0pVwzK08EiPQ1urwADJ5VeUIjWyvVQfa9HSbPetoG5bJ0nCUAgD6H5jRbTak/3lWS0InH9uUtwtLjSbghFjqAfPQ=",
        |  "lastUpdated": {
        |    "$$date": "${yesterday}T10:57:58.421Z"
        |  },
        |  "uniqueActivationCode": "2hn7CpH8tzxzispGVWdvcILJ8VNZSFSfxyuJjtN3B80WULl+h1o=",
        |  "intermediaryDetails": {
        |    "intermediaryNumber": "IN9001112223",
        |    "intermediaryName": "Intermediary Company Name"
        |  }
        |}
        |""".stripMargin,
      s"""
         |{
         |  "_id": {
         |    "$$oid": "68b855a41ca3d6d1c1cb6e4a"
         |  },
         |  "journeyId": "6bf0b5aa-c9f1-4860-8bf4-a428c033c954",
         |  "uniqueUrlCode": "GBVKFL",
         |  "data": "uVAG0e+TN1UvMUqILMfaTgglSAo3/vWEkpr4+iwigZe/t5jf/s8jyioIXbN8OC/fBqTzHR13rgHvHr+zvkEq8N/njpNC88okeNETzOykDTjQSOtmrmDCtB9Y2/AzDnVZcMGOSTibNAdceg2CyVqtwj8E2YZlL6QqF7Ng+mbhxc50yvtruzN3JY57vSWE0EyKF5lrddlUNXUKd5kGROezpEEiT2vJlAPkN/9RkL0UhZYWA91BghaqALFOKIC4nitcaDvqA3aeyh7iHJeMDyDNHkLtWpwnzBfjjtSOjzoMQtxAVxDI6RAaOMkNyAAMkKau/Q4+vWvul4lofEy5SdD/Y0MbPTeAMTd0wtyobya32TJH47bwoNdQm01Fe9cAgYMqCE0lLE3BUGtDL98CFMSJV/h/pWPr+P+QIwEgtr1h5vv52C00LHyOuhv8cM+Gs6q5g2K1gnik+Wt6Wm3LtI8R6mAp57zrnVZQG+sh33MMkgmzG+iV2ivxOy/xAnT8ksggJYZ8zmxl3jwv1XRT0GZP/SLuKhPzYKQDEZ759PF4DHJmETiUWKc0rshqtoJbetIsN29VgNVAlu4vNN2ZI7pgg3w6CKYJ0Mb2PgZTK8QRoIFhC6bKTngG8ac3b/51z4htJJsAERbouVRR9ZpV74mSP2mpmpmQjb7IV8fHIRL2ku846wiy6TJ4GO+tQrOwMoiCTgHiN730ORFitCfe/9ffDcAXVxQtYBiLQ3jubia6Z9fraKmLX4/UbttN6bKzJAJ1uw87pZoMolVXkd6+8Zm+zK4sG/V6rEAIouww7lRPTZBXqqqW/JcKm5Oi/eTRRBeg/QEO1wz3kcnLMvkeVTqnn14u3ySIheFtEUO0f/U5P5GGsvmH3mPeMcLpNnEudacubRIIzi9hgpKiKJk6Ycxc34ygzQsaMwu9wXA=",
         |  "lastUpdated": {
         |    "$$date": "${yesterday}T14:50:12.589Z"
         |  },
         |  "uniqueActivationCode": "GFkDVR/GuyigCoYJTsb7OrjCGF4biV6h4OdxqlnKsMxXf6u8LUY=",
         |  "intermediaryDetails": {
         |    "intermediaryNumber": "IN9001112225",
         |    "intermediaryName": "Intermediary Company Name"
         |  }
         |}
         |""".stripMargin
    )
}
