## tuple
- tupleは、複数のフイールドをひとまとめにして扱うことができる。
```
インスタンスの生成
val persons = ("Yamada", "Tanaka")
パラメータの取得
persons._1 
res: String = Yamada
```
以下のような書き方もできる
```
val tanaka = "Tanaka" -> 10
```
- タプルは扱うのが非常に容易であるが、どの値が何番目に入っているかわかりにくいというデメリットもある。
## case class
```
case class クラス名 { パラメータ名: 型 }
```
case class には以下のような特徴がある
- コンストラクタ引数がデフォルトでvalで定義できる
- コンパニオンオブジェクトが定義できる
- applyやunappluなどの便利なメソッドが自動で生成される
- パターンマッチできる
- case class を定義すると copy toStrng equqls hashCodeなどのメソッドが自動生成される

