package com.q2;

import android.graphics.drawable.Drawable;

/**
 * Created with IntelliJ IDEA.
 * User: gron
 * Date: 6/4/12
 * Time: 5:23 PM
 */
public class ListItem {
    private Drawable icon1;
    private Drawable icon2;
    private String text1;
    private String text2;

    public ListItem(Drawable icon1, Drawable icon2, String text1, String text2) {
        this.icon1 = icon1;
        this.icon2 = icon2;
        this.text1 = text1;
        this.text2 = text2;
    }

    public Drawable getIcon1() {
        return icon1;
    }

    public void setIcon1(Drawable icon1) {
        this.icon1 = icon1;
    }

    public Drawable getIcon2() {
        return icon2;
    }

    public void setIcon2(Drawable icon2) {
        this.icon2 = icon2;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }
}
