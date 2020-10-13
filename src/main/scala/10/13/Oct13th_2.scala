import scala.concurrent.ExecutionContext.Implicits.global
import scala.util._
import scala.concurrent._


object FuturePractice2 extends App {

  def future1: Future[Int] = Future.successful(10)


  def future2: Future[Int] = Future.successful(20)

  val composeFuture: Future[Int] =
  for {
    future1 <- future1
    future2 <- future2
    } yield (future1 + future2)

  composeFuture.andThen{
    case Success(s) => println(s)
  }

}
