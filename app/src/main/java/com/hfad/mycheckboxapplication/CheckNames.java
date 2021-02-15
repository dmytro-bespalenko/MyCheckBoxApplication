package com.hfad.mycheckboxapplication;


public class CheckNames {

    private String name;
    private boolean isChecked;
    private int count;


    public CheckNames(String name, boolean isChecked, int count) {
        this.name = name;
        this.isChecked = isChecked;
        this.count = count;

    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }


    public void setCount(int count) {

        this.count = count;

    }

    public String getName() {
        return name;
    }

    public int getCount() {

        return count;
    }

}
