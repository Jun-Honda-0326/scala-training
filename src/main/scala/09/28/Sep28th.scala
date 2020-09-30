object Sep28th {
  def main(args:Array [String]):Unit = {
    val numSeq1: Seq[Int] = Seq(1,3,5,6,8,9,15,21)
    val numSeq2: Seq[Int] = Seq(43,50,78,99,100,101,111)
    val numSeq3: Seq[Int] = Seq(1,11)
    val numSeq4: Seq[Int] = Seq()
    val numSeqSeq1: Seq[Seq[Int]] = Seq(Seq(1,3,5,6,7,9,12,24), Seq(2,4,5,7)) 
    val numOptSeq1: Seq[Option[Int]] = Seq(Some(0), Some(2), Some(3))
    val strSeq1: Seq[String] = Seq("hi", "hello", "ども", "great")
    
    println(seqQuestion1(numSeq1))
    println(seqQuestion2(numSeq1))
    println(seqQuestion3(numSeqSeq1))
    println(seqQuestion3_1(numSeqSeq1))
    println(seqQuestion3_2(numSeqSeq1))
    println(seqQuestion4(numSeq1))
    println(seqQuestion5(numOptSeq1))
    println(seqQuestion6(strSeq1))
    println(seqQuestion7(numSeq1))
    println(seqQuestion7(numSeq2))
    println(seqQuestion8(numSeq2))
    println(seqQuestion9(numSeq2))
    println(seqQuestion10(numSeq2))
    println(seqQuestion10(numSeq3))
    println(seqQuestion10(numSeq4))
    println(reverse(numSeq1))
    println(reverse_1(numSeq1))
    println(sum(numSeq1))
    println(sum(numSeq4))
    println(sum_1(numSeq1))
    println(sum_1(numSeq4))


  }

//問題1
//Seq[Int]型である、numSeqが引数として渡されるseqQuestion1メソッドがあります。numSeqの要素のうち、3の倍数の要素のみ0に変換する関数を実装してください。

  def seqQuestion1(numSeq: Seq[Int]):Seq[Int] = {
    numSeq.map(n => if(n % 3 == 0)  0 else n)
    // List(1,0,5,0,8,0,0)
  }

//問題2
//Seq[Int]型である、numSeqが引数として渡されるseqQuestion2メソッドがあります。 numSeqのうち3の倍数のみを返すメソッドをfilterを使って作成してください。

  def seqQuestion2(numSeq: Seq[Int]):Seq[Int] = {
    numSeq.filter(_ % 3 == 0)
    //List(3,6,9,15,21)
  }

//問題3
//Seq[Seq[Int]]型である、numSeqSeqが引数として渡されるseqQuestion3メソッドがあります。 numSeqSeqのうち3の倍数を含むSeqのみを返すメソッドをfilterとexistsを使って作成してください。

  def seqQuestion3(numSeqSeq: Seq[Seq[Int]]):Seq[Seq[Int]] = {
    numSeqSeq.filter(_.exists(_ % 3 == 0))
    //List(List(1,3,5,6,7,9,12,24))
  }


  //numSeqSeq1の中からさらに３の倍数を持つものを抽出
  def seqQuestion3_1(numSeqSeq: Seq[Seq[Int]]):Seq[Seq[Int]] = {
    numSeqSeq.filter{n => 
      println(n.filter (_ % 3 == 0))
      true
    }
  }
   

//問題3をさらに細分化したもの。ここでexistsはSeqの中に値が入っているか調べるためのもの。
  def seqQuestion3_2(numSeqSeq: Seq[Seq[Int]]):Seq[Seq[Int]] = {
     numSeqSeq.filter{ x =>
      println(x.exists(_% 3 == 0))
      true
    }
}


//問題4
//Seq[Int]型である、numSeqが引数として渡されるseqQuestion4メソッドがあります。 numSeqに偶数が含まれていればその最初の値を、含まれていない場合は-1を返すメソッドをfindを使って作成してください
//

  def seqQuestion4(numSeq: Seq[Int]):Int = {
    numSeq.find(_ % 2 == 0).getOrElse(-1)
  }
  //ここでgetOrElseはOptionの中身を取り出すのでOption[Int]にはならない
  // 6


//問題5
//Seq[Option[Int]]型である、numOptSeqが引数として渡されるseqQuestion5メソッドがあります。 numOptSeqのうち0を含む最初のOption[Int]を返すメソッドをfindとcontainsを使って作成してください。

  def seqQuestion5(numOptSeq: Seq[Option[Int]]):Option[Int] ={
    numOptSeq.find(n => n.contains(0)).flatten  
  }
// Some(0)

  //問題6
  //Seq[String]型である、strSeqが引数として渡されるseqQuestion6メソッドがあります。 strSeqのうち文字列の長さが2以上であるものの末尾に"x”を追加し、それらのみを含むSeqを返すメソッドを、collectを使って作成してください。

  def seqQuestion6(strSeq: Seq[String]): Seq[String] = {
    strSeq.collect{case str if str.length >= 3 => str + "x"}
  }
// List(hellox, greatx)

//問題7
//Seq[Int]型であるnumSeqが引数として渡されるseqQuestion7メソッドがあります。 numSeqのうち値が100以上である最初のIntを2倍した値を返すメソッドを作成してください。 100以上の値がない場合は0を返してください。 メソッドはcollectFirstを使って作成してください。

  def seqQuestion7(numSeq: Seq[Int]): Int = {
    numSeq.collectFirst{case num if num > 100 => num * 2}.getOrElse(0)
  }
  //0 , 202


//問題8
//Seq[Int]であるnumSeqが引数として渡されるseqQuestion8メソッドがあります。 このうち先頭の値と末尾の値を足し合わせた値(Int)を、 Seqが空である場合は0を返すメソッドをheadOptionとlastOptionを用いて作成してください。

  def seqQuestion8(numSeq: Seq[Int]): Int = {
    numSeq.headOption.get + numSeq.lastOption.get
  }
  // 154

//問題9
//Seq[Int]である長さ3以上のnumSeqが引数として渡されるseqQuestion9メソッドがあります。 このうち先頭の値と末尾の値を除いたSeq[Int]を取得するメソッドをinitとtailを用いて作成してください。

  def seqQuestion9(numSeq: Seq[Int]): Seq[Int] = {
    numSeq.init.tail
// List(50, 78, 99,100,101 )
  }

//問題10
//Seq[Int]型である、numSeqが引数として渡されるseqQuestion10メソッドがあります。 numSeqの要素数が3以上の場合、最初の値と最後の値を足した値を返すメソッドを作成してください。 numSeqが要素が2以下、1以上の場合は0を、numSeqが空の場合は-1を返してください。 メソッドの作成にはmatch式と:+, +:などを用いてください。

  def seqQuestion10(numSeq: Seq[Int]): Int = numSeq match {
      case head +: _ +: _ +: _ :+  last => head + last  
      case _ :+ _ => 0
      case Nil => -1
  }
  // 154, 0, -1

//問題11
//foldLeftを用いて、Seqの要素を反転させる次のシグニチャを持ったメソッドreverseを実装してみましょう。

  def reverse(numSeq: Seq[Int]): Seq[Int] = {
    numSeq.foldLeft(Seq.empty[Int])((a, b) => b +: a)
  }
  List(21,15,9,8,6,5,3,1)

  //問題11の別解

  def reverse_1(numSeq: Seq[Int]): Seq[Int] = {
    val rev: Seq[Int] = Nil
    numSeq.foldRight(rev)((a,x) => x :+ a)

  }


//問題12
//Seqの全ての要素を掛け合わせるメソッドsumをfoldRightを用いて実装してみましょう。
//Seqが空のときは1を返してみましょう。

  def sum(numSeq: Seq[Int]): Int = {
    numSeq.foldRight(1)(_ * _)
  }

//問題13
//問題12でreduceを使ってSeqが空の場合、エラーを吐くようにしましょう。

  def sum_1(numSeq: Seq[Int]): Int ={
    numSeq.reduce(_ * _)
  }




//問題14
//Seq(3×4, 4×2, 4×1)の最小値を出力しましょう。
//
//問題15
//Seq(3×4, 4×2, 4×1)の最大値を出力しましょう。  
//
//

}
