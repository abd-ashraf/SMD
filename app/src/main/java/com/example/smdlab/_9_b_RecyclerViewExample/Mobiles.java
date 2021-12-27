package com.example.smdlab._9_b_RecyclerViewExample;

public class Mobiles {
    private String Name, Company, Price;
//    make Constructor
    public Mobiles(String name, String company, String price) {
        Name = name;
        Company = company;
        Price = price;
    }

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }

    public String getCompany() {
        return Company;
    }
    public void setCompany(String company) {
        Company = company;
    }

    public String getPrice() {
        return Price;
    }
    public void setPrice(String price) {
        Price = price;
    }
}
