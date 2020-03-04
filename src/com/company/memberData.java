package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
    List<Service> services = new ArrayList<>();

    public static void main(String[] args) {
        //This is used to test random functions in the memberData class.
        File toSend = new File("member/1.txt");
        Scanner tmpScan = null;
        try {
            tmpScan = new Scanner(toSend);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        assert tmpScan != null;
        memberData tempData = new memberData(tmpScan);
        tempData.printAll();
    }

    public memberData(Scanner fileInput){
        //populates data files from file input
        name = fileInput.nextLine();
        number = fileInput.nextInt();
        fileInput.nextLine();
        address = fileInput.nextLine();
        city = fileInput.nextLine();
        state = fileInput.nextLine();
        zip_code = fileInput.nextInt();
        fileInput.nextLine();

        //Populates service data
        while(fileInput.hasNext()) {
            String tmp = fileInput.nextLine();
            if (tmp.equals("ServiceFlagAbcd")) {
                Service newServ = new Service(fileInput);
                services.add(newServ);
            }
        }
    }

    public void printAll(){
        System.out.println(name);
        System.out.println(number);
        System.out.println(address);
        System.out.println(city);
        System.out.println(state);
        System.out.println(zip_code);

        for (Service service : services) {
            service.printAll();
        }
    }

    void updateData(){
        //updates a field, then writes to file
    }
}
