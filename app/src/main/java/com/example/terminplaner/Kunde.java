package com.example.terminplaner;

    public class Kunde {
        private int kundeid ;
        private String vorname;



    private String nachname;

    public Kunde(int kundeid,String vorname,String nachname){
        this.kundeid = kundeid;
        this.vorname = vorname;
        this.nachname=nachname;

}

    public Kunde(String vorname,String nachname){

        this.vorname = vorname;
        this.nachname=nachname;

    }

    public int getKundeid() {
        return kundeid;
    }

    public  String getVName(){
        return this.vorname;

}

    public String getNachname(){
        return this.nachname;
}


}


