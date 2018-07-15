package models

import java.io.File

import play.api.data.Form
import play.api.data.Forms._

case class LinkForm(name:String, shortnum:Int)

object  LinkForm{
  
      val form:Form[LinkForm] = Form(
        mapping( "name"->text, "shortnum"->number)(LinkForm.apply)(LinkForm.unapply)
      
      )
      
       val  phoneApps:scala.collection.mutable.Map[String,String] = scala.collection.mutable.Map("https://www.playframework.com/documentation/2.6.x/ScalaRouting" -> "1", "https://www.google.com/" -> "2","https://www.google.com/" -> "3")
  
      def all():scala.collection.mutable.Map[String,String] = {phoneApps}
}

