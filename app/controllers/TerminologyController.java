package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Comment;
import models.Terminology;
import models.User;
import models.Word;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

public class TerminologyController extends Controller {

    public static Result getAllTerminologys(){
        List<Terminology> terminologys = Terminology.finder.all();
        return ok(Json.toJson(terminologys));
    }

    public static Result getById(long id){
        Terminology terminology = Terminology.finder.byId(id);
        return ok(Json.toJson(terminology));
    }

    public static Result postSave(){
        JsonNode json = request().body().asJson();
        Terminology terminology = Json.fromJson(json,Terminology.class);

        String uid = session().get("user_id");
        Long user_id = Long.valueOf(uid);
        User user = User.finder.byId(user_id);
        terminology.user = user;

        String cid = session().get("comment_id");
        Long comment_id = Long.valueOf(cid);
        Comment comment = Comment.finder.byId(comment_id);
        terminology.comment = comment;


        if(terminology.id != null){
            terminology.update();
        }else {
            //terminology.user_id=
            terminology.save();
        }

        return ok(Json.toJson(terminology));
    }

    public static Result postDelete(){
        JsonNode json = request().body().asJson();
        Terminology terminology = Json.fromJson(json, Terminology.class);

        terminology.delete();

        return ok(Json.toJson(terminology));
    }

}
