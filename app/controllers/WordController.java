package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.*;
import play.*;
import play.mvc.*;
import play.libs.Json;


import views.html.*;

import java.util.List;
import java.util.Map;

public class WordController extends Controller {

    public static Result getAllWords(){
        List<Word> words = Word.finder.all();
        return ok(Json.toJson(words));
    }

    public static Result getById(long id){
        Word word = Word.finder.byId(id);
        return ok(Json.toJson(word));
    }

    public static Result postSave(){
        JsonNode json = request().body().asJson();
        Word word = Json.fromJson(json,Word.class);

        if(word.id != null){
            word.update();
        }else {
            word.save();
        }

        return ok(Json.toJson(word));
    }

    public static Result postDelete(){
        JsonNode json = request().body().asJson();
        Word word = Json.fromJson(json, Word.class);

        word.delete();

        return ok(Json.toJson(word));
    }

}
