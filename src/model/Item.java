package model;

import java.time.LocalDate;

public class Item {

    private String id;
    private String name;
    private String date;
    private boolean isBroken;

    public Item(String id, String name, String date, boolean isBroken) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.isBroken = isBroken;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isBroken() {
        return isBroken;
    }

    public void setBroken(boolean broken) {
        isBroken = broken;
    }
}
