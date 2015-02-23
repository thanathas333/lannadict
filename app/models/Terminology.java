package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

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
    public String user_id;

    public static Finder<Long, Terminology> finder = new Finder<Long, Terminology>(Long.class, Terminology.class);


}
