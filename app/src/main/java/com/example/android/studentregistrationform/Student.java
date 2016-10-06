package com.example.android.studentregistrationform;

import java.io.Serializable;

/**
 * Created by Todd on 9/30/2016.
 */

public class Student implements Serializable{
    private String name, email, dept;
    private int mood;

    public Student(String name, String email, String dept, int mood) {
        this.name = name;
        this.email = email;
        this.dept = dept;
        this.mood = mood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getMood() {
        return mood;
    }

    public void setMood(int mood) {
        this.mood = mood;
    }
}
