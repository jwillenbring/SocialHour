package com.example.DataTypes;

public class User {
    private String email;
    private String password;
    private String firstName;
    private String [] groups;
    private String [] pendingGroups;

    public User(String email, String password, String firstName){
        this.setEmail(email);
        this.setPassword(password);
        this.setFirstName(firstName);
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

    public String[] getGroups() {
        return groups;
    }

    public void setGroups(String[] groups) {
        this.groups = groups;
    }

    public String[] getPendingGroups() {
        return pendingGroups;
    }

    public void setPendingGroups(String[] pendingGroups) {
        this.pendingGroups = pendingGroups;
    }
}
