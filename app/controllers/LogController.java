package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.User;
import models.Word;
import play.*;
import play.api.mvc.Session;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.*;
import play.libs.Json;


import views.html.*;

import java.util.List;
import java.util.Map;

public class LogController extends Controller {



    public LogController() {
//        Long user_id = Long.valueOf(session("user_id"));
//        User current_user = User.finder.byId(user_id);
//        Http.Context.current().args.put("current_user",current_user);
    }

    public static class LoginForm {
        public String username;
        public String password;
    }

    public static Result login() {
        return ok(
                login.render()
        );
    }

    public static Result authenticate(){

        Form<LoginForm> form = Form.form(LoginForm.class).bindFromRequest();

        String username = form.get().username;
        String password = form.get().password;

        List<User> users = User.finder.where().eq("username",username).eq("password",password).findList();

        if(users.size() ==1){
            User user = users.get(0);

            session("user_id", user.id.toString());
            session("user_username",user.username);
            session("user_name",user.name);
            //return ok(Json.toJson(session("user_id")));
            return redirect("/");
        }else {
            session().clear();
            return badRequest("Username or Password is in valid");

        }
    }


    public static Result logout(){
        session().clear();
        flash("success", "You've been logged out");
        return redirect("/");
    }
}

