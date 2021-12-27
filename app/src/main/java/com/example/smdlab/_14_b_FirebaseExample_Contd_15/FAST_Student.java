package com.example.smdlab._14_b_FirebaseExample_Contd_15;

public class FAST_Student {
//    Name and Picture of Objects
    String Name, URL;

    public FAST_Student() {

    }

    public FAST_Student(String name, String URL) {
        Name = name;
        this.URL = URL;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
