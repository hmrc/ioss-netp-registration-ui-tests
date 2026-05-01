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
         |""".stripMargin,
      s"""
         |{
         |  "_id": {
         |    "$$oid": "69f4a597aafbf2f9fea9fb39"
         |  },
         |  "journeyId": "d3c3bdc6-31d5-454f-a26c-46fda84ecd89",
         |  "uniqueUrlCode": "XGTMHX",
         |  "data": "2tPgHByR8GuJmo006vtBqOiSDMj+ff5EZjbJAn0aqxXRozK6vPkVELDPn0TMDVHLf5jS1dR9oi1wijqBKixTVy/ID2jKBS9Blnr/lrbqe5YhOkCJL7GY41uC/qZ3pU1adKfsh2gBcfbDEFeNKEiE/Q1ja2O++eGkqw1H/F27pNOthDYNmxUb+G5a7AkBMk+DB94Ai44D2vrMkWQQSdHjtMM+kMA91D2w0k6UuDvfYqeToYnuTqpvhREaiCi50SHwE+6uth8zsL4Q8eC8bcoXe/HyHjLCgoEhp9iHpKIFhAMLt1fSkTSrd2HwJdvzd4/Oobi3hTYJiGchfu9H2l/Y9BknSyhV9OHmjz7jBl0iSuGqaeh+cVHe8+wrriGq6rxD6/kYMnub6Xc6XXdxNchLFPA9lQKXtJ+wSR1JDmdWmyxWJxtMfNZnihlnrZAeM7tZNc1hOO4DQQg4/Z103hO/s4j94ZI0EuM+1bHonf/fkYvxJJi2vRQAwiXZxxz054fHganhd2aeBvaGQfr9H3SrsLKt9Cq3B1yoomSvbHmGIrGtG6P56tXHAOR1HKFg5jOal7cNkrcfuCh4suj4vio4ROeiVmO3aMiqHT0PieAFKz5/3hs9Azh2VCtbVOwPZZbXIyh+Hh+hMTOCLnoLVMUgeP5tzzwlD0SWRcd+gO9zfOZMytxsp9NwKe0QJp5DsP+rdRKNz2jsaDAtLKkaBr3sXn1rn8zrDoSj79f76bnXvmmoEM2/Lil+RuCo3JtppO4DJcTBYykUQsMRD/0Fpth/SzDAtS36+kV75UszENkgbeCYz6noKWm4UtzIY47MpezNlwqCUMzib6CJH7Wsjky0je+kk30B6/vMo5mTu2aKPPy2DlaxHjqDDC8+ZUbXkwuEeEGFXItao/sf12ZzFwdqUpi6n/0RCbCpEndhV/NWPlo6iTF7TOg52uvArS+zGRhqKGeAschM5rfiNymzZeoPSRVltcDhWUYPI+/rpY3f+g==",
         |  "lastUpdated": {
         |    "$$date": "${yesterday}T13:07:32.830Z"
         |  },
         |  "uniqueActivationCode": "cRLZ7JDlFCpk1x/csRQYWrJIqONZlMsjTIrYs1uvrl1ViAYMnuo=",
         |  "intermediaryDetails": {
         |    "intermediaryNumber": "IN9009988771",
         |    "intermediaryName": "Intermediary Company Name"
         |  }
         |}
         |""".stripMargin,
      s"""
         |{
         |  "_id": {
         |    "$$oid": "69f4a5deaafbf2f9feaa4262"
         |  },
         |  "journeyId": "ddddccbd-0897-4967-a1ca-d0e297420f71",
         |  "uniqueUrlCode": "WJKJRN",
         |  "data": "DC0dTjyQRsarNJCCAmAeSRtTKy1XWZLd/PMxbwUS5qT+TG8brw5VbwOa1qL/yRH3wTO3puXA9yWNiqhxlOOMvwTp463M4FyZGbuVzqCxqsyolOHvCmvJYuJ9XhjeMry6phFiJE6wZagBsAzbBBMFfQ+JKWTDhYxOupjOMSaQ6Pi9vfCS8JKatBu/lgg9IkZaST8CyhhYrv2yMeiQxQ/Pj4qwUF7s46iwTn6xvdpfBpImjt/wjYm4kHIUr1djqmhThMMKWLeXMowTIxnCO1AAmioqOlnvnHkbvdPTu4w/Je+5XQ0iVAxK9WRpispEFoGYkDo4GTrwaxNeMPJnDF7KOGCnwKafjUkJpvbKHny78z9IvwnNXogkmkyA+SZV38LOtZq0G08gM5bKzcwXAgi2j8akIFGMR6+ekyhjZBuTxWb1Ep9AJDxlHmE/nW/048c6QaB8/MLKldKjXnnjDpwZ/bmHBebrrC/3yzGCX8WlTf+3mjC+tT82kzjNEguzE4xaLbnkW+HIquspxOSt9j0affIfxchRdO9hyy884+fbMi+RnCAUKAdo8pEmHZEhF4yQk+qEuLc7jMUucHgVawkQJzVOqGUhEOMRBL6jT+bqQP2oU5VexyemrwLTGVP4JwhAC3qV0sfAhijiAk0uJRej0hsSKgTnqIhfjD+6lTCHG5KxEROrvgxawvY8cImhMIkUwy06m/3PIgF25i4GtEzm/0hXWip2X/UgMHA6fNCkO2m0k/jM4jiBHOyS2p/jk7H0A0k69n3yaeA3M214hoxZn7h7eUL8VOjlGiwZvsx9h5C6LHo8wR44HSNDb4b1cH84m/XB+vf2jAxvALuiF5L1NE1womqdAYoYhfPJCXzn7jMzqAxMgAOtpwOgr7HU4oouDzSFg9jhMHVA5GeGp2UMbezUVjWjO6rwlw==",
         |  "lastUpdated": {
         |    "$$date": "${yesterday}T13:08:44.685Z"
         |  },
         |  "uniqueActivationCode": "szM9lo2NCy39Oksd5Utc/5Dvu7vGF3VrhU9owYttYfdX58R0+no=",
         |  "intermediaryDetails": {
         |    "intermediaryNumber": "IN9009988771",
         |    "intermediaryName": "Intermediary Company Name"
         |  }
         |}         |
         |""".stripMargin,
      s"""
         |{
         |  "_id": {
         |    "$$oid": "69f4a637aafbf2f9feaa9aee"
         |  },
         |  "journeyId": "f23cab87-db12-4dc8-9c1f-9f59a8b44598",
         |  "uniqueUrlCode": "VDKLMN",
         |  "data": "RSDco2DS9mudk4OATL+kq2drenGIt4Or+XpkNXu+jSPM0SxKUV1XSsrwmG0y73IM+I/LE+oWZp/V2/4d4TeYTcdKY4UKF7IpSCvhZUK1051cX0xXu2vgeHXEA2bk2CoBBMW3QOrP9FhcgXm3QFdZy/Vcw5LcJISADt3sTjLEEbmcaRtVAbod35cCwsbXSrRH1DK3MgMAD0hbJVO9b6fjvG3mGhuZmA2i1c3yAq5NBcATKtpKYMvUcZASsZ5BuRkb9v5SHC+0N1Fpl6pw4ESSTS6jJ1Af3xJNW37DGY94rimKLm5DsUThEy0eLTXqQtneHvT4qQwQ43abfnl/VO0rKnLDcenQiKOFaoyyVzIUxqr9N4m30YfFAob6BvU5+kmFJ+YB3kzWlqyUqDZu3z24elxZdAywUtJAMJuJVf4JR5lQROGVx+OMvKbFdv5bM0D4+iV7F19DMjMWBe54Sml335b5aLqdDEMM0jqqQeIjmigd+NZ+JKT16mO0a+1gtAU/EmOSuJiKNu7jcFoG7wZF3fJkt79pKfl/L38+E8gy6FGbyzhJ051knRuppfjDee2KcweBbZLb1aiY9ZkGJDTyL97xM9CtWs50l4ur5BCKAsFzVIxwJySwVypCLTEjAr7ZuFqcTktv+klSek9KCA6QirMSjcLHwebrpPU0uatlxDSlJxhA2KgkipXHvDZvJjms0p0qqE/aTqjNyQDAr95UHA8TacCeW2MA1v+ZyZDDr7OWiI/TH1Dbo3kfIj9d9lE0m7DND379G9aWG0/Z/bisFpkaO8vSUXI+3tdzxlPL3pTI+BzcEzzO1jjPknANP12CSzqMYKWCy6aqQKoleUmmiavRaoMR5ipDwmdyzN2NLNoeQ6yOdCpDper2+0xJZAJRB7txOoBK+DQ99J3w2sPKZIkAO7fnM2GLcoeG",
         |  "lastUpdated": {
         |    "$$date": "${yesterday}T13:10:13.783Z"
         |  },
         |  "uniqueActivationCode": "b0+b+QUNEcF0HpJAr8xMg0dJp5pogaUzs3IEONEO5sGRLvCx+DI=",
         |  "intermediaryDetails": {
         |    "intermediaryNumber": "IN9009988771",
         |    "intermediaryName": "Intermediary Company Name"
         |  }
         |}
         |""".stripMargin,
      s"""
         |{
         |  "_id": {
         |    "$$oid": "69f4a68baafbf2f9feaaee76"
         |  },
         |  "journeyId": "52745e4d-f10d-40dd-8b93-926e7a77733c",
         |  "uniqueUrlCode": "RGMTNC",
         |  "data": "sZEE6jQlk2+XrMbnag6i6Oi2XzBx+tBZb/or7coj0ueb+t100t/xBwFOJJ7kLPyErCotYSIZpAn4PzkDa+OP6CWiFCh9PolqPIb2x2mSM4PYkTRLNYafW8wbrFq+FgtBo8W6AW1VMA4sPncm3jda0D43F7A7FLx0SNI13JII3kSZz6u/PpnZ7gA7zzkcRKYIy6Jqb+Nl4aJoYTzPzA/As8qzOnr3lGoMdfFW/odEzwIAm/8OwF6MbKREjPHnf7PjGS0hg3aMzqvcSwx4z7JcRx5vLj8axlTnF3o1BGx4oojcp7l/ct0Pjsrk96b/vuoU8KwZvumfx1ZoscWA+TVV3LkpjV7WkzSv1lL4o/gZMhNYYXUhvttpXU68P7CG/RyFaSJPYw3WPAXqteXreG3Poh93ujx2kZmNU5kntzbOHlzGOD6qTnyDhVBwhJ7TdeWKhfoojsvxLTwcyCwWbiPFBXo1QJ7JI+w0cmiso6mZc0jm6CHjkYHhcc0goql/GFSTxJ2tZa2C2/f8AaBW3INkyIpEawv7/1Y6N/vpHBlsZSDseeuwOl5l/XC9qNtJ0uKD7vwm/woJOwlawWcXzaHTPVl/DC8FtdXrb1cMETlhll26hn6N8+Wq7WIEXEyqdxBcG9wtIyvsmin/4BiaVDSgl2j95DvZWDjVPXiiHDPZCytCejJIbXrqaJG20zpFzTuxIpG9Db4FeBdJn1CXyF5QOpxC6V/cE+cnPNYQA4oFf6hpsXpp/n2A0CGx29tSPfkAGMEcNstkn+Ld1XqPSfaIhy+DCjOBfZzYsLyKT/yGguzOo55uyWFvCK6Rh4Tzp8eayKtLicVFPTNCB7SfF4mau+360P9JPQkbvJpmmHNu1t4qUHDXy0MVO+o3EpaFfcz3sVa0aAWRzfA+WrTCh7MS8tmaiSAEw3kcGCTUtkWbKKO4X7UAWueD6RhHQMtguctqdxqXlAvGDm5hpnLooJ9/NagOev3K5gWwQ9TM",
         |  "lastUpdated": {
         |    "$$date": "${yesterday}T13:11:37.399Z"
         |  },
         |  "uniqueActivationCode": "wbWnI45zo45mUa+awFdKow0366BiaddR3pyk8raZfTEhA6pWU44=",
         |  "intermediaryDetails": {
         |    "intermediaryNumber": "IN9009988771",
         |    "intermediaryName": "Intermediary Company Name"
         |  }
         |}
         |""".stripMargin,
      s"""
         |{
         |  "_id": {
         |    "$$oid": "69f4a72baafbf2f9feab8d2d"
         |  },
         |  "journeyId": "71e668f3-10c8-425d-a044-c8fd64dd0c9e",
         |  "uniqueUrlCode": "VCWKDC",
         |  "data": "S4lGxpZg6dWU4SSQy8RpxPahmeVMuNCQYVYkkKF5FK8pI4DUx1YIl69QXeQ9QHE9Bq2dtOWd61Ot08lP0bWR+YhtRBECLnL5qamsLvJQEkTYgscm2OAL+h0tTXP+CaeSQNTkDaF3xLwZpP0vIvVnFluoKbvTgVpTmx7pCsGEnkf3J0C6/yUo41Xv7WcBz2YD4elLGhgBv3w0Rkbg6ko0Fvk7cGPuj/jJBH0udFjktXzBNLziHr6Gswr6uYDrUGkiN27kXGPQgv3+eVE7lPTJqTYx4mdzNiH0Otsev4WbXTAtMR+FWSzoX7p5yDInJeSKjt2Y13zFkjEI9VUohqydIa/e+pYbF2NjnpymCPiYrAeS0lgnJJdPJiIIVxTmGRaIjhOdLTEIpAT4tvmSGDi13lN5DsYBcByJrglPk9sd9bTAGbcDcUysmUH95fnfRy1NfGZfgJRLVHS5DOCT9scErlXDeL4Rei5si1waw+LsUC06RrWFncBZAvHm0mIjL97OQsaADopSjRfBqwH2c3lynBdQbOUPBJemeafDodx1WbQSIMexefVIqnFf0wwwrv7caZiBK9xOEAGw5r9/C9Yylpc8xVp7PEgggLWaGqJVUO5aSLsZguhE6uWJiYhJ1cs2IC/GicVgr7qwE1NaNQmf4HxTyxZgEFkgjbplm03A199neN67XbhNuwKZqn04mhFhYgG6PevNorqEqlz5aIdzjilcrTolrhub8aOdq40Czp6x52T8zASCSirXse1aQG4Vi0/+XtMlHeIyPVvftuIdOfnaK5HZeBsKrKlQxYJeiyknnGXCCnbZo9E4OYjGQV2FXTdtkAKUcJFw+AbNjuldR8sBbWqKcIVLDCbdXMH7sVkyzjzFN94bhGEmaUPbIQPqki3de+TXzrfolWvbvSXi94CRksr97xZWn5KGfcjHcG2l7fFpLqzrFz6ZsXFU4YREuhw7E3caqGpCOCFoaaeHww3cmBnOMEmFLZJI5lH2rJfbLvKliSiLsfMG2Qx7gIW6NIVuIIAXCoiIWSjDBo862I2C+2EBGShMey0kzwJ8kGboISudKfNy5yNO6QY1usctw0r/MmGjbpJgViN4df5OVaQZhStREwroiZfu34A7C/8G1fnvs94+Qeryb65clXAfSW6wxpXfjsPyKfZl5gDbfNCQWGkZIUriWv5udPpqv9XkoI2rh9v+CuPZRJXFT4vld1/Om/n688JSeWyThFKN9p84K4Ah1+40pxw/2t+hVlY=",
         |  "lastUpdated": {
         |    "$$date": "${yesterday}T13:14:17.618Z"
         |  },
         |  "uniqueActivationCode": "LJ+9wNHmoFJwbLVbQI2RKzwYdd1LEo7ZazXLvSW9MNWEp/JOO44=",
         |  "intermediaryDetails": {
         |    "intermediaryNumber": "IN9009988771",
         |    "intermediaryName": "Intermediary Company Name"
         |  }
         |}
         |""".stripMargin
    )
}
