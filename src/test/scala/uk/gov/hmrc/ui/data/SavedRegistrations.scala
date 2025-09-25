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
        |""".stripMargin
    )
}
