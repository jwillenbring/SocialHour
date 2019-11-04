package com.example.DataTypes;

import java.util.ArrayList;

public class User {
    private String email;
    private String password;
    private String firstName;
    private ArrayList<String> groups;
    private ArrayList<String> pendingGroups;

    public User(String email, String password, String firstName){
        this.setEmail(email);
        this.setPassword(password);
        this.setFirstName(firstName);
    }

    public User(String email, String password, String firstName, String[] groups, String [] pendingGroups){
        this.setEmail(email);
        this.setPassword(password);
        this.setFirstName(firstName);
        this.setGroups(groups);
        this.setPendingGroups(pendingGroups);
    }




    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public ArrayList<String> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<String> groups) {
        this.groups = groups;
    }

    public ArrayList<String> getPendingGroups() {
        return pendingGroups;
    }

    public void setPendingGroups(ArrayList<String> pendingGroups) {
        this.pendingGroups = pendingGroups;
    }
}
