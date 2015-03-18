package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Word;
import play.*;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.*;
import play.libs.Json;


import views.html.*;

import java.util.List;
import java.util.Map;

public class SearchController extends Controller {

    public static Result postSearch(){

        JsonNode json = request().body().asJson();
        String search = json.get("search").textValue();
        search = "%"+search+"%";
        List<Word> words = SearchController.search(search);
        return ok(Json.toJson(words));
    }

    private static List<Word> search(String str){
        return Word.finder.where().ilike("thai",str).findList();
    }

}
