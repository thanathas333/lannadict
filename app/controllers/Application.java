package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {


    public static Result home() {
        return ok (home.render());
    }
    public static Result login() {
        return ok (login.render());
    }
    public static Result about() {
        return ok (about.render());
    }
    public static Result search() {
        return ok(search.render());
    }
    public static Result add() {
        return ok (add.render());
    }
    public static Result register() {
        return ok (register.render());
    }

}
