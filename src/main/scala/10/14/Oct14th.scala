import scala.concurrent._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util._


object ExceptionPractice extends App {

  override def main(args:Array[String]):Unit = {
    val future = Future.failed(new Exception("エラー"))
   

    future.recover{
      case e: Exception => println(e.getMessage)
    }
  }
}









  
 
  



