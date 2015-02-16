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

    public class word extends Controller{

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
