package com.devraghad.myapplication;

import android.app.Application;

public class GloblUser extends Application {
    private String name;
    private String email;

    public GloblUser(String name,String email){
        this.name= name;
        this.email= email;

    }
    public GloblUser(){
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        name = name;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        email = email;
    }
}

