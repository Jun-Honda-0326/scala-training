object MainPractice9_{

  def main(args:Array[String]):Unit = {

    val articles = Seq(Article(1, "吾輩は猫である", "名前はまだない"), Article(2, "大きな株", "株がありました"))
    val articleDetails = Seq(ArticleDetail(1, "小説"))
    val set1:Set[Int] = Set(1,2,3,4,5,6,7)
    val set2:Set[Int] =Set(1,3,5,6,8,9,12)

    println("問題9の解答")
    println(question9(articles,articleDetails))
    println("問題10の解答") 
    question10(set1,set2)                             
  }

//ArticleとArticleDetailというクラスがあります。ArticleとArticleDetailは一対一の関係性を持っていて、データの都合上、各Articleに対してArticleDetailが必ずしも存在するわけではありません。
//Seq[Article]型であるarticlesと、Seq[ArticleDetail]型であるarticleDetailsを引数として受け取り、それぞれ紐づいたArticleとArticleDetailをtupleにして返すquestion9を作成してください

case class Article(id: Long, title: String, body: String)
case class ArticleDetail(articleId: Long, category: String)

  def question9(
    articles:         Seq[Article],
    articleDetails:Seq[ArticleDetail]
  ): Seq[(Article, ArticleDetail)] = {
    
    
  }


//問題10
//Scalaには集合を表すSetというクラスがあります。
//set1: Set[Int], set2: Set[Int] を引数として受け取り、set1, set2の差集合と和集合を標準出力するquestion10を作成してください
  
  def  question10(set1: Set[Int],  set2: Set[Int]):Unit = {
    println(s"差集合は ${set1 diff set2}")
    println(s"和集合は ${set1 | set2}")
  }






































}
