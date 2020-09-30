 object Sep25th { 
  def main1(args: Array[String]):Unit = {
    val num1: Option[Int] = Some(100)
    val none: Option[Int] = None
    val num2: Option[Option[Int]] = Some(Some(200))
    val none2: Option[Option[Int]] = None
    
    println(optionQuestion1(num1))
    println(optionQuestion1(none)) 
    println(optionQuestion2(num1))
    println(optionQuestion2(none))
    println(optionQuestion4(num2))
    println(optionQuestion4(none2))
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
    
}

