package controllers

import javax.inject.Inject
import javax.inject.Singleton

import models.{ LinkForm }
import play.api.libs.Files
import play.api.mvc._

@Singleton
class BasicController @Inject() (cc: ControllerComponents) extends AbstractController(cc) with play.api.i18n.I18nSupport {
 

  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def linkForm() = Action { implicit request: Request[AnyContent] =>
    {

      Ok(views.html.linkForm(LinkForm.form))
    }

  }

  def linkFormPost() = Action { implicit request: Request[AnyContent] =>

    LinkForm.form.bindFromRequest.fold(
      formWithErrors => {
        BadRequest(views.html.linkForm(formWithErrors))
      },
      formData => {

        var svapps = LinkForm.all()

        Ok(formData.name.toString)
        if (svapps.contains(formData.name)) {
          Ok("Duplicate key")
        } else {
          svapps.put(formData.name, "" + formData.shortnum)

          Ok(views.html.phoneLinks(svapps))

        }

      })

  }

}
