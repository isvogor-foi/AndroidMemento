package hr.heureka.memento.entities;

import java.util.Date;

/**
 * Created by ivan on 5.7.2016..
 */
public class WsNewsItem {

    private String name;
    private String text;
    private Date date;
    private String image_path;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }
}