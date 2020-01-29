package com.bandwidth.adhiksh;

import java.util.ArrayList;

public class AppModel {

    //POJO class consists of get method and set method
    private String subject;
    private String date,lar,status;
    private ArrayList<AppModel> AppModel =new ArrayList<>();

    public AppModel(String subject) {
        this.subject = subject;
    }

    public AppModel() {

    }
    //getting content value
    public String getLar(){return lar;}
    //setting content value
    public void setLar(String lar){this.lar=lar;}

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus(){return status;}
    public void setStatus(String status){this.status=status;}


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}