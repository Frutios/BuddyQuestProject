package com.quest.buddy.dtos;

public class FakeUserName {
    private String title;
    private String first;
    private String last;
    public String getTitle() {
        return title;
    }
    public String getLast() {
        return last;
    }
    public void setLast(String last) {
        this.last = last;
    }
    public String getFirst() {
        return first;
    }
    public void setFirst(String first) {
        this.first = first;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
