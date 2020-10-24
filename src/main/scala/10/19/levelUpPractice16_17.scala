import scala.concurrent._ 
import scala.concurrent.ExecutionContext.Implicits.global
import  scala.util._
import concurrent.duration.Duration

 
case class User(
  id:    Long,
  name:  String,
  age:   Int
)

case class UserInfo(
  userId:  Long,
  email:   String,
  phone:   String
)

case class ViewValueUser(
  userId:   String,
  name:     String,
  age:      Int,
  email:    String,
  phone:    String
)


object Database_2 {

  // 暫定的に、特定のUserを返却するような実装にしている
  def getUser(id: Long): Future[User] = {
    Future.successful(
      User(
        id   = 1L,
        name = "nextbeat",
        age  = 10
      )
    )
  }

  // 暫定的に、特定のUserInfoをOption型で返却するような実装にしている
  def getUserInfo(userId: Long): Future[Option[UserInfo]] = {
    Future.successful(
      Some(
        UserInfo(
         userId = 1L,
         email  = "nextbeat@nextbeat.net",
         phone  = "09000000000"
        )
      )
     //None
    )
  }
}

object MainPractice16_17 { 

  def main(args:Array[String]):Unit = {

    val users = Seq(User(1, "honda", 24), User(2, "jun", 28), User(3,"hiroki", 30))
    val userInfoSeq = Seq(UserInfo(1,"j.honda","andoroid" ), UserInfo(2, "jun.mail", "iphone"))
    
    println(question16(users, userInfoSeq))
    println(question17(1L))
  }

///問題16
//ユーザーを表すUserというクラスと、ユーザー情報を表すUserInfoというクラス、ユーザーの情報をHTMLで表示するためのクラスViewValueUserが存在します。
//users: Seq[User]と userInfo: Seq[UserInfo]を引数に受け取り、各UserオブジェクトをもとにViewValueUserを作成するquestion16を作成してください。
//なお、データの都合上、各Userに対してUserInfoが必ずしも存在するわけではない。存在しない場合はemailとphoneを空文字にして返すこと
//※ User.id と UserInfo.userIdは同一の型であり、検索のキーとして使う想定
//
  def question16(users: Seq[User], userInfoSeq: Seq[UserInfo]): Seq[ViewValueUser] = {
    
//    users.map{u => 
//      val uI = userInfoSeq.find(_.userId == u.id)
//        ViewValueUser (
//          u.id.toString,
//          u.name,
//          u.age,
//          uI.map(_.email).getOrElse(""),
//          uI.map(_.phone).getOrElse("")
//        )}
      for {
        u <- users
        val uI = userInfoSeq.find(_.userId == u.id)
      } yield ViewValueUser(
          u.id.toString,
          u.name,
          u.age,
          uI.map(_.email).getOrElse(""),
          uI.map(_.phone).getOrElse(":")

        )
    }

//問題17
//定義等は16に続く。idをもとに特定のUserをFutureで返却するDatabaseオブジェクトがあります。
//取得したUserをもとにUserInfoを取得し、ViewValueUserを生成するメソッドquestion17を作成してください。
//なお、データの都合上Userに対してUserInfoが存在するとは限らないため、存在しない場合はemail, phoneは空文字にして返すこと

  def question17(userId: Long):Future[ViewValueUser] = {
    val viewUser = 
      for {
        u <- Database_2.getUser(userId)
        uI <- Database_2.getUserInfo(u.id)
      } yield ViewValueUser (
          u.id.toString,
          u.name,
          u.age,
          uI.map(_.email).getOrElse(""),
          uI.map(_.phone).getOrElse("")
        )

//    Database_2.getUser(userId).flatMap{
//      u => Database_2.getUserInfo(u.id).map{
//        uI => ViewValueUser(
//          u.id.toString,
//          u.name,
//          u.age,
//          uI.map(_.email).getOrElse(""),
//          uI.map(_.phone).getOrElse("")
//          )
//      }
//    }
//
      Await.ready(viewUser, Duration.Inf)
      
    
  }  
}
    
  

