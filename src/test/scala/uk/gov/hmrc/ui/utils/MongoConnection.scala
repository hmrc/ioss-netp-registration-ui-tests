/*
 * Copyright 2023 HM Revenue & Customs
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

package uk.gov.hmrc.ui.utils

import org.mongodb.scala.{MongoClient, SingleObservableFuture}
import org.mongodb.scala.bson.collection.immutable.Document

import scala.concurrent.Await
import scala.concurrent.duration.*

object MongoConnection {

  private val timeout: FiniteDuration = 10.seconds

  private val mongoClient: MongoClient = MongoClient()

  sys.addShutdownHook {
    mongoClient.close()
  }

  def insert(source: List[String], database: String, collection: String): Unit =
    try {
      val db  = mongoClient.getDatabase(database)
      val col = db.getCollection(collection)
      source.map { e =>
        val doc = Document(e)
        Await.result(
          col.insertOne(doc).toFutureOption(),
          timeout
        )
      }
    } catch {
      case ex: Exception => println(s"Error inserting data into MongoDB: $ex")
    }

  def dropRecords(db: String, collection: String): Unit =
    try
      Await.result(
        mongoClient
          .getDatabase(db)
          .getCollection(collection)
          .drop()
          .head(),
        timeout
      )
    catch {
      case e: Exception => println("Error: " + e)
    }

  def dropPendingRegistrations(): Unit =
    dropRecords("ioss-netp-registration", "pending-registration")
}
