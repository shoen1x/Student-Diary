package com.example.studente_portfolio.model;

public class CheckAttd {
    private int checkrecord;
    private String datecheck;
    private String subName;

    public CheckAttd() {
    }

    public CheckAttd(String subName2, String datecheck2, int checkrecord2) {
        this.subName = subName2;
        this.datecheck = datecheck2;
        this.checkrecord = checkrecord2;
    }

    public String getSubName() {
        return this.subName;
    }

    public void setSubName(String subName2) {
        this.subName = subName2;
    }

    public String getDatecheck() {
        return this.datecheck;
    }

    public void setDatecheck(String datecheck2) {
        this.datecheck = datecheck2;
    }

    public int getCheckrecord() {
        return this.checkrecord;
    }

    public void setCheckrecord(int checkrecord2) {
        this.checkrecord = checkrecord2;
    }
}
