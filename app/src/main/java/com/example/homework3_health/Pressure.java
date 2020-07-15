package com.example.homework3_health;



import java.util.Calendar;
import java.util.Date;


public class Pressure {
    int topPressure;
    int lowerPressure;
    int pulse;
    Date date;

    public Pressure(int topPressure, int lowerPressure, int pulse, Date date) {
        this.topPressure = topPressure;
        this.lowerPressure = lowerPressure;
        this.pulse = pulse;
        this.date = date;
    }

}
