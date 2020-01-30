package com.bandwidth.adhiksh;

import java.util.ArrayList;

public class Model {

    String complaintId;
    String name;
    String age;
    String aadhar;
    String add;
    String locality;
    String pin;
    String email;
    String mob;
    String subject;
    String date;
    String time;
    String location;
    String des;
    String solution;
    private ArrayList<AppModel> AppModel =new ArrayList<>();


    public Model(){

    }

    public Model(ArrayList<com.bandwidth.adhiksh.AppModel> appModel) {
        AppModel = appModel;
    }

    public Model(String complaintId, String name, String age, String aadhar, String add, String locality, String pin, String email, String mob, String subject, String date, String time, String location, String des, String solution) {
        this.complaintId = complaintId;
        this.name = name;
        this.age = age;
        this.aadhar = aadhar;
        this.add = add;
        this.locality = locality;
        this.pin = pin;
        this.email = email;
        this.mob = mob;
        this.subject = subject;
        this.date = date;
        this.time = time;
        this.location = location;
        this.des = des;
        this.solution = solution;

    }

    public String getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(String complaintId) {
        this.complaintId = complaintId;
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

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public ArrayList<com.bandwidth.adhiksh.AppModel> getAppModel() {
        return AppModel;
    }

    public void setAppModel(ArrayList<com.bandwidth.adhiksh.AppModel> appModel) {
        AppModel = appModel;
    }
}
