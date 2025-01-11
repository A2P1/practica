package com.prueba.Practica;

public class DataRecord {

    private int year;
    private String mscode;
    private double lowerCIB;
    private double upperCIB;
    private String estcode;
    private double se;

    public DataRecord() {}

    public DataRecord(int year, String mscode, double lowerCIB, double upperCIB, String estcode, double se) {

        this.year = year;
        this.mscode = mscode;
        this.lowerCIB = lowerCIB;
        this.upperCIB = upperCIB;
        this.estcode = estcode;
        this.se = se;
    }

    // Getters

    public int getYear() {
        return year;
    }

    public String getMscode() {
        return mscode;
    }

    public double getLowerCIB() {
        return lowerCIB;
    }

    public double getUpperCIB() {
        return upperCIB;
    }

    public String getEstcode() {
        return estcode;
    }

    public double getSe() {
        return se;
    }

    // Setters

    public void setYear(int year) {
        this.year = year;
    }

    public void setMscode(String mscode) {
        this.mscode = mscode;
    }

    public void setLowerCIB(double lowerCIB) {
        this.lowerCIB = lowerCIB;
    }

    public void setUpperCIB(double upperCIB) {
        this.upperCIB = upperCIB;
    }

    public void setEstcode(String estcode) {
        this.estcode = estcode;
    }

    public void setSe(double se) {
        this.se = se;
    }
}
