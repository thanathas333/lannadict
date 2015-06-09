package models;

import play.db.ebean.Model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by chaow on 1/28/2015 AD.
 */

// POST /api/terminology/:id/add-comment controllers.XXXX.addComment(id : Long)
/*

        Terminology t = Terminology.finder.byId(id);
        JsonNode json = request().body().asJson();
        Comment comment = Json.fromJson(json,Comment.class);
        //comment.save();
        t.comments.add(comment);
        t.save();
 */

@Entity
public class Terminology extends Model {

    @Id
    public Long id;

    public String thai;
    public String lanna;
    public String link;
    public String romanbali;
    public String thaibali;
    //public String name;
    public String comment;

    //public int status_id;
    //public int user_id;
    //@ManyToOne
    //public Status status;

    @ManyToOne
    public User user;


    public static Finder<Long, Terminology> finder = new Finder<Long, Terminology>(Long.class, Terminology.class);


}
