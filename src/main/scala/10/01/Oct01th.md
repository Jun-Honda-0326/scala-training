## Mapについて
- Mapはキーとバリューのペアを複数配列することができるデータ構造。
- データとデータのマッピング（対応付け）を行う時に使う。
```
Map("りんご" -> 100, "みかん" -> 80, "ぶどう"-> 300)
```
## 追加
- Mapへの要素の追加は + で行う。
```
userMap + (4 + "清水")
res0: Map(1 -> 鈴木, 2 -> 佐藤, 3 -> 山田, 4 -> 清水)
```
## 連結
- Mapに別のMapを連結するには ++ を使う。
```
Map ++ 連結対象のMap
```
## 削除
- Map - キー で削除できる
​
## get
- 指定されたキーに対応する値を取得する。値が存在すれば、Someで包まれたバリューを返す。キーが存在しない場合はNoneを返す。
-  データ型は最初に保持されている型を受け継ぐ。
## getOrElse
- キーが存在する場合はgetと同じ挙動をする。キーが存在しない場合は設定した初期値が返される。
```
Map(1 -> 1000, 2 -> 2000).getOrElse(2, 10000)
2が対応するキーで10000が初期値
```
## contains
-  指定したキーがMapに存在するかどうかを調べ、Booleanで取得する。存在する場合はtrue, しない場合はfalseで返す。
## isDefinedAt
- containsと同じ挙動をする。
## mapValues()
- 値を変更した新しいMap返却する。
## keys
- Mapに含まれるkeyの一覧を取得する
## values
- Mapに含まれる値の一覧を取得する
## filterKeys
- 指定した条件に一致した要素のみを取得したMapを返す
```
val Map = Map(1 -> 100, 2 -> 200)
Map.filterKeys(_ %2 == 0)
res0: Map(2 -> 200)
```
## toMap
- リストをMap変換できるメソッド
```
val userTupleSeq = Seq((1, "鈴木"), (2, "佐藤"), (3, "山田"))
res0:userTupleSeq: Seq[(Int, String)] = List((1,鈴木), (2,佐藤), (3,山田))
リストが３要素以上あるとエラーになる
```
## groupBy
- 指定した条件でグルーピングを行ったMapを生成。
- SeqをMapに変換する
```
val seqTuple = Seq((1, "鈴木), (2, "森山"), (3, "山田"), (4, "田中"))
seqTuple.groupBy(_._2.contains("山"))
res0: Map(false -> List((1,"鈴木"), (4, "田中")), true -> List((2, "森山"), (3, "山田")))
```
​
## Mapとタプルの関係
```
val names = Map(1 -> "鈴木", 2 -> "佐藤", 3 -> "田中")
names.map(i => i._1 + "は" + i._2 + "さんです")
res0: List(1位は鈴木さんです, 2位は佐藤さんです, 3位は田中さんです)
```

