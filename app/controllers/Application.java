package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Word;
import play.*;
import play.mvc.*;
import play.libs.Json;


import views.html.*;

import java.util.List;
import java.util.Map;

public class Application extends Controller {


    public static Result home() {
        return ok (home.render());
    }
    public static Result login() {
        return ok (login.render());
    }
    public static Result about() {
        return ok (about.render());
    }
    public static Result search() {
        return ok(search.render());
    }
    public static Result add() {
        return ok (add.render());
    }
    public static Result register() {
        return ok (register.render());
    }

    public static Result postSearch(){

        JsonNode json = request().body().asJson();

        class res {
            public String search;
        }

        res r = new res();
        r.search = "HELLO WORLD";

        return ok(Json.toJson(r));
    }

    public static Result getAllWords(){
        List<Word> words = Word.finder.all();
        return ok(Json.toJson(words));
    }

    public static Result postWordAdd(){
        JsonNode json = request().body().asJson();
        Word word = Json.fromJson(json,Word.class);

        word.save();

        return ok(Json.toJson(word));
    }

}






