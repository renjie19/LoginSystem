package com.lourence.jonh.view;

import com.lourence.jonh.util.StateEnum;

public class TimeLogView {
    public void viewLogByID(int id, String date, StateEnum type){
        System.out.println(id+"|"+date+"|"+type);
    }
}
