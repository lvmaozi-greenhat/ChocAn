package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Service {
    Date occurred_date; //Date and time service occurred
    Date received_in_system; //Date and time service received into system
    String member_name;
    String provider_name;
    String service_name;
    String comments; //OPTIONAL
    int member_id;
    int service_id;
    double fee;

    public Service(Scanner fileInput){
        //Populate Service class from scanner fileInput object
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        try {
            occurred_date = formatter.parse(fileInput.nextLine());
            received_in_system = formatter.parse(fileInput.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        member_name = fileInput.nextLine();
        provider_name = fileInput.nextLine();
        service_name = fileInput.nextLine();
        comments = fileInput.nextLine();
        member_id = fileInput.nextInt();
        service_id = fileInput.nextInt();
        fee = fileInput.nextDouble();
        //fileInput.nextLine();

        //this.printAll();
    }

    public void printAll(){
        System.out.println(occurred_date);
        System.out.println(received_in_system);
        System.out.println(member_name);
        System.out.println(provider_name);
        System.out.println(service_name);
        System.out.println(comments);
        System.out.println(member_id);
        System.out.println(service_id);
        System.out.println(fee);
    }
}
