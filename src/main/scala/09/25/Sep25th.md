## Optionについて
## get 
- Optinoに包まれた値を取得する。Noneの場合例外が発生する。
```
val num: Option[Int] = Some(100)
num.get
res0: Int = 100
```
## getOrElse
- getの場合Noneの場合だと例外が発生するが、getOrElseの場合だと設定した初期値が返り値になる。
```
None.getOrElse(0)
res0: Int = 0
```

## isEmpty(isDefined)
- Optionの値があるかないかをtrue or falseで返却するメソッド。
```
Some(100).isEmpty
res0 Boolean = false
```
## map
- 関数を引数で受けSome or None で処理を行うメソッド。
- Someの場合は値を関数に渡し、関数によって変換された値をSomeとして返却。
- Noneの場合は関数は適用せず、Noneを返却。
```
val option: Option[Int] = Some(100)
option.map(i => i * 2)
res0: Some(200)

val none: Option[Int] = None
none.map(i => i * 2)
res0: None
```
## flatten
- Option[Option[Int]]のようにOptionが入れ子になっている時に、平滑化するメソッド。
```
val optionOption: Option[Option[int]] = Some(Some(3))
optionOption.flatten
res0: Some(3)
```

## flatMap
- map + flattenの挙動となるメソッドで、引数としてA => Option[T]の型を受け取り、返り値がOption[T]になる。
```
Some(99).flatMap(i => Some(i * 2)) 
```

