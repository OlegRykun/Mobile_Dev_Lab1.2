package ua.kpi.comsys.io8218;

import java.util.Date;

public class TimeOR {

    private final int hour;
    private final int minute;
    private final int second;
    private final String hourFormat;

    public TimeOR() {
        hour = 0;
        hourFormat = "AM";
        minute = 0;
        second = 0;
    }

    public TimeOR(int h, int min, int sec) throws Exception{
        if (h >= 0 && h <= 23) {
            hour = h;
            if (h <= 12){
                hourFormat = "AM";
            } else {
                hourFormat = "PM";
            }
        } else {
            System.err.printf("Incorrect hour %d%n", h);
            throw new Exception();
        }

        if (min >= 0 && min <= 59) {
            minute = min;
        } else {
            System.err.printf("Incorrect minute %d%n", min);
            throw new Exception();
        }

        if (sec >= 0 && sec <= 59) {
            second = sec;
        } else {
            System.err.printf("Incorrect second %d%n", sec);
            throw new Exception();
        }

    }

    public String getTime(){
        return String.format("%d:%d:%d %s", hour, minute, second, hourFormat);
    }

    public TimeOR sumTime(TimeOR h2) throws Exception {
        int sec;
        int min = 0;
        int h = 0;

        if (this.second + h2.second >= 60){
            sec = (this.second + h2.second) - 60;
            min++;
        } else{
            sec = this.second + h2.second;
        }

        if (this.minute + h2.minute + min >= 60){
            min += (this.minute + h2.minute) - 60;
            h++;
        } else{
            min += this.minute + h2.minute;
        }

        if (this.hour + h2.hour + h >= 24){
            h += (this.hour + h2.hour) - 24;
        } else{
            h += this.hour + h2.hour;
        }
        
        return new TimeOR(h, min, sec);
    }

    public TimeOR diffTime(TimeOR h2) throws Exception{
        int sec;
        int min = 0;
        int h = 0;

        if (this.second - h2.second < 0){
            sec = (this.second - h2.second) + 60;
            min--;
        } else{
            sec = this.second - h2.second;
        }

        if (this.minute - h2.minute - min < 0){
            min += (this.minute - h2.minute) + 60;
            h--;
        } else{
            min += this.minute - h2.minute;
        }

        if (this.hour - h2.hour - h < 0){
            h += (this.hour - h2.hour) + 24;
        } else{
            h += this.hour - h2.hour;
        }

        return new TimeOR(h, min, sec);
    }
}
