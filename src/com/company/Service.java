package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Service {
    Date service_date; //contains date and time
    //Date receiving_date_time;
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
            service_date = formatter.parse(fileInput.nextLine());
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
        System.out.println(service_date);
        System.out.println(member_name);
        System.out.println(provider_name);
        System.out.println(service_name);
        System.out.println(comments);
        System.out.println(member_id);
        System.out.println(service_id);
        System.out.println(fee);
    }
}
