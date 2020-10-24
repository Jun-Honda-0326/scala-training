import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.io.BufferedSource
import scala.util._
import scala.io._

object HttpTextClient {

  def get(url: String):BufferedSource= Source.fromURL(url)
}

object Main {

  def main(args:Array[String]):Unit = {
    
    val future: Future[BufferedSource] = Future (
      HttpTextClient.get("http://scalamatsuri.org/")
    )
    futureMap(future)
  }

  def futureMap(future: Future[BufferedSource]):Unit = {
    future.map (
      s => try s.mkString
      finally s.close)
    .onComplete{
      case Success(body) => println(body)
      case Failure(t) => t.getMessage()
    }
      
  }

  
}
