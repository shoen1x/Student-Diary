package com.example.studente_portfolio.model;

public class FileAttrib {
    private String date;
    private String filetype;
    private String title;

    public FileAttrib() {
    }

    public FileAttrib(String title2, String date2, String filetype2) {
        this.title = title2;
        this.date = date2;
        this.filetype = filetype2;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title2) {
        this.title = title2;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date2) {
        this.date = date2;
    }

    public String getFiletype() {
        return this.filetype;
    }

    public void setFiletype(String filetype2) {
        this.filetype = filetype2;
    }
}
