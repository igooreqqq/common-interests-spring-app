package com.meow.commoninterests.request;

public class AddInterest {

    private String content;

    public AddInterest(String content) {
        this.content = content;
    }

    public AddInterest() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
