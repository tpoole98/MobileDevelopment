package com.example.hw02;

import java.io.Serializable;

public class Task implements Serializable {
    String name;
    String date;
    String priority;
    int num;
    public Task(String n, String d, String p, int num){
        this.name = n;
        this.date = d;
        this.priority = p;
        this.num = num;
    }
    public Task(){

    }
    public String getName(){
        return name;
    }
    public String getDate(){
        return date;
    }
    public String getPriority(){
        return priority;
    }
    public int getNum(){
        return num;
    }

}
