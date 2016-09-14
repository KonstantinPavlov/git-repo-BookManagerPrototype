package com.konstpavlov.model;

/**
 * Created by Konstantin on 14.09.2016.
 */
public class Post {

    int id;
    String text;

    public Post(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public Post()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
