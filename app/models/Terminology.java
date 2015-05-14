package models;

import play.db.ebean.Model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by chaow on 1/28/2015 AD.
 */

@Entity
public class Terminology extends Model {

    @Id
    public Long id;

    public String thai;
    public String lanna;
    public String link;

    //public int status_id;
    //public int user_id;
    @ManyToOne
    public Status status;

    @ManyToOne
    public User user;


    @OneToMany(cascade = CascadeType.ALL)
    public List<Comment> comments;

    public static Finder<Long, Terminology> finder = new Finder<Long, Terminology>(Long.class, Terminology.class);


}
