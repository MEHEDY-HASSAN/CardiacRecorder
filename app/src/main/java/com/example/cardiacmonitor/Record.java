package com.example.cardiacmonitor;

/**
 * This is a class of Records
 */
public class Record {
    private String dataMeasured;
    private String timeMeasured;
    private int systolicPressure;
    private int diastolicPressure;
    private int heartRate;
    private String comment;

    public Record(){}

    public Record(String dataMeasured, String timeMeasured, int systolicPressure, int diastolicPressure, int heartRate, String comment) {
        this.dataMeasured = dataMeasured;
        this.timeMeasured = timeMeasured;
        this.systolicPressure = systolicPressure;
        this.diastolicPressure = diastolicPressure;
        this.heartRate = heartRate;
        this.comment = comment;
    }

    public void setDataMeasured(String dataMeasured) {
        this.dataMeasured = dataMeasured;
    }

    public void setTimeMeasured(String timeMeasured) {
        this.timeMeasured = timeMeasured;
    }

    public void setSystolicPressure(int systolicPressure) {
        this.systolicPressure = systolicPressure;
    }

    public void setDiastolicPressure(int diastolicPressure) {
        this.diastolicPressure = diastolicPressure;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }



    public String getDataMeasured() {
        return dataMeasured;
    }

    public String getTimeMeasured() {
        return timeMeasured;
    }

    public int getSystolicPressure() {
        return systolicPressure;
    }

    public int getDiastolicPressure() {
        return diastolicPressure;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public String getComment() {
        return comment;
    }
}
