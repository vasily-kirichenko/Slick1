import slick.backend.StaticDatabaseConfig
import slick.driver.PostgresDriver.api._

import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

@StaticDatabaseConfig("file:src/main/resources/application.conf#tsql")
object Main {
  val cmd: DBIO[Seq[String]] = tsql"select content from message"
  val db = Database.forConfig("test")
  db.run(cmd).onComplete {
    case Success(x) => println(x)
    case Failure(e) => println(s"Error: $e")
  }
}

