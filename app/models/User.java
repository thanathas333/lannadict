package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by ZAM on 1/31/2015 AD.
 */
@Entity
public class User extends Model {

    @Id
    public Long id;

    public String username;
    public String password;
    public String name;
    public String surname;
    public String address;
    public int tel;
    public String email;


    public static Finder<Long, User> finder = new Finder<Long, User>(Long.class, User.class);
}

