package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Terminology;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

public class SearchesController extends Controller {


    public static Result postSearches(){

        JsonNode json = request().body().asJson();
        String search = json.get("search").textValue();
        search = "%"+search+"%";
        List<Terminology> terminologys = SearchesController.search(search);
        return ok(Json.toJson(terminologys));
    }

    private static List<Terminology> search(String str){
        return Terminology.finder.where().ilike("thai",str).findList();
    }


}
