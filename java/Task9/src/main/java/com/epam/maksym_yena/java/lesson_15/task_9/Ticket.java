package com.epam.maksym_yena.java.lesson_15.task_9;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Ticket implements Serializable {

    @JsonProperty("id")
     long id;
    @JsonProperty("title")
     String title;
    @JsonProperty("data")
     String data;
    @JsonProperty("category")
     String category;
    @JsonProperty("place")
     int place;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", place=" + place +
                ", data=" + data +
                '}';
    }
}
