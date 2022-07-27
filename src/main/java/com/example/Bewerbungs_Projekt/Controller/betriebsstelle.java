package com.example.Bewerbungs_Projekt.Controller;
//Hatte ich mal angelegt, ist aber für so nen kleines Projekt nicht nötig.
public class betriebsstelle {
    private String name;
    private String kurzname;
    private String typ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getkurzname() {
        return kurzname;
    }

    public void setkurzname(String kurzname) {
        this.kurzname = kurzname;
    }

    public String gettyp() {
        return typ;
    }

    public void settyp(String typ) {
        this.typ = typ;
    }
    @Override
    public String toString() {
        return "Betriebsstelle{" +
                ", name='" + name + '\'' +
                ", email='" + kurzname + '\'' +
                ", phone='" + typ + '\'' +
                '}';
    }
}
