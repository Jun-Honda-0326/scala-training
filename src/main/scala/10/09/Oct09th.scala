import scala.concurrent._
import ExecutionContext.Implicits.global


object Main09th {

  def main(args:Array[String]):Unit = {

    println(run())
    println(futureSample)
  }

  def run():Unit = {

    Future {
      (1 to 10).foreach{i => Thread.sleep(1000)
      println(i)
      }
    }

   Future { 
     (11 to 20).foreach{i => Thread.sleep(2000)
     println(i)
     }
   }
  }


  def futureSample:Unit = {
  
   val s ="Hello"
   val f:Future[String] = Future {
     s +" future!! "
   }
   
   f foreach{
     msg => println(msg)
   }
  }
}
