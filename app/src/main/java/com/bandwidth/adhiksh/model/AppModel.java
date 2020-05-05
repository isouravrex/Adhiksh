package com.bandwidth.adhiksh.model;


public class AppModel {

    //POJO class consists of get method and set method
    String AppointmentId;
    String name;
    String age;
//    String aadhar;
//    String add;
//    String locality;
//    String pin;
    String email;
    String mob;
    String subject;
    String date;
    String time;
    String authorityname;
    String description;
    String authority;
    String lar;

    public AppModel(){

    }

    public AppModel(String lar) {
        this.lar = lar;
    }

    public AppModel(String appointmentId, String name, String age, String email, String mob, String subject, String date, String time, String authorityname, String description, String authority) {
        AppointmentId = appointmentId;
        this.name = name;
        this.age = age;
        this.email = email;
        this.mob = mob;
        this.subject = subject;
        this.date = date;
        this.time = time;
        this.authorityname = authorityname;
        this.description = description;
        this.authority = authority;

    }

    public String getAppointmentId() {
        return AppointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        AppointmentId = appointmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAuthorityname() {
        return authorityname;
    }

    public void setAuthorityname(String authorityname) {
        this.authorityname = authorityname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getLar() {
        return lar;
    }

    public void setLar(String lar) {
        this.lar = lar;
    }
}
