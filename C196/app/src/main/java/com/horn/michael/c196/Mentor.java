package com.horn.michael.c196;

import java.util.Vector;

/**
 * Created by Mike on 4/14/2017.
 */

public class Mentor {
    public Mentor() {
    }

    public Mentor(String name, Vector<String> phoneNumbers, Vector<String> emails) {
        this.name = name;
        this.phoneNumbers = phoneNumbers;
        this.emails = emails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vector<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Vector<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Vector<String> getEmails() {
        return emails;
    }

    public void setEmails(Vector<String> emails) {
        this.emails = emails;
    }

    private String name;
    private Vector<String> phoneNumbers;
    private Vector<String> emails;


}
