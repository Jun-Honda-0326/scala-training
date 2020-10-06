import scala.util.{ Try, Success, Failure } 

object MainOct06th{

  def main(args:Array[String]): Unit = {
    val either1:Either[String, Int] = Right(10)
    val either2:Either[String, Int] = Left("Error")
    println(eitherFlatMap(either1))
    println(eitherToLeft(either1))
    println(eitherMatch(either1))
    println(eitherMatch(either2))
    println(checkTry(10,2))
    println(checkTry(0,0))
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
}
  













