package com.geektech.lastfmmvvm.entity;

import java.util.Date;

public class Note {
    private String Title;
    private String Description;
    private Date date;

    public Note(String Title, String Description) {
        this.Title = Title;
        this.Description = Description;
        this.date = new Date();
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
