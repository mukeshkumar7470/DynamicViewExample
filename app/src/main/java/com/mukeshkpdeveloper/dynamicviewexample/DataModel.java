package com.mukeshkpdeveloper.dynamicviewexample;

public class DataModel {

    String name;
    int id_;
    boolean isSelected = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId_() {
        return id_;
    }

    public void setId_(int id_) {
        this.id_ = id_;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    @Override
    public String toString() {
        return "DataModel{" +
                "name='" + name + '\'' +
                ", id_=" + id_ +
                ", isSelected=" + isSelected +
                '}';
    }
}
