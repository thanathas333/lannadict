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

        class res {
            public String search;
        }

        res r = new res();
        r.search = "";

        return ok(Json.toJson(r));
    }

    public static Result getAll(){
        DynamicForm form = Form.form().bindFromRequest();
        List<Word> words = Word.finder.all();
        return ok(Json.toJson(words));
    }

}
