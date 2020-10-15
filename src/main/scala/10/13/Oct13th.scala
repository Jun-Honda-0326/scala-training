//Future 練習問題
//保育士バンクで実際に存在するモデル(を簡単にしたもの)を元に、与えられた施設のIDから法人を取得し、法人名を標準出力するメソッドを作成してください。 条件は以下です。

//mainというメソッドで園名を標準出力すること
//mainメソッドにはbranchId: Longを引数として受け取る

import scala.concurrent.ExecutionContext.Implicits.global
import scala.util._
import scala.concurrent._
import scala.concurrent.duration._


case class Organization(
  id:    Long,   // 法人ID
  name:  String, // 法人名
  email: String  // 法人のEmailアドレス
)
// 法人(Organization)が所有している施設情報(保育園・幼稚園など)
case class Branch (
  id:              Long,   // 施設ID
  organizationId:  Long,   // 法人ID
  name:            String  // 施設名
)

// Database情報
object Database  {
  // 施設のIDから、施設情報を取得する
  // 仮で、nextbeat保育園の情報を返却するような実装にしている
  def getBranchById(branchId: Long): Future[Branch] =
    Future.successful(Branch(
      id             = 1,
      organizationId = 1,
      name           = "nextbeat保育園"
    )
  )
 //失敗バージョン
//  Future.failed(new Exception("値が取れませんでした")) //(Branch(
//      id             = 1,
//      organizationId = 1,
//      name           = "nextbeat保育園"
//    ))
//
//)

// 法人のIDから、法人情報を取得する
 // 仮で、株式会社nextbeatの情報を返却するような実装にしている
  def getOrganizationById(organizationId: Long): Future[Organization] =
    Future.successful(Organization(
      id    = 1,
      name  = "株式会社nextbeat",
      email = "nextbeat.net"
      )
  )
} 


object MainOct13th {
  def main(args:Array[String]):Unit = { 
    val branchId:Long = 1
    composeDatabase(branchId)
    
  }

  def composeDatabase(branchId:Long): Unit = { 
    //if (branchId != 1) throw new Exception("エラー")
    val database = 
    for{
      br <- Database.getBranchById(branchId)
      org <- Database.getOrganizationById(br.organizationId)
      } yield org.name
    //val result = Await.ready(database, Duration.Inf)
    //result.value.get match{
      database.onComplete { 
        case Success(s) => println(s)
        case Failure(f) => println(f.getMessage)
      }
  }
}
