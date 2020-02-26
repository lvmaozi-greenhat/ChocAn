package com.company;
import java.io.*;
import java.util.*;

public class Data {
    //Contains protected data structure of services
    //may contain protected functions to write / read to file
    //may contain protected or public data that is found in both memberData and providerData
    protected String name;// Member/Povider name
    protected int number;// Member/Povider number (9 digits)
    protected String address;// Member/Povider street address
    protected String city;// Member/Povider city
    protected String state;// Member/Povider state (2 letters)
    protected int zipCode;// Member/Povider (5 digits)
    protected Date date; //Service date

    public Data(){
        name=null;
        number=000000000;
        address=null;
        city=null;
        state=null;
        zipCode=00000;
        date=null;
    }

    public Data(String name,int number,String address,String city,String state,int zipCode){
        this.name=name;
        this.number=number;
        this.address=address;
        this.city=city;
        this.state=state;
        this.zipCode=zipCode;
        this.date=new Date();
    }

    public void printReport(){
        System.out.println(name);
        System.out.println(number);
        System.out.println(address);
        System.out.println(city);
        System.out.println(state);
        System.out.println(zipCode);
        System.out.println(date);
    }



}
