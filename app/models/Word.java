package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by chaow on 1/28/2015 AD.
 */

@Entity
public class Word extends Model {

    @Id
    public Long id;

    public String thai;
    public String lanna;
    public String link;

    public static Finder<Long,Word> finder = new Finder<Long, Word>(Long.class,Word.class);


}
