package com.example.cat_caring.db;

import java.io.Serializable;
import java.sql.Blob;

public class cat implements Serializable {
    private int id;
    private String catname;
    private String maose;
    private String birthday;
    private String sex;
    private String condition;
    private String character;
    private  Blob image;


    public cat() {
        super();
        // TODO Auto-generated constructor stub
    }



    public  cat(int id, String catname,String maose,String birthday,String sex,String condition,String character) {
        this.id=id;
        this.catname = catname;
        this.maose = maose;
        this.birthday = birthday;
        this.sex = sex;
        this.condition = condition;
        this.character = character;
        this.image=null;
    }
    public  cat(int id, String catname, String maose, String birthday, String sex, String condition, String character, Blob image) {
        this.id=id;
        this.catname = catname;
        this.maose = maose;
        this.birthday = birthday;
        this.sex = sex;
        this.condition = condition;
        this.character = character;
        this.image=image;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCatname() {
        return catname;
    }
    public void setCatname() { this.catname = catname; }
    public String getMaose() {
        return maose;
    }
    public void setMaose(String maobohe) {
        this.maose = maose;
    }
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String maosha) {
        this.birthday = birthday;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getCondition() {
        return condition;
    }
    public void setCondition(String condition) {
        this.condition = condition;
    }
    public String getCharacter() {
        return character;
    }
    public void setCharacter(String character) {
        this.character = character;
    }
    public Blob getImage() {
        return image;
    }
    public void setImage(Blob image) {
        this.image = image;
    }

    public String toString() {
        return "cat [catid=" + id + ", catname=" + catname + ", maose="
                + maose + ", birthday=" + birthday + ", sex=" + sex + ",condition="+condition +",character="+character+"]";

    }
}
