case class Company(company_name:String, telnumber:String, address:String)

  object Oct05th{

    def main(args:Array[String]):Unit = {

      val company: (String,String,String) = ("nextbeat", "03-5423-6131", "東京都渋谷区恵比寿4-9-10")
      println(company._1, company._2, company._3)

      val nextbeat = Company("nextbeat", "03-5423-6131", "東京都渋谷区恵比寿4-9-10")
      println(nextbeat.company_name)
      println(nextbeat.telnumber)
      println(nextbeat.address)
  
      val nextbeat2 = nextbeat.copy(company_name = "ネクストビート")
      println(nextbeat2.company_name)
      println(
        s"私が所属している会社は株式会社${nextbeat2.company_name}で、電話番号は${nextbeat2.telnumber}、住所は${nextbeat2.address}です" 
      )
    }
  }
