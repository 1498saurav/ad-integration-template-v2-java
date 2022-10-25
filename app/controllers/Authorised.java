package controllers;

import models.User;
import play.mvc.Security;
import play.mvc.Http.Context;
import play.mvc.Result;

public class Authorised extends Security.Authenticator {
    public static boolean isLoggedIn(Context ctx) {
        return (getUser(ctx) != null);
    }

    public static String getUser(Context ctx) {
        return ctx.session().get("username");
    }

}