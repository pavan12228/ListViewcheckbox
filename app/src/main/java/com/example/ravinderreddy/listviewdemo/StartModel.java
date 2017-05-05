package com.example.ravinderreddy.listviewdemo;

import java.io.Serializable;

/**
 * Created by Ravinder Reddy on 22-04-2017.
 */

public class StartModel implements Serializable{
    String startName;
    boolean checked;

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    boolean selected;


    public int getStartImage() {
        return startImage;
    }

    public void setStartImage(int startImage) {
        this.startImage = startImage;
    }

    int startImage;

    public String getStartName() {
        return startName;
    }

    public void setStartName(String startName) {
        this.startName = startName;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
