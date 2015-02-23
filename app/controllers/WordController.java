package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.*;
import play.*;
import play.mvc.*;
import play.libs.Json;


import views.html.*;

import java.util.List;
import java.util.Map;

public class WordController extends Controller{

    public static Result getAllWords(){
        List<models.Word> words = models.Word.finder.all();
        return ok(Json.toJson(words));
    }

    public static Result postWordAdd(){
        JsonNode json = request().body().asJson();
        models.Word word = Json.fromJson(json, models.Word.class);

        word.save();

        return ok(Json.toJson(word));
    }

}
