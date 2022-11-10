package com.example.studente_portfolio.model;

public class Resume {
    private String address;
    private String compdesc;
    private String comploc;
    private String compname;
    private String compposition;
    private String educdesc;
    private String educlevel;
    private String educname;
    private String email;
    private String fullname;
    private String languages;
    private String phone;
    private String skills;

    public Resume() {
    }

    public Resume(String fullname2, String email2, String phone2, String skills2, String address2, String languages2, String compname2, String comploc2, String compposition2, String compdesc2, String educname2, String educlevel2, String educdesc2) {
        this.fullname = fullname2;
        this.email = email2;
        this.address = address2;
        this.skills = skills2;
        this.phone = phone2;
        this.languages = languages2;
        this.compname = compname2;
        this.comploc = comploc2;
        this.compposition = compposition2;
        this.compdesc = compdesc2;
        this.educname = educname2;
        this.educlevel = educlevel2;
        this.educdesc = educdesc2;
    }

    public String getFullname() {
        return this.fullname;
    }

    public void setFullname(String fullname2) {
        this.fullname = fullname2;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email2) {
        this.email = email2;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address2) {
        this.address = address2;
    }

    public String getSkills() {
        return this.skills;
    }

    public void setSkills(String skills2) {
        this.skills = skills2;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone2) {
        this.phone = phone2;
    }

    public String getLanguages() {
        return this.languages;
    }

    public void setLanguages(String languages2) {
        this.languages = languages2;
    }

    public String getCompname() {
        return this.compname;
    }

    public void setCompname(String compname2) {
        this.compname = compname2;
    }

    public String getComploc() {
        return this.comploc;
    }

    public void setComploc(String comploc2) {
        this.comploc = comploc2;
    }

    public String getCompposition() {
        return this.compposition;
    }

    public void setCompposition(String compposition2) {
        this.compposition = compposition2;
    }

    public String getCompdesc() {
        return this.compdesc;
    }

    public void setCompdesc(String compdesc2) {
        this.compdesc = compdesc2;
    }

    public String getEducname() {
        return this.educname;
    }

    public void setEducname(String educname2) {
        this.educname = educname2;
    }

    public String getEduclevel() {
        return this.educlevel;
    }

    public void setEduclevel(String educlevel2) {
        this.educlevel = educlevel2;
    }

    public String getEducdesc() {
        return this.educdesc;
    }

    public void setEducdesc(String educdesc2) {
        this.educdesc = educdesc2;
    }
}
