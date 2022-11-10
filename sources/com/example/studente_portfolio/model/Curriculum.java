package com.example.studente_portfolio.model;

public class Curriculum {
    private String activachiv;
    private String activdesc;
    private String activname;

    public Curriculum() {
    }

    public Curriculum(String activname2, String activachiv2, String activdesc2) {
        this.activname = activname2;
        this.activachiv = activachiv2;
        this.activdesc = activdesc2;
    }

    public String getActivName() {
        return this.activname;
    }

    public void setActivName(String activname2) {
        this.activname = activname2;
    }

    public String getActivAchiv() {
        return this.activachiv;
    }

    public void setActivAchiv(String activachiv2) {
        this.activachiv = activachiv2;
    }

    public String getActivDesc() {
        return this.activdesc;
    }

    public void setActivDesc(String activdesc2) {
        this.activdesc = activdesc2;
    }
}
