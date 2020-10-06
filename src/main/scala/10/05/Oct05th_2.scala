object MainOct05th02{

  def main5(args:Array[String]):Unit = {
    val japan = new Japanese("田中", 30)
    val american = new American("Tom", 25)
    val rectangular = new Rectangular(10,20,30)
    val foursided = new FourSidedPyramid(10,20,30)
    val hello = new sayHello("山本") 
    val helloEnglish = new sayHelloEnglish("Tom") 
    val nextbeat = new NextbeatName("ネクストビート")
    
    println(japan.greet())
    println(american.greet())
    println(s"直方体の体積は${rectangular.calculate()}です")
    println(s"四角錐の体積は${foursided.calculate()}です")
    println(hello.hello()) 
    println(helloEnglish.hello())
    println(nextbeat.printName)
  }
}


abstract class Person(name:String, age:Int){
  def greet():String
}

class Japanese(name:String, age:Int) extends Person(name = name, age = age){
  def greet() = { 
    s"${age}歳の${name}さんです。"
  }
}

class American(name:String,age:Int) extends Person(name = name, age = age){
  def greet() ={ 
    s"He is ${age}yeas old and His name is ${name}." 
  }
}


abstract class Shape( height:Int) {
  def calculate():Int
}

class Rectangular(height:Int, vartical:Int,  wide:Int) extends Shape(height = height){
  def calculate() = {
    height * wide * vartical
  }
}

class FourSidedPyramid(height:Int, vartical:Int, wide:Int) extends Shape(height = height){
  def calculate() = {
    height * wide * vartical * 1/3
  }
}

class sayHello(name:String){

  def hello():String = {
   s"こんにちは${name}さん" 
  }
}

class sayHelloEnglish(name:String) extends sayHello(name = name) {

   override def hello(): String = {
    s"Hello ${name}"
  }
}

trait Nextbeat {
  val name:String
  def printName:String = name 
}

class NextbeatName(val name:String) extends Nextbeat 


