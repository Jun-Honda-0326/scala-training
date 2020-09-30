object Sep28th {
  def main(args:Array [String]):Unit = {
    val numSeq1: Seq[Int] = Seq(1,3,5,6,8,9,15,21)
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
  }

//問題1
//Seq[Int]型である、numSeqが引数として渡されるseqQuestion1メソッドがあります。numSeqの要素のうち、3の倍数の要素のみ0に変換する関数を実装してください。

  def seqQuestion1(numSeq: Seq[Int]):Seq[Int] = {
    numSeq.map(n => if(n % 3 == 0)  0 else n)
  }

//問題2
//Seq[Int]型である、numSeqが引数として渡されるseqQuestion2メソッドがあります。 numSeqのうち3の倍数のみを返すメソッドをfilterを使って作成してください。

  def seqQuestion2(numSeq: Seq[Int]):Seq[Int] = {
    numSeq.filter(_ % 3 == 0)
  }

//問題3
//Seq[Seq[Int]]型である、numSeqSeqが引数として渡されるseqQuestion3メソッドがあります。 numSeqSeqのうち3の倍数を含むSeqのみを返すメソッドをfilterとexistsを使って作成してください。

  def seqQuestion3(numSeqSeq: Seq[Seq[Int]]):Seq[Seq[Int]] = {
    numSeqSeq.filter(_.exists(_ % 3 == 0))

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



//問題5
//Seq[Option[Int]]型である、numOptSeqが引数として渡されるseqQuestion5メソッドがあります。 numOptSeqのうち0を含む最初のOption[Int]を返すメソッドをfindとcontainsを使って作成してください。
//

  def seqQuestion5(numOptSeq: Seq[Option[Int]]):Option[Int] ={
    numOptSeq.find(n => n.contains(0)).flatten  
  }


//問題7
//Seq[Int]型であるnumSeqが引数として渡されるseqQuestion7メソッドがあります。 numSeqのうち値が100以上である最初のIntを2倍した値を返すメソッドを作成してください。 100以上の値がない場合は0を返してください。 メソッドはcollectFirstを使って作成してください。
//

  //問題6
  //Seq[String]型である、strSeqが引数として渡されるseqQuestion6メソッドがあります。 strSeqのうち文字列の長さが2以上であるものの末尾に"x”を追加し、それらのみを含むSeqを返すメソッドを、collectを使って作成してください。
  //

  def seqQuestion6(strSeq: Seq[String]): Seq[String] = {
    strSeq.collect{case str if str.length >= 3 => str + "x"}


  }





//問題8
//Seq[Int]であるnumSeqが引数として渡されるseqQuestion8メソッドがあります。 このうち先頭の値と末尾の値を足し合わせた値(Int)を、 Seqが空である場合は0を返すメソッドをheadOptionとlastOptionを用いて作成してください。
//
//問題9
//Seq[Int]である長さ3以上のnumSeqが引数として渡されるseqQuestion9メソッドがあります。 このうち先頭の値と末尾の値を除いたSeq[Int]を取得するメソッドをinitとtailを用いて作成してください。
//
//問題10
//Seq[Int]型である、numSeqが引数として渡されるseqQuestion10メソッドがあります。 numSeqの要素数が3以上の場合、最初の値と最後の値を足した値を返すメソッドを作成してください。 numSeqが要素が2以下、1以上の場合は0を、numSeqが空の場合は-1を返してください。 メソッドの作成にはmatch式と:+, +:などを用いてください。
//
//問題11
//foldLeftを用いて、Seqの要素を反転させる次のシグニチャを持ったメソッドreverseを実装してみましょう。
//
//問題12
//Seqの全ての要素を掛け合わせるメソッドsumをfoldRightを用いて実装してみましょう。
//Seqが空のときは1を返してみましょう。
//
//問題13
//問題12でreduceを使ってSeqが空の場合、エラーを吐くようにしましょう。
//
//問題14
//Seq(3×4, 4×2, 4×1)の最小値を出力しましょう。
//
//問題15
//Seq(3×4, 4×2, 4×1)の最大値を出力しましょう。  
//
//

}
