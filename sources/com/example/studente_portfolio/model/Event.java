package com.example.studente_portfolio.model;

import java.util.Date;

public class Event {
    private Date date;
    private String dateevent;
    private String datehh;
    private String datemm;
    private String datetime;
    private String eventdesc;
    private String eventname;

    public Event() {
    }

    public Event(String eventname2, String eventdesc2, Date date2, String dateevent2, String datetime2, String datehh2, String datemm2) {
        this.eventname = eventname2;
        this.eventdesc = eventdesc2;
        this.date = date2;
        this.dateevent = dateevent2;
        this.datetime = datetime2;
        this.datehh = datehh2;
        this.datemm = datemm2;
    }

    public String getEventName() {
        return this.eventname;
    }

    public void setEventName(String eventname2) {
        this.eventname = eventname2;
    }

    public String getEventdesc() {
        return this.eventdesc;
    }

    public void setEventdesc(String eventdesc2) {
        this.eventdesc = eventdesc2;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date2) {
        this.date = date2;
    }

    public String getDateevent() {
        return this.dateevent;
    }

    public void setDateevent(String dateevent2) {
        this.dateevent = dateevent2;
    }

    public String getDatetime() {
        return this.datetime;
    }

    public void setDatetime(String datetime2) {
        this.datetime = datetime2;
    }

    public String getDatehh() {
        return this.datehh;
    }

    public void setDatehh(String datehh2) {
        this.datehh = datehh2;
    }

    public String getDatemm() {
        return this.datemm;
    }

    public void setDatemm(String datemm2) {
        this.datemm = datemm2;
    }
}
