package com.example.sgholidays;

public class Holiday {
    private String name;
    private String date;
    private String picture;
    private String category;

    public Holiday(String name, String date){
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }
    public String getDate() {
        return date;
    }

    public String getPicture() {
        return picture;
    }

    public String getCategory() {
        return category;
    }
}
