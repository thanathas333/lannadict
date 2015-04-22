package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.User;
import models.Word;
import play.*;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.*;
import play.libs.Json;


import views.html.*;

import java.util.List;
import java.util.Map;

public class LogController extends Controller {

    public static Result login() {
        return ok(
                login.render()
        );
    }

    public static Result authenticate(){
        JsonNode json = request().body().asJson();

        String username;
        String password;

        username = json.get("username").asText();
        password = json.get("password").asText();

        User user = User.finder.where().eq("username",username).eq("password",password).findList().get(0);

        return ok(Json.toJson(user));

    }




}
