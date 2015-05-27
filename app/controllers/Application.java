package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.User;
import models.Word;
import play.*;
import play.api.mvc.Session;
import play.mvc.*;
import play.libs.Json;


import views.html.*;

import java.util.List;
import java.util.Map;

public class Application extends Controller {

    public Application() {
//        Long user_id = Long.valueOf(session("user_id"));
//        User current_user = User.finder.byId(user_id);
//        Http.Context.current().args.put("current_user",current_user);
    }

    public static Result home() {
        if(Http.Context.current().args.get("current_user") != null){
            System.out.println( Http.Context.current().args.get("current_user").toString());
        }

        return ok(home.render());
    }

    public static Result login() {
        return ok(login.render());
    }

    public static Result about() {
        return ok(about.render());
    }

    public static Result search() {
        return ok(search.render());
    }

    public static Result register() {
        return ok(register.render());
    }

    public static Result admin() {
        return ok(admin.render());
    }

    public static Result admins() {
        return ok(admins.render());
    }

    public static Result adminaudit() {
        return ok(adminaudit.render());
    }

    public static Result terminologyaudit() {
        return ok(terminologyaudit.render());
    }

    public static Result terminologyadd() {
        return ok(terminologyadd.render());
    }

    public static Result users() {
        Long user_id = Long.valueOf( session("user_id") );
        User user = User.finder.byId(user_id);
        if (user.status.name.equals("user")){
            return ok(users.render());
        }else if (user.status.name.equals("admin")) {
            return redirect("/admin");
        }else {
            return redirect("/terminologyadd");
        }

    }

    public static Result logout() {
        return ok(logout.render());
    }

    public static Result useraddword() {
        return ok(useraddword.render());
    }

    public static Result useraddform() {
        return ok(useraddform.render());
    }

    public static Result help() {
        return ok(help.render());
    }

}



