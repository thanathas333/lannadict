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

    public static Result getAll(){
        return ok(Json.toJson(models.Status.finder.all()));
    }
}
