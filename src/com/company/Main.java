package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        //create dataController, and call a function to initialize all data
            //read stuff from files, ect ect
        //create a reportController, and pass dataController into it
        //create a autoReport, and pass reportController into it (threading?)
        //create an Interface class, and pass dataController and reportController into it
        //call a function to initialize the interface

        final String FILENAME = "test.txt";

        //get data from user
        String userData = Utilities.getCommandLineData("test data");
        //delete any data that might already be in that file
        Utilities.deleteFileIfExists(FILENAME);

        //append this data to the file
        Utilities.dataFileAppend("test1", FILENAME);
        Utilities.dataFileAppend("test2", FILENAME);
        Utilities.dataFileAppendNewline("test.txt");

        //append user data as well
        Utilities.dataFileAppend(userData, FILENAME);
        Utilities.dataFileAppendNewline(FILENAME);

        //load the file into a list of strings
        List<String> file_data = Utilities.getFileData(FILENAME);

        //print those lines
        for(String line : file_data)
            System.out.println(line);
    }
}
