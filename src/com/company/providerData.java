package com.company;

import java.util.List;

public class providerData extends Data {
    //Contains data read from provider files, and functions to write to correct files
    //data public or protected
    //contains data structure of service class
        //this shows what services a provider can provide to a member
        //function to add a service to a member?
    //TODO: load in data from text files and load into objects

    String name;
    int id;
    String address;
    String city;
    String state;
    int zip_code;
    List<Service> services;
    int n_consultations;
    double week_fees; //maybe unnecessary and should be calculated on the fly instead
}

//test