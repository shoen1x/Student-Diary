package com.example.studente_portfolio.model;

public class Note {
    private String content;
    private String title;

    public Note() {
    }

    public Note(String title2, String content2) {
        this.title = title2;
        this.content = content2;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title2) {
        this.title = title2;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content2) {
        this.content = content2;
    }
}
