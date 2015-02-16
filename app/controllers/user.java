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

public class user extends Controller {

    public static Result getAllUsers(){
        List<User> users = User.finder.all();
        return ok(Json.toJson(users));
    }

    public static Result postUserAdd(){
        JsonNode json = request().body().asJson();
        User user = Json.fromJson(json,User.class);

        user.save();

        return ok(Json.toJson(user));
    }

}
