package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.User;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;


public class CommentController extends Controller {

    public static Result getAllComments(){
        List<models.Comment> commentes = models.Comment.finder.all();
        return ok(Json.toJson(commentes));
    }

    public static Result getById(long id){
        models.Comment comment = models.Comment.finder.byId(id);
        return ok(Json.toJson(comment));
    }

    public static Result postSave(){
        JsonNode json = request().body().asJson();
        models.Comment comment = Json.fromJson(json, models.Comment.class);

        String uid = session().get("user_id");
        Long user_id = Long.valueOf(uid);
        User user = User.finder.byId(user_id);
        comment.user = user;


        if(comment.id != null){
            comment.update();
        }else {
            comment.save();
        }

        return ok(Json.toJson(comment));
    }

    public static Result postDelete(){
        JsonNode json = request().body().asJson();
        models.Comment comment = Json.fromJson(json, models.Comment.class);
        return ok(Json.toJson(comment));
    }

    public static Result getCurrent(){
        Long comment_id = Long.valueOf(session("comment_id"));
        models.Comment comment = models.Comment.finder.byId(comment_id);
        return  ok(Json.toJson(comment));
    }

    public static Result getAll(){
        return ok(Json.toJson(models.Comment.finder.all()));
    }

}
