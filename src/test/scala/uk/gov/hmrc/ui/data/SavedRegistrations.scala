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

object SavedRegistrations {
  val yesterday = LocalDate.now().minusDays(1)

  val data: List[String] =
    List(
      s"""
         |{
         |  "_id": {
         |    "$$oid": "68d50709fe8b3f3aeaf1898c"
         |  },
         |  "journeyId": "0f838e76-6565-471c-ab13-92941ae47a7a",
         |  "data": "ehhn4DBMQy1tvY49FpvlIqZeF+qVUZ3ya6p6rmo9pOT1WZwXLi6dKy+iFP/oQLFfBmXMMGlgEX0hWZ5+KT2nHoJFiu/Yll1GRrh+ATqivWN+7WhmN+2aYqBY82Xp3zNpVS0fXJkNH717XXLDhHLPEQr0YWGng+m1ytRRgiv+1pjFt8BuMf9MotZiuqf9zXJNZOC5Y6lF4ltpa5Ljcor5SxTQnOsFuB3a6chVxSYPyFYxqSDndylojKlENIMofx9r/I7FjexpiFDXS+NlnjFW2ifChCfQTrO8DMYTfo6/C/XWwKUJqgbLyrkW1brlgdu7vHaDJAjAzGemrAKT8bbsg1kc+RcLKouFVNasXbhMrRbi+6TyEFTrMnanMfUYa676rN8SzgS+4ZLTeGAQOuSP6m6ZaG/PuUOqrZy7F1SIgsJ/ViA5xVWVuoQpeMRZjY/W9O0xSSex37KuaOex7wE=",
         |  "intermediaryNumber": "IN9001114567",
         |  "lastUpdated": {
         |    "$$date": "${yesterday}T09:10:33.247Z"
         |  }
         |}
      """.stripMargin,
      s"""
         |{
         |  "_id": {
         |    "$$oid": "68d50eb1fe8b3f3aeaf284ee"
         |  },
         |  "journeyId": "aab4028d-9d91-49bd-ae1f-e885b80b3722",
         |  "data": "jRQ90IrrVap+T12TWjxpgB+5BxR0U9oCtw91rM3p9xkPZNUkNg48unyflIyNM9gcUJQbgYHOyN3IUQ6vHaJ0/9A3Ndg/P2DFzpXxokBNLb2QMtIFC5HjAdK4tbXzD0DB4TTzT8b3lZydNtIBUYi+imcLAWZMbbI5ZfSI3gS94RGDZZyPreWuelUnLjYVZ8DhDmPPF5YEjmkTcc1ITgkCY9H0/EgugR22CipY97BDB10ZNneBwk/HbQJ5UebJpD8Wmyq+oU2SY6WQ8p2NJEqr0upQmOYLANiSGJ1JrP7PDejA0GDWjjPvei650UEGUIaJjxV9cliceg/rDlPi/PqQN6EJnq8jsj3UablV4Op2vHAK5E/9P5O8frYmDI3pi1dSwCyjTOc3/D+4BFasFcpIKJSve5Y2oE0/kBFeD4EU5kwKYSK6vz+cnP1chUCq0Oo8SLFgQUdOtrHDDS2UldQ759OeHaBxD0TOgfmXRADYOTKrKfFoRjl7aQkiY7z9AJ3ukFmr/lW/yvGh17DEDLraAdfSGNznICdF1SIsV+iEeR/iKb46vUiEplAw9c0+qsfuLt4Z1NN3XV522Nkf7cyndF3C9z7tFwNNmOwcb20ArnCGERTtCHkKOVSIbDl4Apf+vwy7fY/qJ1LVESwsJjq80pT+opCeQbAgk+xMk2exILvVyAI+kceqLpH8pm+yU5VkBSwis0QwdghIVMpQp17zulit/2v6B3RpOHAEX4nsIkyS2Fh0BKKRlm8LmUNYyx09ftQNUKUfc99jeHr+r3Yw2gDhcjMLlMFDzYElz7leqSEKHiXRLfRC0F5W66v8u2M9O9+I4zf0EFudj47k0UPe8q4ilrAVG48YjH8Ruvwu+/MnX1I8rn03TMsrvGzRaTW8gFh2c2dx6YAXTLtzNSw6ZEtXKQSy44pv+j3qG3zLxIiP9ZE/gTyD+9bulEonpqBGP3oBVdNXNU20XQhK6m0Oq0jBAHbPPfwHtcDvUqV/DQ3+D9bie2QgzvXdP/dcTOe/JFm8C68vGmA7m39CdgSlVltPxi058ARymEIVhI/Cq0P6quNWp+BfQr5OGAddAHFQzmKoUu/5Rk4hmPbW4pFj8km01KjgMC+m4+ss9+JVguwJ/7c+CsX6hCAXWvILiA==",
         |  "intermediaryNumber": "IN9001114567",
         |  "lastUpdated": {
         |    "$$date": "${yesterday}T09:43:12.969Z"
         |  }
         |}
      """.stripMargin,
      s"""
         |{
         |  "_id": {
         |    "$$oid": "68d5197dfe8b3f3aeaf3e9ab"
         |  },
         |  "journeyId": "6a6184f4-1725-4c2e-b83d-e5a10b201c40",
         |  "data": "q7pVX12ctfkeiz7qRXe1iETe2Rltu7CiPPPyI0v1DNWniiiOG7gkIx0WZe1/FL3wVXJ7XY0kKC585pJdph5FXrTk3sBp8xhucNytyMwW7lNvBKG+INEvazYklemwDyH7k7IOUk4InUv8cV3qt3bXQghbJ8HxM9xQMHKa9nEzX6stbs8cZAeCaZYz6xw6t/3lzPRkik1tc4GdocSChWLWRVBt3AORdL0kVpEpcy64vnMsgzp7uR1KeKdI8NixCXhKv0J9QceBcmzB5HxfX80R3aOkCGhyKm751Uvz9hKl3vkDAHl18mR06A9F/pm4UVHKaUXkKs54B9EGv5++ugdteAdHQuwqGE19S+7/4jqaKDrDMGwvuTbWfmCUK34pYmR8q9vywRrZktVe92ZBTn0BAd1eImRhvARyTHxKgEELqO/347TS0o5PYK8rC+1DB5V7ZzYLWK3E7VykFUMbbLMj6PfwegBpbXhyoCOy8jRLebKLzRwz81TyPgzYfplbT9qKpINwXmI5OWd8UxBDoVFvJd/Pw0OaqnshyNh9sYYXqlvQV3BBSCa7XL2d/+Bg76MTovxbtcJ08uyhOjQ2hx60l2mIFu92dBuYwJEvE2N9DDaJmQ29KE7BzL5aHoDnRL75d1hjjDx3cVotI9k4hNB12ArY9HpMQWBsRzck1YaUlwL2v7bq8HhoquHeqLEBJK/HWkwfAu9mmyrqt4dPY8MZjknuKxkyous2ei7on47s+/cVBNUhD2y2XIyYSB38w2Dcjfi2heUbhZzGUwi022hWUHGabdETz6ggxOtu6QEfcIRvs7ieCPpf3b0ql23pUQbDuNBU4NVX1tnpwG2xACqJ6X3GrytUiTlDKzF2xIV9L9sNEaVsZYaBRRCvmkurEr8j+Qa+87stGYhhjao4leGo5X8qkdE3H1FkD2TUhUbnrorf8JNwXqOVKNX59o6LyG/il+NkFAntMCwAEm1+qfqe3xu5/uruB6Lfis+Vne3yu2Kjr0F225YnfwMMq/s1X8n9nILL12W4MZa5WzrYB9XZpaydqym112YZIdj1eSqA0yTvQ1FaX62WDA==",
         |  "intermediaryNumber": "IN9001114567",
         |  "lastUpdated": {
         |    "$$date": "${yesterday}T10:29:17.137Z"
         |  }
         |}
       """.stripMargin,
      s"""
         |{
         |  "_id": {
         |    "$$oid": "68d51c55fe8b3f3aeaf44772"
         |  },
         |  "journeyId": "9fbdac7e-b33c-4575-a248-1105faea5251",
         |  "data": "bRd5cvtxSJlcEIoyVHzxneNQkyJSEV6WAzEF1OyAGyA5RMfKu1UPluofVrtJzJattUc0seM04/16ZPFg1O56AcTNeaHqKbPDT+M7n+T/TNe5Lb/4TU5ZsTJ/7efbmzBvRIkKFUkxUgHUV13vpFlpvIpS5bk60mqneJF7Mi6uNE0/pXadCInGEpL9NCjI6reOAjqRH24o4Jt682bweyY0NTy0iJCvhYQIL/H0SkdbnVPGnBRK6Q1+k3PqWrAD7qIQ7gifb9zkGzoCMWC5Et95/jjaRFRrY4mgP1sPUJc9wBtF0cjC0elxh5ll1fLfSYxzAKFsPHirrGqUdF4l8zWLfsygKyxP7Ri5QSaEarb3FQS17KFbWu6Bl31+WM7Xvm5Y+Ege6IOZ/sGBbsU1IXWPCpfaAIH2Ra3IDpagK5W1yrH+DOgVZO6mIlKl2ghzbR+Y7oFcDDIeb8fsTZgSxe4DbdI8TIaEwDldUPk74ZE2czv8Z5Yv4Stb0f4AVVGwZG5BwtziGyg55N1XLfPmQ566jisPAQPk9SzARcIsDBwPUUW+TlfZ30/M/0zdq507OXiKRR8+WQixCcV4jEI4d4TawhDvcK+oGN1rD5CRhIxdYgKy6X/ddG4Wt5x5u71KSBg17KIDToeGY60dvkbgrHWaF5AD4ZVb5EvZZb8yZ9QYE/mi0xn4T9KV2eb4ycgKmgr6E1QieluWbyx0qnK4zEgwPfTwHkAswYGAtWfkwZPeal9bYyTy/zv6bXVX45rH28oAhmuzJ3nUxo06XUjdcYr5XJne//+EsL18ryZT1E6AgKRjpJsCd9VxCePVNEgt85rkxrtp49Rh3Q==",
         |  "intermediaryNumber": "IN9001114567",
         |  "lastUpdated": {
         |    "$$date": "${yesterday}T10:41:25.101Z"
         |  }
         |}
        """.stripMargin,
      s"""
         |{
         |  "_id": {
         |    "$$oid": "68d51ce5fe8b3f3aeaf45a85"
         |  },
         |  "journeyId": "ac6d2c97-b774-46dc-9503-b212d9bedb9a",
         |  "data": "I0ywK8699EvvqzYPPDjCk8S0nuwK1Q2dal9A0+DDGOoxWps6iq9Yt2RUOEWPiL1eYdL2agVVLaaU4OCHf1FAwp1dsxUaoLmjx+Ukj5DbcefOjnuW64F9nm7gNnaGpJ5l4BSl0zRa78lyG3L/MaVdAv9vSbe0Kz8OFonymmd/TjbURScYDlshHq4aC/QjvydQ8BSm3XdKuwufyTtQwzsxt4tqHJ1kRg+kaM1aUshyDzdMhlUaZDLGGBmWoaxGFND1ePnXOXXvEGUvEXNIOSI6ERN0/QLobc5f4HF/XJRIE22MJKe06dZLo1yeWjzMvRaH/b4c99GbqkIyA9zV2NqF8ta9NztPt//mUfunimUrQ4E5n+QIjDYahJIB3jfUgIaTYgKzmKdQt4vJYloHzpOONnojrbI3ABf1bptiqnnE8CI0Bpgi1rZdblDqN0ba6/yIAUzSiKxFcFQw7stHB3tPaJAayti0FbD7OiyUzlRnUL1YOXIZMzHafF0jyb/ZjnbI5neVHWiY4bU2GCYqdq5erk/JZK3NhwFVjz/4QRqZ2eIiGYrt34DS00gmukqqsVS/G4jp3w7BzGAa5+LHtSuGiMkUyWg6kHf6msmJnMVW77HPbD7CqNrCKNPXRYSv9TtrVLmmTAQdy8NHnL7rnL7NhCGzG9WOZYaURRMuj9buoKASPblsVRpjB+gTYuVB1lej4qZ6oPbgeZGWzjn7uGHUThRtWnbmyVMRweRdXS31SHgcG3MpYTqJDcobTBZHt/GPFgX0eQ0SaTLEiyfRh8s+gGa4gt8C0baJPpLYW3+HOYwLDkiSf1+/ZsufEU/OWTw4Wp4uYGCM6KDwdqceOMWHuBN20iqS0wp15xWD/mT9yG20vyfSMFBqsDTOFCV6mNKMY3JTrb5piw+uiQFIMEUj3PLbETbnAlbXT8u7T3FAuTQfrOolhMN42l1JpURYsHFBEVc=",
         |  "intermediaryNumber": "IN9001114567",
         |  "lastUpdated": {
         |    "$$date": "${yesterday}T10:43:49.261Z"
         |  }
         |}
        """.stripMargin,
      s"""
         |{
         |  "_id": {
         |    "$$oid": "68d53029fe8b3f3aeaf5d3f3"
         |  },
         |  "journeyId": "943102c8-50fa-41a2-9ff0-20e8229c8bc3",
         |  "data": "ef1Wm5xvgKjZ3CCfOSbMCoXZj32tqX9r/WlW038t/Tzp9xiUsaYNFA4SeKG3lQWG7tkZmqzNZLiHKdWGGm6h93gYII1XPKGKzRwRKkGsOReXEMfokSDHJx+Qy5+Oc51AHx+70dVVJHslB64TcNu2hNOnVFCLkWjIqy6lL6j3OzOfXDUhjwX5TLv3QMf31X0h6V3lpTG7sAVJ/8DkvA0MmNY5TLwLDQe+QTMXsm2o2Jgolos4+1AQj5tyaU18vMsVyFPxCazXoMDPntDxiejL7tSE324yEwwzNw3DR6IGzT+4p7raqRZpDQfXtrPSjhoGobaXhzrxt7hH5epkW6FU7HfHXADUJjUBZ8eQfd5/3h/Ug+hR6BKUSHqo2GCFxHK1iQxihDOJ8whQfCjgoA7QQ61zfkLAzDyN+RpyylPCZyIj6ouiBWcT9EJkLVqCa21puo5zefc7gBLlzDeWec1xBa+2T4avYbAP8pT6KRnCdoA5NIXBOKpuo/ZhMx1GYTXvQlaKR7baoS+GvtMQSR0v8wTIW95OLWUiDDftJY3FXtbDQ8zEwVe5Mm3oApoHpkoJMZfGMi8w52839SyGoNLMroUQumcHHHmhHxYOwjkJz/cPjfOZUb0HlN1n+NjtoGvqd5NsE9P4XGsPpvB336QDxeR/PveRTjha3QWba7fimm2q85L65rY6PgRohSvibpaps6cQe2yXjwqXEa0/ZPB61p4Pvws7MtGwlxSifXFSewANWUFIuWuTHdtc/ynj2HqmS24Nw2KyB6pVXiobtV24pk45BKZEN0ZCesW+5J6pORtgEv1LvwJwCv9FmN6UZWWN2y1rOKKfdEkqc5quvcoRot6Ukjpz3teOVCKjQDh8AYuKNWF407SnrA7KFeFCLuwWGru8O9VvbOH1iEyI9c/UYOSP2xuu8jdSXcMfgPQMk44kWXkkjT74Qwj4mWVAvzkDz8t2Rh/YQeaOrqFspFgID5TbIVrIIcr7AwDtB+frRRsNuLFlRIPsUlWqNbc1urJpLgT6FlXqvKLNnI3iPmsheg+r1oPjHf1wqdOdNu+qpTaGjZ8menpPr6KbecIec1O89vjqT8+EKKvbDMt2sSAtFeOyqW4cTESjNeZiSsAmH+zUgZk32pofThJ8RH7vQPu/5Hq2vu6Sfr1Btrsz3zKnu0muMyGnHu+4VJJ5OwXmW4baTrLlrVvUFhCO9ps7bUk6DrsTxiuVt0ngqfjVfFVSQLCsRxDyf004JOPzWdkaYrSpi6RyBJr7hI6oRI7CeXuWgyeOQQ3STqUBGwNCT0cNs1Wf1iIBoHs+juWc9JMMbMe/k7acUngKBFSCUZ9PxJ4u55kcmDx93MLsybx5Ld0GyWGsSRbsproAm5JoIIbvv8rZvsoeVvxDpKI82spN8IQNwzugc/wMjVaHAf/aRj/YkdMrkfox1XpFG3mlEOvQLFeJ2w==",
         |  "intermediaryNumber": "IN9002224567",
         |  "lastUpdated": {
         |    "$$date": "${yesterday}T12:06:01.551Z"
         |  }
         |}
         |
        |""".stripMargin,
      s"""
         |{
         |  "_id": {
         |    "$$oid": "69943ceae6f82aaba6ce4946"
         |  },
         |  "journeyId": "6b301bae-3d8f-4e82-ac7b-1eeed1d0d1ea",
         |  "data": "gMK7gfKL/ztmPWuArYgOcFj+dUo3pTQLcH581djlSUb+0gWxogtJRzilguTYwOza1cVX9xj+DPUqb6PV4NzlTiU2PD6f8tLsKjvFbJvh+aqmW2+5QgUVO3iTbygrQ/Fm+nAF+uJJZmw0BBU4rkPEb38E2bSXxpEANmyZxPBRuSy0szwVYLsxv9gyQeWx+pD1zf5Pn5hdJm4iz7LBzC3MihGFt68l/HCwJJaduXQm+K0+PU8gyeF6bOhxre4pamYJIzPC1uBXhk7MMA==",
         |  "intermediaryNumber": "IN9008888888",
         |  "lastUpdated": {
         |    "$$date": "${yesterday}T10:03:22.071Z"
         |  }
         |}
         |""".stripMargin,
      s"""
         |{
         |  "_id": {
         |    "$$oid": "6994400ae6f82aaba6d158f8"
         |  },
         |  "journeyId": "46d06582-735b-4ffa-8e24-781f0e9dc49d",
         |  "data": "i5qK91xfbdoJTfzr5Cv0uJ+31MICJSPYebm0UErzEEbn+TqgYGu3N0RD1vsbL8JLuwOVorkQVV0Tz83PXWrvXPnvjztsZGVDLyq9j9f+5cpLyQFrcTNaxwrEBMLjKzRmJnBQogsXkAGomgQUvnLS0V0JHtOJ/t1tug8sVFYuvLh0I5idT2RVsntLkjzU+Zj+vvc0SKMYuTOJkX30lC62KDEkU+yyfzKKIumQXn+DlOqvzwR191la2ZChgNBkeklg1cX5+cG+IwK8BrsB6IlwJvsBnqivrX7eqBfGfqfv8WNvrba+7MvoAsqOCzx22lxM+RXUMUmKHErIc1SmjPdC6bl/bSSMT+y/BVYRU8RlkX0BNx4QeXqIyHG33tpHcKaVoSEpPSf/SXGxM+2Rvz+e3bEsllg8BLLK71xnlbmcOFv4P8mTSjhGgiZUd8fXoV72IQ8gYrzrMJz8v2eF5oE7d4CrVOHMqBDOE5ijLgxH9T5K3Zl8vQI+QWzje/pg5CufuL5EL+IEiGpwQBG1HTWqGsuwNerD4d0b1Bb6Uu30pWLgfd/XQIs65qoqsWz2cbhJA6K9Hk4eNs8AtpfKtVnzy9MRpohpS8MpEYcFpq3HeClz+blT3SSGZ5w/E/obPot5ZD+NIibeKvvwRSvwf9o6oDujcnX3uPgw6IpEVi2e6F5pAVoWg62a",
         |  "intermediaryNumber": "IN9008888888",
         |  "lastUpdated": {
         |    "$$date": "${yesterday}T10:16:42.911Z"
         |  }
         |}
         |""".stripMargin,
      s"""
         |{
         |  "_id": {
         |    "$$oid": "69944afae6f82aaba6dc1115"
         |  },
         |  "journeyId": "c8d5c883-c605-44d6-b405-0da3090b58e9",
         |  "data": "grO+8wOUw8VXHC3q3Br9LsmbLJB0L+wlkSGUM5Tf7Kzb4Pt72GKD9aYJsdKfJ6AIAPthUmou7R//RZ9bUdPldTCCdVndZclEyz9b1+wb90xxlWGciLohdfVnrBmKKdHJ7TLCDYG96a5PfaYNAa/crhPElMRQoQn5ucYedK/vXbdAg8suUyotuSKo4BhOS27ddh7Mq2aKCj8g0xiAh8ZXd8oZcpIDYorDol2Tj9Qe/4DY2yMSq7ZPM5grlg7Bp49urCyVFTCVR8hr5Q4xhmwu4t8PeRvhNpkqXFEKXM5pfC5mNzDX1DwUjVvS3/96Riw/vsaMzAgZXiW16G2U9uNKPjPUW/DIYu+WTDUB+KOeP6d/hhLu6McGS9186XfR/CqVi4X9AZKYZ5jIxi4vndcYbT2f7ShWPeYR/xcBCvSviw2mOC+rCOdKxdsMjTA3PWioGR76/rSDtIPT72zg4t0l+1ft6uS5m11sZxrwoMAyBPX+mwIh99+HWY96/A9zfnuxonfbn6e/BLpUwmZyW7jFyUcFPM2Do6R7DyqZfn2VqNRSEyNAiK3o9L4LuXFzb7DHwC/+65LRLxKTHGjc4QKudgIsnLHY6azvt4uRMdtB8eHRCLQO1Y3bDG4Wsg6HS3ucD5l7OTb92KftY7YZUu3lZdo+XD9cFqCdHOYfUOCGptYa0kst9wwoqIg0IEn1/XjE6/VDjie53KmVmc0lQd6P16WPOJgc+IM96AEU9WpxOKa/sWEkOsaqMyXpDmhldaFILipwqQvm5POuHCr9mj7Rncn7HQ9V5/jQ0Fwh5XrZ",
         |  "intermediaryNumber": "IN9008888888",
         |  "lastUpdated": {
         |    "$$date": "${yesterday}T11:03:22.681Z"
         |  }
         |}
         |""".stripMargin,
      s"""
         |{
         |  "_id": {
         |    "$$oid": "69945c0ee6f82aaba6ece134"
         |  },
         |  "journeyId": "8a33675c-7320-466f-8934-d39c2df60eca",
         |  "data": "fswoNt7FLIk2Tf8dn0oeqywgtizmQ7hafNGgwI7DLj7qcqodQ0f/6LJl8OUNKRSulrP0PlGw+Qr/mkw7ccpZwOOWdftISUTB6Z25AYA/Wcmr2hhje868k8JIyHSIk/9ZR0kc+mdiPJj8W3hJrWmueUG2uH44QyXNPgvqrbYvQ+t0uQth46Sewliq5FPvmmKDEABHTcoedNv419pcM3TZJch2vuaBxvA0DlsAyUoUUf6XLhsW9k14VyHGswYaqwaZrPcG08R4wRii5zoQIynpu/fHzdfgMn0kf7tpeYjRQvhVYV6p2qnm8RKhQcZ10ElkoNYaimskmUWk7JMcxnSt73i8kWh4b9cn+sJwSxI4Zq1DIbJzBE3EQhYhXO4UW+7dabYm26aRv2kWov7zo79X2WBznCHUKq6pMXIO9/gwG/6eg2I5FIaj7aPDdU1DzmDTYBKeSwlRHU7UWHjrd2d2yLL2ZdJMiI7Uwely08eQXyHr1QBbaUCt5P6Zc6TG/KLNNujBAkVwXBlk65lkqrc7ZsrAfwSBxY8OA4jKS6+hQkz586q0hQtH3vArH2/uz8Xui6795ep0eobw8ggjQbfHGy9FEzpcsL+ctQcZEdm9aKaRBmnPNGQo0eWoyKRulQ7VJI3Dm0x/kA8YS/f168DbG+/9GJhI/uNodbYng8m1/c4IEW5tpRUToHoF5uFByrlepOAQozoSOp/fscKll6Cw+Q6XP5dzUbIA1OmsNlfm1kvSEYlPUWL/Kkl/AuyQ3cVypVOiVkTpbr8d4X/36Tu9uMm6YUXel+01WegXh8uZHSpYxwhIVq/9Xf64CleGhTQbg5P6MjW3KQAHkGZDhrY6zzfSsyrwYjeVsEov7g9qzZPmSHQMsYRmutV3V0czH4kXmvUdeUNFFMQfEzMoxyU5sRB5U+BRPYLVMBksfQvQMPLwF1FOKk5WJTouG8WblXCwjvWPrNqyjsVeSWScza+vUkUnbLsDjwI/ZhA0lmTpriz3Rk+JGaOAg+bEP/iC/U58rVtZFF+GX3JKpXQSzkq9+W88Vrq2I1xSXVSILuQsVr8vwSybiNtkUvPCtTJyHbxmtlREBU9eqeG9ba7d0PO5gKHPwWl2CO0okxxnf2VkY0oHxg==",
         |  "intermediaryNumber": "IN9008888888",
         |  "lastUpdated": {
         |    "$$date": "${yesterday}T12:16:14.380Z"
         |  }
         |}
         |""".stripMargin
    )
}
