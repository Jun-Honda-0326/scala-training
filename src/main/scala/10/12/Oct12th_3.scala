import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
import scala.util._
import scala.concurrent.duration._
import scala.util.Random

object FuturePractice extends App {

  def random(futureName: String): List[Int] = {
    val r:List[Int] = List.fill(10)(Random.nextInt(10)) 
      if (!r.contains(1)) throw new Exception("1はありません")
      r
   }

  val future1: Future[List[Int]] = Future {
    random("future1")
  }

  val future2:Future[List[Int]] = Future {
    random("future2")
    
  }
  //println(future1.isCompleted) false

  //val result = Await.ready(future1, Duration.Inf)
  //println(s"future1をresultに格納  ${result}")
  //println(future1.isCompleted)

  future1.onComplete{
    case Success(future1) => println(s"future1の結果  ${future1}")
    case Failure(f) => println(s"future1の結果 ${f.getMessage}")
  }
  
  future2
  .andThen{
    case Success(future2) => println(s"future2 andThenの結果  ${future2}") 
  }.onComplete { 
    case Success(future2) => println(s"future2 onCompleteの結果  ${future2}") 
    case Failure(f) => println(s"future2の結果 ${f.getMessage}")
  }

  val composedFuture: Future[List[Int]] =
    for{
      first <- future1
      second <- future2
    } yield (first ++ second)

  composedFuture.onComplete{
    case Success(s) => println(s"合成結果: ${s}")
    case Failure(f) => println("合成できませんでした")
  }


        
       
        
  Thread.sleep(3000)
        
    
}
