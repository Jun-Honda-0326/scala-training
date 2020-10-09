import scala.util.{ Try, Success, Failure } 

object MainOct06th{

  def main(args:Array[String]): Unit = {
    val either1:Either[String, Int] = Right(100)
    val either2:Either[String, Int] = Left("Error")
    val either3:Either[String, Int] = Right(200)
    val success:Try[Int] = Success(100)
    val failure:Try[Nothing] = Failure(new Exception("エラーメッセージ"))
    
    println(eitherFlatMap(either1))
    println(eitherToLeft(either1))
    println(eitherMatch(either1))
    println(eitherMatch(either2))
    println(checkTry(10,2))
    println(checkTry(0,0))
    println(eitherQuestion2(either1,either2,either3))
    println(tryToEither(success))
    println(tryToEither(failure))

  }

  def eitherFlatMap(either: Either[String, Int]):Int = {
    either.flatMap(i => Right(i * 4)).right.get
    }

  def eitherToLeft(either: Either[String, Int]):Either[String, Int] = {
    either.flatMap(_ => Left("Error"))
  }

  def eitherMatch(either:Either[String, Int]):String = {
    either match {
    case Right(int) => s"値は${int}です"
    case Left(msg) => msg 
    }
  }

  def checkTry(x:Int, y:Int):String = {
    val try1:Try[Int] = Try(x /y) 
      try1 match {
        case Success(s) => (s).toString 
        case Failure(f) => f.getMessage
      }
  }

  def eitherQuestion2
    (either1:Either[String,Int], either2:Either[String,Int], either3:Either[String,Int]):Unit = {
   val v = for {
      val1 <- either1
      val2 <- either2
      val3 <- either3
    } yield { 
   
      val1 * val2 * val3
    }
    println("---")
    println(v)
  }

//問題3
//Try[Int]を、Either[String, Int]に変換するコードを書いてください。
//
//Eitherの左辺には、Tryが持っている Throwable.getMessageの値を渡してください。
//
//Try[Int]の定義で１行、変換で１行の計２行記述してください。 
 
  def tryToEither(i:Try[Int]):Either[String,Int] = {
    i.toEither.fold(f => Left(f.getMessage), s => Right(s))
  }
}

  
