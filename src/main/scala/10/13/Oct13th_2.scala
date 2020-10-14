//import scala.concurrent.ExecutionContext.Implicits.global
//import scala.util._
//import scala.concurrent._
//
//
//object FuturePractice2 {
//
//  def future1: Future[Int] = Future.successful(10)
//
//
//  def future2: Future[Int] = Future.successful(20)
//}
//
//object Main {
//
//
//   def main(args: Array[String]): Unit = {
//    println(composeFuture)
//  }
//
//  def composeFuture = {
//
//    val composeFuture: Future[Int] =
//    for {
//      future1 <- future1
//      future2 <- future2
//      } yield (future1 + future2)
//
//    composeFuture.andThen{
//      case Success(s) => s
//    }
//  }
//
//}
//
////
