package com.example.eunbee.help_dormitory.models;

/**
 * Created by Student on 2016-11-15.
 */


// [START blog_user_class]
public class User {

    public String work;
    public int year;
    public int month;
    public int date;


    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String work, int year,int month, int date) {
        this.work = work;
        this.year = year;
        this.month = month;
        this.date = date;
    }


}
// [END blog_user_class]