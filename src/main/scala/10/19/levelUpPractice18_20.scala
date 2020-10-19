import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

case class Props(
  length: Int, // 縦
  width:  Int  // 横
)


object MainPractice18_20 {

  def main(ags:Array[String]): Unit = {

    implicit val height = 10
    val props = Props(5, 6)
    val today = LocalDateTime.of(2020, 10, 20, 9, 0, 0)
    val yesterday = LocalDateTime.of(2020, 10, 18, 9, 0, 0)

    println("問題18の解答")
    question18(props)
    println("問題19の解答")
    println(question19(today))
    println(question19(yesterday))
    println("問題20の解答")
    println(question20(yesterday))
  }
//問18
//props: Props が引数として受け取り、propsの値をもとにそれに基づいた直方体、四角錐の体積を計算するメソッドquestion18を作成してください
//高さの値: Int は、暗黙的にimplicit parameter として渡されるようにすること。(値は任意とする)

  def question18(props: Props)(implicit height: Int): Unit = {

    println("直方体の体積は" + props.length * props.width * height) 
    println("四角錐の体積は" + (props.length * props.width * height) * 1/3) 

  }

//問19
//LocalDateTime型のldtを引数として受け取り、ldtが現在の時刻より前であればtrueを、
//あとであればfalseを返すメソッドquestion19を作成してください

  def question19(idt: LocalDateTime): Boolean = {
    val now = LocalDateTime.now
    idt.isBefore(now)
  }

  def question20(idt: LocalDateTime):String = { 
    idt.format(DateTimeFormatter.ofPattern("yyy年MM月dd日 HH時ss分"))
  }

}
