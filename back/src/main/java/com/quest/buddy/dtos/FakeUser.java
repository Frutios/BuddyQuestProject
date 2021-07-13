package com.quest.buddy.dtos;

public class FakeUser {
    private FakeUserName name;
    private String email;
    private FakeUserPicture picture;
    private String phone;
    public FakeUserName getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public FakeUserPicture getPicture() {
        return picture;
    }
    public void setPicture(FakeUserPicture picture) {
        this.picture = picture;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setName(FakeUserName name) {
        this.name = name;
    }
}
