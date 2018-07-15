package controllers


import javax.inject._
import play.api.mvc._
import models.{BasicForm, ConstrainedForm, InputTypesForm, LinkForm}


@Singleton
class Relative @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  
  def svtake(name:String) = Action { implicit request =>
    Ok(views.html.svpoint(name))
  }

  def helloview() = Action { implicit request =>
    Ok(views.html.svpoint("Bob"))
  }
  
  def phone(nameOurId: String) = Action {
    
    var states = LinkForm.all()
    var ourId:String = s"4"
    var it:Iterator[java.lang.String]= states.keysIterator
    var key:String = s"https://www.msn.com/"
     var found:String = s"11"
     var phoneUrl = s"NoFound"
     
     for(  key  <- it){
         ourId =states.get(key).get
    
     if(ourId == nameOurId){
       phoneUrl = key.toString
    
     }
     
     }
 
     Redirect( phoneUrl)
    
   
  
  }

 
}