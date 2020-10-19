abstract class Monoid[A] {
  def add(x: A, y: A): A
  def unit: A
}

object ImplicitTest {
  implicit val stringMonoid: Monoid[String] = new Monoid[String] {
    def add(x: String, y: String): String = x concat y
    def unit: String = ""
  }
  
  implicit val intMonoid: Monoid[Int] = new Monoid[Int] {
    def add(x: Int, y: Int): Int = x + y
    def unit: Int = 0
  }
  
  def sum[A](xs: List[A])(implicit m: Monoid[A]): A =
    if (xs.isEmpty) m.unit
    else m.add(xs.head, sum(xs.tail)) //暗黙的にintMonoidを呼び出している
    //xs.head =1, sum(2,3)
    //sum(2,3) => 5
    //1 + 5
    
  def main(args: Array[String]): Unit = {
    println(sum(List(1, 2, 3)))       // intMonoidを暗に使用
    //6
    println(sum(List("a", "b", "c"))) // stringMonoidを暗に使用
    //abc
  }
}
