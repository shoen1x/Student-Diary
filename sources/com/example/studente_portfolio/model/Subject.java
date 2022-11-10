package com.example.studente_portfolio.model;

public class Subject {
    private int checkrecord;
    private String subcredit;
    private String subid;
    private String sublec;
    private String subname;
    private String subsec;
    private String subsem;

    public Subject() {
    }

    public Subject(String subname2, String subid2, String subsec2, String sublec2, String subsem2, String subcredit2, int checkrecord2) {
        this.subname = subname2;
        this.subid = subid2;
        this.subsec = subsec2;
        this.sublec = sublec2;
        this.subsem = subsem2;
        this.subcredit = subcredit2;
        this.checkrecord = checkrecord2;
    }

    public String getSubname() {
        return this.subname;
    }

    public void getSubname(String subname2) {
        this.subname = subname2;
    }

    public String getSubid() {
        return this.subid;
    }

    public void getSubid(String subid2) {
        this.subid = subid2;
    }

    public String getSubsec() {
        return this.subsec;
    }

    public void getSubsec(String subsec2) {
        this.subsec = subsec2;
    }

    public String getSublec() {
        return this.sublec;
    }

    public void getSublec(String sublec2) {
        this.sublec = sublec2;
    }

    public String getSubsem() {
        return this.subsem;
    }

    public void getSubsem(String subsem2) {
        this.subsem = subsem2;
    }

    public String getSubcredit() {
        return this.subcredit;
    }

    public void getSubcredit(String subcredit2) {
        this.subcredit = subcredit2;
    }

    public int getCheckRecord() {
        return this.checkrecord;
    }

    public void setCheckRecord(int checkrecord2) {
        this.checkrecord = checkrecord2;
    }
}
