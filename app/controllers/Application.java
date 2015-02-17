package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.User;
import models.Word;
import play.*;
import play.mvc.*;
import play.libs.Json;


import views.html.*;

import java.util.List;
import java.util.Map;

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
    public static Result admin() {
        return ok (admin.render());
    }
    public static Result admins() {
        return ok (admins.render());
    }
    public static Result adminaudit() {
        return ok (adminaudit.render());
    }
    public static Result delete() {
        return ok (delete.render());
    }

}






