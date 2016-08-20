import slick.backend.StaticDatabaseConfig
import slick.dbio.DBIO
import slick.driver.PostgresDriver.api._
import scala.concurrent._
import ExecutionContext.Implicits.global

@StaticDatabaseConfig("file:src/main/resources/application.conf#tsql")
object Db {
  val program: DBIO[Seq[String]] =
    tsql"""select "content" from "message""""
}
