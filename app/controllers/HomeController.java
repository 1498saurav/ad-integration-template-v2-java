package controllers;

import models.User;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.index;
import views.html.login;
import play.mvc.Http.*;

import javax.inject.Inject;

public class HomeController extends Controller {

    private FormFactory formFactory;

    @Inject
    public HomeController(FormFactory f){
        this.formFactory=f;
    }

    public Result index() {
        return ok(index.render(new User(),Authorised.isLoggedIn(ctx())));
    }

    public Result login(){
        Form<User> userForm=formFactory.form(User.class);
        return ok(login.render(userForm));
    }

    public Result loginSubmit(){
        Form<User> userForm=formFactory.form(User.class).bindFromRequest();

        if(userForm.hasErrors()){
            return badRequest(login.render(userForm));
        }

        User user=userForm.get();

        System.out.println(user.getUsername()+"\n"+user.getPassword());
        session().clear();
        session("username", user.getUsername());
        return ok(index.render(user, Authorised.isLoggedIn(ctx())));
    }

    @Security.Authenticated(Authorised.class)
    public  Result logout() {
        session().clear();
        return redirect(routes.HomeController.index());
    }

}
