package com.company;

import java.util.List;
import java.util.Scanner;

public class memberData extends Data {
    //Contains data read from member files, and functions to write to data files
    //data public or protected
    //Contains a data structure of Service classes
        //Service classes indicate which services have been provided to the member
    //TODO: load in data from text files and load into objects
    String name;
    int number;
    String address;
    String city;
    String state;
    int zip_code;
    List<Service> services;

    public memberData(Scanner fileInput){
        //populates data files from file input

    }

    void updateData(){
        //updates a field, then writes to file
    }
}
