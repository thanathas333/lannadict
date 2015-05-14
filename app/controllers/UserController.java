package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.*;
import play.*;
import play.mvc.*;
import play.libs.Json;


import views.html.*;

import java.util.List;
import java.util.Map;

public class UserController extends Controller {

    public static Result getAllUsers(){
        List<User> users = User.finder.all();
        return ok(Json.toJson(users));
    }

    public static Result getById(long id){
        User user = User.finder.byId(id);
        return ok(Json.toJson(user));
    }

    public static Result postSave(){
        JsonNode json = request().body().asJson();
        User user = Json.fromJson(json,User.class);

        if(user.id != null){
            user.update();
        }else {
            user.save();
        }

        return ok(Json.toJson(user));
    }

    public static Result postDelete(){
        JsonNode json = request().body().asJson();
        User user = Json.fromJson(json, User.class);
        return ok(Json.toJson(user));
    }

    public static Result getCurrent(){
        Long user_id = Long.valueOf(session("user_id"));
        User user = User.finder.byId(user_id);
        return  ok(Json.toJson(user));
    }

    public static Result getAll(){
        return ok(Json.toJson(User.finder.all()));
    }



}
