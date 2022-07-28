package com.example.cardiacmonitor;

import java.io.Serializable;
import java.util.Objects;

/**
 * This is a class of Records
 */
public class Record implements Serializable, Comparable<Record>{
    private String dataMeasured;
    private String timeMeasured;
    private int systolicPressure;
    private int diastolicPressure;
    private int heartRate;
    private String comment;

    /**
     * This is the parameterized constructor
     * @param dataMeasured
     *      date value
     * @param timeMeasured
     *      time value
     * @param systolicPressure
     *      systolicPressure value
     * @param diastolicPressure
     *      diastolicPressure value
     * @param heartRate
     *      heartrate value
     * @param comment
     *      comment
     */

    public Record(String dataMeasured, String timeMeasured, int systolicPressure, int diastolicPressure, int heartRate, String comment) {
        this.dataMeasured = dataMeasured;
        this.timeMeasured = timeMeasured;
        this.systolicPressure = systolicPressure;
        this.diastolicPressure = diastolicPressure;
        this.heartRate = heartRate;
        this.comment = comment;
    }

    /**
     * Check if two Measurement object are equals
     * @param o
     *      another object o
     * @return
     *      return if both are equals or not
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record that = (Record) o;
        return systolicPressure == that.systolicPressure && diastolicPressure == that.diastolicPressure && heartRate == that.heartRate && dataMeasured.equals(that.dataMeasured) && timeMeasured.equals(that.timeMeasured) && Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataMeasured, timeMeasured, systolicPressure, diastolicPressure, heartRate, comment);
    }

    /**
     * Default parameter
     */

    public Record(){}

    /**
     * Set data
     * @param dataMeasured
     *      input date
     */

    public void setDataMeasured(String dataMeasured) {
        this.dataMeasured = dataMeasured;
    }

    /**
     * Set time
     * @param timeMeasured
     * input time
     */

    public void setTimeMeasured(String timeMeasured) {
        this.timeMeasured = timeMeasured;
    }

    /**
     * Set systolicPressure
     * @param systolicPressure
     * input systolicPressure
     */
    public void setSystolicPressure(int systolicPressure) {
        this.systolicPressure = systolicPressure;
    }

    /**
     * Set diastolicPressure
     * @param diastolicPressure
     * input diastolicPressure
     */
    public void setDiastolicPressure(int diastolicPressure) {
        this.diastolicPressure = diastolicPressure;
    }

    /**
     * Set heartrate
     * @param heartRate
     * input heartrate
     */
    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    /**
     * Set comment
     * @param comment
     * input comment
     */
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


    /**
     *
     * @param record
     * @return
     */
    @Override
    public int compareTo(Record record) {
        return this.timeMeasured.compareTo(record.getTimeMeasured());
    }
}
