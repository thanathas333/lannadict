package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
    public String firstname;
    public String surname;
    public String address;
    public String tel;
    public String email;

    @ManyToOne
    public Status status;




    public static Finder<Long, User> finder = new Finder<Long, User>(Long.class, User.class);
}

