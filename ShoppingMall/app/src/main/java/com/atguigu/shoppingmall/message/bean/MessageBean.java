package com.atguigu.shoppingmall.message.bean;
public class MessageBean {
    private String name;
    private String text;
    private String time;
    private String icon;

    public MessageBean() {
    }

    public MessageBean(String name, String text, String time, String icon) {
        this.name = name;
        this.text = text;
        this.time = time;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) { this.text = text; }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }


}
