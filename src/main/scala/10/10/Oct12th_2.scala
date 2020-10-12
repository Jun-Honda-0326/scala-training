//Futureの組み合わせ

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.language.postfixOps
import scala.util.{Success, Failure, Random}

object CompositeFuture extends App {

  val random = new Random()
  val waitMaxMillSec = 499 //3000ミリ秒

  def waitRandom(futureName: String): Int = { //futureNameはfirstもしくはsecond
    val waitMillSec = random.nextInt(waitMaxMillSec) //3000ミリ秒をMAXとする待機時間の生成（ランダム）
    if (waitMaxMillSec < 500) throw  new RuntimeException (s"${futureName} waitMaxMillSec is ${waitMaxMillSec}") //待機時間が500 ms  未満であれば Failureを返す
    Thread.sleep(waitMillSec)
    waitMillSec
  }

  val futureFirst: Future[Int] = Future{
    waitRandom("first")
  }

  val futureSecond: Future[Int] = Future{
    waitRandom("second")
  }
  
  //futureFirstとfutureSecondを合成する処理
  val compositeFuture: Future[(Int, Int)] = for {
    first <- futureFirst
    second <- futureSecond
  } yield (first, second)

  compositeFuture onComplete {
    case Success((first, second)) => println(s"Success first:${first}, second:${second}")
    case Failure(f) => println(s"Failure: ${f.getMessage}")
  }

  compositeFuture recover{
    case e:Exception => println(Future.successful(2))
  }
  Thread.sleep(5000)

}
