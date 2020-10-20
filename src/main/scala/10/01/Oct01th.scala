object Oct01th {

  def main3(args: Array[String]): Unit = {
    val fruitsMap = Map("りんご" -> 100,"みかん" -> 80, "ぶどう" -> 400)
    val seq: Seq[Int] = Seq(1,2,3,4)


    println(mapQuestion1(fruitsMap))
//    println(mapQuestion2_1(fruitsMap))
    println(mapQuestion2_2(fruitsMap))
    println(mapQuestion3(fruitsMap))
//    println(mapQuestion4(fruitsMap))
    println(mapQuestion5(seq))
  

  }

//問1
//みかんの価格を取得してみましょう。

  def mapQuestion1(fruitsMap: Map[String, Int]):Int = {
    fruitsMap.get("みかん").get
  }


//問2
//Mapに存在しない「"いちご"」を指定してgetメソッドで価格を取得しようとしたとき、どうなるかやってみてください。

//  def mapQuestion2_1(fruitsMap: Map[String, Int]):Int = {
//    fruitsMap.get("いちご").get
//  } 例外が発生する 
//

//このように、存在しなかった場合は「0」というデフォルト値を返すようにするにはどうすればいいでしょうか？

  def mapQuestion2_2(fruitsMap: Map[String, Int]):Int = {
    fruitsMap.getOrElse("いちご", 0)
  }


//問3
//fruitsの中に、特定のキーが存在するかを調べるにはどんな方法がありますか？また、それを使って「ぶどう」と「いちご」の存在判定をしてみてください。

  def mapQuestion3(fruitsMap: Map[String, Int]):Boolean  = {
    println(fruitsMap.contains("ぶどう"))
    fruitsMap.contains("いちご")
  }


//問4
//Mapの各値に「円」をつけたMapに変換してみてください。具体的には、以下のようなMapにしてください。
//
//  def mapQuestion4(fruitsMap: Map[String, Int]):Map[String, String ] = {
//    fruitsMap.mapValues(_ + "円")
//  }

//問5
  def mapQuestion5(seq: Seq[Int]):Map[Int, Seq[Int]] = {
    seq.groupBy(_ %2 )    

  }

}


