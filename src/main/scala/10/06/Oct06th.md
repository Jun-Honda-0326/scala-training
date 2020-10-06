## Either 
- Either はOptionとよく似ているがOptionは値が存在しない場合があるのに対し、Eitherはどちらも必ず値を持つ。
- Either型はエラー処理などでよく使用され、慣習的に処理の失敗時をLeft 成功時をRightと定義する。
```
定義の方法
val r:Either[String, Int] = Right(100)
val l:Either[String, Int] = Left("Error")
```
- Eitherにもmap、flatMapが使用できる。
```
val r: Either(String, Int) = Right(100)
r.flatMap(i => Right(i * 10))  //Right(10000)
r.flatMap(_ => Left("Error")) // Left(Error)  Right → Left変換ができる

val l: Either[Int, Int] = Left(10)
l.left.flatMap(i => Left(i * 10)) //100 Leftの場合はleftを指定して実行する必要がある
```
## getOrElse 
- Optionと同じでRightの時は値をそのまま返し、Left時は引数を返す。
## Try
- エラー処理に用いられるクラス。プログラムが例外を発生しうる場合に使用する。
- SuccessとFailureを値として持っていること。
- 例外処理に特化していること
- 例外として外部APIへの接続、ユーザーからの意図しない入力などがある。
- Tryを使用するには import scala.util.Try をする必要がある 
