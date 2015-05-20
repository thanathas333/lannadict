package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by chaow on 1/28/2015 AD.
 */

@Entity
public class Petition extends Model {

    @Id
    public Long id;

    public String lanna;
    public String thai;
    public String link;
    public int status_id;
    public int user_id;

    public static Finder<Long, Petition> finder = new Finder<Long, Petition>(Long.class, Petition.class);


}
