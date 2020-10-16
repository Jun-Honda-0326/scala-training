case class TypePram[T](t: T)


object Oct15th_2 {

  def main(args:Array[String]): Unit = {
    val string =  new  TypePram[String]("hoge")
    println(string.t)
    
    val int = new TypePram[Int](999)
    println(int.t)
  }
}
