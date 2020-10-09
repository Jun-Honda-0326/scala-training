 object Sep25th { 
  def main(args: Array[String]):Unit = {
    val num1: Option[Int] = Some(100)
    val none: Option[Int] = None
    val num2: Option[Option[Int]] = Some(Some(200))
    val none2: Option[Option[Int]] = None
    val map: Map[Int, String] = Map(1 -> "ロシア", 2 -> "カナダ", 3 -> "アメリカ")

    println(optionQuestion1(num1))
    println(optionQuestion1(none)) 
    println(optionQuestion2(num1))
    println(optionQuestion2(none))
    println(optionQuestion4(num2))
    println(optionQuestion4(none2))
    println(optionQuestion5(num1))
    println(optionQuestion5(none))
    println(mapPractice(map))
  }


//題1 Option[Int]型である、numが引数として渡されるメソッドoptionQuestion1があります。Someの場合はその値を、Noneの場合は０を返却するメソッドを、getOrElseメソッドを使って作成してください。

 
  def optionQuestion1(num: Option[Int]):Int = {
    num.getOrElse(0)
  }


//問題2 Option[Int]型である、numが引数として渡されるoptionQuestion2メソッドがあります。Someの場合はその値に3を足したSome[Int]を、Noneの場合はそのままNoneを返却するメソッドを、mapメソッドを使って作成してください。

  def optionQuestion2(num: Option[Int]):Option[Int] = {
    num.map(n => n * 3)
  }


//問題3 val strOpt: Option[String] = Some("") を定義し、それに対してisEmpty, isDefined を実行した場合にどのような挙動をするか確かめてください。

//isEmptyを実行した場合はfalse、isDefinedを実行した時はtrueになる。


//問題4 Option[Option[Int]]型である、numが引数として渡されるoptionQuestion4メソッドがあります。Someの場合はその値を2倍したSome[Int]を、Noneの場合はそのままNoneを返却するメソッドを作成してください。

  def optionQuestion4(num: Option[Option[Int]]):Option[Int] = {
    num.flatten.map(n => n * 2)
  }


  def optionQuestion5(num: Option[Int]): Int = {
    num match {
      case Some(i) => 1000
      case None => -1
    }
  }

  def mapPractice(map:Map[Int,String]):Unit ={
     val list =  for (m <- map.values) yield m 
     val list2 = list.toSeq
     val keys = map.keys.toSeq 

     var i = 0

     while(i < keys.length) {
       println(s"${keys(i)}位は${list2(i)}です")
       i = i + 1
     }
  }




}

