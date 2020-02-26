package com.company;

public class Main {

    public static void main(String[] args) {
        //create dataController, and call a function to initialize all data
            //read stuff from files, ect ect
        //create a reportController, and pass dataController into it
        //create a autoReport, and pass reportController into it (threading?)
        //create an Interface class, and pass dataController and reportController into it
        //call a function to initialize the interface

        System.out.println("Hello World!");
        Data A=new Data("jack",123456789,"address","city","OR",12345);
        A.printReport();
    }
}
