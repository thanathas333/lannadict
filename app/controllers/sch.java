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

public class sch extends Controller {

    public static Result postSearch(){

        JsonNode json = request().body().asJson();

        class res {
            public String search;
        }

        res r = new res();
        r.search = "";

        return ok(Json.toJson(r));
    }


}
