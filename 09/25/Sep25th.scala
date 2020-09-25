object Sep25th {
  def main(args: Array[String]):Unit = {
    val num1: Option[Int] = Some(100)
    val none: Option[Int] = None
    println(optionQuestion1)
  }
  
//1 Option[Int]型である、numが引数として渡されるメソッドoptionQuestion1があります。Someの場合はその値を、Noneの場合は０を返却するメソッドを、getOrElseメソッドを使って作成してください。

def optionQuestion1(num: Option[Int]):Int {
    num.getOrElse(0)
   

    

    /*// if (i.getOrElse(num)　=== Some){
      println(i)
    }else
      println(0)
*/
  }
}
