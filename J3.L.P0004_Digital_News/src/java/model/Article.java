package model;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

/**
 *
 * @author Thaycacac
 */
public class Article {

    private int id;
    private String title;
    private String image;
    private String content;
    private Date publish_date;
    private Time publish_time;
    private String author;
    private String description;

    public Article() {
    }

    public Article(int id, String title, String image, String content, Date date,Time publish_time, String author) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.content = content;
        this.publish_date = date;
        this.publish_time = publish_time;
        this.author = author;
        if (content.length() <= 250) {
            this.description = content + "...";
        } else {
            this.description = content.substring(0, 250) + "...";
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(Date publish_date) {
        this.publish_date = publish_date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateTimeFormated() {
        SimpleDateFormat date = new SimpleDateFormat("MMM dd yyy '-' ");
        SimpleDateFormat time = new SimpleDateFormat("hh:mma");
        String dateFomated = date.format(this.publish_date) + time.format(this.publish_time).toLowerCase();
        return dateFomated;
    }

    @Override
    public String toString() {
        return id + " - " + title + " - " + content + " - " + image + " - " + description + " - " + author + publish_date + publish_time;
    }

}
