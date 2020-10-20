object  MainPractice1_8 {

  def main(args:Array[String]): Unit = {
    val numOpt1:Option[Int] = Some(11)
    val numOpt2:Option[Int] = Some(6)
    val numOpt3: Option[Int] = Some(3)
    val numOpt4: Option[Int] = None
    val seq:Seq[Int] = Seq(6,5,7,4,2,1,8)
    val seq2:Seq[Int] = Seq(1,1,2,2,3,3,4,5,6,6,7)
    val seqOp1:Seq[Option[Int]] = Seq(Some(20), Some(30), None)

    println("問題1の答え")
    question1(numOpt1)
    question1(numOpt2)
    question1(numOpt3)
    question1(numOpt4)
    println("問題2の答え")
    println(question2(numOpt1))
    println(question2(numOpt4))
    println("問題3の答え")
    println(question3(seq))
    println("問題4の答え")
    println(question4(seq))
    println("問題5の答え")
    println(question5(seqOp1))
    println("問題6の答え")
    println(question6(seq))
    println("問題7の答え")
    println(question7(seq))
    println("問題8の答え")
    println(question8(seq2))
  }

 

//問題1
//Option[Int]型の numOptを引数として受け取り
//numOptがSomeでかつ値が10以上であれば、"A"
//numOptがSomeでかつ値が9以下、5以上であれば、"B"
//numOptがSomeでかつ値が4以下であれば"C"
//numOptがNoneであれば"D"
//を標準出力させるメソッドquestion1を作成してください

  def question1(numOpt: Option[Int]):Unit  = {
    numOpt  match{
      case Some(i) if(i > 10) => println("A")
      case Some(i) if(5 < i && i < 9) => println("B")
      case Some(i) if(i < 4) => println("C")
      case _ => println("D")
    }
  }

//問題2
//Option[Int] => String に変換する関数 convと、Option[Int]型である numOpt を引数にとり、numOptを文字列にして返すメソッドconvertToStringがあります。convertToStringを使ってnumOpt: Option[Int]をStringに変換するメソッドquestion2を作成してください。
//numOptは以下の条件に従って変換させること
//    1.numOptがSome()であれば、そのIntの値をStringに変換する
//    2.numOptがNoneであれば、"空でした"というStringに変換する

  def convertToString(numOpt: Option[Int])(conv: Option[Int] => String): String = conv(numOpt)
  
  def question2(numOpt: Option[Int]):String = {
      convertToString(numOpt){n => n.getOrElse("空でした").toString }
  }


//問題3
//Seq[Int]型であるnumsを引数として受け取り、配列の中身を昇順でソートするquesion3を作成してください
  
  def question3(seq: Seq[Int]):Seq[Int] = {
    seq.sorted
  }

//問題4
//Seq[Int]型であるnumsを引数として受け取り、配列の中身を降順でソートするquesion4を作成してください。その際にreverseメソッドは使用しないこと

  def question4(nums:Seq[Int]):Seq[Int] = {
    nums.sortWith((a, b) => a > b)
  }

  //問題5
  //Seq[Option[Int]]型である、numOpsを引数にとりnumOpsの要素がSomeの場合は中の数字を、Noneの場合はリストから外したSeq[Int]を返すquestion5を作成してください
  def question5(numsOps: Seq[Option[Int]]):Seq[Int] = {
    numsOps.flatten
  }

//問題6
//Seq[Int]型である、numsを引数として渡され、各要素とその要素のindex(位置)をタプルで紐付けたSeq[(Int,Int)]を返すquestion6を作成してください

  def question6(nums: Seq[Int]):Seq[(Int, Int)] = {
   nums.zipWithIndex 
  } 

//問題7
//Seq[Int]型であるnumsを引数として受け取り、numsの最大値のindex(添字)を返却するquestion7を作成してください
//最大値が複数存在する場合は、そのうちいずれかが返却されているようになっていれば問題ない

  def question7(nums:Seq[Int]):Int ={
    nums.indexWhere(i => i == (nums.max))
  }

//問題8
//Seq[Int]型であるnumsを引数として受け取り、配列の中の重複を省いた状態で返すquestion8を作成してください

  def question8(nums:Seq[Int]):Seq[Int] = {
    nums.distinct
  }


}
