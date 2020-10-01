# Seqについて
## map
- コレクションの各要素に処理を行わせる
```
Seq(1,2,3).map(_ * 2)
res0: Seq[Int] = List(2,4,6)
```
## flatten
- 入れ子になったSeqを解消できる
```
Seq(Seq(1,2,3), Seq(4,5,6)).flatten
res0: Seq[Int] = List(1,2,3,4,5,6)
```
## flatMap
- mapとflatttenを合わせたもの
```
Seq(1,2).flatMap(a => 
  {Seq(3,4).map(b =>{ 
    (a,b)
  })
})
res0: Seq[Int]: List(1,3),(2,4), (2,3),(2,4)
```
## find
- 対象コレクションのうち、条件を満たす最初の要素をSomeに入れて返す。ない場合はNoneを返す。引数にはBoolean型を返す関数を渡す。
```
numSeq: [Int] = Seq(1,2,3)
numSeq.find(num => num > 1)
res0: Option[Int] = Some(2)
```
## filter
- 対象コレクションのうち、条件を満たす要素だけで構成されたコレクションを返す。一つも条件を満たす要素がない場合は空のコレクションが返される。
```
numSeq: Seq[Int] = Seq(1,3,6).find(n => n %2 == 0 )
numSeq: Seq[Int] = Seq(1,3,6).find(_ %2 == 0)
res0: Some(6)
```
## findとfilter違い
- findはコレクションの中から条件に合致した要素1つを返すのに対し、filterは条件に合致した値を全てコレクションとして返す。

## collect
- filterとmapを組み合わせたようなメソッド。caseにマッチした要素だけが抽出され、その上で変換された値がコレクションとして返される。
```
val numSeq: Seq[Int] = Seq(1,2,3)
numSeq.collect{
    case 1 => 100
    case 2 => 200
    case _ => -1
  }
res0: Seq[Int] = List(100,200,-1)
```
## collectFirst
- findとmapを組み合わせたようなメソッド。caseにマッチした最初の要素が抽出され、その上で変換された値たOptionに包まれて返ってくる。
```
val numSeq:Seq[Int] = Seq(1,2,3)
numSeq.collectFirst(case n if n > 2 => n * 2)
res0: Option[Int] = Some(6)
```
## exists
- コレクションの中に１つでも条件を満たす要素があればtrueを返す。条件を満たさない場合はfalseを返す。
```
val numSeq: Seq[Int] = Seq(1,2,3)
numSeq.exists(_ > 1)
res0: true
```
## contains
- 引数で指定した要素がコレクションに1つでも含まれていれば、trueを1つも含まれていない場合はfalseを返す。
```
val numSeq: Seq[Int] = Seq(1,2,3)
numSeq.contains(3)
res0: true
```
## empty
- 同じ型の空のコレクションを返す。
emptySeq: Seq[Int] = Seq.empty
res0:Seq[Int] = List()
``
## head
- コレクションの先頭の要素を返す。コレクションがからの場合はOptionのgetと同じく例外を返す。
```
val numSeq: Seq[Int] = Seq(1,2,3)
numSeq.head
res0: Int = 1
```
### headOption
- コレクションの先頭の値をOption型で返す。コレクションが空の場合はNoneを返す。
```
val numSeq: Seq[Int] = Seq(1,2,3)
numSeq.headOption
res0: Option[Int] = Some(1)
```
## last
- コレクションの末尾の要素を返す。headの逆ver
```
val numSeq: Seq[Int] = Seq(1,2,3)
numSeq.last
res0: Int = 3
```
## lastOption
- コレクションの末尾の値をOption型で返す。headOptionの逆。
```
val numSeq: Seq[Int] = Seq(1,2,3)
numSeq.lastOption
res0: Option[Int] = Some(3)
```
## init
- コレクションのうち末尾を除いた残りのコレクションを返す。コレクションが空の場合は例外を返す。
```
val numSeq: Seq[Int] = Seq(1,2,3)
numSeq.init
res0: Seq[Int] = Seq(1,2)
```
## tail
- コレクションのうち先頭を除いた残りのコレクションを返す。initの逆。
```
val numSeq: Seq[Int] = Seq(1,2,3)
numSeq.tail
rs0: Seq[Int] = Seq(2,3)
```
## +: :+
- +:は先頭に要素を追加したコレクションを返す。
- :+は末尾に要素を追加したコレクションを返す。
```
val numSeq: Seq[Int] = Seq(1,2,3)
4 +: numSeq
res0 : Seq[Int] = Seq(4,2,3,1)

4 :+ numSeq
res1: Seq[Int] = Seq(1,2,3,4)
```
## ++
- ２つのコレクションを連結したコレクションを返す。
```
val numSeq1: Seq[Int] = Seq(1,2,3)
val numSeq2: Seq[Int] = Seq(4,5,6)
numSeq1 + numSeq2
res0: Seq[Int] = Seq(1,2,3,4,5,6)
```
## Nil
- 空のリストを返す。
## foldLeft
- 左から順に畳み込み演算を行う。第１引数は初期値、第二引数は実行したい処理。
- 何もついていない時は左畳み込みになる。
- Seqが空の場合は設定した初期値を返す。
## foldRight
- 右から順番に畳み込み演算を行う。foldLeftの逆。
```
例 
Seq(1,2,3,4,5).foldLeft(-7)((a: Int, b: Int)) => a - b
// -22
(-7 - 1) -2)-3)-4)-5 = -22

Seq(1,2,3,4,5).foldRight(-7)((a: Int, b: Int) => a - b
// 10
1-(2-(3-(4-(5-(-7)) = 10
```
### reduce
- foldと同じく畳み込みを行うメソッドだが、初期値を要しない。
- foldLeft foldRightにより畳み込みの順番を指定できる。何もついていない時は左畳み込みになる。
- foldもreduceも単に要素を足し合わせたりするだけであれば、Seq.reduce(_+_)のように省略可能。
### min max
- 最小、最大の要素を返す。空のSeqに実行すると例外が発生する。
### match
- matchによりSeqの分割が可能。引数で指定した数だけ分割できる。
```
val numSeq = Seq(1,2,3,4)
numSeq match {case h +: t => (h,t)}
res0: (Int, Seq[Int]) = (1,List(1,2,3))

numSeq match {case h :+ t => (h,t)}
res1: (Int, Seq[Int]) =(List(1,2,3),4)

データ構造でcaseしてリストを分割している
```











