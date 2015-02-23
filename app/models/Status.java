package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by chaow on 1/28/2015 AD.
 */

@Entity
public class Status extends Model {

    @Id
    public Long id;

    public String name;
    public String description;

    public static Finder<Long, Status> finder = new Finder<Long, Status>(Long.class, Status.class);


}
