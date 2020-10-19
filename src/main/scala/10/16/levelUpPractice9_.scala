import scala.util._
import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object MainPractice9_15{

  def main(args:Array[String]):Unit = {

    val articles = Seq(Article(1, "吾輩は猫である", "名前はまだない"), Article(2, "大きな株", "株がありました"),Article(3, "naruto", "忍者" ))
    val articleDetails = Seq(ArticleDetail(1, "小説"), ArticleDetail(2, "童話"))
    
    //問題10,の定義
    val set1:Set[Int] = Set(1,2,3,4,5,6,7)
    val set2:Set[Int] =Set(1,3,5,6,8,9,12)
    //問題11の定義
    val people: Seq[Person] = Seq(Person(1, "honda", Some("男")), Person(2, "jun", Some("女")))

    //問題13の定義
    val fOps1:Future[Option[String]] = Future(Some("おはよう"))
    val fOps2:Future[Option[String]] = Future(None)
    val fOps3:Future[Option[String]] = Future.failed(new Exception("失敗です"))
    
    //問題14の定義
    val fEith1:Future[Either[Int, String]] = Future(Right("こんにちは"))
    val fEith2:Future[Either[Int, String]] = Future(Left(100))

    //問題15の定義
    val nums:Seq[Future[Int]] = Seq(Future(1), Future(2), Future(3))
    

    println("問題9の解答")
    println(question9(articles,articleDetails))
    println("問題10の解答") 
    question10(set1,set2)                             
    println("問題11の解答")
    println(question11(people))
    question13(fOps1)
    question13(fOps2)
    question13(fOps3)
    question14(fEith1)
    question14(fEith2)
  }

//問題9
////ArticleとArticleDetailというクラスがあります。ArticleとArticleDetailは一対一の関係性を持っていて、データの都合上、各Articleに対してArticleDetailが必ずしも存在するわけではありません。
////Seq[Article]型であるarticlesと、Seq[ArticleDetail]型であるarticleDetailsを引数として受け取り、それぞれ紐づいたArticleとArticleDetailをtupleにして返すquestion9を作成してください

case class Article(id: Long, title: String, body: String)
case class ArticleDetail(articleId: Long, category: String)

  def question9(
    articles:         Seq[Article],
    articleDetails:Seq[ArticleDetail]
    ): Seq[(Article, ArticleDetail)] = {
      for {
        a  <- articles
        d  <- articleDetails.find(_.articleId == a.id)
      } yield(a, d) 
  }


////問題10
////Scalaには集合を表すSetというクラスがあります。
////set1: Set[Int], set2: Set[Int] を引数として受け取り、set1, set2の差集合と和集合を標準出力するquestion10を作成してください
  
  def  question10(set1: Set[Int],  set2: Set[Int]):Unit = {
    println(s"差集合は ${set1 diff set2}")
    println(s"和集合は ${set1 | set2}")
  }

//問11
//Seq[Person]型であるpeopleを引数として受け取り、全てのgenderをNoneにするquestion11を作成してください
case class Person(id: Long, name: String, gender: Option[String])

  def question11(people: Seq[Person]):Seq[Person] = {
    people.map(_.copy(gender = None))

  }

//問12
//, 区切りで生成された文字列numStrを引数として受け取り、 ,で区切られた各文字が数字であればSome[Int], 数字でなければNoneにして返すメソッドquestion12を作成してください
//例: "1,2,3,4,hello" → Seq(Some(1),Some(2),Some(3),Some(4),None)

//問13
//Future[Option[String]]型であるfOpsを引数として受け取り中の結果がSomeであればその文字列を、
//Noneであれば "なし" と標準出力させるquestion13を作成してください
  
  def question13(fOps: Future[Option[String]]):Future[Unit] = {
    Future{
      fOps.onComplete{
        case Success(Some(i)) => println(i)
        case Success(None)    => println("なし")
        case Failure(e)       => println(e.getMessage)
      }
    }
  }

//問14
//Future[[Either[Int,String]]] 型であるfEithを引数として受け取り、
//中の結果がRightであればその文字列を、Leftであれば中の数字をぞれぞれ標準出力させるquestion14を作成してください
  
  def question14(fEith: Future[Either[Int, String]]):Future[Unit] = {
    Future{
      fEith.onComplete{
        case Success(Right(r))  => println(r)
        case Success(Left(l))   => println(l)
        case Failure(e)         => println(e.getMessage) 
      }
    }
  }


//問15
//Seq[Future[Int]]型であるnumsを引数として受け取り、中の数字の合計したFuture[Int]を返すquestion15を作成してください
//配列の中が空であればFuture[Int] = Future.successful(0) を返すようにすること。
//またFuture.sequenceは使用しないこと

  def question15(nums: Seq[Future[Int]]):Future[Unit] = {
    Future{
      

    }

  }

























  }
