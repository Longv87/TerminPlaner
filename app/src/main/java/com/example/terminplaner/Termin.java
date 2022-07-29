package com.example.terminplaner;



public class Termin {
    private int Terminid;
    private String Datum;
    private String Anfangzeit;
    private String Ende;
    private String Designart;

public Termin(int Terminid,String Datum,String Anfangzeit,String Ende,String Designart){
    this.Terminid = Terminid;
    this.Datum = Datum;
    this.Anfangzeit= Anfangzeit;
    this.Ende = Ende;
    this.Designart = Designart;
}

    public int getTerminid() {
        return Terminid;
    }

    public String getDatum() {
        return Datum;
    }

    public String getAnfangzeit() {
        return Anfangzeit;
    }

    public String getEnde() {
        return Ende;
    }

    public String getDesignart() {
        return Designart;
    }
}
