package com.example.cardiac_recorder;

public class health_info_model {
    String heart_rate,systolic_pressure,diastolic_pressure,status,date,time,key,UserID;

    public health_info_model() {
    }

    public health_info_model( String date, String time,String systolic, String diastolic, String heart_rate ) {
        this.systolic_pressure = systolic;
        this.diastolic_pressure = diastolic;
        this.heart_rate = heart_rate;
        this.date = date;
        this.time = time;
    }

    public String getheart_rate(){ return heart_rate;}
    public String getsystolic_pressure(){ return systolic_pressure;}
    public String getdiastolic_pressure(){ return diastolic_pressure;}
    public String getstatus(){ return status;}
    public String gettime(){ return time;}
    public String getdate(){ return date;}


    public String getUserID() {
        return UserID;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
