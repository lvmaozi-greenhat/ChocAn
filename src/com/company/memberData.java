package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class memberData extends Data {
    //Contains data read from member files, and functions to write to data files
    //data public or protected
    //Contains a data structure of Service classes
        //Service classes indicate which services have been provided to the member
    //TODO: load in data from text files and load into objects
    String memoryLocation;
    String name;
    int number;
    String address;
    String city;
    String state;
    int zip_code;
    List<Service> services = new ArrayList<>();

    public memberData() {
        //Default constructor: all set to null.
    }

    public static void main(String[] args) {
        //This is used to test random functions in the memberData class.
        File toSend = new File("member/1.txt");


        memberData tempData = new memberData(toSend);
        tempData.printAll();


        Scanner userInput = new Scanner(System.in);
        memberData tempData2 = new memberData();
        tempData2.fromUserInput(userInput);
        tempData2.printAll();
    }

    public memberData(File inputFile){
        //populates data files from file input
        //memoryLocation = fileInput
        try {
            memoryLocation = inputFile.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner fileInput = null;
        try {
            fileInput = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        assert fileInput != null;
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

    void fromUserInput(Scanner userInput){
        //TODO: Sanitize user input
        System.out.println("Enter member name: ");
        name = userInput.nextLine();

        System.out.println("Enter ID Number: ");
        number = userInput.nextInt();
        userInput.nextLine();

        System.out.println("Enter member street address: ");
        address = userInput.nextLine();

        System.out.println("Enter member city:");
        city = userInput.nextLine();

        System.out.println("Enter user state: ");
        state = userInput.nextLine();

        System.out.println("Enter member zip code: ");
        zip_code = userInput.nextInt();
        userInput.nextLine();
    }

    public void printAll(){
        System.out.println(memoryLocation);
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

    void writeToFile(){
        //Writes to file
    }

    void addService(Service toAdd){
        //add a new service to services arrayList
    }
}
