package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.*;
import play.*;
import play.mvc.*;
import play.libs.Json;


import views.html.*;

import java.util.List;
import java.util.Map;


public class StatusController extends Controller {

    public static Result getAllStatuss(){
        List<models.Status> statuses = models.Status.finder.all();
        return ok(Json.toJson(statuses));
    }

    public static Result getById(long id){
        models.Status status = models.Status.finder.byId(id);
        return ok(Json.toJson(status));
    }

    public static Result postSave(){
        JsonNode json = request().body().asJson();
        models.Status status = Json.fromJson(json, models.Status.class);

        if(status.id != null){
            status.update();
        }else {
            status.save();
        }

        return ok(Json.toJson(status));
    }

    public static Result postDelete(){
        JsonNode json = request().body().asJson();
        models.Status status = Json.fromJson(json, models.Status.class);
        return ok(Json.toJson(status));
    }

    public static Result getCurrent(){
        Long status_id = Long.valueOf(session("status_id"));
        models.Status status = models.Status.finder.byId(status_id);
        return  ok(Json.toJson(status));
    }

    public static Result getAll(){
        return ok(Json.toJson(models.Status.finder.all()));
    }

}
