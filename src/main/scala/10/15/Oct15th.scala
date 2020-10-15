//問題1
// 文字列の配列、strSeqが与えられます。※ seqの定義は以下
//val strSeq: Seq[String] = Seq("し", "な", "て", "も", "お")
//foldLeftを使って、"おもてなし"(型はString)という文字列を作成してください。(他に必要なメソッドがあれば、使用しても構わない)


//問題2
//数字の配列、intSeqが与えられます。 ※ intSeqは空の可能性もある
//val intSeq: Seq[Int] = Seq(1,2,3,4) もしくは Seq()
//reduce もしくは reduceOptionを使って、intSeqの中身を合計する処理を作成してください。(配列が空の場合には、0を返すこと)


//問題3
//数字の配列、intSeqが与えられます。 ※ intSeqは空の可能性もある
//val intSeq: Seq[Int] = Seq(1,2,3,4) もしくは Seq()
//collectを使って、1の場合には"x"を、2の場合には"y"を、それ以外の場合には"z"に変換し配列を返す処理を作成してください。


//問題4
//数字の配列、intSeqが与えられます。 ※ intSeqは空の可能性もある
//val intSeq: Seq[Int] = Seq(11, 22, 44, 33) もしくは Seq()
//reduceOptionを使って、intSeqの最大値を算出する処理を作成してください。(配列が空の場合は、0を返すこと)



object Main {

  def main(args:Array[String]):Unit = {
    val strSeq: Seq[String] = Seq("し", "な", "て", "も", "お")
    val intSeq: Seq[Int] = Seq(1,2,3,4)
    val intSeq2: Seq[Int] = Seq()
    val intSeq3: Seq[Int] = Seq(11,22,44,33)

    println("問題1の答え")
    println(question1(strSeq))
    println("問題2の答え")
    println(question2(intSeq))
    println(question2(intSeq2))
    println("問題3の答え")
    println(question3(intSeq))
    println(question3(intSeq2))
    println("問題4の答え")
    println(question4(intSeq3))
    println(question4(intSeq2))
  }



  //問題1
  def question1(strSeq: Seq[String]):String = {
    val nil:Seq[String] = Nil
    strSeq.foldLeft(nil)((a, x) => x +: a).mkString("")
  } 

  //問題2
  def question2(intSeq: Seq[Int]):Int = {
    intSeq.reduceOption((a,b) =>  a + b ).getOrElse(0)
  } 

  //問題3
  def question3(intSeq: Seq[Int]):Seq[String] = {
    val seq = intSeq.collect{
      case 1 => "x"
      case 2 => "y"
      case _ => "z"
    } 
    if (seq.isEmpty) Nil else seq 
  }

  //問題4
  def question4(intSeq: Seq[Int]): Int = {
    intSeq.reduceOption((a, b) => if (a > b)  a else b ).getOrElse(0)
  }

}
