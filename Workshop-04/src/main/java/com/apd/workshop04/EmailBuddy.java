package com.apd.workshop04;

// ===== EMAIL BUDDY MODEL =====
public class EmailBuddy {
    private String name, address;
    private boolean onHotList;

    public EmailBuddy() {
        name = "";
        address = "";
        onHotList = false;
    }

    public EmailBuddy(String aName, String anAddress) {
        name = aName;
        address = anAddress;
        onHotList = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String newAddress) {
        address = newAddress;
    }

    public boolean onHotList() {
        return onHotList;
    }

    public void onHotList(boolean onList) {
        onHotList = onList;
    }

    public String toString() {
        return (name);
    }
}