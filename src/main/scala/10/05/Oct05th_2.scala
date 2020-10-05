abstract class Person(name:String, age:Int){
  def greet():Unit
}

class Japanese(name:String, age:Int) extends Person(name = name, age = age){
  def greet(): Unit ={ 
    println(s"${age}歳の${name}さんです。")
  }
}

class American(name:String,age:Int) extends Person(name = name, age = age){
  def greet():Unit ={ 
    println(s"He is ${age}yeas old and His name is ${name}.") }
}


abstract class Shape( height:Int) {
  def calculate():Unit
}

class Rectangular(height:Int, vartical:Int,  wide:Int) extends Shape(height = height){
  def calculate() = {
    println(height * wide * vartical)
  }
}

class FourSidedPyramid(height:Int, vartical:Int, wide:Int) extends Shape(height = height){
  def calculate() = {
    println(height * wide * vartical * 1/3)
  }
}

object Oct05th02{

  def main(args:Array[String]):Unit = {
    val japan = new Japanese("田中", 30)
    val american = new American("Tom", 25)
    val rectangular = new Rectangular(10,20,30)
    val foursided = new FourSidedPyramid(10,20,30)
    japan.greet()
    american.greet()
    rectangular.calculate()
    foursided.calculate()
  }

}

  
