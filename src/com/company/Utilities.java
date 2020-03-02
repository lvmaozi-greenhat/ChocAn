package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utilities {
    //delimiter to be used in files
    public static final char DELIMITER = '|';

    //get data from user
    static String getCommandLineData(String dataType) {
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.print("Please enter a value for ");
        System.out.print(dataType);
        System.out.print(": ");
        //get input
        input = scanner.nextLine();
        //if valid input, return
        if(!(input.equals("")))
            return input;
        //if no valid input, try again
        else {
            System.out.println("Error, please give a value.");
            return getCommandLineData(dataType);
        }
    }

    //get optional data from user
    static String getOptionalCommandLineData(String dataType) {
        System.out.print("Please enter a value for ");
        System.out.print(dataType);
        System.out.print(" (optional): ");
        return new Scanner(System.in).nextLine();
    }

    //print data to terminal
    static void printCommandLineData(String value, String dataType) {
        System.out.print(dataType);
        System.out.print(": ");
        System.out.println(value);
    }

    //get a whole file of data, a list of lines
    static List<String> getFileData(String filename) {
        List<String> data = new ArrayList<>();
        BufferedReader br;
        String line;
        //try getting the data from the given filename
        try {
            br = new BufferedReader(new FileReader(filename));
            while((line = br.readLine()) != null)
                data.add(line);
            br.close();
            return data;
        //if that filename doesn't exist, return null
        } catch(Exception x) {
            System.out.println("Error, file not found.");
            return null;
        }
    }

    //write a piece of data, delimiter included
    static void dataFileAppend(String data, String filename) {
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(filename, true));
            bw.append(data);
            bw.append(DELIMITER);
            bw.close();
        }
        catch(Exception x) {
            System.out.println("File writing error.");
        }
    }

    //append a newline on after adding data
    static void dataFileAppendNewline(String filename) {
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(filename, true));
            bw.append('\n');
            bw.close();
        }
        catch(Exception x) {
            System.out.println("File writing newline error.");
        }
    }

    static void deleteFileIfExists(String filename) {
        new File(filename).delete();
    }
}
