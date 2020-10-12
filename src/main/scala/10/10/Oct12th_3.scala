import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
import scala.util._
import scala.concurrent.duration._

object FuturePractice extends App {

  val future1 = Future {
    Thread.sleep(3000)
    "Futureは難しい"
  }
  println(future1.isCompleted)

  val result = Await.ready(future1, Duration.Inf)
  println(result.value.get.get)
  println(future1.isCompleted)

  future1.onComplete{
    case Success(s) => println(s"Success ${s}")
    case Failure(f) => println("${f.getMessage}")
  }
  


}
