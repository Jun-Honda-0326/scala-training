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

 //簡単なスレッドの作り方
  println(Thread.currentThread().getName)

  val thread = new Thread(() => {
    Thread.sleep(1000)
    println(Thread.currentThread().getName)
  })
  thread.start()

  println("main thread finished.")

    // 10個のスレッドが協調して、10万ずつをcounterという変数をインクリメントしながら出力する
    private var  counter = 0
    def next(): Int = synchronized {
      counter = counter + 1
      counter
    }
    for (i <- 1 to 10){
      new Thread(() => for(j <- 1 to 10) println(next())).start()
    }

    for(i <- 1 to 4){
      new Thread(() => for(j <- 1 to 100) println(s"thread ${i}: ${j}")).start() 
    }


  //スレッド A は、1000 ミリ秒待った後、現在の UNIX 時刻のミリ秒を取得してフィールド now に代入して下さい。
  //スレッド B は、now に値が新たに代入されるまで待ち続け、コンソールに出力するようにしてみてください。
  var now: Long = 0L
  val threadA = new Thread(() => synchronized {
    Thread.sleep(1000)
    now = System.currentTimeMillis()
  })
  val threadB = new Thread(() => synchronized {
    while (now == 0L) {
      Thread.sleep(1000)
    }
    println(now)
  })
  threadA.start()
  threadB.start()

}

