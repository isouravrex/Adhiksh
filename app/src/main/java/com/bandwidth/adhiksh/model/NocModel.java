package com.bandwidth.adhiksh.model;

public class NocModel {

    String nocId;
    String name;
    String age;
    String aadhar;
    String fathersname;
    String category;
    String email;
    String mobie;
    String subject;
    String description;

    public NocModel(){

    }

    public NocModel(String nocId, String name, String age, String aadhar, String fathersname, String category, String email, String mobie, String subject, String description) {
        this.nocId = nocId;
        this.name = name;
        this.age = age;
        this.aadhar = aadhar;
        this.fathersname = fathersname;
        this.category = category;
        this.email = email;
        this.mobie = mobie;
        this.subject = subject;
        this.description = description;
    }

    public String getNocId() {
        return nocId;
    }

    public void setNocId(String nocId) {
        this.nocId = nocId;
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

    public String getFathersname() {
        return fathersname;
    }

    public void setFathersname(String fathersname) {
        this.fathersname = fathersname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobie() {
        return mobie;
    }

    public void setMobie(String mobie) {
        this.mobie = mobie;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
