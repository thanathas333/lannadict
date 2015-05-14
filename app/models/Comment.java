package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by chaow on 1/28/2015 AD.
 */

@Entity
public class Comment extends Model {

    @Id
    public Long id;

    public String comment;

    @ManyToOne
    public User user;

    public static Finder<Long, Comment> finder = new Finder<Long, Comment>(Long.class, Comment.class);


}
